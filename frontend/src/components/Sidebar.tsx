import { Link } from "react-router-dom";

export function Siderbar() {
    return (
        <div>
            <Link to="/cadastrarservico">Cadastrar Serviço</Link>
            <br/>
            <Link to="/listarservico">Listar Serviço</Link>
        </div>
    );
}