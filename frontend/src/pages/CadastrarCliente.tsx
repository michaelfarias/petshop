import { FormEvent, ChangeEvent, useState } from "react";
import { Formik, Form, Field, ErrorMessage } from 'formik';
import * as yup from 'yup';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

import api from '../services/api';

const sigupSchema = yup.object().shape({
  nome: yup.string().required('Campo obrigatório'),
  email: yup.string().email('Email inválido').required('Campo obrigatório'),
  cpf: yup.string().required('Campo obrigatório'),
  telefone: yup.string().required('Campo obrigatório'),
  login: yup.string().required('Campo obrigatório'),
  senha: yup.string().required('Campo obrigatório')
})

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
      <ToastContainer />
      <h1>Cadastro de Cliente</h1>

      <Formik
        initialValues={{
          nome: '',
          email: '',
          cpf: '',
          telefone: '',
          login: '',
          senha: ''
        }}
        validationSchema={sigupSchema}
        onSubmit={values => {
          console.log(JSON.stringify(values));
         
          api.post('clientes', values).then(res => {
            const { status } = res

            if (status == 200) {
              toast.success('Cadastrado com sucesso!', { theme: 'colored', autoClose: 3000 })
            }

          }).catch(erro => {
            const { data } = erro.response
            data.map((erro:any)=>{

              toast.error(erro.erro,{theme:'colored'})
            })

          });

        }}
      >
        {
          () => (
            <Form>
              Nome: <Field name="nome" />
              <ErrorMessage name='nome' /><br />

              Email: <Field name="email" />
              <ErrorMessage name='email' /><br />

              Cpf:<Field name="cpf" />
              <ErrorMessage name="cpf" /><br />

              Telefone:<Field name="telefone" />
              <ErrorMessage name="telefone" /><br />

              Login:<Field name="login" />
              <ErrorMessage name="login" /><br />

              Senha:<Field name="senha" type="password" />
              <ErrorMessage name="senha" /><br />

              <button type='submit'>Cadastrar</button>
            </Form>
          )
        }
      </Formik>
      {/* <form onSubmit={handleCadastrarCliente}>
                Nome:  <input type="text" placeholder="Nome do cliente" name="nome" onChange={event => { setValues({ ...values, [event.target.name]: event.target.value }) }} /><br />
                Email: <input type="email" name="email" onChange={handleSetState} /><br />
                Cpf: <input type="text" name="cpf" onChange={handleSetState} /><br />
                Telefone: <input type="text" name="telefone" onChange={handleSetState} /><br />
                Login: <input type="text" name="login" onChange={handleSetState} /> <br />
                Senha: <input type="password" name="senha" onChange={handleSetState} /><br />
                <button type="submit">
                    Cadastrar
                </button>
            </form> */}
    </div>
  );
}