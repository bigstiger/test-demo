package com.stiger.enumd;

public class EnumDemo {
	public static void main(String[] args) {
//		method();
		Color color = Color.YELLOW;
		switch (color) {
		case BLUE:
			System.out.println("��ɫ");
			break;
		case YELLOW:
			System.out.println("��ɫ");
			break;
		case PINK:
			System.out.println("��ɫ");
			break;
		default:
			break;
		}
	}

	private static void method() {
		int color = ColorInte.BLUE;
		switch (color) {
		case ColorInte.PINK:
			System.out.println("��ɫ");
			break;
		case ColorInte.BLUE:
			System.out.println("��ɫ");
			break;
		case ColorInte.YELLOW:
			System.out.println("��ɫ");
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
