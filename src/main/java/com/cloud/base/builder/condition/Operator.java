package com.cloud.base.builder.condition;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 运算符枚举类
 * 
 * @author changjiang
 * @date 2018年3月15日 下午4:22:53
 * @since beijing
 */
@Getter
@NoArgsConstructor
public enum Operator {
	
	Equal				("({1}:({2}))"),
	NotEqual			("NOT ({1}:({2}))"),
	Between				("({1}:[{2} TO {3}])"),
	Like				("({1}:({2}*))"),
	NotLike				("NOT ({1}:({2}*))"),
	GreaterThan			("({1}:{{2} TO *])"),
	GreaterThanOrEqual	("({1}:[{2} TO *})"),
	LessThan			("({1}:{* TO {2}})"),
	LessThanOrEqual		("({1}:{* TO {2}])");
	
	/**
	 * 表达式示例
	 */
	private String patten;

	private Operator(String patten) {
		this.patten = patten;
	}

}
