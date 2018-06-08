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
 * 使用spring-aop管理日志
 * @author xy_ha
 *
 */
@Order(value=1)
@Aspect
@Component
public class LogAspect {
	//将所有的execution抽取出来，注意.*之间不能有空格
	@Pointcut(value="execution(* *.*(..))")
	public void myPoint(){
		
	}
	
	//第一个*表示返回全类型，第二个*表示全类名
	@Before(value="execution(public * *.*(int,int))")
	public void logStart(JoinPoint joinPoint){
		//获取参数列表
		Object[] args = joinPoint.getArgs();
		
		//获取方法签名
		Signature signature = joinPoint.getSignature();
		
		//获取方法名
		String name = signature.getName();
		
		System.out.println("日志【"+name+"】"+"开始执行"+" 参数列表:"+Arrays.asList(args));
	}
	
	@After(value="execution(* com.haidong.inf.CalculatorInf.*(..))")
	public void logEnd(JoinPoint joinPoint){
		String name = joinPoint.getSignature().getName();
		System.out.println("日志【"+name+"】最终执行完成！");
	}
	
	@AfterReturning(value="execution(* com.haidong.inf.CalculatorInf.*(..))",returning="rt")
	public void logReturn(JoinPoint joinPoint,Object rt){
		String name = joinPoint.getSignature().getName();
		System.out.println("日志【"+name+"】方法正常返回，返回值为："+rt);
	}
	
	@AfterThrowing(value="execution(* *.*(..))",throwing="e")
	public void logExeption(JoinPoint joinPoint ,Exception e){
		String name = joinPoint.getSignature().getName();
		System.out.println("日志【"+name+"】出现异常"+e);
	}
	
	/*@Around(value="execution(* *.*(..))")
	public void logAround(JoinPoint joinPoint){
		String name = joinPoint.getSignature().getName();
		System.out.println("日志【"+name+"】环绕哦！");
	}*/
	
	public static void main(String[] args) {
		System.out.println(Math.round(-11.5));
	}
}
