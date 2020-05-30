<template>
    <div>
        <h2>Login</h2>
        <form @submit.prevent="onSubmit(email, password)">
            <input type="text" v-model="email" placeholder="Email Address">
            <input type="password" v-model="password" placeholder="Password">
            <input type="submit" value="Login">
        </form>
        <p><i></i></p>
    </div>
</template>

<script>
    export default {
        name: "LoginContent",
        data() {
            return {
                email: '',
                password: '',
                msg: ''
            }
        },
        methods: {
            onSubmit(email, password) {

                this.$store.dispatch('LOGIN', {email, password})
                    .then(() => this.redirect())
                    .catch(({message}) => this.msg = message)
            }
        }
    }
</script>

<style scoped>

</style>