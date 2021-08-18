import { Route, BrowserRouter, Switch } from 'react-router-dom';

import { ListarServico } from './pages/ListarServico';

function App() {
  return (
    <BrowserRouter>
      <Switch >
        <Route path='/' component={ListarServico} />
      </Switch>
    </BrowserRouter>
  );
}

export default App;
