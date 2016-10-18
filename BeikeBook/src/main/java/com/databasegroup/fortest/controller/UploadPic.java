package com.databasegroup.fortest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.Part;

import org.springframework.web.multipart.*;

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
			Model model) {
		try {
			picFile.transferTo(
					new File("" + picFile.getOriginalFilename()));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("message", "uploaded successfully!");
		return "/fortest/showMessage";
	}
}
