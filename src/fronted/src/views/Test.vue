<template>
    <div>
        Test Vue 입니다.
        {{test}}
    </div>
</template>

<script>
    import axios from "axios";

    export default {
        name: "Test.",
        data() {
            return {
                test : ''
            }
        },
        methods : {
            testFunction : function (){

                const accessToken = localStorage.getItem("accessToken");

                axios.post('/api/test',accessToken
                ).then(response => {
                    this.test = response.data.authorities;
                }).catch((ex) => {
                    console.warn("ERROR!!!!! : ",ex)
                })

                alert(accessToken);

                axios.post('/api/validate',accessToken)
                    .then((response) =>{
                        if(response.data === true)
                            alert('세션존재')
                        else
                            alert('세션만료')
                    })
                    .catch((err) => {
                        alert(err);
                    })
            }
        },
        created() {
            this.testFunction();
        }
    }
</script>

<style scoped>

</style>