package com.stiger.party;

/**
 * �������:
 * 		Ϊ�˺����,����ѧϰ�ɱ�,��ߴ�����չ��
 * 		������չ��: ����ı��ʱ��,����ĵ�Խ��,��չ��Խǿ
 * ����: 
 * 		1. ��ʱ����~~
 * 	
 * 	���: 
 * 		1. ��̬ -> ��һ����ߴ������չ��
 *		2. ����������  - > �������ģʽ
 *			1. ��϶�: ����ɾ��һ�����ʱ��,����Ե�ǰ��Ӱ��ԽС,��϶�Խ��
 *			2. ����: ������϶�
 *		3. ����
 *			1. �ô������ͨ����: ����ı��ʱ��,���벻��Ҫ�䶯
 */
public class PartyDemo {
	
	public static void main(String[] args) {
		
		System.out.println("��Ὺʼ��~~");
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
		System.out.println("�������~~");
	}
}
