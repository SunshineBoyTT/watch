package com.spring.base.utils;

import org.codehaus.xfire.client.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.net.URL;
import java.util.Date;

public class SmsSend {
	//密码
	@Value("#{config['vcode_pass']}")
	public String vcodePass="";
	//账号
	@Value("#{config['vcode_username']}")
	public String vcodeUsername="";

	private static final Logger logger = LoggerFactory.getLogger(SmsSend.class);
//	@Value("#{config['vcode_pass']}")
//	public String vcode_pass="";
	public static void main(String[] args) {
		SmsSend sms = new SmsSend();
		sms.HttpSmsSend(
				"18368085192",
//				"尊敬的业主：您好！您的快件（单号："+StringUtil.formatDate6(new Date())+"）已到达物业处，预计2小时内将会送达，请注意查收。如有问题，请及时致电（物业电话），谢谢！（物业）。",
				"验证码："+ StringUtil.formatDate6(new Date()),
				"【智慧兔】");
	}
	public void HttpSmsSend(String phone, String content, String sgin){
		try {
			/**
			 * 发送短信
			 */
			Client client = new Client(new URL("http://121.40.188.122:6080/smsWs/sms.ws?wsdl"));
			Object[] o = client.invoke("sendSMS", new Object[]{vcodeUsername,
					StringUtil.getMD5Str(vcodePass),phone,content+sgin,"10659800","shcmcc"});
			logger.error("短信发送："+o[0].toString());
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
	}
}
