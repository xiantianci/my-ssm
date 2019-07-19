package com.bjsxt.pojo;

public class File {
	private int id;
	private int count;
	private String path;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@Override
	public String toString() {
		return "File [id=" + id + ", count=" + count + ", path=" + path + "]";
	}
	
}
