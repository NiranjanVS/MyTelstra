import React from 'react';
import AppBar from '@material-ui/core/AppBar';
import Button from '@material-ui/core/Button';
import Toolbar from '@material-ui/core/Toolbar';
import Typography from '@material-ui/core/Typography';
import { makeStyles } from '@material-ui/core/styles';
import FadeMenu from './Menu.js'
import { Container } from 'reactstrap';

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

export default function Indexnavbar(){
    const classes = useStyles();

    return(
        <Container>
            <AppBar position="fixed" color="default" elevation={0} className={classes.appBar}>
                <Toolbar className={classes.toolbar}>
                    <img src = "/media/logo.png" alt = "Company logo">
                    </img>
                    <Typography variant="h6" color="inherit" noWrap className={classes.toolbarTitle}>
                    </Typography>
                    <FadeMenu menuName = "Mobile" className = {classes.link}/>
                    <FadeMenu menuName = "Broadband" className = {classes.link}/>
                    <FadeMenu menuName = "Shop" className = {classes.link}/>
                    <FadeMenu menuName = "cart" className = {classes.link}/>
                <Button href="#" color="primary" variant="outlined" className={classes.link}>
                    Login
                </Button>
                </Toolbar>
            </AppBar>
        </Container>
    );
}