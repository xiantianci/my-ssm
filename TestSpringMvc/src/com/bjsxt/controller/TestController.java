package com.bjsxt.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.resource.HttpResource;

import com.bjsxt.pojo.People;
@Controller
public class TestController {
	
	@RequestMapping("demo1")
	public String demo1(String name,int age) {
		System.out.println(name+""+age);
		
		return "redirect:main.jsp";
	}
	
	@RequestMapping("demo2")
	@ResponseBody
	public People demo2() {
		People p = new People();
		p.setAge(12);
		p.setName("lao");
		
		return p;
	}
	
	@RequestMapping("download")
	public void download(String filename,HttpServletResponse res,HttpServletRequest req) throws IOException {
		res.setHeader("Content-Disposition", "attachment;filename=bbb.txt");
		ServletOutputStream outputStream = res.getOutputStream();
		String path=req.getServletContext().getRealPath("files");
		File file = new File(path, filename);
		byte[] byteArray = FileUtils.readFileToByteArray(file);
		outputStream.write(byteArray);
		outputStream.flush();
		outputStream.close();
	}
	
	@RequestMapping("upload")
	public String upload(String name, MultipartFile file) throws IOException {
		InputStream inputStream = file.getInputStream();
		String filename = file.getOriginalFilename();
		String substring = filename.substring(filename.lastIndexOf("."));
		String uuid = UUID.randomUUID().toString();
		String newfile="D:/tools/"+uuid+substring;
		System.out.println(newfile);
		FileUtils.copyInputStreamToFile(inputStream, new File(newfile));
		
		return "index2";
	}
	
}
