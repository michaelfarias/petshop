import { ChangeEvent, FormEvent } from "react";

type FunctionTypes = {
    handleCadastrarServico?: (event: FormEvent) => void;
    handleSetState?: (event: ChangeEvent<HTMLInputElement | HTMLSelectElement>) => void;
    setSelectedIdPromocao?: (id: number | string) => void;
    promocoes?: [];
}

export default function FormularioServico(
    {
        handleCadastrarServico,
        handleSetState,
        setSelectedIdPromocao,
        promocoes

    }: FunctionTypes) {

    return (
        <div>
            <form onSubmit={handleCadastrarServico}>
                Nome: <input type="text" name="nome" onChange={handleSetState} /><br />
                Descrição: <input type="textarea" name="descricao" onChange={handleSetState} /><br />
                Tipo de Animal:
                <select name="animal" onChange={handleSetState}>
                    <option value='1'>Mamifero</option>
                    <option value='2'>Peixe</option>
                    <option value='3'>Réptil</option>
                    <option value='4'>Ave</option>
                    <option value='5'>Anfíbio</option>
                </select>
                <br />
                Preço: <input type="text" name="preco" onChange={handleSetState} />
                <br />
                Status:
                <select name="status" onChange={handleSetState} >
                    <option value='1'>Disponível</option>
                    <option value='2'>Indisponível</option>
                </select>
                <br />
                Promoções:
                {
                    promocoes &&
                    (
                        <select name="status" onChange={e => { setSelectedIdPromocao && setSelectedIdPromocao(e.target.value) }} >
                            <option hidden />
                            {
                                promocoes.map((promocao: any, index) => (
                                    <option key={index} value={promocao.id}>{promocao.nome}</option>
                                ))
                            }
                        </select>
                    )
                }
                <br />
                <button type='submit'>Cadastrar</button>
            </form>
        </div>
    );
}