package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // 문제 상황
//        /*
//         ThreadA: 사용자 A가 10000원 주문
//         */
//        statefulService1.order("userA", 10000);
//        /*
//         ThreadB: 사용자 B가 20000원 주문 -> A가 주문하고 조히하는 사이에 B가 끼어든 상황!
//         */
//        statefulService2.order("userB", 20000);
//        /*
//         ThreadA: 사용자 A가 주문 금액 조회
//         */
//        int price = statefulService1.getPrice();
//        System.out.println("price = " + price);
//        assertThat(statefulService1.getPrice()).isEqualTo(20000);

        // 문제 해결
        int userAPrice = statefulService1.order("userA", 10000);
        int userBPrice = statefulService2.order("userB", 20000);
        System.out.println("price = " + userAPrice);
        assertThat(userAPrice).isEqualTo(10000);
    }

    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}