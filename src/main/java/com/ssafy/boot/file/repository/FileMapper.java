package com.ssafy.boot.file.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.boot.file.model.FileDto;

@Mapper
public interface FileMapper {
	List<FileDto> list();
	FileDto file(String id);
	void add(List<FileDto> list);
}
