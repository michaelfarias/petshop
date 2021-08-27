import { Route, BrowserRouter, Switch } from 'react-router-dom';

import { ListarServico } from './pages/ListarServico';
import { CadastrarCliente } from './pages/CadastrarCliente';
import { CadastrarServico } from './pages/CadastrarServico';
import { ListarClientes } from './pages/ListarClientes';

import { Siderbar } from './components/Sidebar';

function App() {
  return (
    <BrowserRouter>
      <Switch >
        <Route exact path='/' component={Siderbar} />
        <Route path="/listarservico" component={ListarServico} />
        <Route path='/cadastrarcliente' component={CadastrarCliente} />
        <Route path='/cadastrarservico' component={CadastrarServico} />
        <Route path='/listarclientes' component={ListarClientes} />
      </Switch>
    </BrowserRouter>
  );
}

export default App;
