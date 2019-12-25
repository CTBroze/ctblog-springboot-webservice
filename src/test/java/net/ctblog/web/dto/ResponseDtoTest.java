package net.ctblog.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ResponseDtoTest {

    @Test
    public void lombok_function_test(){
        //given
        String name = "test";
        int amount = 1000;

        //when
        ResponseDto dto = new ResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
        /*
        assertThat:
        assertj라는 테스트 검증 라이브러리의 검증 메소드
        검증하고 싶은 대상을 메소드 인자로 받는다
        isEqualTo:
        assertj의 동등 비교 메소드
        asserThat에 있는 값과 isEqualTo의 값을 비교해서 같은때만 성공처리
         */
    }
}
