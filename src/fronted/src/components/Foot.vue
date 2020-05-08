<template>
    <div id="footer">
        <p>EMAIL : ggomjae@naver.com</p>
        <p>TELL : 010-4911-2542 </p>
    </div>
</template>

<script>
    export default {
        name: "Foot.vue"
    }
</script>

<style scoped>
    #footer{
        position: fixed;
        bottom: 0;
        width: 100%;
        height: 50px;
        background: #F6F6F8;
        opacity: 0.5;
    }

    #footer p{
        font-size: 10px;
        color: #2F3B52;
        text-align: center;
    }
</style>