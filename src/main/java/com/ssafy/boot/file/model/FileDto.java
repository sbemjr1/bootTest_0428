package com.ssafy.boot.file.model;

public class FileDto {
	private String id;
	private String name;
	private String path;

	public FileDto() {
	}

	public FileDto(String id, String name, String path) {
		this.id = id;
		this.name = name;
		this.path = path;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "FileResponse [id=" + id + ", name=" + name + ", path=" + path + "]";
	}
}
