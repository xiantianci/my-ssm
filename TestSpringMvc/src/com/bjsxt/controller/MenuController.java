package com.bjsxt.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjsxt.pojo.Menu;
import com.bjsxt.service.MenuService;

@Controller
public class MenuController {
	@Resource
	private MenuService menuServiceImpl;
	
	@RequestMapping("show")
	@ResponseBody
	public List<Menu> show(){
		return menuServiceImpl.show();
	}
}
