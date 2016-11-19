package com.databasegroup.utils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class UploadFileUtil {
	
	private String pathRoot;
	
	public UploadFileUtil(HttpServletRequest request) {
		pathRoot = request.getSession().getServletContext().getRealPath("");
		pathRoot += "images/";
	}
	
	public String saveFileToWeb(MultipartFile picFile, 
			String folder, String type) {
		String filename = UUID.randomUUID().toString().replace("-", "")
				.substring(0,10) + type;
		String path = pathRoot + folder;
		String picPath = "/images/" + folder + "/" + filename;
		File file = new File(path);
		try {
			if (!file.exists()) file.mkdir();
			path += "/" + filename;
			picFile.transferTo(new File(path));
		} catch (IllegalStateException | IOException e) {
			return "";
		}
		return picPath;
	}
}
