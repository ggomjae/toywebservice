import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

import Pocket from '../components/Pocket.vue'
import Title from '../components/Title.vue'

export const router = new VueRouter({
    mode: 'history',
    routes: [
        {
            path: '/title',
            component: Title,
            name: 'Title'
        },
        {
            path: '/pocket',
            component: Pocket,
            name: 'Pocket'
        }
    ]
})