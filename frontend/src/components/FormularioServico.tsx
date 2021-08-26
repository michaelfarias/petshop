import { ChangeEvent, FormEvent } from "react";

type TipoServico = {
    id: number;
    nome: string;
    preco: number;
    status: string | number;
    descricao: string;
    promocao: {
        id?: number;
        preco: number;
    };
}

type FunctionTypes = {
    handleButtonSalvar?: (event: FormEvent) => void;
    handleSetState?: ((event: ChangeEvent<HTMLInputElement | HTMLSelectElement>) => void);
    setSelectedIdPromocao?: (id: number | string) => void;

    servico?: TipoServico | any;
    promocoes?: [];
    nomeButton?: string;
}

export default function FormularioServico(
    {
        handleButtonSalvar,
        handleSetState,
        setSelectedIdPromocao,

        promocoes,
        servico,
        nomeButton

    }: FunctionTypes) {

    return (
        <div>
            <form onSubmit={handleButtonSalvar}>
                Nome: <input type="text" value={servico && servico.nome} name="nome" onChange={handleSetState} />
                <br />
                {!servico &&
                    <>
                        Descrição: <input type="textarea" value={servico && servico.descricao} name="descricao" onChange={handleSetState} /><br />
                        <br />
                        Tipo de Animal:
                        <select name="animal" onChange={handleSetState}>
                            <option value='1'>Mamifero</option>
                            <option value='2'>Peixe</option>
                            <option value='3'>Réptil</option>
                            <option value='4'>Ave</option>
                            <option value='5'>Anfíbio</option>
                        </select>
                        <br />
                    </>
                }
                Preço: <input type="text" value={servico && servico.preco} name="preco" onChange={handleSetState} />
                <br />
                Status:
                <select name="status" onChange={handleSetState} >
                    <option value='1'>Disponível</option>
                    <option value='2'>Indisponível</option>
                </select>
                <br />
                {
                    promocoes &&
                    <>
                        Promoções:
                        <select name="status" onChange={e => { setSelectedIdPromocao && setSelectedIdPromocao(e.target.value) }} >
                            <option hidden />
                            {
                                promocoes.map((promocao: any, index) => (
                                    <option key={index} value={promocao.id}>{promocao.nome}</option>
                                ))
                            }
                        </select>
                    </>
                }
                <br />
                <button type='submit'>{nomeButton}</button>
            </form>
        </div>
    );
}