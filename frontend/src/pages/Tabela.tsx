import { makeStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';

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
    status: string;
    promocao: {
        preco: number
    };
}

type Props = {
    dados: TipoServico[]
}

export function Tabela(props: Props) {
    const classes = useStyles();

    const servicos = props.dados;

    return (
        <Paper className={classes.root}>
            <Table className={classes.table} aria-label="simple table">
                <TableHead>
                    <TableRow>
                        <TableCell>Nome</TableCell>
                        <TableCell align="right">Preço</TableCell>
                        <TableCell align="right">Status</TableCell>
                        <TableCell align="right">Desconto</TableCell>
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

                        </TableRow>
                    ))
                    }
                </TableBody>
            </Table>
        </Paper >
    );
}
