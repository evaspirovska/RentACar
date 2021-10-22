import logo from './logo.svg';
import './App.css';
import React, {Component} from "react";
import {BrowserRouter as Router, Redirect, Route} from 'react-router-dom'
import CarService from "../../repository/CarService";
import UserService from "../../repository/UserService";

class App extends Component {

  constructor(props) {
    super(props);
    this.state = {
      cars: [],
      rents: [],
      users: [],
      car: {},
      rent: {}
    }
  }

  componentDidMount() {
    this.loadCars();
    this.loadRents();
    this.loadUsers();
  }

  loadCars = () => {
     CarService.getAllCars()
         .then((data) => {
           this.setState({cars: data.data})
         });
  }

  loadRents = () => {
    CarService.getAllRents()
        .then((data) => {
          this.setState({rents: data.data})
        });
  }

  loadUsers = () => {
    UserService.getUsers()
        .then((data) => {
          this.setState({users: data.data})
        });
  }

  deleteCar = (id) => {
    CarService.deleteCar(id)
        .then(() => {
          this.loadProducts();
        });
  }

  addCar = (name, description, price, location, carStatus) => {
    CarService.addCar(name, description, price, location, carStatus)
        .then(() => {
          this.loadCars();
        });
  }

  getCar = (id) => {
    CarService.getCar(id)
        .then((data) => {
          this.setState({
            car: data.data
          })
        })
  }

  editCar = (id, name, description, price, location, carStatus) => {
    CarService.editCar(id, name, description, price, location, carStatus)
        .then(() => {
          this.loadCars();
        });
  }

  deleteRent = (id) => {
    CarService.deleteRent(id)
        .then(() => {
          this.loadRents();
        });
  }

  addRent = (name, carPrice, reservationPeriod, days, carId, userId, rentStatus) => {
    CarService.addRent(name, carPrice, reservationPeriod, days, carId, userId, rentStatus)
        .then(() => {
          this.loadRents();
        });
  }

  getRent = (id) => {
    CarService.getRent(id)
        .then((data) => {
          this.setState({
            rent: data.data
          })
        })
  }

}

export default App;
