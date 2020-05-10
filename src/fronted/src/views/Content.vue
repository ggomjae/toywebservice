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
            'Title' : Title,
            'PostContent' : PostContent
        }
    }
</script>

<style scoped>

</style>