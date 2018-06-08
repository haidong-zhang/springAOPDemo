package com.haidong.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.haidong.config.ConcertConfig;
import com.haidong.entity.CompactDisc;
import com.haidong.inf.CalculatorInf;
import com.haidong.inf.Performer;
import com.haidong.inf.Singer;

public class AOPTest {
    @Test
    public void test1(){
    	ApplicationContext ioc = new ClassPathXmlApplicationContext(
    			"applicationContext.xml");
    	CalculatorInf bean = ioc.getBean(CalculatorInf.class);
    	System.out.println(bean.sum(1, 2));
    	
    	System.out.println("----------------");
    	
    	System.out.println(bean.div(1, 2));
    	
//    	Object bean = ioc.getBean("aBean");
//    	Object bean = ioc.getBean("calculator");
    	System.out.println(bean);
    }
    
    @Test
    public void testDancer(){
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConcertConfig.class);
//    	context.register(ConcertConfig.class);
//    	context.refresh();
    	Performer bean = context.getBean(Performer.class);
    	bean.perform();
    }
    
    @Test
    public void testTrackCounter(){
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConcertConfig.class);
    	CompactDisc bean = context.getBean(CompactDisc.class);
    	bean.playTrack(3,4);
    }
    
    @Test
    public void testIntroducer(){
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.haidong");
    	Performer per = (Performer)context.getBean("dancer");
    	Singer singer = (Singer)per;
    	singer.sing();
    	
//    	((Singer)per).sing();
    	
    }
}
