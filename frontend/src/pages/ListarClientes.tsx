import { FormEvent, useState } from 'react';

import api from '../services/api';

type ClienteTipo = {
    id?: number;
    nome?: string;
    email?: string;
    cpf?: string;
    telefone?: string;
}

export function ListarClientes() {

    const [clientes, setClientes] = useState<Array<ClienteTipo>>([]);
    const [op, setOp] = useState<string>('');
    const [inputBuscar, setInputBuscar] = useState('');
    const [openDialog, setOpenDialog] = useState(false);
    const [dados, setDados] = useState<ClienteTipo>();

    function buscarCliente(event: FormEvent) {
        event.preventDefault();

        if (op === 'nome' || op === 'cpf') {
            api.get(`clientes/cliente/?${op}=${inputBuscar}`).then(res => {
                setClientes([res.data]);
            });

        }
        else {
            api.get('clientes').then(res => {
                setClientes(res.data);
            });
        }

    }

    function handleOpenDialog(value: boolean) {
        setOpenDialog(value);
    }

    function salvarCliente() {
        const data = {
            id: dados?.id,
            nome: dados?.nome,
            email: dados?.email,
            cpf: dados?.cpf,
            telefone: dados?.telefone
        };

        api.put('clientes', data).then(res => { console.log('Atualizado com sucesso') });
    }

    return (
        <div>
            <form onSubmit={buscarCliente}>
                <dialog open={openDialog}>

                    Nome:  <input type="text" value={dados?.nome} onChange={e => { setDados({ ...dados, ['nome']: e.target.value }) }} /><br />
                    Email: <input type="text" value={dados?.email} onChange={e => { setDados({ ...dados, ['email']: e.target.value }) }} /><br />
                    Cpf:    <input type="text" value={dados?.cpf} onChange={e => { setDados({ ...dados, ['cpf']: e.target.value }) }} /><br />
                    Telefone: <input type="text" value={dados?.telefone} onChange={e => { setDados({ ...dados, ['telefone']: e.target.value }) }} /><br />
                    <button
                        onClick={() => { salvarCliente() }}
                    >Salvar</button>
                    <button
                        onClick={() => { handleOpenDialog(false) }}
                    >Fechar</button>
                </dialog>
                Buscar por:
                <select onChange={e => { setOp(e.target.value) }}>
                    <option value="">Todos</option>
                    <option value="nome">Nome</option>
                    <option value="cpf">CPF</option>
                </select>
                <br />
                <input
                    type="text"
                    placeholder="Insira o nome ou cpf"
                    onChange={e => { setInputBuscar(e.target.value) }}
                />
                <button>Buscar</button>
            </form>
            <br />

            <table>
                <thead>
                    <th>Nome</th>
                    <th>Email</th>
                    <th>CPF</th>
                    <th>Telefone</th>
                    <th>Ações</th>
                </thead>
                <tbody>
                    {clientes.map(cliente => (

                        <tr key={cliente.id}>
                            <td>{cliente.nome}</td>
                            <td>{cliente.email}</td>
                            <td>{cliente.cpf}</td>
                            <td>{cliente.telefone}</td>
                            <td>
                                <button
                                    onClick={() => {
                                        setOpenDialog(true);

                                        setDados(cliente);
                                    }}
                                >Editar</button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}