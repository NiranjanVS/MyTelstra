import React from 'react';
import Button from '@material-ui/core/Button';
import Menu from '@material-ui/core/Menu';
import MenuItem from '@material-ui/core/MenuItem';
import Fade from '@material-ui/core/Fade';
import { Style } from '@material-ui/icons';
import { Link } from 'react-router-dom';
import { useHistory } from "react-router-dom";
import {USER} from 'constants/index';
import Alert from 'react-s-alert';
import 'react-s-alert/dist/s-alert-default.css';
import 'react-s-alert/dist/s-alert-css-effects/slide.css';
import axios from 'axios';
import { useState, useEffect } from 'react';

export default function FadeMenu(props) {
  const [anchorEl, setAnchorEl] = React.useState(null);
  const open = Boolean(anchorEl);
  var userDetails = JSON.parse(localStorage.getItem(USER));
  let history = useHistory();

  const handleClick = (event) => {
    setAnchorEl(event.currentTarget);
  };

  const handleClose = () => {
    setAnchorEl(null);
    // history.push({
    //   pathname: '/Broadband/newConnection',
    //   authenticated: props.authenticated,
    //   user: props.user
    // });
  };
  // const [user, setState] = useState({});
  // const [details, setDetails] = useState({});
  // var userDetails = JSON.parse(localStorage.getItem(USER));
  // useEffect(() => {
  //     axios
  //       .get("http://localhost:8088/currentPlan/"+ userDetails.id)
  //       .then(response => setDetails(response.data));
  // }, [userDetails]);
  // useEffect(() => {
  //   const url = "http://localhost:8088/userDetails/" +  userDetails.id;
  //   axios
  //     .get(url)
  //     .then(response => setState(response.data));
  // }, [userDetails]);
    
  // const handleupgrade = () => {

  //   if(details.id=== user.planshistory){
  //     history.push({
  //     pathname: '/Broadband/upgradeplan'
  //   });
  //   }
  //   else{
  //     Alert.error("Already Upgraded");
  //   }
  // }

  // console.log(props.authenticated + "Menu");
  // console.log(props.user + "Menu");

  return (
    <div>
      <Button aria-controls="fade-menu" aria-haspopup="true" onClick={handleClick}>
        {props.menuName}
      </Button>
      <Menu
        id="fade-menu"
        anchorEl={anchorEl}
        getContentAnchorEl={null}
        keepMounted
        anchorOrigin={{ vertical: "bottom", horizontal: "center" }}
        transformOrigin={{ vertical: "top", horizontal: "center" }}
        open={open}
        onClose={handleClose}
        TransitionComponent={Fade}
      >
        <MenuItem href="/Broadband/viewPlans" component="a" onClick={handleClose}>View Plans</MenuItem>
        <MenuItem href="/Broadband/currentplan" component="a" onClick={handleClose}>Current Plan</MenuItem>
        {/* <MenuItem onClick={handleClose}><Link to = {{pathname: '/Broadband/newConnection', authenticated: props.authenticated, user: props.user}}>New Connection</Link></MenuItem> */}
        <MenuItem onClick={handleClose} href='/Broadband/newConnection' component="a">New Connection</MenuItem>

        <MenuItem href="/Broadband/upgradeplan" component="a" onClick={handleClose}>Upgrade existing Plan</MenuItem>
        <MenuItem href="/Broadband/billdetails" component="a" onClick={handleClose}>Pay Due Bill</MenuItem>
        <MenuItem href="/Broadband/rechargehistory" component="a" onClick={handleClose}>Payment History</MenuItem>
      </Menu>
    </div>
  );
}
