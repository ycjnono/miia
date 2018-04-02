package com.miia.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 检索字段配置
 * 
 * @author ycj
 * @since miia group for beijing @ 2018
 * @version 1.0.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Field {

	/**
	 * 字段名称
	 * 
	 * @return
	 */
	public String name();

	/**
	 * 高亮显示
	 * 
	 * @return
	 */
	public boolean isHighLight() default false;

}
