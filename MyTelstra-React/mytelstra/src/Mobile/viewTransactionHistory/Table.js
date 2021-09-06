import React from "react";
import MaterialTable from "material-table";
import { useState, useEffect } from 'react';
import Container from '@material-ui/core/Container';
import axios from 'axios';
import { makeStyles } from '@material-ui/core/styles';

const useStyles = makeStyles((theme) => ({
    '@global': {
      ul: {
        margin: 0,
        padding: 0,
        listStyle: 'none',
      },
    },
    '.menu': {
        display: 'inline-block'
    },
    appBar: {
      borderBottom: `1px solid ${theme.palette.divider}`,
    },
    toolbar: {
      flexWrap: 'wrap',
    },
    toolbarTitle: {
      flexGrow: 1,
    },
    link: {
      margin: theme.spacing(1, 1.5),
      float: 'left'
    },
    heroContent: {
      padding: theme.spacing(8, 0, 6),
    },
    cardHeader: {
      backgroundColor:
        theme.palette.type === 'light' ? theme.palette.grey[200] : theme.palette.grey[700],
    },
    cardPricing: {
      display: 'flex',
      justifyContent: 'center',
      alignItems: 'baseline',
      marginBottom: theme.spacing(2),
    },
    footer: {
      borderTop: `1px solid ${theme.palette.divider}`,
      marginTop: theme.spacing(8),
      paddingTop: theme.spacing(3),
      paddingBottom: theme.spacing(3),
      [theme.breakpoints.up('sm')]: {
        paddingTop: theme.spacing(6),
        paddingBottom: theme.spacing(6),
      },
    },
}));

//₹

export default function Table(){
    const classes = useStyles();
    const [plans, setState] = useState([]);
    useEffect(() => {
        axios
            .get("http://localhost:8083/rechargeHistory/10010")
            .then(response => setState(response.data))
    }, [])
    console.log(plans);
    const columns=[
        {
            title:'Plan ID', field:'planID'
        },
        {
            title:'Date of Recharge', field:'dateOfRecharge'
        },
        {
            title:'Date of Expiry', field:'dateOfExpiry'
        },
        {
            title:'Transaction ID', field:'transactionId'
        },
        {
            title:'Payment Mode', field:'paymentMode'
        }
    ]
    return(
        <div>
            <Container maxWidth="xl" component="main">
                  <MaterialTable title="Transaction History"
                      data = {plans}
                      columns = {columns}
                  />
            </Container>
        </div>
    );
}