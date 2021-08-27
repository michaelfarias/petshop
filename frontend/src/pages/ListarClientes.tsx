import { FormEvent, useState } from 'react';

import api from '../services/api';

type ClienteTipo = {
    id: number;
    nome: string;
    email: string;
    cpf: string;
    telefone: string;
}

export function ListarClientes() {

    const [clientes, setClientes] = useState<Array<ClienteTipo>>([]);
    const [op, setOp] = useState<string>('');
    const [inputBuscar, setInputBuscar] = useState('');

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

    return (
        <div>
            <form onSubmit={buscarCliente}>
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
                </thead>
                <tbody>
                    {clientes.map(cliente => (

                        <tr key={cliente.id}>
                            <td>{cliente.nome}</td>
                            <td>{cliente.email}</td>
                            <td>{cliente.cpf}</td>
                            <td>{cliente.telefone}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}