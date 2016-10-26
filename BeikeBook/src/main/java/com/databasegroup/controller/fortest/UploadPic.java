package com.databasegroup.controller.fortest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.*;

import com.databasegroup.utils.uploadFile;

@Controller
@RequestMapping("/uploadPic")
public class UploadPic {
	
	@RequestMapping(method=GET)
	public String uploadPic() {
		return "/fortest/uploadPic";
	}
	
	@RequestMapping(method=POST)
	public String processUpload(
			@RequestPart("userPic") MultipartFile picFile,
			HttpServletRequest request,
			Model model) throws Exception {
		uploadFile up = new uploadFile(request);
		String filename = picFile.getOriginalFilename();
		up.saveFileToWeb(picFile, filename);
		model.addAttribute("message", "uploaded successfully!");
		model.addAttribute("imagesFile", filename);
		return "/fortest/showMessage";
	}
}
