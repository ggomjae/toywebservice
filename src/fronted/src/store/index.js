import Vue from 'vue';
import Vuex from 'vuex';
import axios from 'axios';

Vue.use(Vuex);


export const store = new Vuex.Store({

    state: {
        accessToken: null
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
    if (!accessToken) return

    alert(accessToken);
    axios.defaults.headers.common['Authorization'] = accessToken;
}

tokenRefrash();

