import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

import Board from '../views/Board.vue'
import Enter from '../views/Enter.vue'
import Profile from '../views/Profile.vue'
import Save from "../views/Save.vue";

export const router = new VueRouter({
    mode: 'history',
    routes: [
        {
            path: '/enter',
            component: Enter,
            name: 'Enter'
        },
        {
            path: '/board',
            component: Board,
            name: 'Board'
        },
        {
            path: '/profile',
            component: Profile,
            name: 'Profile'
        },
        {
            path: '/save',
            component: Save,
            name: 'Save'
        },
    ]
})