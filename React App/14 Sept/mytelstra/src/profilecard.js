import React from "react";
import Alert from 'react-s-alert';
import { ACCESS_TOKEN, UserAuthenticated, USER } from 'constants/index';
import {
  Badge,
  Button,
  Card,
  Form,
  Navbar,
  Nav,
  Container,
  Row,
  Col,
} from "react-bootstrap";
import {RiUserReceivedFill} from 'react-icons/ri';

var userDetails = JSON.parse(localStorage.getItem(USER));
console.log(userDetails)
function User() {
  return (
    <>
      <Container fluid>
        <Row className="justify-content-md-center">
          <Col md="4" xs="auto">
            <Card className="card-user">
              {/* <div className="card-image" justify-content="center">
                <img
                  alt="..."
                  className="d-block mx-auto"
                  src={
                    require("img/google-logo.png")
                      .default
                  }
                ></img>
              </div> */}
              <Card.Body>
                <div className="text-avatar">
                    <span>{userDetails.name && userDetails.name[0]}</span>
                </div>
                    {/* <img
                      alt="..."
                      className="avatar border-gray d-block mx-auto img-fluid w-30"
                      src={userDetails.imageUrl}
                    ></img> */}
                <h5 className="text-center" style={{paddingTop:"10px"}}>ID : {userDetails.id}</h5>
                <h3 className="text-center" >{userDetails.name}</h3>
                <h5 className="description text-center">{userDetails.email}</h5>
              </Card.Body>
              {/* <hr></hr> */}
              <div className="button-container my-auto mx-auto" style={{paddingBottom:"10px"}}>
                <Button
                  href="/" onClick = {() => {
                    localStorage.removeItem(ACCESS_TOKEN);
                    localStorage.removeItem(UserAuthenticated);
                    localStorage.removeItem(USER);
                    this.setState({
                    authenticated: false,
                    currentUser: null,
                    
                    });
                    Alert.success("You're safely logged out!");
                  }}
                  >
                  Logout
                  <RiUserReceivedFill/>
                </Button>
              </div>
            </Card>
          </Col>
        </Row>
      </Container>
    </>
  );
}

export default User;
