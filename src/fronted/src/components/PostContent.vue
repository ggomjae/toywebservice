<template>
    <div>
        <div class="controlBtn">
            <span class="boardBtns" v-if="checkUser()" @click="updateBtn">수정</span>
            <span class="boardBtns" v-if="checkUser()" @click="deleteBtn">삭제</span>
        </div>
        <div>
            <fieldset id="postCss">
                <legend id="postLegend">POST</legend>
                <div>
                    <div>
                        <span class ="pc">Title </span>
                         : {{postContent.title}}
                    </div>
                    <div>
                        <span class ="pc">Author </span>
                         : {{postContent.author}}
                    </div>
                    <div>
                        <span class ="pc">Content </span>
                         : {{postContent.content}}
                    </div>
                </div>
            </fieldset>
        </div>
        <div class="controlBtn">
            <span class="Btns" @click="replyBtn">댓글</span>
        </div>

        <div v-for="reply in replyContent" v-bind:key="reply.rno" >
            <div id ="replyField">
                <div id="replyinformation">
                    <span id="replyauthor">{{reply.author}}</span>
                    <span id="replydate">{{moment(reply.modifiedDate).format(' YYYY.MM.DD HH:mm')}}</span>
                    <span id="replydeleteBtn" v-show = changeRender(reply.author) @click="replyDeleteBtn(reply.rno,reply.author)">
                        삭제
                    </span>
                </div>
                <div id="replyContent">
                    {{reply.content}}
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import axios from "axios";
    import {router} from "../routes";

    export default {
        name: "PostContent",
        data(){
            return{
                postContent : '',
                replyContent : [],
                user : '',
                status : false
            }
        },
        methods : {
            checkUser(){
                return this.postContent.author == this.user;
            },
            changeRender(data){
                return data == this.user;
            },
            getRevisions() {
                axios.get('/api/board/posts/' + this.$route.query.id)
                    .then(response => {
                        this.user = this.$store.state.loginEmail;
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
                        this.$router.push('/board');
                    }).catch(e => {
                    console.log('error:', e);
                    alert(e);
                })
            },
            replyDeleteBtn(param,param_two){
                if(param_two != this.user){
                    alert("삭제할수없습니다");
                    return;
                }

                axios.delete('/api/reply/delete/'+param)
                    .then(response => {
                        console.log('success:',response);
                        alert('지웠습니다.');
                        router.replace('/board')
                            .catch(e => {
                                console.log('error:',e);
                            })
                    }).catch(e => {
                    console.log('error:', e);
                    alert(e);
                })
            },
            replyBtn(){
                router.push("/reply?id="+this.$route.query.id)
                    .catch(err => {
                        console.log('error :',err)
                    })
            },
        },
        mounted() {
            this.getRevisions();
            this.getReply();
        }
    }
</script>

<style scoped>

    .pc{
        color: #2F3B52;
    }

    #postLegend {
        color:#2F3B52;
        font-size:16px;
        background:#fff;
        -moz-border-radius:4px;
        box-shadow: 0 1px 5px gray;
        padding:5px 10px;
        font-family:Helvetica, sans-serif;
        font-weight:bold;
    }
    #postCss {
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
        cursor: pointer;
    }
    .Btns{
        float: right;
        color:#2F3B52;
        font-size:16px;
        background:#fff;
        -moz-border-radius:4px;
        box-shadow: 0 1px 5px gray;
        padding:5px 10px;
        font-family:Helvetica, sans-serif;
        font-weight:bold;
        border-radius:10px;
        margin: 0 5px 0 0;
        cursor: pointer;
    }
    .boardBtns{
        float: right;
        font-size:16px;
        padding:5px 10px;
        font-family:Helvetica, sans-serif;
        margin: 0 5px 0 0;
        cursor: pointer;
    }
    #replydeleteBtn{
        float: right;
        color:#2F3B52;
        font-size: 12px;
        cursor: pointer;
    }
    #replyField{
        border-bottom: 1px solid lightslategray;
        margin: 0 auto;
    }
    #replyinformation{
        text-align: left;
    }
    #replyContent{
        text-align: left;
    }
    #replyauthor,#replydate{
        font-size: 12px;
        color: #7f7f7f;
    }
    #replyauthor{
        font-weight: bold;
    }
    @media screen and (min-width: 600px){
        fieldset,#replyField{
            width: 600px;
        }
        .controlBtn{
            width: 584px;
        }
    }
</style>