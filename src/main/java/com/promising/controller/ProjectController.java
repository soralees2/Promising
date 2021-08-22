package com.promising.controller;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.promising.repository.CommunityRepository;
import com.promising.repository.MemberRepository;
import com.promising.repository.ProjectRepository;
import com.promising.vo.CommentVO;
import com.promising.vo.CommunityVO;
import com.promising.vo.MemberVO;

import com.promising.vo.PageMaker;
import com.promising.vo.PageVO;
import com.promising.vo.ProjectVO;

@Controller
@RequestMapping("/project")
public class ProjectController {
	Logger logger = LoggerFactory.getLogger(ProjectController.class);
	@Autowired
	private ProjectRepository repo;
	@Autowired
	private MemberRepository memberrepo;
	@Autowired
	private CommunityRepository comrepo;

	//@GetMapping("/detail")
	//	public void detail(Model model) {
	//		model.addAttribute("hello", "안녕하세요, 반갑습니다!");


	@GetMapping("/detail/{pno}")
	public String detail(@PathVariable("pno") Long pno,Model model) {


		return "project/detail";
	
	}
	@GetMapping("/story/{pno}")
	public String projectStory(@PathVariable("pno") Long pno,Model model) {
		ProjectVO vo= repo.findById(pno).get();
		model.addAttribute("vo",vo);
		
		return "project/story";
	}
	
	@GetMapping("/community/{pno}")
	public String projectCommunity(@PathVariable("pno") Long pno,Model model) {
		System.out.println("프로젝트 넘  : " + pno);
		ProjectVO vo= repo.findById(pno).get();
		List<CommunityVO> comList = comrepo.getCommunities(vo);

//		List<CommentVO> cmtList = comrepo.getCommets(vo);
		
		model.addAttribute("vo",vo);
		model.addAttribute("com", comList);
		
		return "project/community";
	}
	
	@GetMapping("/notice/{pno}")
	public String projectNotice(@PathVariable("pno") Long pno,Model model) {

		System.out.println("프로젝트 넘  : " + pno);
		ProjectVO vo= repo.findById(pno).get();
		//CommunityVO qvo= repo.findByCmt(pno).get();

		model.addAttribute("vo",vo);





		
		return "project/notice";

	}
//	
//	@GetMapping("/detail/{pno}")
//	public String detail(@PathVariable("pno") Long pno,Model model) {
//		System.out.println("프로젝트 넘  : " + pno);
//		ProjectVO vo= repo.findById(pno).get();
//		//CommunityVO qvo= repo.findByCmt(pno).get();
//
//		model.addAttribute("vo",vo);
//		
//		return "project/detail";
//		
//
//	}



	//	@GetMapping("/detail/{bno}")
	//	public String detail(@PathVariable("bno") Long bno, Model model) {
	//		System.out.println(bno);
	//		BoardVO vo= repo.findById(bno).get();
	//		model.addAttribute("vo",vo);
	//		System.out.println("bno : "+ bno);
	//		return "board/detail";
	//		
	//	}


	@GetMapping("/payment")
	public void payment(Model model) {
	}

	@GetMapping("/main")
	public String main(Model model) {
		List<ProjectVO> result = repo.selectAll();
		model.addAttribute("result", result);
		return "project/main";
	}

	//	@PostMapping("/newest")
	//	@ResponseBody
	//	public List<ProjectVO> newest (Model model, Principal principal) {
	//		System.out.println("최신순 요청");
	//		List<ProjectVO> result = repo.selectNewest();
	//		model.addAttribute("result", result);
	//		return result;
	//	}

	//	@PostMapping("/close")
	//	@ResponseBody
	//	public List<ProjectVO> close (Model model, Principal principal) {
	//		System.out.println("마감순 요청");
	//		List<ProjectVO> result = repo.selectClose();
	//		model.addAttribute("result", result);
	//		return result;
	//	}
	@GetMapping("/newest")
	public String newest(Model model) {
		System.out.println("최신순 요청");
		List<ProjectVO> result = repo.selectNewest();
		model.addAttribute("result", result);
		return "project/main";
	}

	@GetMapping("/close")
	public String close(Model model) {
		System.out.println("마감순 요청");
		List<ProjectVO> result = repo.selectClose();
		model.addAttribute("result", result);
		return "project/main";
	}

	@GetMapping("/list")
	public String list(PageVO pvo, Model model) {
		Pageable page = pvo.makePageable(0, "pno");
		Page<ProjectVO> result = repo.findAll(repo.makePredicate(pvo.getType(), pvo.getKeyword()),page);
		List<ProjectVO> project = repo.selectList();
		model.addAttribute("project", project);
		model.addAttribute("result", new PageMaker<ProjectVO>(result));
		return "project/list";
	}

	@GetMapping("/auth/upload1")
	public void upload1() {
		logger.debug("업로드하러옴1");
	}
	@GetMapping("/auth/upload2")
	public void upload2() {
		logger.debug("업로드하러옴22");
	}
	@GetMapping("/auth/upload3")
	public void upload3() {

	}
	@Transactional // 서비스로 옮길 예정
	@PostMapping("/auth/upload3")
	public String projectUpload(ProjectVO vo,MultipartFile[] file,Principal principal,String prStartday,String prEndday,String targetmoney,String presentprice) throws Exception {
		MemberVO newvo =memberrepo.findByUsername(principal.getName()).get();
		vo.setPrWriter(newvo.getUname());
		java.sql.Date prStartdate =java.sql.Date.valueOf(prStartday);
		java.sql.Date prEnddate =java.sql.Date.valueOf(prEndday);

		vo.setPrStartdate(prStartdate);
		vo.setPrEnddate(prEnddate);
		vo.setPrCheck("N");
		vo.setPrStatus("I");
		System.out.println(targetmoney+" "+presentprice);
		vo.setPrTargetMoney(Integer.parseInt(targetmoney));
		vo.setPrPresentPrice(Integer.parseInt(presentprice));


		File filesPath = new File("src"+File.separator+"main"+File.separator+"resources"+File.separator +"static"+File.separator+"images"+File.separator+"projectuploading");
		if(!filesPath.exists()) {
			filesPath.mkdir();
		}
		for(MultipartFile tmp :file) {
			if(tmp.getSize()>0) {
				String oriName = tmp.getOriginalFilename();
				String sysName=UUID.randomUUID().toString().replaceAll("-","")+"_"+oriName;
				vo.setPrOriName(oriName);
				vo.setPrSysName(sysName);
				System.out.println(filesPath.getAbsolutePath()+" "+sysName+" "+oriName);
				tmp.transferTo(new File(filesPath.getAbsolutePath()+"/"+sysName));

			}
		}
		System.out.println(vo);
		repo.save(vo);
		return "redirect:/project/complete";
	}
	
	@GetMapping("/complete")
	public void complete() {

	}
	@PostMapping("/summeruploading")
	@ResponseBody
	public String summerUploading(MultipartFile file) throws Exception {
		System.out.println("컨트롤러까지왔어!");
		File filesPath = new File("src"+File.separator+"main"+File.separator+"resources"+File.separator +"static"+File.separator+"images"+File.separator+"summernoteuploading");
		if(!filesPath.exists()) {
			filesPath.mkdir();
		}
		String oriName = file.getOriginalFilename();
		String sysName=UUID.randomUUID().toString().replaceAll("-","")+"_"+oriName;

		System.out.println(filesPath.getAbsolutePath()+" "+sysName+" ///"+oriName);

		file.transferTo(new File(filesPath.getAbsolutePath()+"/"+sysName));

		return sysName;

	}
}




