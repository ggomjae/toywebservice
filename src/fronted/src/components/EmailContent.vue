<template>
    <div>
        <fieldset>
            <legend>Email</legend>
            <div>
                <div>
                    <label>
                        <input type="text" v-model="address" placeholder="이메일 주소">
                    </label>
                </div>
                <div>
                    <label>
                        <input type="text" v-model="title" placeholder="제목">
                    </label>
                </div>
                <div>
                    <label>
                        <textarea v-model="content" placeholder="메일 내용을 입력해주세요."></textarea>
                    </label>
                </div>
                <span id ="subBtn" @click="emailSubmit"/>
                Email
            </div>
        </fieldset>
    </div>
</template>

<script>
    import axios from "axios";

    export default {
        name: "EmailContent",
        data(){
            return{
                address : '',
                title : '',
                content : ''
            }
        },
        methods : {
            emailSubmit(){
                axios.post('/api/mail',
                    { title:this.title, address:this.address, content:this.content }
                ).then( response =>{
                    alert("보냈습니다.");
                    console.log(response);
                }).catch( err => {
                    alert("실패했습니다.");
                    console.log(err);
                });
            }
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
        height: 35px;
    }

    input, textarea {
        border: 1px solid #CCCCCC;
        font-size: 14px;
        line-height: 1.2em;
        margin-bottom:15px;
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