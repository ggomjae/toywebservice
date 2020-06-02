import Vue from 'vue';
import VueRouter from 'vue-router';

Vue.use(VueRouter);

export const router = new VueRouter({
    mode: 'history',
    routes: [
        {
            path: '/enter',
            component: ()=> import('../views/Enter.vue'),
            name: 'Enter'
        },
        {
            path: '/board',
            component: ()=> import('../views/Board.vue'),
            name: 'Board'
        },
        {
            path: '/profile',
            component: ()=> import('../views/Profile.vue'),
            name: 'Profile'
        },
        {
            path: '/save',
            component: ()=> import('../views/Save.vue'),
            name: 'Save'
        },
        {
            path: '/content',
            component: ()=> import('../views/Content.vue'),
            name: 'Content'
        },
        {
            path: '/update',
            component: ()=> import('../views/Update.vue'),
            name: 'Update'
        },
        {
            path: '/reply',
            component: ()=> import('../views/Reply.vue'),
            name: 'Reply'
        },
        {
            path: '/email',
            component: ()=> import('../views/Email.vue'),
            name: 'Email'
        },
        {
            path: '/',
            component: ()=> import('../views/Login.vue'),
            name: 'Login'
        },
        {
            path: '/join',
            component: ()=> import('../views/Join.vue'),
            name: 'Join'
        }
    ]
})