package aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    int count = 0;

    @After("execution(public * service.impl.BorrowOrderService.findAll())")
    public void log() {
        System.out.println("===================> START LOG <===========================");
        count++;
        System.out.println(count);
//        String nameClass = joinPoint.getTarget().getClass().getSimpleName();
//        String method = joinPoint.getSignature().getName();
//        System.out.println(nameClass + "." + method);
//        System.out.println(result.toString());
    }
}
