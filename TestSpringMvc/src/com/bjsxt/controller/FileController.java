package com.bjsxt.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bjsxt.pojo.User;
import com.bjsxt.service.FileService;

@Controller
public class FileController {
	@Resource
	private FileService fileServiceImpl;
	
	@RequestMapping("showAllFiles")
	public String showAllFiles(Model m) {
		m.addAttribute("fileList", fileServiceImpl.selectAllFiles());
		return "main";
	}
	
	@RequestMapping("uploadFile")
	public void updCount(HttpServletRequest req,HttpServletResponse res,int id,String name) throws IOException {
		
		User user = (User) req.getSession().getAttribute("user");
		fileServiceImpl.updCount(id,user,name);
		res.setHeader("content-Disposition", "attachment;filename="+name);
		File file = new File(req.getServletContext().getRealPath("files"),name);
		OutputStream os =res.getOutputStream();
		byte[] byteArray = FileUtils.readFileToByteArray(file);
		os.write(byteArray);
		os.flush();
		os.close();
	}
}
