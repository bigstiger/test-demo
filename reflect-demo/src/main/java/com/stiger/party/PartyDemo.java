package com.stiger.party;

/**
 * 面向对象:
 * 		为了好理解,降低学习成本,提高代码扩展性
 * 		代码扩展性: 需求改变的时候,代码改的越少,扩展性越强
 * 需求: 
 * 		1. 临时换人~~
 * 	
 * 	解决: 
 * 		1. 多态 -> 进一步提高代码的扩展性
 *		2. 方便代码管理  - > 工厂设计模式
 *			1. 耦合度: 当你删掉一个类的时候,如果对当前类影响越小,耦合度越低
 *			2. 解耦: 降低耦合度
 *		3. 反射
 *			1. 让代码具有通用性: 需求改变的时候,代码不需要变动
 */
public class PartyDemo {
	
	public static void main(String[] args) {
		
		System.out.println("晚会开始了~~");
//		ZhangXueYou zxy = new ZhangXueYou();
//		zxy.sing();
		
//		LiuDeHua ldh = new LiuDeHua();
//		ldh.sing();
		
//		Singer singer = new ZhangXueYou();
//		singer.sing();
		
		Singer singer = PartyFactory.getSinger();
		singer.sing();
		
		Dancer gg = PartyFactory.getDancer();
		gg.dance();
		
		Player zbs = PartyFactory.getPlayer();
		zbs.show();
		System.out.println("难玩今宵~~");
	}
}
