package com.databasegroup.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.databasegroup.model.Class;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="books")
public class BooksController {
	
	@RequestMapping(method=GET)
	public String books() {
		return "books";
	}
}
