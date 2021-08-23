package com.promising.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
	 Logger logger =  LoggerFactory.getLogger(LogAspect.class);

	 @Around("execution(* com.promising.*.*.*(..))")
	    public Object logging(ProceedingJoinPoint pjp)  {
		 Long start = System.currentTimeMillis();  
		 logger.info("start - " + pjp.getSignature().getDeclaringTypeName() + " / " + pjp.getSignature().getName());
	        Object result = null;
			try {
				result = pjp.proceed();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Long end = System.currentTimeMillis();
	        logger.info("finished - " + pjp.getSignature().getDeclaringTypeName() + " / " + pjp.getSignature().getName()+" 소요시간은 "+((end-start)*0.001)+"초 입니다.");
	        return result;
	    }

}
