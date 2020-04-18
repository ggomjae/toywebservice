<template>
  <div id = "app">
    <router-view></router-view>
  </div>
</template>

<script>
  //import Board from "./views/Board";
  //import Enter from "./views/Enter";

  export default {
    name : 'App',
    components : {
      //  'Board' : Board,
      // 'Enter' : Enter
    }
  }
</script>

<style>
  body{
    text-align: center;
    background: #F6F6F8;
  }

  input{
    border-style: groove;
    width: 200px;
  }

  button{
    border-style: groove;
  }

  #app{
    position: relative;
  }
  .shadow{
    box-shadow: 5px 10px 10px rgba(0,0,0,0.03);
  }
</style>