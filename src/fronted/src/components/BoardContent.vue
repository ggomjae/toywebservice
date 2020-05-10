<template>
    <div>
        <vue-good-table
                id="table"
                :columns="columns"
                :rows="rows"
                @on-row-click="onRowClick">
        </vue-good-table>

        <div id="spanControl">
            <span id = 'reg' v-on:click="gotoSave" />
        </div>
    </div>
</template>

<script>
    import axios from 'axios';
    import 'vue-good-table/dist/vue-good-table.css'
    import  { VueGoodTable }  from 'vue-good-table';
    import {router} from "../routes";

    export default {
        name: "BoardContent",
        components: {
            'VueGoodTable' : VueGoodTable
        },
        data: ()=>{
            return {
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
                        dateInputFormat: 'yyyy-MM-dd\'T\'HH:mm:ss.SSS',
                        dateOutputFormat: 'yyyy-MM-dd',
                    }
                ],
                rows: []
            }
        },
        methods : {
            getRevisions() {
                axios.get('/api/board/all')
                    .then(response => {
                        this.rows = response.data;
                        console.log(response.data);
                    }).catch( e=>{
                    console.log('error:',e)
                })
            },
            onRowClick(params){
                router.push("/content?id="+params.row.id)
                    .catch(err => {
                        console.log('error :',err)
                    })
            },
            gotoSave : function () {
                this.$router.push('/save')
            }
        },
        mounted() {
            this.getRevisions();
        }
    }
</script>

<style scoped>
    #table,#spanControl{
        margin: 0 auto;
    }

    #reg{
        display: inline-block;
        width: 50px;
        height: 50px;
        box-shadow: 0 3px 6px rgba(0,0,0,.2), 0 3px 6px rgba(0,0,0,.2);
        border-radius: 30px 30px;
        background-size: cover;
        float: right;
        margin: 20px 20px 0 0;
        background-image: url('../assets/kimdamm.png');
    }

    #reg:hover{
        cursor: pointer;
    }
    @media screen and (min-width: 768px){
        #table,#spanControl{
            width: 752px;
        }
    }

</style>