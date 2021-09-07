//import logo from './logo.svg';
import Home from 'Home/Home';
import Landing from 'Landing';
//import ViewPlans from 'Broadband/viewPlans/viewPlans'
import ViewMobilePlans from 'Mobile/viewPlans/viewPlans'
import ViewTransactionHistory from 'Mobile/viewTransactionHistory/viewTransactionHistoy';
import Indexnavbar from 'Mobile/navbar';
import './App.css';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import ViewActiveMobilePlans from 'Mobile/activePlans/viewActivePlans';


function App() {
  return(
    <Router>
      <div>
        <Switch>
          <Route path="/" exact component={Landing}/>
          <Route path="/dashboard" exact component={Home}/>
          <Route path="/mobile/plans" exact component={ViewMobilePlans}/>
          <Route path="/mobile/activeplans" exact component={ViewActiveMobilePlans}/>
          <Route path="/mobile/rechargehistory/:id" component={ViewTransactionHistory}/>
        </Switch>
      </div>
    </Router>
  );
}

export default App;
