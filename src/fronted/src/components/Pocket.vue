<template>
    <div class="pocketContainer shadow">
        <span id = "title">Pocket</span>
        <span class= "addContainer" v-on:click="open">
            <i class="addBtn fas fa-plus" aria-hidden="true"></i>
        </span>
    </div>
</template>

<script>
    export default {
        name: "Pocket",
        methods:{
            open() {
                console.log('click');
            }
        }
    }
</script>

<style scoped>

    .pocketContainer{
        background: white;
        width : 290px;
        height: 50px;
        line-height: 50px;
        border-radius: 5px;
        position: absolute;
        left:50%;
        top:50%;
        margin-left:-150px;
        margin-top:50px;
    }

    .addContainer{
        float: right;
        background: linear-gradient(to right, #6478FB, #8763FB);
        display: block;
        width: 3rem;
        border-radius: 0 5px 5px 0;
    }
    .addBtn{
        color: white;
        vertical-align: middle;
    }
</style>