import { ChangeEvent, FormEvent, useEffect, useState } from 'react';
import FormularioServico from '../components/FormularioServico';

import api from '../services/api';
import { Principal } from './Principal';

type ServicoType = {
    nome?: string;
    descricao?: string;
    animal?: string;
    preco?: number;
    status?: string;
};

export function CadastrarServico() {
    const [selectedIdPromocao, setSelectedIdPromocao] = useState<number | string>();
    const [promocoes, setPromocoes] = useState<[]>([]);

    const [servico, setServico] = useState<ServicoType>({
        nome: '',
        descricao: '',
        animal: '1',
        preco: 0.0,
        status: '1',
    });

    useEffect(() => {
        api.get('promocoes').then(res => {
            setPromocoes(res.data);
        });
    }, []);

    function handleCadastrarServico(event: FormEvent) {
        event.preventDefault();

        const data = { ...servico, promocao: { id: selectedIdPromocao } }

        api.post('servicos', data);
    }

    function handleSetState(event: ChangeEvent<HTMLInputElement | HTMLSelectElement>) {
        const name = event.target.name;
        const value = event.target.value;

        setServico({ ...servico, [name]: value });
    }

    return (
        <Principal>
            <h1>##### Cadastrar Serviço #####</h1>

            <FormularioServico
                handleSetState={handleSetState}
                handleButtonSalvar={handleCadastrarServico}
                setSelectedIdPromocao={setSelectedIdPromocao}
                promocoes={promocoes}
                
                nomeButton="Cadastrar"
            />
        </Principal>
    )
}