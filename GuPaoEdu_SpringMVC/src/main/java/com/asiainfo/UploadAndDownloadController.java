package com.asiainfo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadAndDownloadController {
	@RequestMapping("/upload")
	public void upload(MultipartFile multipartFile) {
		System.out.println();
	}
}
