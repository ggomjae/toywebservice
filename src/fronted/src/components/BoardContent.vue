<template>
    <div>
        <vue-good-table
                id="table"
                :columns="columns"
                :rows="rows"
                @on-row-click="onRowClick">
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
                        label: '작성자',
                        field: 'author',
                        sortable: false,
                    },
                    {
                        label: '제목',
                        field: 'title',
                        sortable: false,
                    },
                    {
                        label: '날짜',
                        field: 'modifiedDate',
                        type: 'date',
                        inputFormat: 'DD-MM-YYYY HH:mm',
                        outputFormat: 'DD-MM-YYYY HH:mm'
                    }
                ],
                rows: []
            }
        },
        methods : {
            getRevisions() {
                axios.get('http://localhost:8081/api/board/test')
                    .then(response => {
                        this.content = response.data;
                        this.rows = response.data;
                        console.log(response);
                    }).catch( e=>{
                    console.log('error:',e)
                })
            },
            onRowClick(params){
                console.log(params);
                console.log(params.row.id);
            }
        },
        mounted() {
            this.getRevisions();
        }
    }
</script>

<style scoped>
    #table{
        margin: 0 auto;
    }

    @media screen and (min-width: 768px){
        #table{
            width: 752px;
        }
    }
</style>