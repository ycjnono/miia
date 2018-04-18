/**
 * all Copyright 2018 MIIA
 */
package com.miia.base;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import lombok.extern.slf4j.Slf4j;

/**
 * 通知发送器工厂类
 * 
 * @author yan.changjiang
 * @since miia group for beijing
 * @Copyright 2018 MIIA
 */
@Slf4j
public class SenderFactory {
	
	/**
	 * 默认配置文件
	 */
	private static final String PROPERTIES_DEFAULT = "application.properties";

	/**
	 * 根据资源获取对应实现类
	 * 
	 * @param type
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static AbstractSender createSender(SenderType type) {
		try {
			if (type != null) {
				Class<AbstractSender> T = (Class<AbstractSender>) Class.forName(type.getSource());
				AbstractSender newInstance = T.newInstance();
				setPropert(newInstance);
				return newInstance;
			}
		} catch (Exception e) {
			log.error("created sender error", e);
		}
		return null;
	}
	
	private static void setPropert(AbstractSender sender){
		Properties properties = new Properties();
		InputStream inputStream = SenderFactory.class.getClassLoader().getResourceAsStream(PROPERTIES_DEFAULT);
		try {
			properties.load(inputStream);
			inputStream.close();
			sender.properties = properties;
		} catch (IOException e) {
			log.error("loading properties file error",e);
		}
	}

}
