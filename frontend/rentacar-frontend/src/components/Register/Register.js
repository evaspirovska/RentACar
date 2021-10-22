import axios from 'axios';

const url = 'http://localhost:9091/api';

const register = (username, password, email, telephone) => {

    return axios.post(
        url + '/register', {username, password, email, telephone}
    );
}

export default register;