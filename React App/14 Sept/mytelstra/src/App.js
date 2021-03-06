//import logo from './logo.svg';
import Home from 'Home/Home';
import Landing from 'Landing';
import './App.css';
import ViewPlans from 'Broadband/viewPlans/viewPlans'
import UpgradePlans from 'Broadband/upgradePlans/UpgradePlans';
import AddressForm from 'Broadband/NewConnection/newConAddressForm';
import ViewCurrentPlans from 'Broadband/viewCurrentPlan/ViewCurrentPlan';
import Checkout from 'payment/checkout';
import SignIn from 'login/LogIn'
import SignUp from 'login/SignUp';
import RegisterPage from 'views/examples/RegisterPage';
import LandingPage from 'views/examples/LandingPage';
import ViewItems from 'shop/displayItems';
import ViewMobileDashboard from 'Mobile/Dashboard/view';
import User from 'profilecard';


function App() {
  return(
    <div>
      <User/>
    </div>
  );
}

export default App;
