import axios from "axios";

const getUsers = () => {
    return axios.get("http://localhost:9093/api/user", { headers: authHeader() });
};

const getUserById = (id) => {
    return axios.get("http://localhost:9093/api/user/" + id, { headers: authHeader() });
}

export default {getUsers, getUserById};