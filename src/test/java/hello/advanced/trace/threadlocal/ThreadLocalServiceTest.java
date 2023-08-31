package hello.advanced.trace.threadlocal;

import hello.advanced.trace.threadlocal.code.FieldService;
import hello.advanced.trace.threadlocal.code.ThreadLocalService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ThreadLocalServiceTest {
    private ThreadLocalService threadLocalService = new ThreadLocalService();

    // 동시성문제 -> 주로 싱글톤, static 같은 공용 필드에 접근할때 발생, 값을 변경할때 유의!!
    @Test
    void field() {
        log.info("main start");
        Runnable userA = () -> {
            threadLocalService.logic("userA");
        };
        Runnable userB = () -> {
            threadLocalService.logic("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadA.setName("thread-B");

        threadA.start();
        //sleep(2000); // 동시성 문제 발생 x
        sleep(100); // 동시성 문제 발생 O
        threadB.start();

        sleep(3000); // 메인쓰레드 종료 대기

        log.info("main exit");
    }


    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}