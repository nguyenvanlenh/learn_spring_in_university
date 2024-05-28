package com.wl.spring.services.impl;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.wl.spring.services.UploadService;

@Service
public class CloudinaryService implements UploadService {

	@Autowired
	 private Cloudinary cloudinary;

	    public Map upload(MultipartFile file)  {
	        try{
	        	Map map = this.cloudinary.uploader().upload(file.getBytes(),
		                ObjectUtils.asMap("resource_type", "auto"));
	        	System.out.println(map.get("secure_url"));
	            return map;
	        }catch (IOException io){
	            throw new RuntimeException("Image upload fail");
	        }
	    }
}
