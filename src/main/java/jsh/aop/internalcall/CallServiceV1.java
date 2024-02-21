package jsh.aop.internalcall;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CallServiceV1 {


    // 스프링 부트 2.6 부터는 수정자로 자기 자신 주입이 불가능하다.
    // spring.main.allow-circular-references=true 설정 필요
//    private CallServiceV1 callServiceV1;
//
//    @Autowired
//    public void setCallServiceV1(CallServiceV1 callServiceV1) {
//        this.callServiceV1 = callServiceV1;
//    }

    public void external() {
        log.info("call external");
//        callServiceV1.internal(); //외부 메서드 호출
    }

    public void internal() {
        log.info("call internal");
    }
}
