<template>
  <div id = "app">
    <keep-alive  include="Profile">
      <router-view></router-view>
    </keep-alive>
    <div class="temp"></div>
    <Foot></Foot>
  </div>
</template>

<script>
  import Foot from "./components/Foot";
  export default {
    name : 'App',
    components : {
        'Foot' : Foot
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

  .temp{
    height: 50px;
  }

  .shadow{
    box-shadow: 5px 10px 10px rgba(0,0,0,0.03);
  }
</style>