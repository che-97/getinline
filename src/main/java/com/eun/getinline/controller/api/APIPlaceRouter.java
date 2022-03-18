package com.eun.getinline.controller.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.web.servlet.function.RequestPredicates.path;
import static org.springframework.web.servlet.function.RouterFunctions.route;


@Configuration
public class APIPlaceRouter {
    //함수형 프로그래밍 Router



    @Bean
    public RouterFunction<ServerResponse> placeRouter(APIPlaceHandler apiPlaceHandler){
        return route().nest(path("/api/places"),builder -> builder
                // APIPlaceController
                // http://localhost:8080/actuator/mappings 에 보이지 않음
                // request mapping path를 보여주기 때문
                // http://localhost:8080/actuator/beans router bean등록된것은 확인할 수 있음
                //.GET("" , req -> ServerResponse.ok().body(List.of("place1", "place2")))
                .GET("" , apiPlaceHandler::getPlaces)
                .POST("" , apiPlaceHandler::createPlaces)
                .GET("/{placeId}" ,apiPlaceHandler::getPlace)
                .PUT("/{placeId}" , apiPlaceHandler::modifyPlaces)
                .DELETE("/{placeId}" , apiPlaceHandler::removePlaces)
        ).build();
    }
}
