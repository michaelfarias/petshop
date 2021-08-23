import { useState } from 'react';
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
import Radio from '@material-ui/core/Radio';
import RadioGroup from '@material-ui/core/RadioGroup';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import FormControl from '@material-ui/core/FormControl';
import FormLabel from '@material-ui/core/FormLabel';

import { Siderbar } from '../components/Sidebar';
import { Tabela } from './Tabela';

import api from '../services/api';

type TipoServico = {
    id: number;
    nome: string;
    preco: number;
    status: string;
    promocao: {
        preco: number
    };
}

export function ListarServico() {

    const [servicos, setServicos] = useState<TipoServico[]>([]);
    const [opcao, setOpcao] = useState('');
    const [textBuscar, setTextBuscar] = useState('');

    function handleButtonBuscar() {
        api.get(`servicos/${opcao}?${opcao}=${textBuscar}`)
            .then(res => {
                setServicos(res.data)
            })
    }

    return (
        <div>
            <Siderbar />
            <form>
                <TextField
                    id="outlined-basic"
                    label="Buscar..."
                    variant="outlined"
                    onChange={event => { setTextBuscar(event.target.value) }}
                />
                <FormControl component="fieldset">
                    <FormLabel component="legend">Buscar por:</FormLabel>
                    <RadioGroup aria-label="gender" name="gender1" onChange={event => { setOpcao(event.target.value) }}>
                        <FormControlLabel value="nome" control={<Radio />} label="Nome" />
                        <FormControlLabel value="preco" control={<Radio />} label="Preço" />
                    </RadioGroup>
                </FormControl>
                <Button variant="contained" color="primary" onClick={handleButtonBuscar}>
                    Buscar
                </Button>

            </form>
            <Tabela dados={servicos} />
        </div>
    )
}