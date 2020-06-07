<template>
    <div>
        <LoginAndJoinTitle></LoginAndJoinTitle>
        <LoginContent></LoginContent>
    </div>
</template>

<script>

    import LoginContent from "../components/LoginContent";
    import LoginAndJoinTitle from "../components/LoginAndJoinTitle";

    export default {
        name: "Login",
        components : {
            LoginAndJoinTitle,
            'LoginContent' : LoginContent
        }
    }
</script>

<style scoped>

</style>