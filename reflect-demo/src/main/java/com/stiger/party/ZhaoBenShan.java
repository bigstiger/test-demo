package com.stiger.party;

interface Player{
	void show();
}

public class ZhaoBenShan implements Player {
	public void show(){
		System.out.println("�Ա�ɽ���ݹ���~~");
	}
}

class LiuQian implements Player {
	public void show(){
		System.out.println("��ǫ���ݴ��~~");
	}
}
