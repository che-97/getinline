package com.eun.getinline.controller.api;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.web.servlet.function.ServerResponse.ok;
import static org.springframework.web.servlet.function.ServerResponse.created;

import java.net.URI;
import java.util.List;

@Component
public class APIPlaceHandler {

    //router에서 .GET("" , req -> ServerResponse.ok().body(List.of("place1", "place2"))) 의
    // req -> ServerResponse.ok().body(List.of("place1", "place2")) 부분분
    public ServerResponse getPlaces(ServerRequest request) {
       return ok().body(List.of("place1", "place2"));
    }

    public ServerResponse createPlaces(ServerRequest request) {
        return created(URI.create("/api/places/1")).body(true); // TODO : 1은 구현할 때 제대로 넣어주자
    }

    public ServerResponse getPlace(ServerRequest request) {
        return ok().body("place "+ request.pathVariable("placeId"));
    }

    public ServerResponse modifyPlaces(ServerRequest request) {
        return ok().body(true);
    }

    public ServerResponse removePlaces(ServerRequest request) {
        return ok().body(true);
    }


}
