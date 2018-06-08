package com.haidong.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

import com.haidong.impl.BackSinger;
import com.haidong.inf.Singer;

/**
 * 歌手引入者
 * @author xy_ha
 *
 */
@Aspect
public class SingerIntroducer {
	@DeclareParents(value="com.haidong.inf.Performer+",defaultImpl=BackSinger.class)
	public static Singer singer;
}
