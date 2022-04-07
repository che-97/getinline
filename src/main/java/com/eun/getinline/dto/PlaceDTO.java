package com.eun.getinline.dto;

import com.eun.getinline.constant.PlaceType;

import java.time.LocalDateTime;

//recode jdk16 이후부터 정식
//final class로 멤버들도 final static
//생성자 자동생성 등...
public record PlaceDTO(
        PlaceType placeType,
        String placeName,
        String address,
        String phoneNumber,
        Integer capacity,
        String memo
) {
    public static PlaceDTO of(
            PlaceType placeType,
            String placeName,
            String address,
            String phoneNumber,
            Integer capacity,
            String memo
    ) {
        return new PlaceDTO(placeType, placeName, address, phoneNumber, capacity, memo);
    }
}
