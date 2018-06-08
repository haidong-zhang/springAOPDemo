package com.haidong.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * ʹ��spring-aop������־
 * @author xy_ha
 *
 */
@Order(value=1)
@Aspect
@Component
public class LogAspect {
	//�����е�execution��ȡ������ע��.*֮�䲻���пո�
	@Pointcut(value="execution(* *.*(..))")
	public void myPoint(){
		
	}
	
	//��һ��*��ʾ����ȫ���ͣ��ڶ���*��ʾȫ����
	@Before(value="execution(public * *.*(int,int))")
	public void logStart(JoinPoint joinPoint){
		//��ȡ�����б�
		Object[] args = joinPoint.getArgs();
		
		//��ȡ����ǩ��
		Signature signature = joinPoint.getSignature();
		
		//��ȡ������
		String name = signature.getName();
		
		System.out.println("��־��"+name+"��"+"��ʼִ��"+" �����б�:"+Arrays.asList(args));
	}
	
	@After(value="execution(* com.haidong.inf.CalculatorInf.*(..))")
	public void logEnd(JoinPoint joinPoint){
		String name = joinPoint.getSignature().getName();
		System.out.println("��־��"+name+"������ִ����ɣ�");
	}
	
	@AfterReturning(value="execution(* com.haidong.inf.CalculatorInf.*(..))",returning="rt")
	public void logReturn(JoinPoint joinPoint,Object rt){
		String name = joinPoint.getSignature().getName();
		System.out.println("��־��"+name+"�������������أ�����ֵΪ��"+rt);
	}
	
	@AfterThrowing(value="execution(* *.*(..))",throwing="e")
	public void logExeption(JoinPoint joinPoint ,Exception e){
		String name = joinPoint.getSignature().getName();
		System.out.println("��־��"+name+"�������쳣"+e);
	}
	
	/*@Around(value="execution(* *.*(..))")
	public void logAround(JoinPoint joinPoint){
		String name = joinPoint.getSignature().getName();
		System.out.println("��־��"+name+"������Ŷ��");
	}*/
	
	public static void main(String[] args) {
		System.out.println(Math.round(-11.5));
	}
}
