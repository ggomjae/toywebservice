<template>
    <div>
        <fieldset>
            <legend>REPLY</legend>
            <div>
                <div>
                    <label>
                        <input type="text" class="replyColor" v-bind:placeholder="author" :readonly="true"/>
                    </label>
                </div>
                <div>
                    <label>
                        <textarea v-model="content" placeholder="CONTENT.."></textarea>
                    </label>
                </div>
                <span id ="subBtn" @click="saveData"/>
                save
            </div>
        </fieldset>
    </div>
</template>

<script>
    import axios from "axios";

    export default {
        name: "ReplySave",
        data() {
            return {
                bno : '',
                author : '',
                content : ''
            }
        },
        methods : {
            saveData : function () {
                axios.post('/api/reply/save',
                    { bno:this.$route.query.id, author:this.author, content:this.content }
                ).then(response => {
                    console.log(response);
                    alert("등록했습니다.");
                    this.$router.push('/content?id=' + this.$route.query.id)
                        .catch(err=>{
                            console.log(err);
                        });
                }).catch((ex) => {
                    console.warn("ERROR!!!!! : ",ex)
                })
            }
        },
        mounted() {
            this.author = this.$store.state.loginEmail;
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

    .replyColor{
        background: #e3d2d2;
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

    @media screen and (min-width: 600px){
        fieldset{
            width: 600px;
        }
    }
</style>