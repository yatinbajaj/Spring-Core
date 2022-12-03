package aspect;

import java.util.logging.Logger;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.aspectj.lang.JoinPoint;

@Component
@Aspect
public class LoggingAspect {
	private Logger logger=Logger.getLogger(getClass().getName());
	
	@Before("execution(void com.example.springcore..*.set*(*))")   // point cut
	public void callSetter(JoinPoint jointPoint) {    
		String methodName = jointPoint.getSignature().getName().toString();
		String args = jointPoint.getArgs()[0].toString();
		logger.info("called" + methodName+" with args "+ args + " on "+jointPoint.getTarget());
	}
}
