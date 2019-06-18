package com.stiger.proxy;

interface ArithInte{
	int add(int x, int y);
	int minus(int x, int y);
	int multiply(int x, int y);
	int devide(int x, int y);
}

public class ArithClass implements ArithInte{
	@Override
	public int add(int x, int y) {
		int sum = x + y;
//		System.out.println("^-^加法运算开始了哦~~");
		return sum;
	}
	@Override
	public int minus(int x, int y) {
		int minus = x - y;
		return minus;
	}
	@Override
	public int multiply(int x, int y) {
		int multiply = x * y;
		return multiply;
	}
	@Override
	public int devide(int x, int y) {
		int devide = x / y;
		return devide;
	}
}
