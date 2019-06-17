package com.stiger.party;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * 工厂类: 生产商品
 *	
 *	1. 通常是静态方法
 *
 *	基本工厂模式: 反射 + 配置文件
 *		1. 跟具体商品进行解耦,只跟抽象商品有关
 *		2. 配置文件
 *			1. 将动态易变化的部分转移到配置文件中
 *			2. 那么需求变动,只需更改文件内容,代码无需变动(无需编译,无需部署)
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
