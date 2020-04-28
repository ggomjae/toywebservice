<template>
    <div>
        <h1>{{ content }}</h1>
    </div>
</template>

<script>
    import axios from 'axios'

    export default {
        name: "BoardContent",
        data: ()=>{
            return {
                content : ''
            }
        },
        created() {
            axios.get('http://localhost:8081/api/board')
                .then(response => {
                    this.content = response.data;
                    console.log(response.data);
                }).catch( e=>{
                    console.log('error:',e)
            })
        }
    }
</script>

<style scoped>

</style>