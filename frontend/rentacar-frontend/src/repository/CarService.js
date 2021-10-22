import axios from 'axios';

const getAllCars = () => {
    return axios.get("http://localhost:9091/api/car", { headers: authHeader() });
};

const getCar = (id) => {
    return axios.get("http://localhost:9091/api/car/" + id, { headers: authHeader() });
};

const deleteCar = (id) => {
    return axios.post("http://localhost:9091/api/delete/", id, { headers: authHeader() });
};

const editCar = (data) => {
    return axios.post("http://localhost:9091/api/edit", data, { headers: authHeader() });
};

const addCar = (data) => {
    return axios.post("http://localhost:9091/api/addCar", data, { headers: authHeader() });
};

const getAllRents = () => {
    return axios.get("http://localhost:9094/api/rent", { headers: authHeader() });
};

const getRent = (id) => {
    return axios.get("http://localhost:9094/api/rent/" + id, { headers: authHeader() });
};

const addRent = (data) => {
    return axios.post("http://localhost:9094/api/addRent", data, { headers: authHeader() });
}

const deleteRent = (id) => {
    return axios.post("http://localhost:9094/api/deleteRent/", id, { headers: authHeader() });
};

export default {getAllCars, getCar, deleteCar, editCar, addCar,
                getAllRents, getRent, addRent, deleteRent};