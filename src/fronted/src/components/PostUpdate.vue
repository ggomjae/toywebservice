<template>
        <div>
            <fieldset>
                <legend>POST</legend>
                <div>
                    <div>
                        <input type="text" v-model="title" />
                    </div>
                    <div>
                        <input type="text" id="readonlyInput" v-model="author" readonly />
                    </div>
                    <div>
                        <textarea v-model="content" ></textarea>
                    </div>
                    <span id ="subBtn" @click="updateData" value=""/>
                    update
                </div>
            </fieldset>
        </div>
</template>

<script>
    import axios from "axios";

    export default {
        name: "PostUpdate",
        data(){
            return{
                postContent : '',
                title : '',
                author : '',
                content : ''
            }
        },
        methods : {
            getRevisions() {
                axios.get('/api/board/posts/' + this.$route.query.id)
                    .then(response => {
                        this.postContent = response.data;
                        this.title = this.postContent.title;
                        this.author = this.postContent.author;
                        this.content = this.postContent.content;
                        console.log('success:',response.data);
                    }).catch(e => {
                    console.log('error:', e)
                })
            },
            updateData : function () {
                axios.put('/api/board/posts/'+this.postContent.id,
                    { title:this.title, author:this.author, content:this.content }
                ).then(response => {
                    console.log('success:',response);
                    alert('수정하였습니다.');
                    this.$router.push('/content?id='+this.$route.query.id)
                        .catch(err=>{
                            console.log(err);
                        })
                }).catch(e => {
                    console.log('error:', e);
                    alert(e);
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

    input{
        height: 35px;
    }

    input, textarea {
        border: 1px solid #CCCCCC;
        font-size: 14px;
        line-height: 1.2em;
        margin-bottom:15px;
    }

    #subBtn{
        background-image: url('../assets/kimdamm.png');
        text-align: center;
        display: inline-block;
        width: 50px;
        height: 50px;
        box-shadow: 0 3px 6px rgba(0,0,0,.2), 0 3px 6px rgba(0,0,0,.2);
        border-radius: 30px 30px;
        background-size: cover;
        margin-bottom: 0;
        cursor: pointer;
    }

    input{
        height: 30px;
        width: 200px;
    }

    textarea{
        height: 130px;
        width: 280px;
    }

    #readonlyInput{
        background: #e3d2d2;
    }
    @media screen and (min-width: 600px){
        fieldset{
            width: 600px;
        }
    }
</style>