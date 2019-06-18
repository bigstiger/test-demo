package com.stiger.enumd;

public class EnumDemo {
	public static void main(String[] args) {
//		method();
		Color color = Color.YELLOW;
		switch (color) {
		case BLUE:
			System.out.println("蓝色");
			break;
		case YELLOW:
			System.out.println("黄色");
			break;
		case PINK:
			System.out.println("粉色");
			break;
		default:
			break;
		}
	}

	private static void method() {
		int color = ColorInte.BLUE;
		switch (color) {
		case ColorInte.PINK:
			System.out.println("粉色");
			break;
		case ColorInte.BLUE:
			System.out.println("蓝色");
			break;
		case ColorInte.YELLOW:
			System.out.println("黄色");
			break;
		default:
			break;
		}
	}
}

interface ColorInte{
	int PINK = 1 ,BLUE = 2000,YELLOW = 3;
//	int PINK = 1;
//	int BLUE = 2000;
//	int YELLOW = 3;
}

enum Color{
	PINK,
	BLUE,
	YELLOW;
}
