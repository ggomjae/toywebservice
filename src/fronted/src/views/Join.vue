<template>
    <div>
        <LoginAndJoinTitle></LoginAndJoinTitle>
        <JoinContent></JoinContent>
    </div>
</template>

<script>

    import JoinContent from "../components/JoinContent";
    import LoginAndJoinTitle from "../components/LoginAndJoinTitle";

    export default {
        name: "Join",
        components : {
            LoginAndJoinTitle,
            'JoinContent' : JoinContent
        }
    }
</script>

<style scoped>

</style>>