package com.stiger.party;
/**
 * 
 * Singer :������Ʒ
 * ZhangXueYou :ʵ����Ʒ
 *
 */
interface Singer{
	void sing();
}

public class ZhangXueYou implements Singer {
	
	public void sing(){
		System.out.println("��ѧ���ݳ�: �Ǳ�!");
	}
}

class LiuDeHua implements Singer {
	public void sing(){
		System.out.println("���»��ݳ�: ����!");
	}
}

class WangJie implements Singer {
	@Override
	public void sing() {
		System.out.println("����:����������~~");
	}
}
