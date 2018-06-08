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
		System.out.println("手机静音");
		System.out.println("找到座位");
		jp.proceed();
		System.out.println("鼓掌！");
		} catch (Throwable e) {
			e.printStackTrace();
			System.out.println("这演的啥啊！退票！");
		}
	}
}
