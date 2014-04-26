package framework.generic.utils.mail;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import framework.generic.utils.properties.PropertiesUtil;
import framework.generic.utils.string.StringUtil;

/**
 * 简单邮件发送工具类 在 app.properties 中配置 {"mail.host","mail.username",
 * "mail.password"}即可
 * <p>
 * 项目名称：framework-generic-utils
 * </p>
 * <p>
 * 版权：2013-广州扬基信息科技有限公司
 * </p>
 * 获取值的方式 :MailUtil.getInstance().sendSimpleMail("xxx@qq.com", null, "test",
 * "123");
 * 
 * @see framework.generic.utils.mail.MailUtil
 * @version 1.0, 2013-1-6 上午8:57:13
 * @author quanyongan
 */
public class MailUtil {

	private static final String DEFAULT_ENCODING = "utf-8";
	private static Logger logger = LoggerFactory.getLogger(MailUtil.class);
	// Spring的邮件工具类，实现了MailSender和JavaMailSender接口
	public static JavaMailSenderImpl mailSender;

	public final String DEFAULT_PROPERTIES_FILE = "app.properties";
	public final String DEFAULT_HOST = "GZ-MAIL04.pousheng.com";
	public final String DEFAULT_USERNAME = "test@pousheng.com";
	public final String DEFAULT_PASSWORD = "123456789";
	protected String host;
	protected String username;
	protected String password;
	protected String fileName;
	protected static MailUtil mailUtil;

	private void init() {
		if (this.fileName == null) {
			this.fileName = DEFAULT_PROPERTIES_FILE;
		}
		this.host = PropertiesUtil.getProperty(this.fileName, "mail.host");
		this.username = PropertiesUtil.getProperty(this.fileName, "mail.username");
		this.password = PropertiesUtil.getProperty(this.fileName, "mail.password");
		if (StringUtil.isNullOrEmpty(this.host)) {
			this.host = DEFAULT_HOST;
		}
		if (StringUtil.isNullOrEmpty(this.username)) {
			this.username = DEFAULT_USERNAME;
		}
		if (StringUtil.isNullOrEmpty(this.password)) {
			this.password = DEFAULT_PASSWORD;
		}
		// 初始化JavaMailSenderImpl，当然推荐在spring配置文件中配置，这里是为了简单
		mailSender = new JavaMailSenderImpl();
		// 设置参数
		mailSender.setHost(this.host);
		mailSender.setUsername(this.username);
		mailSender.setPassword(this.password);
	}

	public MailUtil() {
		this.init();
	}
	
	/**
	* 构造函数
	* @param mail_host 邮件服务器
	* @param mail_userName 邮件用户名称
	* @param mail_password 邮件用户密码
	 */
	public MailUtil(String mail_host, String mail_userName, String mail_password) {
		this.host = mail_host;
		this.username = mail_userName;
		this.password = mail_password;
		// 初始化JavaMailSenderImpl，当然推荐在spring配置文件中配置，这里是为了简单
		mailSender = new JavaMailSenderImpl();
		// 设置参数
		mailSender.setHost(this.host);
		mailSender.setUsername(this.username);
		mailSender.setPassword(this.password);
	}
	

	public MailUtil(String fileName) {
		this.fileName = fileName;
		this.init();
	}

	public static MailUtil getInstance() {
		if (mailUtil == null) {
			mailUtil = new MailUtil();
		}
		return mailUtil;
	}

	public static MailUtil getInstance(String fileName) {
		if (mailUtil == null) {
			mailUtil = new MailUtil(fileName);
		}
		return mailUtil;
	}

	/**
	 * 发送纯文本邮件.
	 * 
	 * @param toAddress
	 *            接收者的邮箱地址
	 * @param ccAddress
	 *            抄送的邮箱地址
	 * @param subject
	 *            标题
	 * @param content
	 *            内容
	 */
	public void sendSimpleMail(String toAddress, String[] ccAddress, String subject, String content) throws MailException {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom(mailSender.getUsername());
		msg.setTo(toAddress);
		if (!StringUtil.isNullOrEmpty(ccAddress) && ccAddress.length > 0) {
			msg.setCc(ccAddress);
		}
		msg.setSubject(subject);
		msg.setText(content);
		mailSender.send(msg);
		if (logger.isInfoEnabled()) {
			logger.info("纯文本邮件已发送至{}", StringUtils.join(msg.getTo(), ","));
		}
	}

	/**
	 * 发送纯文本邮件.
	 * 
	 * @param toAddress
	 *            接收者的邮箱地址
	 * @param ccAddress
	 *            抄送的邮箱地址
	 * @param subject
	 *            标题
	 * @param content
	 *            内容
	 */
	public void sendSimpleMail(String[] toAddress, String[] ccAddress, String subject, String content) throws MailException {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom(mailSender.getUsername());
		msg.setTo(toAddress);
		if (!StringUtil.isNullOrEmpty(ccAddress) && ccAddress.length > 0) {
			msg.setCc(ccAddress);
		}
		msg.setSubject(subject);
		msg.setText(content);
		mailSender.send(msg);
		if (logger.isInfoEnabled()) {
			logger.info("纯文本邮件已发送至{}", StringUtils.join(msg.getTo(), ","));
		}
	}

	/**
	 * 发送富文本文件
	 * 
	 * @param toAddress
	 *            发送地址
	 * @param ccAddress
	 *            抄送
	 * @param subject
	 *            标题
	 * @param content
	 *            内容
	 */
	public void sendMimeMail(String toAddress, String subject, String content) throws MailException, MessagingException {
		sendMimeMail(toAddress, null, subject, content, null);
	}

	public void sendMimeMail(String[] toAddress, String[] ccAddress, String subject, String content) throws MailException, MessagingException {
		sendMimeMail(toAddress, ccAddress, subject, content, null);
	}

	public void sendMimeMail(String toAddress, String[] ccAddress, String subject, String content) throws MailException, MessagingException {
		sendMimeMail(new String[] { toAddress }, ccAddress, subject, content, null);
	}

	public void sendMimeMail(String toAddress, String[] ccAddress, String subject, String content, File attachment) throws MailException, MessagingException {
		sendMimeMail(new String[] { toAddress }, ccAddress, subject, content, null);
	}

	public void sendMimeMail(String[] toAddress, String[] ccAddress, String subject, String content, File attachment) throws MailException, MessagingException {
		MimeMessage msg = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg, true, DEFAULT_ENCODING);
		helper.setFrom(this.username);
		helper.setTo(toAddress);
		if (!StringUtil.isNullOrEmpty(ccAddress) && ccAddress.length > 0) {
			helper.setCc(ccAddress);
		}
		helper.setSubject(subject);
		helper.setText(content, true);
		if (!StringUtil.isNullOrEmpty(attachment) && attachment.isFile()) {
			helper.addAttachment(attachment.getName(), attachment);
		}
		mailSender.send(msg);
	}

}
