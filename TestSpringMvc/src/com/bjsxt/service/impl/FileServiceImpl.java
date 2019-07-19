package com.bjsxt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.bjsxt.mapper.FileMapper;
import com.bjsxt.pojo.File;
import com.bjsxt.pojo.User;
import com.bjsxt.service.FileService;
@Service
public class FileServiceImpl implements FileService {
	@Resource
	private FileMapper fileMapper;
	@Override
	public List<File> selectAllFiles() {
		return fileMapper.selectAllFiles();
	}
	@Override
	public int updCount(int id ,User user, String name ) {
		Logger logger = Logger.getLogger(FileService.class);
		logger.info(user.getUsername()+"œ¬‘ÿ¡À"+name);
		return fileMapper.updFileCount(id);
	}

}
