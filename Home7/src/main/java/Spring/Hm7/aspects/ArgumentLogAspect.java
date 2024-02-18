package Spring.Hm7.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication != null ? authentication.getName() : "anonymous";
        log.info("Arg name: {} Имя вызвавшего пользователя: {}", joinPoint.getArgs()[0], username);
    }

}
