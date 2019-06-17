package com.stiger.party;
/**
 * 
 * Singer :抽象商品
 * ZhangXueYou :实际商品
 *
 */
interface Singer{
	void sing();
}

public class ZhangXueYou implements Singer {
	
	public void sing(){
		System.out.println("张学友演唱: 吻别!");
	}
}

class LiuDeHua implements Singer {
	public void sing(){
		System.out.println("刘德华演唱: 冰雨!");
	}
}

class WangJie implements Singer {
	@Override
	public void sing() {
		System.out.println("王杰:不浪漫罪名~~");
	}
}
