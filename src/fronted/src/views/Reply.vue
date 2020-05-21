<template>
    <div>
        <Title></Title>
        <ReplySave></ReplySave>
    </div>
</template>

<script>

    import Title from "../components/Title";
    import ReplySave from "../components/ReplySave";

    export default {
        name: "Reply",
        components : {
            'ReplySave' : ReplySave,
            'Title' : Title
        }
    }
</script>

<style scoped>

</style>