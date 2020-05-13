<template>
    <div>
        <Title></Title>
        <div class="controlBtn">
            <span class="Btns" @click="updateBtn">수정</span>
            <span class="Btns" @click="deleteBtn">삭제</span>
        </div>
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
        <div class="controlBtn">
            <span class="Btns" @click="replyBtn">댓글</span>
        </div>
        <div v-for="reply in replyContent" v-bind:key="reply.rno">
            <fieldset>
                {{reply.rno}}
                {{reply.author}}
                {{reply.content}}
            </fieldset>
        </div>
    </div>
</template>

<script>
    import Title from "../components/Title";
    import axios from "axios";
    import {router} from "../routes";

    export default {
        name: "Content",
        data(){
            return{
                postContent : '',
                replyContent : []
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
            },
            getReply(){
                axios.get('/api/reply/all/' + this.$route.query.id)
                    .then(response => {
                        this.replyContent = response.data;
                        console.log('success:',response.data);
                    }).catch(e => {
                    console.log('error:', e)
                })
            },
            updateBtn(){
                console.log('updateBtn');
                router.push("/update?id="+this.$route.query.id)
                    .catch(err => {
                        console.log('error :',err)
                    })
            },
            deleteBtn(){
                  axios.delete('/api/board/posts/'+this.postContent.id)
                      .then(response => {
                          console.log('success:',response);
                          alert('지웠습니다.');
                          this.$router.push('/board')
                      }).catch(e => {
                          console.log('error:', e);
                          alert(e);
                  })
            },
            replyBtn(){
                router.push("/replysave?id="+this.$route.query.id)
                    .catch(err => {
                        console.log('error :',err)
                    })
            }
        },
        mounted() {
            this.getRevisions();
            this.getReply();
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

    .controlBtn{
        margin: 0 auto;
        height: 40px;
    }

    .Btns{
        float: right;
        margin: 10px 10px 0 0;
    }

    @media screen and (min-width: 600px){
        fieldset{
            width: 600px;
        }
        .controlBtn{
            width: 584px;
        }
    }
</style>