<template>
    <div id="aaa">
        <span id ="damiImage">
            <img v-bind:src="imgData" alt="imgData">
        </span>
        <div class="profileContainer">
            <ul>
                <li>
                    <span class="detail"> {{object.job}}</span>
                    <span>{{object.name}}</span>
                 </li>
                 <li>
                     <span class="detail">키</span>
                     <span>{{object.tall}}</span>
                 </li>
                 <li>
                     <span class="detail">출생</span>
                     <span>{{object.birthday}}</span>
                 </li>
                 <li>
                     <span class="detail">학력</span>
                     <span>{{object.Education}}</span>
                 </li>
            </ul>
        </div>
            <input type="file" ref="file" v-if="checkUser()" v-on:change="handleFileUpload()">
            <button  v-if="checkUser()" v-on:click="fileSubmit()">
                Submit
            </button>
    </div>
</template>

<script>
    import axios from "axios";

    export default {
        name: "ProfileContent",
        data: ()=>{
            return {
                object : {
                    name: "김다미",
                    job : "영화배우",
                    birthday: "1995.4.9",
                    tall: "170cm",
                    Education: "인천대학교"
                },
                file : '',
                //imgData : require('../assets/kim.png')
                imgData : ''
                //만약 url을 갖고온다면  그냥 '' 에넣으면 된다
            }
        },
        methods : {
            checkUser(){
                return this.$store.state.loginEmail == "iksjsixje@gmail.com";
            },
            fileSubmit(){
                let formData = new FormData();
                formData.append('file',this.file);

                axios.post('/api/fileupload',formData,{
                    headers: {
                        'Content-Type': 'multipart/form-data'
                    }
                }).then( response =>{
                        this.reset();
                        localStorage.setItem("img",response.data);
                        this.$store.state.filePath = response.data;
                        this.imgData = response.data;
                        console.log(response);
                }).catch( err => {
                        console.log(err);
                    });
            },
            handleFileUpload() {

                if(this.imgData !== '/img/kim.png') {
                    localStorage.removeItem("img");
                    axios.post('/api/removeFile', { imgPath: this.imgData
                        })
                        .then(response => {
                            console.log(response.data);
                        }).catch(e => {
                        console.log('error:', e)
                    });
                }

                this.file = this.$refs.file.files[0];
            },
            reset() {
                const input = this.$refs.file;
                input.type = 'file';
            }
        },
        mounted() {
            this.imgData = this.$store.state.filePath;
        }
    }
</script>

<style scoped>

    #damiImage,img{
        display: inline-block;
        width: 250px;
        height: 250px;
    }
    .profileContainer{
        text-align: center
    }

    ul{
        display: inline-block;
        list-style-type: none;
    }

    li{
        display: flex;
        min-height: 20px;
        height: 20px;
        width: 150px;
        line-height: 20px;
        margin: 0.5rem 0;
        padding:0 0.9rem;
    }

    .detail{
        color: gray;
        font-size: 12px;
    }

    @media screen and (min-width: 992px) and (min-height: 900px){
        li{
            height: 40px;
            line-height: 40px;
            width: 200px;
        }
    }

</style>