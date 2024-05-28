package com.wl.spring.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.wl.spring.services.impl.CloudinaryService;

@Controller
@PreAuthorize("isAuthenticated()")
public class UploadFile {

	@Autowired
	private CloudinaryService cloudinaryService;

	@GetMapping("/upload")
	public String view() {
		return "upload";
	}
	@GetMapping("/uploads")
	public String uploadMultiFile() {
		return "uploads";
	}

	@PostMapping("/upload")
	public String upload(@RequestParam(name = "file") MultipartFile file) {
		Map data = cloudinaryService.upload(file);
		if(!data.isEmpty()) return "index";
		return "upload";
	}

	@PostMapping("/uploads")
	public String uploads(@RequestParam(name = "files") List<MultipartFile> files) {
		for (MultipartFile file : files) {
			Map data = cloudinaryService.upload(file);
		}
		return "redirect:/index";

	}

}
