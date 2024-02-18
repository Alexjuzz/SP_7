package Spring.Hm7.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;


@Aspect
@Slf4j
@Component
public class ArgumentLogAspect {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();


    @Pointcut("execution(* Spring.Hm7.api.TaskApiController.*(..))")

    public void apiPointcut() {

    }

    @Before("apiPointcut()")
    public void beforeCallMethodArgs(JoinPoint joinPoint) {

        String username = authentication != null ? authentication.getName() : "anonymous";
        String methodName = joinPoint.getSignature().getName();
        log.info("Method name {} Argumetns name: {} Имя вызвавшего пользователя: {} ", methodName
                , Arrays.toString(joinPoint.getArgs()), username);

    }

    @AfterReturning(value = "apiPointcut()", returning = "result")
    public void afterCallMethodArgs(JoinPoint joinPoint, Object result) {
        String username = authentication != null ? authentication.getName() : "anonymous";
        log.info("Return args: {} Имя вызвавшего пользователя: {} ", result, username);
    }

}
