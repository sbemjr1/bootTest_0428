package com.ssafy.boot.file.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ssafy.boot.file.model.FileDto;
import com.ssafy.boot.file.model.FileResponse;

import jakarta.servlet.ServletContext;

public interface FileService {
	List<FileDto> list();
	FileDto file(String id);
	void add(MultipartFile[] files, ServletContext servletContext) throws IllegalStateException, IOException;
	public FileResponse fileDownload(String id) throws MalformedURLException;
}
