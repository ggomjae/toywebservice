import Vue from 'vue';
import Vuex from 'vuex';
import axios from 'axios';

Vue.use(Vuex);

export const store = new Vuex.Store({

    state: {
        accessToken: null,
        loginEmail : null
    },
    getters: {

    },
    mutations: {
        LOGIN (state, accessToken) {
            state.accessToken = accessToken;
            localStorage.setItem("accessToken",accessToken);
        },
        LOGOUT (state) {
            state.accessToken = null
        }
    },
    actions: {
        LOGIN ({commit}, {email, password}) {
            return axios.post(`/api/login`, {email, password})
                .then((data) => {
                        alert(`Bearer ${data.data}`);
                        this.state.loginEmail = email;
                        alert(this.state.loginEmail);
                        commit('LOGIN', data.data);
                        axios.defaults.headers.common['Authorization'] = `Bearer ${data.data}`;
                    }
                )
        },
        LOGOUT ({commit}) {
            commit('LOGOUT')
        }
    }
});

const tokenRefrash = () => {
    const accessToken = localStorage.getItem("accessToken");
    if (!accessToken)
        return

    axios.post('/api/user',accessToken)
        .then((response) =>{
            alert(response.data);
            store.state.loginEmail = response.data;
        })
        .catch((err) => {
            alert(err);
        })

    alert(accessToken);
    axios.defaults.headers.common['Authorization'] = accessToken;
}

tokenRefrash();

