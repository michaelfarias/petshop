import { ChangeEvent, FormEvent, useEffect, useState } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';
import { Button } from '@material-ui/core';

import api from '../services/api';
import FormularioServico from '../components/FormularioServico';

const useStyles = makeStyles({
    root: {
        width: '100%',
        overflowX: 'auto',
    },
    table: {
        minWidth: 650,
    },
});

type TipoServico = {
    id: number;
    nome: string;
    preco: number;
    status: string | number;
    promocao: {
        id?: number;
        preco: number;
    };
}

type Props = {
    dados: TipoServico[]
}

export function Tabela(props: Props) {
    const classes = useStyles();

    const dados = props.dados
    const [servicos, setServicos] = useState<TipoServico[]>([]);
    const [servicoSelecionado, setServicoSelecionado] = useState<TipoServico>();
    const [openDialog, setOpenDialog] = useState<boolean>(false);

    useEffect(() => {
        setServicos(dados);
    }, [dados]);

    function deletarServico(id: number) {

        const newServicos = servicos.filter((servico: TipoServico) => servico.id !== id);

        api.delete(`servicos/${id}`).then(res => {

            setServicos(newServicos)

        }).catch(error => {
            alert("erro ao excluir")
        })
    }

    async function handleAtualizarServico(event: FormEvent) {
        event.preventDefault();

        const data = {
            ...servicoSelecionado,
            promocao: { id: servicoSelecionado?.promocao.id },
            status: (servicoSelecionado?.status == 'DISPONIVEL' || servicoSelecionado?.status == 1) ? 1 : 2,
        }

        servicos.forEach(item => {
            if (item.id === servicoSelecionado?.id) {
                item.nome = servicoSelecionado.nome;
                item.preco = servicoSelecionado.preco;
                item.status = (servicoSelecionado.status == 1 ||
                    servicoSelecionado.status == 'DISPONIVEL') ?
                    'DISPONIVEL' : 'INDISPONIVEL';
            }
        })

        setServicos(servicos);
        onClickCloseModal();

        const response = await api.put('servicos', data);

        if (response.status === 204) {
            console.log("Atualização feita com sucesso.")
        }
    }

    function handleSetState(event: ChangeEvent<HTMLInputElement | HTMLSelectElement>) {
        const name = event.target.name;
        const value = event.target.value;

        servicoSelecionado && setServicoSelecionado({ ...servicoSelecionado, [name]: value });
    }

    function onClickOpenModal(servicoSelecionado: TipoServico) {
        setServicoSelecionado(servicoSelecionado);

        setOpenDialog(true);
    }

    function onClickCloseModal() {
        setOpenDialog(false);
    }

    return (
        <Paper className={classes.root}>
            {
                servicoSelecionado && (

                    <dialog open={openDialog}>
                        <FormularioServico
                            handleButtonSalvar={handleAtualizarServico}
                            handleSetState={handleSetState}

                            servico={servicoSelecionado}
                            nomeButton="Atualizar"
                        />

                        <button onClick={() => { onClickCloseModal() }}>Fechar</button>
                    </dialog>
                )
            }
            <Table className={classes.table} aria-label="simple table">
                <TableHead>
                    <TableRow>
                        <TableCell>Nome</TableCell>
                        <TableCell align="right">Preço</TableCell>
                        <TableCell align="right">Status</TableCell>
                        <TableCell align="right">Desconto</TableCell>
                        <TableCell align="right">Ações</TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {servicos.map(servico =>
                    (
                        <TableRow key={servico.id}>

                            <TableCell component="th" scope="servico">
                                {servico.nome}
                            </TableCell>
                            <TableCell align="right">{servico.preco}</TableCell>
                            <TableCell align="right">{servico.status}</TableCell>
                            <TableCell align="right">{servico.promocao ? `${servico.promocao.preco}%` : 'Sem desconto'}</TableCell>
                            <TableCell align="right">
                                <Button
                                    variant='contained'
                                    color='primary'
                                    onClick={() => { deletarServico(servico.id) }}
                                >
                                    Excluir
                                </Button>
                                <Button
                                    variant='contained'
                                    color='secondary'
                                    onClick={() => { onClickOpenModal(servico) }}
                                >
                                    Editar
                                </Button>
                            </TableCell>
                        </TableRow>
                    ))
                    }
                </TableBody>
            </Table>
        </Paper >
    );
}
