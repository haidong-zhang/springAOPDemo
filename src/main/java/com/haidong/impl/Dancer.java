package com.haidong.impl;

import com.haidong.inf.Performer;

public class Dancer implements Performer{

	@Override
	public void perform() {
		System.out.println("请开始你的表演！");
		System.out.println("跳舞开始！");
	}
}
