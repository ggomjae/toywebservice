<template>
    <div>
        <h1>{{ profile }}</h1>
    </div>
</template>

<script>

    import axios from "axios";

    export default {
        name: "ProfileContent",
        data: ()=>{
            return {
                profile : ''
            }
        },
        created() {
            axios.get('http://localhost:8081/api/profile')
                .then(response => {
                    this.profile = response.data;
                    console.log(response.data);
                }).catch( e=>{
                console.log('error:',e)
            })
        }
    }
</script>

<style scoped>

</style>