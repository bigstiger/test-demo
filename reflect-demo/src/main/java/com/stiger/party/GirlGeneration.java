package com.stiger.party;

interface Dancer{
	void dance();
}

public class GirlGeneration implements Dancer {
	public void dance(){
		System.out.println("少女时代表演 Gee Gee Gee...");
	}
}

class AKB48 implements Dancer {
	public void dance(){
		System.out.println("AKB48 表演 卖萌~~");
	}
}
