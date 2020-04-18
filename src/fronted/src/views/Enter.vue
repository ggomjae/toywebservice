<template>
    <div>
        <Title></Title>
        <Pocket></Pocket>
    </div>
</template>

<script>
    import Title from "../components/Title";
    import Pocket from "../components/Pocket";

    export default {
        name: "Enter",
        components : {
              'Title' : Title,
              'Pocket' : Pocket
        }
    }
</script>

<style scoped>

</style>