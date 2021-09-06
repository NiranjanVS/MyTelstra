//import logo from './logo.svg';
import Home from 'Home/Home';
import Landing from 'Landing';
//import ViewPlans from 'Broadband/viewPlans/viewPlans'
import ViewMobilePlans from 'Mobile/viewPlans/viewPlans'
import ViewTransactionHistory from 'Mobile/viewTransactionHistory/viewTransactionHistoy';
import Table from 'Mobile/viewTransactionHistory/viewTransactionHistoy'
import './App.css';

function App() {
  return(
    <div>
      <ViewTransactionHistory/>
    </div>
  );
}

export default App;
