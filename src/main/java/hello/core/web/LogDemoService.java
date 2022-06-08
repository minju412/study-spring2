package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    private final MyLogger myLogger; // 의존관계를 주입받는다.

    public void logic(String id) {
        myLogger.log("service id = " + id);
    }
}
