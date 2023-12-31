package hello.advanced.trace.strategy.code.strategy;

import hello.advanced.trace.strategy.code.template.Callback;
import hello.advanced.trace.strategy.code.template.TimeLogTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateCallbackTest {

    /**
     * template call back pattern - 익명 내부 클래스, + 람다
     */

    @Test
    void callbackV1() {

        TimeLogTemplate template = new TimeLogTemplate();
        template.execute(() -> {log.info("비즈니스 로직1 실행");});
        template.execute(() -> {log.info("비즈니스 로직2 실행");});
    }
}
