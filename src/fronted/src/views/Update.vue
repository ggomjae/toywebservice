<template>
    <div>
        <Title></Title>
        <PostUpdate></PostUpdate>
    </div>
</template>

<script>
    import Title from "../components/Title";
    import PostUpdate from "../components/PostUpdate";

    export default {
        name: "Update",
        components :{
            'PostUpdate':PostUpdate,
            'Title' : Title
        }
    }
</script>

<style scoped>

</style>