import Vue from 'vue';
import VueRouter from 'vue-router';

Vue.use(VueRouter);

const requireAuth = () => (to, from, next) => {
    const accessToken = localStorage.getItem("accessToken");
    if (accessToken)
        return next();

    next('/');
};

const enterAuth = () => (to, from, next) => {
    const accessToken = localStorage.getItem("accessToken");
    if (accessToken)
        return next('/enter');

    next();
};

export const router = new VueRouter({
    mode: 'history',
    routes: [
        {
            path: '/test',
            component: ()=> import('../views/Test.vue'),
            name: 'Test',
        },
        {
            path: '/enter',
            component: ()=> import('../views/Enter.vue'),
            name: 'Enter',
            beforeEnter: requireAuth()
        },
        {
            path: '/board',
            component: ()=> import('../views/Board.vue'),
            name: 'Board',
            beforeEnter: requireAuth()
        },
        {
            path: '/profile',
            component: ()=> import('../views/Profile.vue'),
            name: 'Profile',
            beforeEnter: requireAuth()
        },
        {
            path: '/save',
            component: ()=> import('../views/Save.vue'),
            name: 'Save',
            beforeEnter: requireAuth()
        },
        {
            path: '/content',
            component: ()=> import('../views/Content.vue'),
            name: 'Content',
            beforeEnter: requireAuth()
        },
        {
            path: '/update',
            component: ()=> import('../views/Update.vue'),
            name: 'Update',
            beforeEnter: requireAuth()
        },
        {
            path: '/reply',
            component: ()=> import('../views/Reply.vue'),
            name: 'Reply',
            beforeEnter: requireAuth()
        },
        {
            path: '/email',
            component: ()=> import('../views/Email.vue'),
            name: 'Email',
            beforeEnter: requireAuth()
        },
        {
            path: '/',
            component: ()=> import('../views/Login.vue'),
            name: 'Login',
            beforeEnter: enterAuth()
        },
        {
            path: '/join',
            component: ()=> import('../views/Join.vue'),
            name: 'Join',
            beforeEnter: enterAuth()
        }
    ]
});