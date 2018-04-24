/**
 * all Copyright 2018 MIIA
 */
package com.miia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yan.changjiang 
 * @since miia group for beijing
 * @Copyright 2018 MIIA
 */
@SpringBootApplication
public class NoticeApplication {
	
//	public static void main(String[] args) {
//		AbstractSender sender = SenderFactory.createSender(SenderType.MAIL);
//		NoticeConfig config = new NoticeConfig();
//		config.setFromAddress("ricardo@foxiange.cn");
//		String[] to = {"ycjnono@126.com"};
//		config.setToAddress(to);
//		config.setSubject("hello");
//		config.setMessage("zhengwenm");
//		sender.init(config);
//		boolean success = sender.send();
//		System.out.println(success);
//	}
	
	public static void main(String[] args) {
		SpringApplication.run(NoticeApplication.class, args);
	}

}
