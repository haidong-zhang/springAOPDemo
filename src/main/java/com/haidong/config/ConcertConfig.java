package com.haidong.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.haidong.aspect.AudienceAroundAdvice;
import com.haidong.aspect.SingerIntroducer;
import com.haidong.aspect.TrackCounter;
import com.haidong.entity.CompactDisc;
import com.haidong.impl.Dancer;
import com.haidong.inf.Performer;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class ConcertConfig {
	@Bean
	public AudienceAroundAdvice audience(){
		return new AudienceAroundAdvice();
	}
	
	@Bean(name="dancer")
	public Performer dancer(){
		return new Dancer();
	}
	
	@Bean
	public TrackCounter trackCounter(){
		return new TrackCounter();
	}
	
	@Bean
	public CompactDisc compactDisc(){
		return new CompactDisc();
	}
	
	@Bean
	public SingerIntroducer singerIntroducer(){
		return new SingerIntroducer();
	}
}
