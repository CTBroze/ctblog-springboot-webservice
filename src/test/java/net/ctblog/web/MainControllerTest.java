package net.ctblog.web;

import com.sun.org.apache.xalan.internal.xsltc.runtime.ErrorMessages_zh_CN;
import net.ctblog.config.auth.SecurityConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class) //스프링부트테스트와 제이유닛사이의 연결자 역활
@WebMvcTest(controllers = MainController.class, excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class)})//Web에 집중할수있는 어노테이션
public class MainControllerTest {
    @Autowired //Spring이 관리하는 bean을 주입받는다.
    private MockMvc mvc; //스프링 MVC테스트의 시작점, API테스트 용

    @Test
    @WithMockUser(roles="USER")
    public void test_return() throws Exception{
        String test = "test";

        mvc.perform(get("/test")) //test주소로 get요청
                .andExpect(status().isOk()) //접속상태 점검
                .andExpect(content().string(test)); //응답본문의 내용을 검증
    }

    @Test
    @WithMockUser(roles="USER")
    public void Dto_return() throws Exception{
        String name = "test";
        int amount = 1000;

        mvc.perform(get("/test/dto").param("name",name).param("amount",String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name))) //jsonPath : JSON응답값을 필드별로 검증하는 메소드 $를 기준으로 필드명을 명시합니다.
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
