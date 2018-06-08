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
		System.out.println("�ص��ֻ�");
	}
	
	@Before("myPointcut()")
	public void takeSeats(){
		System.out.println("�ҵ���λ");
	}
	
	@AfterReturning("myPointcut()")
	public void applause(){
		System.out.println("���ĺúð������ƣ�����");
	}
	
	@AfterThrowing("myPointcut()")
	public void demanRefund(){
		System.out.println("ʲô����Ʊ����Ʊ��");
	}
}
