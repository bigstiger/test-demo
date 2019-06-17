package com.stiger.party;

interface Player{
	void show();
}

public class ZhaoBenShan implements Player {
	public void show(){
		System.out.println("赵本山表演拐卖~~");
	}
}

class LiuQian implements Player {
	public void show(){
		System.out.println("刘谦表演大便~~");
	}
}
