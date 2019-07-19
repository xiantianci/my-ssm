package com.bjsxt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.bjsxt.pojo.File;

public interface FileMapper {
	@Select("select * from file")
	List<File> selectAllFiles();
	@Update("update file set count = count +1 where id = #{0}")
	int updFileCount(int id);
}
