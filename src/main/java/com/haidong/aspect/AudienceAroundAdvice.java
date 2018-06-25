package com.haidong.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
@Aspect
public class AudienceAroundAdvice {
	
	@Pointcut("execution(* com.haidong.inf.Performer.perform(..))")
	public void myPointcut(){}
	
	@Around("myPointcut()")
	public void watchPerformance(ProceedingJoinPoint jp){
		try {
		 System.out.println("�ֻ�����");
		System.out.println("�ҵ���λ");
		jp.proceed();
		System.out.println("���ƣ�");
		} catch (Throwable e) {
			e.printStackTrace();
			System.out.println("���ݵ�ɶ������Ʊ��");
		}
	}
}
