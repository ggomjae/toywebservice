<template>
    <div>
        <Title></Title>
        <div>
            <fieldset>
                <legend>POST</legend>
                <div>
                    <div>
                        {{postContent.title}}
                    </div>
                    <div>
                        {{postContent.author}}
                    </div>
                    <div>
                        {{postContent.content}}
                    </div>
                </div>
            </fieldset>
        </div>
    </div>
</template>

<script>
    import Title from "../components/Title";
    import axios from "axios";

    export default {
        name: "Content",
        data(){
            return{
                postContent : ''
            }
        },
        components : {
            'Title' : Title
        },
        methods : {
            getRevisions() {
                axios.get('/api/board/posts/' + this.$route.query.id)
                    .then(response => {
                        this.postContent = response.data;
                        console.log('success:',response.data);
                    }).catch(e => {
                    console.log('error:', e)
                })
            }
        },
        mounted() {
            this.getRevisions();
        }
    }
</script>

<style scoped>

    legend {
        color:#2F3B52;
        font-size:16px;
        background:#fff;
        -moz-border-radius:4px;
        box-shadow: 0 1px 5px gray;
        padding:5px 10px;
        font-family:Helvetica, sans-serif;
        font-weight:bold;
    }

    fieldset {
        font-family:Helvetica, sans-serif;
        border-radius:10px;
        background: #F6F6F8;
        padding:20px;
        border-color:lightgray;
        margin: 0 auto;
    }

    @media screen and (min-width: 600px){
        fieldset{
            width: 600px;
        }
    }
</style>