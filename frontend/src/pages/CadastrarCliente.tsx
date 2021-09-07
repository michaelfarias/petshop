import { FormEvent, ChangeEvent, useState } from "react";

import api from '../services/api';

export function CadastrarCliente() {

    const [values, setValues] = useState({
        nome: '',
        email: '',
        cpf: '',
        telefone: '',
        login: '',
        senha: ''
    })

    function handleCadastrarCliente(event: FormEvent) {
        event.preventDefault();
        console.log(values)
        api.post('clientes', values).then(res => { }).catch(erro => {
            const { data } = erro.response
            console.log(data)

        });

    }

    function handleSetState(event: ChangeEvent<HTMLInputElement>) {
        const name = event.target.name as string
        const newValue = event.target.value;

        setValues({ ...values, [name]: newValue });
    }

    return (
        <div>
            <h1>Cadastro de Cliente</h1>
            <form onSubmit={handleCadastrarCliente}>
                Nome:  <input type="text" placeholder="Nome do cliente" name="nome" onChange={event => { setValues({ ...values, [event.target.name]: event.target.value }) }} /><br />
                Email: <input type="email" name="email" onChange={handleSetState} /><br />
                Cpf: <input type="text" name="cpf" onChange={handleSetState} /><br />
                Telefone: <input type="text" name="telefone" onChange={handleSetState} /><br />
                Login: <input type="text" name="login" onChange={handleSetState} /> <br />
                Senha: <input type="password" name="senha" onChange={handleSetState} /><br />
                <button type="submit">
                    Cadastrar
                </button>
            </form>
        </div>
    );
}