<template>
    <div>
        <h3>{{ content }}</h3>
        <vue-good-table
                id="table"
                :columns="columns"
                :rows="rows">
        </vue-good-table>
    </div>
</template>

<script>
    import axios from 'axios';
    import 'vue-good-table/dist/vue-good-table.css'
    import  { VueGoodTable }  from 'vue-good-table';

    export default {
        name: "BoardContent",
        components: {
            'VueGoodTable' : VueGoodTable
        },
        data: ()=>{
            return {
                content : '',
                columns: [
                    {
                        label: 'Title',
                        field: 'Title',
                    },
                    {
                        label: 'Author',
                        field: 'Author',
                    },
                ],
                rows: [
                    { Title:"gom e da", Author: "Gomjae"},
                    { Title:"pig da", Author: "KyungJae"},
                ]
            }
        },
        created() {
            axios.get('http://localhost:8081/api/board/test')
                .then(response => {
                    this.content = response.data;
                    console.log(response.data);
                }).catch( e=>{
                    console.log('error:',e)
            })
        }
    }
</script>

<style scoped>
    #table{
        position: absolute;
        left:50%;
        top:50%;
        margin-left:-100px;
        margin-top:100px;
    }
</style>