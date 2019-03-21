package com.stiger.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;

@Component  //交给spring创建bean
public class EmailSendUtils {
	@Autowired
	private JavaMailSender mailSender; //导入Mail.jar包自带的类,不用管
	// 获取application.yml的值
	@Value("${spring.mail.username}")
	private String form /*= "shulin.wang@nio.com"*/; //发件人邮箱地址
	@Value("${spring.mail.copyTo}")
	private String copyTo;

	// 发送邮件 附带文件
	@Async
	public void sendAttachmentsMail(String receiveUser, String subject, String content, InputStreamSource source,String fileName) {
		//创建微型邮件对象
		MimeMessage message = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(form); //发件人邮件地址
			//helper.setTo(receiveUser); //收件人邮箱地址
			helper.setSubject(subject); //邮箱标题
			helper.setText(content);//邮件内容
			String users = receiveUser + "," + copyTo;
			// 设置邮件接收方
			Address[] internetAddressTo = new InternetAddress().parse(users);
			//获取本地文件从文件输入流
			// 添加多个附件可以使用多条
			helper.addAttachment(fileName,source);
			message.setRecipients(MimeMessage.RecipientType.TO,  internetAddressTo);
			mailSender.send(message);
			System.out.println("带附件的邮件发送成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("发送带附件的邮件失败");
		}
	}

	@Async //可用不管 用于集成Dubbo 消费优化的注解
	public void sendMail(String to, String subject, String content) {
		//创建微型邮件对象
		MimeMessage message = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(form); //发件人邮件地址
			helper.setSubject(subject); //邮箱标题
			helper.setText(content);//邮件内容
			String users = to + "," + copyTo;
			// 设置邮件接收方
			Address[] internetAddressTo = new InternetAddress().parse(users);
			//获取本地文件从文件输入流
			// 添加多个附件可以使用多条
			message.setRecipients(MimeMessage.RecipientType.TO,  internetAddressTo);
			mailSender.send(message);
			System.out.println("发送简单邮件成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("发送简单邮件失败");
		}
	}

	/*@Async //可用不管 用于集成Dubbo 消费优化的注解
	public void sendMail(String to, String subject, String content) {
		// 创建邮件配置
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom(form);// 发起者
		mailMessage.setTo(to);// 接受者
		mailMessage.setSubject(subject);//发送邮件的标题
		mailMessage.setText(content);//发送内容
		try {
			mailSender.send(mailMessage);
			System.out.println("发送简单邮件");
		} catch (Exception e) {
			System.out.println("发送简单邮件失败" + e.getMessage());
		}
	}*/

}