package com.ssafy.boot.file.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.boot.file.model.FileDto;
import com.ssafy.boot.file.service.FileService;

import jakarta.servlet.ServletContext;

@Controller
public class FileController {
	private final ServletContext context;
	private final FileService fileService;

	@Autowired
	public FileController(ServletContext servletContext, FileService fileService) {
		this.context = servletContext;
		this.fileService = fileService;
	}

	@GetMapping("/fileform")
	public String fileForm(Model model) throws SQLException {
		List<FileDto> list = fileService.list();
		model.addAttribute("filelist", list);

		return "fileview";
	}

	@PostMapping("/fileupload")
	public String fileUpload(@RequestParam("upfile") MultipartFile[] files) throws Exception {
		// 1. file을 폴더에 저장
		System.out.println("fileServlet 111111");
		fileService.add(files, context);
		return "redirect:/fileform";
	}

	@GetMapping("/filedownload")
	public ModelAndView fileDownload(@RequestParam("fid") String fid) {
		FileDto dto = fileService.file(fid);
		return new ModelAndView("fileDownloadView", "file", dto);
	}

}
