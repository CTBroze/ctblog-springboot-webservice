package net.ctblog.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter //선언된 모든 필드의 get 메소드를 생성해 줍니다.
@RequiredArgsConstructor //선언된 모든 final필드가 포함된 생성자를 생성해 줍니다.
public class ResponseDto {

    private final String name;
    private final int amount;
}
