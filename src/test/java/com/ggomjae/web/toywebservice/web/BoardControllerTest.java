package com.ggomjae.web.toywebservice.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class BoardControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void initTest() throws Exception{
        String hello = "Gomjae";
        mvc.perform(get("/api/board"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    public void boardtest() throws Exception{
        String name = "gae";
        int amount = 28;

//        mvc.perform(get("/api/board/dto")
//        .param("name",name)
//        .param("amount",String.valueOf(amount)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.name",is(name)))
//                .andExpect(jsonPath("$.amount",is(amount)));

    }

}
