package com.asiainfo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.checkerframework.checker.units.qual.m;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadAndDownloadController {
	@RequestMapping(value = "/upload", produces = "text/html;charset=utf-8") // produces属性防止通过@ResponseBody返回到页面的数据出现中文乱码
	@ResponseBody
	public String upload(MultipartFile multipartFile) throws Exception {
		String name = multipartFile.getName();
		String originalFilename = multipartFile.getOriginalFilename();
		System.out.println("name = " + name + ", originalFilename = " + originalFilename);

//		InputStream inputStream = multipartFile.getInputStream();// 获取InputStream，通过InputStream的read方法来操作，更简单的方式是使用transferTo()方法直接转换成File。
		multipartFile.transferTo(new File("/Users/zhangzhiwang/Desktop/" + originalFilename));
		return "上传成功";
	}

	@RequestMapping(value = "/download")
	public void download(HttpServletResponse response) throws UnsupportedEncodingException {
		File file = new File("/Users/zhangzhiwang/Documents/外围/赋码重复修改.xlsx");
		// 设置header来告诉客户端是文件的下载
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition","attchement;filename=" + URLEncoder.encode(file.getName(), "UTF-8"));// URLEncoder.encode(）防止中文文件名下载后出现乱码，不过在chrome浏览器测试成功，safari浏览器仍然是乱码
		
		try (InputStream inputStream = new FileInputStream(file);
				OutputStream out = response.getOutputStream();) {
			byte[] bs = new byte[1024];
			int len = 0;
			while((len = inputStream.read(bs)) != -1) {
				out.write(bs, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
