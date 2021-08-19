import { Route, BrowserRouter, Switch } from 'react-router-dom';

import { ListarServico } from './pages/ListarServico';
import { CadastrarCliente } from './pages/CadastrarCliente';

function App() {
  return (
    <BrowserRouter>
      <Switch >
        <Route exact path='/' component={ListarServico} />
        <Route path='/cadastrarcliente' component={CadastrarCliente} />
      </Switch>
    </BrowserRouter>
  );
}

export default App;
