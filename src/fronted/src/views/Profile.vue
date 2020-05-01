<template>
    <div>
        <Title></Title>
        <profile-content></profile-content>
    </div>

</template>

<script>
    import Title from "../components/Title";
    import ProfileContent from "../components/ProfileContent";

    export default {
        name: "Profile",
        components : {
            'Title' : Title,
            'ProfileContent' : ProfileContent
        }
    }
</script>

<style scoped>

</style>