//package com.promising.controller;
//
//import java.io.File;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//
//
//@Controller
//public class imageController {
//
//	@PutMapping("/image/upload")
//	public @ResponseBody String imageUpload(@RequestParam("file")HttpServletRequest request,HttpServletResponse response) {
//		String filesPath = request.getServletContext().getRealPath("images");
//		System.out.println(filesPath);
//		File filesFolder= new File(filesPath);
//		int maxSize = 1024*1024*10;
//		if(!filesFolder.exists()) filesFolder.mkdir(); 
//		
//		
//	
//
//	}
//}
//
