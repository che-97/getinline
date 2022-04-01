package com.eun.getinline.controller.api;

import com.eun.getinline.constant.ErrorCode;
import com.eun.getinline.dto.APIErrorResponse;
import com.eun.getinline.exception.GeneralException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RequestMapping("/api")
@RestController
public class APIEventController {

    @GetMapping("/events")
    public List<String> getEvents() {
        //throw new GeneralException("테스트 메시지");
        return List.of("event1", "event2");
    }

    @PostMapping("/events")
    public Boolean createEvent() {
        //throw new RuntimeException("runtime 테스트 메시지");
        return true;
    }

    @GetMapping("/events/{eventId}")
    public String getEvent(@PathVariable Integer eventId) {
        return "event " + eventId;
    }

    @PutMapping("/events/{eventId}")
    public Boolean modifyEvent(@PathVariable Integer eventId) {
        return true;
    }

    @DeleteMapping("/events/{eventId}")
    public Boolean removeEvent(@PathVariable Integer eventId) {
        return true;
    }

    /*@ExceptionHandler
    public ResponseEntity<APIErrorResponse> general(GeneralException e){

        ErrorCode errorCode = e.getErrorCode();
        HttpStatus status = errorCode.isClientSideError() ? HttpStatus.BAD_REQUEST : HttpStatus.INTERNAL_SERVER_ERROR;

        //ResponseEntity는 HttpEntity를 상속받음으로써 HttpHeader와 body를 가질 수 있다.
        return ResponseEntity
                .status(status)
                .body(APIErrorResponse.of(
                   false, errorCode
                ));
    }*/
}