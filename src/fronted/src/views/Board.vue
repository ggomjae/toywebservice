<template>
    <div id="board">
        <Title></Title>
        <BoardContent></BoardContent>
    </div>

</template>

<script>
    import Title from "../components/Title";
    import BoardContent from "../components/BoardContent";

    export default {
        name: "Board",
        components : {
            'BoardContent':BoardContent,
            'Title' : Title
        }
    }
</script>

<style scoped>

</style>