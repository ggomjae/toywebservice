<template>
  <div id = "app">
    <Title></Title>
    <Pocket></Pocket>
  </div>
</template>

<script>
  import Title from "./components/Title";
  import Pocket from "./components/Pocket";

  export default {
    components : {
      'Title' : Title,
      'Pocket' : Pocket
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

  .shadow{
    box-shadow: 5px 10px 10px rgba(0,0,0,0.03);
  }
</style>