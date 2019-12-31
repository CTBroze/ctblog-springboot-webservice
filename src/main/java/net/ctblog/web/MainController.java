package net.ctblog.web;

import net.ctblog.web.dto.ResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //컨트롤러를 JSON을 반환하는 컨트롤러로 만들어준다.
public class MainController {
    @GetMapping("/test") //HTTP메서드인 GET의 요청을 받을 수 있는 API를 만들어준다.
    public String test(){ //test로 요청이들어오면 문자열test 반환
        return "test";
    }
    @GetMapping("/test/dto")
    public ResponseDto mainDto(@RequestParam("name") String name, @RequestParam("amount") int amount) { //@RequestParam 외부에서 API로 넘긴 파라미터를 가져오는 어노테인션
        return new ResponseDto(name, amount);
    }

}
