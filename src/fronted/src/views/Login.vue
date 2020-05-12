<template>
    <div>
        <Title></Title>
        <span>
            <span v-if="loginStatus">true</span>
            <span v-if="!loginStatus">false</span>
        </span>
    </div>
</template>

<script>
    import Title from "../components/Title";
    import axios from "axios";

    export default {
        name: "Login",
        components: {
            'Title' : Title
        },
        data(){
            return {
                loginStatus : true
            }
        },
        methods : {
            getRevisions() {
                console.log('aaaa');
                axios.get('/login')
                    .then(response => {
                        this.loginStatus = response.data;
                        console.log('success:',response.data);
                    }).catch(e => {
                    console.log('error:', e)
                })
            },
        },
        mounted() {
            this.getRevisions();
        }
    }
</script>

<style scoped>

</style>