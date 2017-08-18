package advice;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class Advice {
	
	private static final Logger log = Logger.getLogger(Advice.class);
	
	
	/**
	 * ǰ��֪ͨ��������֤��
	 * @param pj
	 */
	public void messageBefore(JoinPoint pj) throws Throwable {
		int num = (int)(Math.random()*1000000);
		if(num<100000){
			num=num+100000;
		}
		System.out.println("\n-----------------------ǰ����ǿ-------------------------\n������֤�룺"+num);
	}
	
	/**
	 * ����֪ͨ����¼��־
	 * @param jp
	 * @throws Throwable
	 */
	public void logAfter(JoinPoint jp) throws Throwable {
		String methodName = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		Object target = jp.getTarget();
		log.info("\n-----------------------������ǿ-------------------------\n��¼��־...");
		log.info("������ " + target.getClass().getName() + " �� " + methodName + " ������" 
					+ "������" + Arrays.toString(args));
	}
	
	/**
	 * ������ǿ����¼ϵͳʱ��
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	public Object timestampAround(ProceedingJoinPoint pjp) throws Throwable{
		Object[] args = pjp.getArgs();
		String methodName = pjp.getSignature().getName();
		System.out.println("\n-----------------------������ǿ-------------------------\n");
		System.out.println("ִ��֮ǰ��¼ϵͳʱ��..." + System.currentTimeMillis());
		Object obj = pjp.proceed();
		System.out.println("Ŀ�귽����" + methodName +"������"+Arrays.toString(args));
		System.out.println("\n-----------------------������ǿ-------------------------\n");
		System.out.println("ִ��֮���¼ϵͳʱ��..." + System.currentTimeMillis());
		return obj;
	}
	
	/**
	 * �쳣�׳���ǿ
	 * @param jp
	 * @throws Throwable
	 */
	public void error(JoinPoint jp) throws Throwable{
		System.out.println("��������"+jp.getSignature().getName());
	}
	
}
