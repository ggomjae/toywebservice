<template>
    <div>
        <Title></Title>
        <Post></Post>
    </div>

</template>

<script>
    import Post from "../components/Post";
    import Title from "../components/Title";

    export default {
        name: "Save",
        components : {
            'Post' : Post,
            'Title' : Title
        }
    }
</script>

<style scoped>

</style>