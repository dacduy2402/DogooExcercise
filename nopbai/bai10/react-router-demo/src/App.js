import { BrowserRouter as Router, Route , Switch } from 'react-router-dom'
import './App.css';
import Html from './component/Html';
import Css from './component/Css';
import JavaScript from './component/JavaScript';
import NodeJs from './component/NodeJs';
import Menu from './component/Menu';
import Footer from './component/Footer';
import PageNotFound from './component/PageNotFound';
import ViewBook from './component/ViewBook';

function App() {
  return (
    <Router>
     
    <div className="container">
      <Menu />
    </div>

  
     <div className="alert alert-secondary font-weight-bold" role="alert">
       <div className="container">
    <Switch >
      <Route path="/" exact component={Html} />
      <Route path="/html" component={Html} />
      <Route path="/css" component={Css} />
      <Route path="/javascript" component={JavaScript} />
      <Route path="/nodejs" component={NodeJs} />
      <Route path="/book-detail/:id" component={ViewBook} />
      <Route path='*' exact={true} component={PageNotFound} />
      </Switch>
      </div>
     </div>
    <Footer />
</Router>

  );
}

export default App;
