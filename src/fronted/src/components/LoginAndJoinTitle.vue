<template>
    <div>
        <h1>
            <span id = 'titlejoin' v-on:click="gotoJoin"></span>
            <span id = 'titlelogin' v-on:click="gotologin"></span>
            DaSa 2
        </h1>
    </div>
</template>

<script>
    export default {
        name: "LoginAndJoinTitle",
        methods :{
            gotologin : function () {
                this.$router.push('/')
                    .catch(err=>{
                        console.log(err);
                    })
            },
            gotoJoin : function () {
                this.$router.push('/join')
                    .catch(err=>{
                        console.log(err);
                    })
            }
        }
    }
</script>

<style scoped>
    h1{
        color:#2F3B52;
        font-weight: 900;
        margin: 5rem 0 1.5rem;
    }
    @media screen and (min-width: 768px) and (min-height: 900px){
        h1{
            margin: 10rem 0 1.5rem;
        }
    }

    #titlelogin{
        text-align: center;
        display: inline-block;
        width: 50px;
        height: 50px;
        box-shadow: 0 3px 6px rgba(0,0,0,.2), 0 3px 6px rgba(0,0,0,.2);
        border-radius: 30px 30px;
        background-size: cover;
        margin-right: 1.1rem;
        background-image: url('../assets/login.png');
    }

    #titlejoin{
        text-align: center;
        display: inline-block;
        width: 50px;
        height: 50px;
        box-shadow: 0 3px 6px rgba(0,0,0,.2), 0 3px 6px rgba(0,0,0,.2);
        border-radius: 30px 30px;
        background-size: cover;
        margin-right: 1.1rem;
        background-image: url('../assets/join.png');
    }

    #titlelogin,#titlejoin:hover{
        cursor: pointer;
    }
</style>