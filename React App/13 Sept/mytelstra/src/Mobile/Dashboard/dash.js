import React from "react";
import ChartistGraph from "react-chartist";
// react-bootstrap components
import logo from 'Mobile/cross.gif'
import Grid from '@material-ui/core/Grid'
import {
  Badge,
  Button,
  Card,
  Navbar,
  Nav,
  Table,
  Container,
  Row,
  Col,
  Form,
  OverlayTrigger,
  Tooltip,
} from "react-bootstrap";

function Dashboard() {
  return (
    <>
    <Grid container direction={'row'}>
      <Container justifyContent="center">
        <Grid item xs={4}>
            <Card className="card-stats">
              <Card.Body>
                    <div className="numbers">
                      <p className="card-category">Number</p>
                      <Card.Title as="h4">150GB</Card.Title>
                    </div>
              </Card.Body>
            </Card>
            <Card className="card-stats">
              <Card.Body>
                    <div className="numbers">
                      <p className="card-category">Revenue</p>
                      <Card.Title as="h4" weight="bold">$ 1,345</Card.Title>
                    </div>
              </Card.Body>
            </Card>
          <Card className="card-stats">
              <Card.Body>
                    <div className="numbers">
                      <p className="card-category">Errors</p>
                      <Card.Title as="h4">23</Card.Title>
                    </div>
              </Card.Body>
            </Card>
            <Card className="card-stats">
              <Card.Body>
                    <div className="numbers">
                      <p className="card-category">Followers</p>
                      <Card.Title as="h4">+45K</Card.Title>
                    </div>
              </Card.Body>
            </Card>
        </Grid>
        <Grid item xs={6}>
          <img src={logo} alt="logo"/>
        </Grid>
      </Container>
      </Grid>
    </>
  );
}

export default Dashboard;
