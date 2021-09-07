import { useState } from 'react';

import api from '../services/api';

export function ComprarServico() {

    const [servicos, setServicos] = useState<any>();
    const [animal, setAnimal] = useState<string>();

    function buscarPorTipoDeAnimal() {
        api.get(`servicos/animal`, {
            params: {
                animal
            }
        }).then(res => {
            setServicos(res.data);
            console.log(res.data)
        });
    }


    return (
        <div>
            Escolha o tipo de Animal:<br />
            <select onChange={e => { setAnimal(e.target.value) }}>
                <option value="1">Mamifero</option>
                <option value="2">Peixe</option>
                <option value="3">Reptil</option>
                <option value="4">Ave</option>
                <option value="5">Anfibio</option>
            </select>

            <button onClick={() => { buscarPorTipoDeAnimal() }}>Buscar</button>
            <br />
            <table>
                <thead>
                    <th>y</th>
                    <th>r</th>
                    <th>w</th>
                    <th>q</th>
                </thead>
                <tbody>
                    {
                        servicos.map((servico: any, index: number) => (

                            <tr key={index}>
                                <td>{servico.nome}</td>
                                <td>b</td>
                                <td>c</td>
                                <td>d</td>
                            </tr>
                        ))
                    }
                </tbody>
            </table>
        </div>
    );
}