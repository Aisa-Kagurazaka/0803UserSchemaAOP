package advice;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class Advice {
	
	private static final Logger log = Logger.getLogger(Advice.class);
	
	
	/**
	 * 前置通知，发送验证码
	 * @param pj
	 */
	public void messageBefore(JoinPoint pj) throws Throwable {
		int num = (int)(Math.random()*1000000);
		if(num<100000){
			num=num+100000;
		}
		System.out.println("\n-----------------------前置增强-------------------------\n发送验证码："+num);
	}
	
	/**
	 * 后置通知，记录日志
	 * @param jp
	 * @throws Throwable
	 */
	public void logAfter(JoinPoint jp) throws Throwable {
		String methodName = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		Object target = jp.getTarget();
		log.info("\n-----------------------后置增强-------------------------\n记录日志...");
		log.info("调用了 " + target.getClass().getName() + " 的 " + methodName + " 方法，" 
					+ "参数：" + Arrays.toString(args));
	}
	
	/**
	 * 环绕增强，记录系统时间
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	public Object timestampAround(ProceedingJoinPoint pjp) throws Throwable{
		Object[] args = pjp.getArgs();
		String methodName = pjp.getSignature().getName();
		System.out.println("\n-----------------------环绕增强-------------------------\n");
		System.out.println("执行之前记录系统时间..." + System.currentTimeMillis());
		Object obj = pjp.proceed();
		System.out.println("目标方法：" + methodName +"参数："+Arrays.toString(args));
		System.out.println("\n-----------------------环绕增强-------------------------\n");
		System.out.println("执行之后记录系统时间..." + System.currentTimeMillis());
		return obj;
	}
	
	/**
	 * 异常抛出增强
	 * @param jp
	 * @throws Throwable
	 */
	public void error(JoinPoint jp) throws Throwable{
		System.out.println("出错啦："+jp.getSignature().getName());
	}
	
}
