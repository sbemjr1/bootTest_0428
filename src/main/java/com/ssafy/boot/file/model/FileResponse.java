package com.ssafy.boot.file.model;

import org.springframework.core.io.Resource;

public class FileResponse {
	private String name;
	private Resource resource;

	public FileResponse() {
	}

	public FileResponse(String name, Resource resource) {
		super();
		this.name = name;
		this.resource = resource;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	@Override
	public String toString() {
		return "FileResponse [name=" + name + ", resource=" + resource + "]";
	}

}
