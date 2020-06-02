import Vue from 'vue';
import Vuex from 'vuex';
import axios from 'axios';

Vue.use(Vuex);

//const resourceHost = 'http://localhost:9001';

export const store = new Vuex.Store({
    state: {
        accessToken: null
    },
    getters: {

    },
    mutations: {
        LOGIN (state, {accessToken}) {
            state.accessToken = accessToken;
        },
        LOGOUT (state) {
            state.accessToken = null
        }
    },
    actions: {
        LOGIN ({commit}, {email, password}) {
            return axios.post(`/api/login`, {email, password})
                .then(({data}) => {
                        alert(data);
                        commit('LOGIN', data);
                    }
                )
        },
        LOGOUT ({commit}) {
            commit('LOGOUT')
        },
    }
});


