import { FormEvent, useEffect, useState } from 'react';

import { Siderbar } from '../components/Sidebar';

import api from '../services/api';

type TipoPromocao = {
    id: number;
    nome: string;
}

export function CadastrarServico() {
    const [nome, setNome] = useState('');
    const [descricao, setDescricao] = useState('');
    const [codTipoAnimal, setCodTipoAnimal] = useState('1');
    const [preco, setPreco] = useState('0.0');
    const [status, setStatus] = useState('1');
    const [selectedIdPromocao, setSelectedIdPromocao] = useState<number | string>();
    const [promocoes, setPromocoes] = useState([]);

    useEffect(() => {
        api.get('promocoes').then(res => {
            setPromocoes(res.data);
        });
    }, []);

    function handleCadastrarServico(event: FormEvent) {
        event.preventDefault();
        console.log(selectedIdPromocao)
        const data = { nome, descricao, codTipoAnimal, preco, status, promocao: { id: selectedIdPromocao } }
        console.log(data)
        api.post('servicos', data);
    }

    return (
        <div>
            <Siderbar/>
            <h1>Cadastrar Servico</h1>
            <form onSubmit={handleCadastrarServico}>
                Nome:<input type="text"
                    onChange={e => setNome(e.target.value)} /><br />
                Descrição: <textarea placeholder="Decreva aqui o serviço..."
                    onChange={e => setDescricao(e.target.value)} /><br />

                Tipo de animal:
                 <select name='tipo'
                    onChange={e => { setCodTipoAnimal(e.target.value) }}>
                    <option value='1'>Mamifero</option>
                    <option value='2'>Peixe</option>
                    <option value='3'>Réptil</option>
                    <option value='4'>Ave</option>
                    <option value='5'>Anfíbio</option>
                </select>
                <br />
                   Preço: <input type="text" onChange={e => { setPreco(e.target.value) }} />
                <br />
                Status:
                <select name='status' onChange={e => { setStatus(e.target.value) }}>
                    <option value='1'>Disponível</option>
                    <option value='2'>Indisponível</option>
                </select>
                <br />

                <select
                    onChange={e => { setSelectedIdPromocao(e.target.value) }}

                >
                    <option hidden>Selecione uma opção</option>
                    {
                        promocoes.map((promocao: TipoPromocao, index) =>
                            <option
                                key={index}
                                value={promocao.id}

                            >
                                {promocao.nome}
                            </option>
                        )
                    }
                </select>
                <br />
                <button type="submit">
                    Cadastrar
                    </button>
            </form>
        </div>
    )
}