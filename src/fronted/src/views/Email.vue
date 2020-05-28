<template>
    <div>
        <Title></Title>
        <EmailContent></EmailContent>
    </div>
</template>

<script>
    import EmailContent from "../components/EmailContent";
    import Title from "../components/Title";

    export default {
        name: "Email",
        components : {
            'Title' : Title,
            'EmailContent' : EmailContent
        }
    }
</script>

<style scoped>

</style>