package com.stiger.party;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * ������: ������Ʒ
 *	
 *	1. ͨ���Ǿ�̬����
 *
 *	��������ģʽ: ���� + �����ļ�
 *		1. ��������Ʒ���н���,ֻ��������Ʒ�й�
 *		2. �����ļ�
 *			1. ����̬�ױ仯�Ĳ���ת�Ƶ������ļ���
 *			2. ��ô����䶯,ֻ������ļ�����,��������䶯(�������,���貿��)
 *			
 */
public class PartyFactory {
	static Properties p = new Properties();
	static{
		try {
			p.load(new FileInputStream("party.properties"));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Singer getSinger(){
		Singer singer = null;
		try {
			String name = p.getProperty("singer");
			Class<?> clazz = Class.forName(name);
			singer = (Singer) clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		Singer singer = new LiuDeHua();
		return singer;
	}
	public static Dancer getDancer(){
		Dancer dancer = null;
		try {
			String name = p.getProperty("dancer");
			Class<?> clazz = Class.forName(name);
			dancer = (Dancer) clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dancer;
	}
	public static Player getPlayer(){
		Player player = null;
		try {
			String name = p.getProperty("player");
			Class<?> clazz = Class.forName(name);
			player = (Player) clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return player;
	}
	
}
