package com.promising.controller;

import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class imageController {

	@PutMapping("/image/upload")
	public @ResponseBody String imageUpload(@RequestParam("File") MultipartFile mpf) {
		//@RequestParam("imgFile") MultipartFile imgFile 변수명 같으니까 리퀘스트파람 생략 가능
		 UUID uuid = UUID.randomUUID();
		 String uuidFileName = uuid+"_"+mpf.getOriginalFilename();
		Path filePath = Paths.get(UtilCos.getResourcePath()+uuidFileName)
		
		
		
		
		
		//		MultipartFile file =mtf.getFile(sysName);
//		boolean isc =file.isEmpty();
//		if(isc==true) {
//			File_Dto fDTO = new File_Dto(user_seq,"","",0);
//			isk = fService.imageUp(fDTO);
//			}else {
//		
//		
//;		File dir = new File(filePath);
//		if(!dir.exists()) {
//			dir.mkdirs();
//			}
//			file.transferTo(new File(filePath,stoName));
//			logger.info("경로 : "+filePath+"/"+stoName);
//			File_Dto fDTO = new File_Dto(user_seq,oriName,stoName,fileSize);
//			isk = fService.imageUp(fDTO);
//			map.put("path", filePath+"/"+stoName);
//		}
//	map.put("isk", isk+"");
//		
//		
//		//이미지 정보확인
//		System.out.println(oriName.getOriginalFilename());
//		System.out.println(oriName.getContentType());
//		System.out.println(oriName.getSize());
//		System.out.println(oriName.getName());
//		
//		String filesPath = request.getServletContext().getRealPath("person_img");
//		File filesFolder= new File(filesPath);
//		
//		UUID uuid = UUID.randomUUID();
//		String sysName = uuid+"_"+oriName.getOriginalFilename();
//		
//		
//		
//		
//		
//		try {
//			System.out.println(oriName.getBytes().toString());
//			//getBytes가 이미지 실체고 이걸 파일로 변환해서 저장해야한다.
//		} catch (IOException e) {
//	// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	
	
}
}
	

