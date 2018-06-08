package com.haidong.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
@Aspect
public class AudienceAspect {
	
	@Pointcut("execution(* com.haidong.inf.Performer.perform(..))")
	public void myPointcut(){}
	
	@Before("myPointcut()")
	public void silienceCellPhone(){
		System.out.println("关掉手机");
	}
	
	@Before("myPointcut()")
	public void takeSeats(){
		System.out.println("找到座位");
	}
	
	@AfterReturning("myPointcut()")
	public void applause(){
		System.out.println("跳的好好啊，鼓掌！！！");
	}
	
	@AfterThrowing("myPointcut()")
	public void demanRefund(){
		System.out.println("什么鬼，退票！退票！");
	}
}
