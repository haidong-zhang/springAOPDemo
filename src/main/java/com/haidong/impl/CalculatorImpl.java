package com.haidong.impl;

import org.springframework.stereotype.Component;

import com.haidong.inf.CalculatorInf;
/**
 * 计算器实现类
 * @author xy_ha
 *
 */
@Component
public class CalculatorImpl implements CalculatorInf {

	@Override
	public int sum(int a, int b) {
		return a+b;
	}

	@Override
	public int sub(int a, int b) {
		return a-b;
	}

	@Override
	public int mul(int a, int b) {
		return a*b;
	}

	@Override
	public int div(int a, int b) {
		return a/b;
	}

}
