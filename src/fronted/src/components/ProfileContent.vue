<template>
    <div id="aaa">
        <span id ="damiImage">
            사진
        </span>
        <div class="profileContainer">
            <ul>
                <li>
                    <span class="detail"> {{object.job}}</span>
                    <span>{{object.name}}</span>
                 </li>
                 <li>
                     <span class="detail">키</span>
                     <span>{{object.tall}}</span>
                 </li>
                 <li>
                     <span class="detail">출생</span>
                     <span>{{object.birthday}}</span>
                 </li>
                 <li>
                     <span class="detail">학력</span>
                     <span>{{object.Education}}</span>
                 </li>
            </ul>
        </div>
        <button>
            upload
        </button>
    </div>
</template>

<script>

    export default {
        name: "ProfileContent",
        data: ()=>{
            return {
                object : {
                    name: "김다미",
                    job : "영화배우",
                    birthday: "1995.4.9",
                    tall: "170cm",
                    Education: "인천대학교"
                }
            }
        }
    }
</script>

<style scoped>

    #damiImage{
        display: inline-block;
        width: 200px;
        height: 200px;
        border: 1px solid purple;
    }
    .profileContainer{
        text-align: center
    }

    ul{
        display: inline-block;
        list-style-type: none;
    }

    li{
        display: flex;
        min-height: 20px;
        height: 20px;
        width: 150px;
        line-height: 20px;
        margin: 0.5rem 0;
        padding:0 0.9rem;
    }

    .detail{
        color: gray;
        font-size: 12px;
    }

    @media screen and (min-width: 992px) and (min-height: 900px){
        li{
            height: 40px;
            line-height: 40px;
            width: 200px;
        }
    }

</style>