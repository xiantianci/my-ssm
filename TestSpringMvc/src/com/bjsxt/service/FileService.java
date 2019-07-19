package com.bjsxt.service;

import java.util.List;

import com.bjsxt.pojo.File;
import com.bjsxt.pojo.User;

public interface FileService {
	List<File> selectAllFiles();
	
	int updCount(int id,User user,String name);
}
