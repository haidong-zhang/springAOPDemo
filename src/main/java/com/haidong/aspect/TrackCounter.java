package com.haidong.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TrackCounter {
	@Pointcut("execution(* com.haidong.entity.CompactDisc.playTrack(int,int)) && args(numb,trackNum)")
	public void trackPlayed(int numb,int trackNum){
		
	}
	
	@Before("trackPlayed(trac,number)")
	public void countTrack(int trac,int number){
		System.out.println("���������У��һ���playTrack()����ǰ������"+trac);
		System.out.println("���������У��һ���playTrack()����ǰ������"+number);
	}
}
