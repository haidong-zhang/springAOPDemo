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
		System.out.println("我在切面中，我会在playTrack()运行前被调用"+trac);
		System.out.println("我在切面中，我会在playTrack()运行前被调用"+number);
	}
}
