import { Route, BrowserRouter, Switch } from 'react-router-dom';

import { ListarServico } from './pages/ListarServico';
import { CadastrarCliente } from './pages/CadastrarCliente';
import { CadastrarServico } from './pages/CadastrarServico';

function App() {
  return (
    <BrowserRouter>
      <Switch >
        <Route exact path='/' component={ListarServico} />
        <Route path='/cadastrarcliente' component={CadastrarCliente} />
        <Route path='/cadastrarservico' component={CadastrarServico} />
      </Switch>
    </BrowserRouter>
  );
}

export default App;
