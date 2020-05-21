<template>
    <div>
        <Title></Title>
        <PostContent></PostContent>
    </div>
</template>

<script>
    import Title from "../components/Title";
    import PostContent from "../components/PostContent";
    export default {
        name: "Content",

        components : {
            'PostContent':PostContent,
            'Title' : Title
        }
    }
</script>

<style scoped>

</style>