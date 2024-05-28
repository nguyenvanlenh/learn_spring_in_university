package com.wl.spring.models;

import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;
public class File {
	@Transient
	private MultipartFile file;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
	

}
