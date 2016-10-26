package com.databasegroup.utils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class uploadFile {
	public static String pathRoot;
	
	public uploadFile(HttpServletRequest request) {
		pathRoot = request.getSession().getServletContext().getRealPath("");
		pathRoot += "images\\";
	}
	
	public boolean saveFileToWeb(MultipartFile picFile, String savePath) {
		UUID uuid = UUID.randomUUID();
		try {
			picFile.transferTo(new File(pathRoot + savePath));
		} catch (IllegalStateException | IOException e) {
			return false;
		}
		return true;
	}
}
