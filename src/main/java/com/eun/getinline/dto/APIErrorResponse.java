package com.eun.getinline.dto;

import com.eun.getinline.constant.ErrorCode;
import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
// @NorgsConstructor : 파라미터가 없는 기본 생성자 생성 , 지금은 기본생성자 필요없음... 파라미터 반드시 필요...
@RequiredArgsConstructor(access = AccessLevel.PROTECTED) //final이나 @NonNull 인 필드 값만 파라미터로 받는 생성자 생성, 접근 권한이 protected, 상속받은 클래스에서는 생성자 접근가능하도록
public class APIErrorResponse {

    private final Boolean success;
    private final Integer errorCode;
    private final String message;

    //생성자에 넣는 필드의 데이터 타입 형식을 다르게 하기 위해 아래와 같은 방식으로...
    public static APIErrorResponse of(Boolean success, Integer errorCode, String message) {
        return new APIErrorResponse(success, errorCode, message);
    }

    public static APIErrorResponse of(Boolean success, ErrorCode errorCode) {
        return new APIErrorResponse(success, errorCode.getCode(), errorCode.getMessage());
    }

    public static APIErrorResponse of(Boolean success, ErrorCode errorCode, Exception e) {
        return new APIErrorResponse(success, errorCode.getCode(), errorCode.getMessage(e));
    }

    public static APIErrorResponse of(Boolean success, ErrorCode errorCode, String message) {
        return new APIErrorResponse(success, errorCode.getCode(), errorCode.getMessage(message));
    }

}
