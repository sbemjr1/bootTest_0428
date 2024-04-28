package com.ssafy.boot.file.service;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.boot.file.model.FileDto;
import com.ssafy.boot.file.model.FileResponse;
import com.ssafy.boot.file.repository.FileMapper;

import jakarta.servlet.ServletContext;

@Service
public class FileServiceImpl implements FileService {
	private final FileMapper fileMapper;
	
	@Autowired
	public FileServiceImpl(FileMapper fileMapper) {
		this.fileMapper = fileMapper;
	}

	@Override
	public List<FileDto> list() {
		return fileMapper.list();
	}

	@Override
	public FileDto file(String id) {
		return fileMapper.file(id);
	}
	
	@Override
	public void add(MultipartFile[] files, ServletContext servletContext) throws IllegalStateException, IOException {
		System.out.println("fileService 1 ");
		String realPath = servletContext.getRealPath("/WEB-INF/img");
		String today = new SimpleDateFormat("yyMMdd").format(new Date());
		String saveFolder = realPath + File.separator + today;
		File folder = new File(saveFolder);
		List<FileDto> list = new ArrayList<>();
		if (!folder.exists()) folder.mkdirs();
		for (int i=0; i<files.length; i++) {
			String ext = files[i].getOriginalFilename().split("\\.")[1];
			String uuid = UUID.randomUUID().toString();
			FileDto dto = new FileDto();
			
			dto.setName(files[i].getOriginalFilename());
			dto.setPath(saveFolder + "\\" + uuid + "." + ext);
			files[i].transferTo(new File(folder, uuid + "." + ext));
			list.add(dto);
		}
		System.out.println("fileService 2 ");
		fileMapper.add(list);
		System.out.println("fileService 3 ");
	}
	
	@Override
	public FileResponse fileDownload(String id) throws MalformedURLException {
		FileDto file = file(id);
		if (file == null) return null;
		URI uri = new File(file.getPath()).toURI();
		Resource resource = new UrlResource(uri);
		FileResponse res = new FileResponse();
		res.setName(file.getName());
		res.setResource(resource);
		return res;
	}

	
}
