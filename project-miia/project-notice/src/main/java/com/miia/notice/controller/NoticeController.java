/**
 * all Copyright 2018 MIIA
 */
package com.miia.notice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 通知前端控制器
 * 
 * @author yan.changjiang
 * @since miia group for beijing
 * @Copyright 2018 MIIA
 */
@RestController
@RequestMapping("/notice")
public class NoticeController {
	
	
	
	@GetMapping("/index")
	public Object index(){
		return "ddd";
	}

}
