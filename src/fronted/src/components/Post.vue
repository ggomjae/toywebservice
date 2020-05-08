<template>
    <div>
        <div class="input_row">
            <label for="id">아이디</label>
            <input type="text" id="id" v-model="user.userid">
        </div>
        <div class="input_row">
            <label for="name">이름</label>
            <input type="text" id="name" v-model="user.name">
        </div>
        <div class="input_row">
            <label for="password">비밀번호</label>
            <input type="password" id="password" v-model="user.password">
        </div>
        <button :click="register">SAVE</button>
    </div>
</template>

<script>
    export default {
        name: "Post",

    }
</script>

<style scoped>

</style>