package com.eun.getinline.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {

    @GetMapping("/")
    public String root() throws Exception{
        //spring의 경우 jsp를 전통적으로... (tomcat)
        //JspTemplateAvailabilityProvider -webapp 경로 정의되어있음
        // jsp를 사용하지 않으려고 Autoconfiguration 이용 - 아무 템플릿엔진 이용 (ex> thymeleaf 이용시 자동으로 main\resources\templates경로 설정됨)
        // https://spring.io/guides/tutorials/react-and-spring-data-rest/
        //WebMvcAutoConfiguration
        //throw new Exception("test");
        return "index";
    }


}
