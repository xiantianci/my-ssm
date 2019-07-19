package com.bjsxt.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.bjsxt.pojo.User;
import com.bjsxt.service.UserService;

@Controller
public class UserController {
	@Resource
	private UserService userServiceImpl;
	
	@RequestMapping("register")
	public String register(User user,MultipartFile file,HttpServletRequest req) throws IOException {
		String fileName = file.getOriginalFilename();
		String suffix = fileName.substring(fileName.lastIndexOf("."));
		String uuid = UUID.randomUUID().toString();
		String photo = uuid+suffix;
		String path = req.getServletContext().getRealPath("images")+"\\"+photo;
		FileUtils.copyInputStreamToFile(file.getInputStream(), new File(path));
		user.setPhoto(photo);
		System.out.println(path);
		userServiceImpl.insertUser(user);
		req.getSession().setAttribute("user", user);
		return "redirect:/showAllFiles";
	}
}
