package com.stiger.party;

interface Dancer{
	void dance();
}

public class GirlGeneration implements Dancer {
	public void dance(){
		System.out.println("��Ůʱ������ Gee Gee Gee...");
	}
}

class AKB48 implements Dancer {
	public void dance(){
		System.out.println("AKB48 ���� ����~~");
	}
}
