Fan of Celebrity webservice
==================== 
vue + springboot + jpa 
------------ 
### Project Description    
>  '김다미'배우에 대한 팬 운영 사이트. Vue.js, SpringBoot , ORM JPA, Maria DB를 이용.<br> 
>AWS S3를 이용한 Profile file upload, AWS EC2를 이용해서 배포 및 운영.  <br>
> 모바일 웹으로 개발된 애플리케이션이 특징<br>

>Author 민경재[GGOMJAE] <br>
2020.04.04 ~ ING <br>
* 개인 개발 블로그 링크 <https://blog.naver.com/ggomjae/221890680558> <br>
### 개발 상황
>1.vue + springboot 연동, Proxy 설정으로 CORS문제 해결<br>
>2.vue router - /enter , /board<br>
>3.front ----> server.data return ----->front<br>
>4.profile component add , router<br>
>5.vue-good-table , backend : save.update - service,controller,dto<br>  
>6.BoardContent Fronted <-> BackEnd, PC,모바일에 따른 @Media 적용 등 [#24] commit 내용<br>
>7.JPA hibernate를 이용한 Posts CRUD 기능 구현<br>
>8.JPA hibernate를 이용한 댓글 이용 - 단방향 구현, 양방향 안쓴 이유<br>
>9.로딩 개선을 위한 Chunk Optimization, MAX 1로 극대화<br>
>10.AWS s3를 이용하여 Profile upload - 만약 file을 올리면 기존에 있던 파일 s3 object 삭제 <br>
>
>11.keep-alive를 이용한 component data 유지 -> 나중에 vuex를 이용하여 수정 예정<br>

### Screenshots 과 세부 내용
<br>

>**[2020.04.29] :구조 및 1,2,3 스크린샷 [ 계속 update ]** <br>
<div>
    <img width ="300" src = "https://user-images.githubusercontent.com/43604493/82628329-81967400-9c27-11ea-9222-317c788b6b1f.JPG">
    <img width ="300" src = "https://user-images.githubusercontent.com/43604493/80437214-ff72a280-893b-11ea-96f0-9a2a3dbce99b.JPG">
</div>
<br>

```proxy```를 이용하여 fronted,back port ```CORS 해결```


```bash
devServer : {
        proxy : {
            '/api' : {
                target : 'http://localhost:9000',
                ws : true,
                changeOrigin: true
            },
        },
    }
```

<br>

>**[2020.05.03] : 4 profile component add , router**<br>
<div>
    <img height="300" src = "https://user-images.githubusercontent.com/43604493/80930510-f9266f80-8dee-11ea-83f1-1316b26e1189.JPG">
</div>

<br>

```vue-router```를 이용해 경로에 따른 component load<br>
```code splitting```를 이용하여 코드 분할

```bash
import VueRouter from 'vue-router';
export const router = new VueRouter({
    mode: 'history',
    routes: [
        {
            path: '/enter',
            component: ()=> import('../views/Enter.vue'),
            name: 'Enter'
        },
     ...
```

<br>


>**[2020.05.08] : 5,6 스크린샷** <br>
<div>
    <img height="300" src = "https://user-images.githubusercontent.com/43604493/81408988-3b4a0b00-9179-11ea-8987-16c56b2c0f4b.JPG">
</div>

<br>

```vue-good-table```을 이용한 table 구현<br>

```bash
import 'vue-good-table/dist/vue-good-table.css'
import  { VueGoodTable }  from 'vue-good-table';

data: ()=>{
            return {
                columns: [
                    {
                        label: '작성자',
                        field: 'author',
                        sortable: false,
                    },
            ...
```

```Controller,Service,JPA```를 이용한 데이터 긁기<br>
각 구현 일부분
```bash

@GetMapping("/api/board/all")
public List<PostsListResponseDto> findAllPosts(){
     logger.info("ggomjae");
     List<PostsListResponseDto> postAll = postsService.findAllDesc();

     return postAll;
}

@Transactional(readOnly = true)
public List<PostsListResponseDto> findAllDesc(){

     return postsRepository.findAllDesc().stream()
             .map(PostsListResponseDto::new)
             .collect(Collectors.toList());
}

public interface ReplysRepository extends JpaRepository<Replys, Long> {

    @Query("SELECT r FROM Replys r WHERE r.bno = ?1 AND r.rno > 0 ORDER BY r.rno ASC")
    List<Replys> getReplys(Long bno);
}
```
>**[2020.05.11] : 7 JPA hibernate를 이용한 Posts CRUD 기능구현**<br>

<br>

```CRUD``` 사진과 현재까지의 ```모든 과정```

<div>
    <img height="300" src = "https://user-images.githubusercontent.com/43604493/81544719-d8dc4f00-93b2-11ea-86e3-ff3bf62f7680.JPG">
</div>

* /enter 에서 /board로 가는 경로 과정을 이미지화
    * 현재 저장되어있는 posts를 보여주는 board 

<br>

<div>
    <img height="300" src = "https://user-images.githubusercontent.com/43604493/81544723-da0d7c00-93b2-11ea-8a10-a8cfeb20f68e.JPG">
</div>

* /save 에서 posts를 저장후 update 된 /board로 가는 경로 과정을 이미지화
    * 저장한 posts를 보여주는 /BoardContent 경로에 있는 Content  

<br>

<div>
    <img height="300" src = "https://user-images.githubusercontent.com/43604493/81544725-daa61280-93b2-11ea-9e90-3037046f4a1d.JPG">
</div>

* /BoardContent 에서 삭제,수정을 통해 Posts Update
    
<br>

>**[2020.05.14] : 8 JPA hibernate를 이용한 댓글 이용 - 단방향 구현**<br>

<br>

```단반향``` 으로 구현<br>
```양방향``` 으로 구현 안한 이유 : 개인 블로그 <https://blog.naver.com/ggomjae/221965307769> <br>
<div>
    <img height="300" src = "https://user-images.githubusercontent.com/43604493/82350370-39642f80-9a36-11ea-8118-c90316019f31.JPG">
</div>

* /ReplySave 경로에서 Reply content 저장후 /boardContent Update

>**[2020.05.17] : 9 로딩 개선을 위한 Chunk Optimization**<br>

<br>

```bash
configureWebpack: {
        plugins: [
            new webpack.optimize.LimitChunkCountPlugin({
                maxChunks: 1
            }),
        ]
    },
    filenameHashing: false,
    productionSourceMap: false
```    
<br>

>**[2020.05.18~19] : 10 AWS s3를 이용하여 Profile upload**<br>

<div>
    <img height="300" src = "https://user-images.githubusercontent.com/43604493/82358843-0c1d7e80-9a42-11ea-85dd-889efa032104.JPG">
</div>

<br>

```bash
[vue]

<input type="file" ref="file" v-on:change="handleFileUpload()">
<button  v-on:click="fileSubmit()">
            Submit
</button>

axios.post('/api/fileupload',formData,{
        headers: {
           'Content-Type': 'multipart/form-data'
}
```
* vue를 통해 file upload, multipart를 이용하여 서버단으로 전송
```bash
[Filecontroller]
@RequiredArgsConstructor
@RestController
public class FileController {

    private final S3Service s3Service;

    @PostMapping("/api/removeFile")
    public boolean removeFile(@RequestBody String filePath){
         ...

         return false;
    }

    @PostMapping("/api/fileupload")
        public String execWrite(@RequestParam("file") MultipartFile multipartFile)throws IOException {
            
        return s3Service.upload(multipartFile);
    }
}

[S3service]
public String upload(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
      
        s3Client.putObject(new PutObjectRequest(bucket, fileName, file.getInputStream(), null)
                .withCannedAcl(CannedAccessControlList.PublicRead));
        return s3Client.getUrl(bucket, fileName).toString();
}   
```
* ```s3Service```는 ```AWS S3의 비즈니스 로직```을 담당, 파일 조작
    * service의 upload를 통해 로직 구현
    
```bash
if(this.imgData !== '') {
        axios.post('/api/removeFile', { imgPath: this.imgData
            })
            .then(response => {
                       console.log(response.data);
            }).catch(e => {
                       console.log('error:', e)
            });
}

this.file = this.$refs.file.files[0];
```
* Profile upload이기 때문에 기존에 S3에 있던 file 이 있으면 삭제하기 위해 imgPath 전송
    * ```keep-alive```를  통해 data 유지, data에 있으면 axios로 전송

```bash
[FileController]
@PostMapping("/api/removeFile")
    public boolean removeFile(@RequestBody String filePath){

        String temp = filePath;

        int idx = filePath.lastIndexOf("/");
        temp = temp.substring(idx+1);
        idx = temp.indexOf('"');
        String realPath = temp.substring(0,idx);
        logger.info(realPath);

        if(s3Service.delete(realPath))
            return true;
        return false;
    }
}

[S3Service]
s3Client.deleteObject(bucket, currentFilePath);
```
* File형태가 아닌 String 형태로 전송했기 때문에 ```lastIndexOf```와 ```Substring```으로 FilePath 구함
    * FilePath를 ```s3Service.delete``` 를 통해 로직 실행

<br>

> **[2020.05.19] : 11 keep-alive를 이용한 component data 유지**<br>
<div>
    <img height="300" src = "https://user-images.githubusercontent.com/43604493/82354068-48011580-9a3b-11ea-8948-ea59929dcf98.JPG">
</div>

* /Profile에서 File을 올리고 다시 경로를 바꾸면 refrash로 image가 없어지는 형상.
    * ```keep-alive```를 통해 component data 유지 -> vuex로 다시 바꿀 예정
```bash
<keep-alive  include="Profile">
      <router-view></router-view>
</keep-alive>
```
<div>
    <img height="300" src = "https://user-images.githubusercontent.com/43604493/82350376-3b2df300-9a36-11ea-99f1-0cc99b983638.JPG">
</div>

### 끝맺음