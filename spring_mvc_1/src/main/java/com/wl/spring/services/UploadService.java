package com.wl.spring.services;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
public interface UploadService {
	
	Map upload(MultipartFile file);

}
