<template>
   <section class="listContainer">
       <ul>
           <li> Profile
               <span v-on:click="goProfile" id="goProfileBtn">
                   <i class="checkBtn fas fa-check" aria-hidden="true"></i>
               </span>
           </li>
           <li> Board
               <span v-on:click="goBoard" id="goBoardBtn">
                   <i class="checkBtn fas fa-check" aria-hidden="true"></i>
               </span>
           </li>
           <li> Options
               <span id="goOptionBtn">
                   <i class="checkBtn fas fa-check" aria-hidden="true"></i>
               </span>
           </li>
       </ul>
   </section>
</template>

<script>
    export default {
        name: "List",
        methods :{
            goBoard : function () {
                this.$router.push('/board')
            },
            goProfile : function () {
                this.$router.push('/profile')
            }
        }
    }
</script>

<style scoped>
    .listContainer{
        position: absolute;
        left:50%;
        top:50%;
        margin-left:-80px;
        margin-top:50px;
    }

    ul{
        list-style-type: none;
        padding-left: 0px;
        margin-top: 0;
        text-align: left;
    }

    li{
        display: flex;
        min-height: 50px;
        height: 50px;
        width: 190px;
        line-height: 50px;
        margin: 0.5rem 0;
        padding:0 0.9rem;
        background: white;
        border-radius: 5px;
        box-shadow: 0.5px 1px 0px 0px rgba(0,0,0,.2);

    }

    #goProfileBtn{
        padding-left: 127px;
    }

    #goBoardBtn{
        padding-left: 130px;
    }

    #goOptionBtn{
        padding-left: 115px;
    }

    #goOptionBtn:hover, #goBoardBtn:hover, #goProfileBtn:hover{
        cursor: pointer;
    }

</style>