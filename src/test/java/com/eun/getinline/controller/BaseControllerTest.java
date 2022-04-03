package com.eun.getinline.controller;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
//@AutoConfigureMockMvc
//@SpringBootTest
@WebMvcTest(BaseController.class)
class BaseControllerTest {

    //@Autowired
    //private MockMvc mvc;

    private final MockMvc mvc;

    //Junit 5 부터 생성자 주입 가능해짐
    public BaseControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("[view][GET] 기본 페이지 요청")
    @Test
    void givenNothing_whenRequestingRootPage_thenReturnsIndexPage() throws Exception {
        //Given

        // When & then
        mvc.perform(get("/"))
                .andExpect(status().isOk())
                /*.andExpect(content().contentType(MediaType.TEXT_HTML_VALUE + ";charset=UTF-8"))*/
                /*.andExpect(content().contentType(MediaType.valueOf("text/html;charset=UTF-8"))*/
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML_VALUE))
                .andExpect(content().string(containsString("This is default page.")))
                .andExpect(view().name("index"))
                .andDo(print());
    }

    @Test
    void whenthen(@Autowired MockMvc mvc2) throws Exception {
        //Given

        // When
        ResultActions result = mvc2.perform(get("/"));

        // then
        result
                .andExpect(status().isOk())
                /*.andExpect(content().contentType(MediaType.TEXT_HTML_VALUE + ";charset=UTF-8"))*/
                /*.andExpect(content().contentType(MediaType.valueOf("text/html;charset=UTF-8"))*/
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML_VALUE))
                .andExpect(content().string(containsString("This is default page.")))
                .andExpect(view().name("index"))
                .andDo(print());
    }
}