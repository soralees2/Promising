package com.promising.controller;

import java.io.File;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.promising.config.SecurityConfig;
import com.promising.repository.CommunityRepository;
import com.promising.repository.MemberRepository;
import com.promising.repository.ProjectRepository;
import com.promising.repository.QnaRepository;
import com.promising.service.EmailService;
import com.promising.vo.MemberRoleVO;
import com.promising.vo.MemberVO;
import com.promising.vo.ProjectVO;
import com.promising.vo.QnaVO;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private EmailService emailService;
	@Autowired
	private SecurityConfig security;

	@Autowired
	private PasswordEncoder pwEncoder;

	@Autowired
	private HttpSession session;

	@Autowired
	private MemberRepository repo;

	@Autowired
	private ProjectRepository repoProject;

	@Autowired
	private QnaRepository qnaRepo;

	@Autowired
	private CommunityRepository crepo;

	@GetMapping("/login")
	public void login() {

	}

	@GetMapping("/signup")
	public void signup() {

	}
	@PostMapping("/signup")
	public String join(MemberVO vo) {
		MemberRoleVO role = new MemberRoleVO();
		role.setRoleName("BASIC");
		vo.setRoles(Arrays.asList(role));
		vo.setPassword(pwEncoder.encode(vo.getPassword()));
		vo.setSysName("basicprofile.png");
		repo.save(vo);
		return "redirect:/member/login";
	}

	@GetMapping("/auth/mypage")
	public void mypage(Model model,Principal principal) {
		String userName =principal.getName();

		MemberVO result = repo.findByUsername(userName).get();
		//		model.addAttribute("list",result);
		model.addAttribute("result", result);
	}



	@GetMapping("/auth/infoUpdate")
	public void infoUpdate(Model model,Principal principal) {
		String userName =principal.getName();

		MemberVO result = repo.findByUsername(userName).get();

		//		model.addAttribute("list",result);
		model.addAttribute("result", result);


	}

	@RequestMapping(value="/auth/infoUpdate/{uname}",method = RequestMethod.POST)
	@ResponseBody
	public void nameUpdate(@PathVariable("uname") String uname,@RequestBody MemberVO mvo,Model model,Principal principal) {
		System.out.println("닉넴바꾸기");

		String originName =principal.getName();		
		MemberVO vo=repo.findById(originName).get(); //찐
		String beforeName= vo.getUname();    // 바뀌기 전 닉네임
		repoProject.updateProjectUname(beforeName,uname);
		qnaRepo.updateQnaReceive(beforeName, uname);
		vo.setUname(uname); // 닉네임 변경

		System.out.println("=========================username : " + vo.getUsername());
		System.out.println("vo getname"+vo.getUname());
		System.out.println("vo getname"+vo.getAddress1());
		System.out.println("=========================username : " + mvo.getUsername());
		System.out.println("mvo uname"+mvo.getUname());

		repo.save(vo);

		//		return "redirect:/member/infoUpdate";

	}


	@RequestMapping(value="/auth/uphoneUpdate/{modifyContact}",method = RequestMethod.POST)
	@ResponseBody
	public void emailUpdate(@PathVariable("modifyContact") String modifyContact,Model model,Principal principal) {
		System.out.println("10시");

		String originName =principal.getName();		
		MemberVO vo=repo.findById(originName).get(); //찐
		vo.setUphone(modifyContact);

		repo.save(vo);

		//		return "redirect:/member/infoUpdate";

	}

	@PostMapping("/auth/profileAttach")
	public String profileUpload(MemberVO vo,MultipartFile[] file,Principal principal,HttpServletRequest request) throws Exception {
		vo = repo.findByUsername(principal.getName()).get();

		//		String realPath = session.getServletContext().getRealPath("/");

		String relativePath ="src"+File.separator+"main"+File.separator+"resources"+File.separator +"static"+File.separator+"images"+File.separator+"profileUpload";
		System.out.println(relativePath+"/ 앞쪽이 리얼패스 ㅇㅇ");
		File filesPath = new File(relativePath);
		if(!filesPath.exists()) {
			filesPath.mkdir();
		}
		for(MultipartFile tmp :file) {
			if(tmp.getSize()>0) {
				String oriName = tmp.getOriginalFilename();
				String sysName=UUID.randomUUID().toString().replaceAll("-","")+"_"+oriName;
				vo.setOriName(oriName);
				vo.setSysName(sysName);
				System.out.println(filesPath.getAbsolutePath()+" "+sysName+" "+oriName);
				tmp.transferTo(new File(filesPath.getAbsolutePath()+"/"+sysName));

			}
		}
		try 
		{
			Thread.sleep(2500);
		}
		catch(InterruptedException e) 
		{
			e.printStackTrace();
		}
		System.out.println(vo);
		repo.save(vo);
		return "redirect:/member/auth/mypage";

	}


	@GetMapping("/auth/myProjectGoing")
	public void myProjectGoing(Model model,Principal principal) {
		String writer =principal.getName();
		System.out.println(writer);
		MemberVO vo= repo.findByUsername(writer).get();
		
		System.out.println("브이오내용"+vo);
		//		System.out.println(writer); 출력잘됨

		List<ProjectVO> result = repoProject.selectCheckingPro(vo.getUname()); // username으로 조회해야할듯..
		List<ProjectVO> result2 = repoProject.selectProceedingPro(vo.getUname());//username으로 조회해야할듯..
		List<ProjectVO> result3 = repoProject.selectFinishedPro(vo.getUname());//username으로 조회해야할듯..
		
		System.out.println(result);
		System.out.println(result2);
		System.out.println(result3);
		model.addAttribute("result", result);
		model.addAttribute("result2", result2);
		model.addAttribute("result3", result3);
	}

	@GetMapping("/auth/qna")
	public void qna(Model model, Principal principal) {
		String writer =principal.getName();
		MemberVO vo = repo.findByUsername(writer).get();
		System.out.println(writer);

		List<QnaVO> result = qnaRepo.selectQnaTome(writer);
		List<QnaVO> send = qnaRepo.selectQnaToOthers(writer);
		List<ProjectVO> project = repoProject.findAll();
		System.out.println("이것이 내가 받은 문의"+result);
		System.out.println("이것이 다른사람에게 보낸 문의"+send);
		model.addAttribute("result", result);
		model.addAttribute("result2", send);
		model.addAttribute("project", project);
	}



	@PostMapping("/{uname}")
	public ResponseEntity<List<QnaVO>> VOID(@PathVariable("uname")String uname, @RequestBody QnaVO qvo, Principal principal){
		String writer=principal.getName();

		System.out.println(qvo.getContents());
		System.out.println("-----------------" + uname); // 작성자 닉네임
		MemberVO vo = new MemberVO();
		System.out.println(qvo);
		MemberVO mvo = repo.findByUsername(uname).get();
		String receiver = mvo.getUsername();
		vo.setUsername(receiver);
		System.out.println("ㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎㅎ : " + principal.getName());
		qvo.setWriter(principal.getName());
		qvo.setMember(vo);
		System.out.println("qvo : "+qvo);
		qnaRepo.save(qvo);
		return new ResponseEntity<>(getListByMember(vo),HttpStatus.CREATED);
	}

	private List<QnaVO> getListByMember(MemberVO vo) throws RuntimeException{
		return qnaRepo.getQnaOfMember(vo);
	}






	@PostMapping("/idcheck/{username}")
	@ResponseBody
	public String idcheck(@PathVariable("username") String username) {
		if(repo.findByUsername(username).isPresent()) {
			return "exist";
		}else {
			return "can";
		}
	}
	@PostMapping("/unamecheck/{uname}")
	@ResponseBody
	public String unameCheck(@PathVariable("uname") String uname) {

		if(repo.findByUname(uname).isPresent()) {
			return "exist";
		}else {
			return "can";
		}
	}


	@RequestMapping(value="/auth/pwModify",method = RequestMethod.POST)
	@ResponseBody
	public String pwUpdate(@RequestBody Map<String,Object> param,Model model,Principal principal) {
		String originName =principal.getName();		
		String toNewPw=(String)param.get("modifyPw1");
		MemberVO vo=repo.findByUsername(originName).get(); //찐
		vo.setPassword(pwEncoder.encode(toNewPw));		
		repo.save(vo);
		return "success";
	}
	
	
	
	
	
	@RequestMapping(value="/auth/addressUpdate",method = RequestMethod.POST)
	public String addressUpdate(@RequestBody Map<String,Object> param,Model model,Principal principal) {
		
		System.out.println("변경~~start");
		System.out.println(principal);
		String originName =principal.getName();		
		
		for(String key : param.keySet()){
			System.out.println(key + " : " + param.get(key));
		}
		
		System.out.println(param.toString());
		
		//만약에 originName 이 DB에 존재한다면 &안한다면
		
		String realName=(String)param.get("realName");
		String address1=(String)param.get("address1");
		String address2=(String)param.get("address2");
		String postcode=(String)param.get("postcode");
		String uphone=(String)param.get("uphone");
		System.out.println(realName+": 이것은 진짜이름 ");
		System.out.println(address1+": 이것은 주소1");
		System.out.println(address2+": 이것은 주소2");
		System.out.println(postcode+": 이것은 우편");
		System.out.println(uphone+": 이것은 핸펀");
		
		
		
		MemberVO vo=repo.findByUsername(originName).get(); //찐
		vo.setAddress1(address1);
		vo.setAddress2(address2);
		vo.setUpostcode(postcode);
		vo.setUphone(uphone);
		vo.setRealname(realName);
		repo.save(vo);		
		return "redirect:/member/infoUpdate";
	}
	
	@GetMapping("/forget")
	public void forget() {
		
	}
	@PostMapping("/forget")
	public String findPW(String username) throws MessagingException {
		String secret=emailService.secretKey();
		MemberVO vo= repo.findByUsername(username).get();
		vo.setPassword(pwEncoder.encode(secret));
		repo.save(vo);
		System.out.println(username+"이메일입니다");
		StringBuffer emailcontent = new StringBuffer();
		emailcontent.append("<!DOCTYPE html>");
		emailcontent.append("<html>");
		emailcontent.append("<head>");
		emailcontent.append("</head>");
		emailcontent.append("<body>");
		emailcontent.append(
				" <div" 																																																	+ 
						"	style=\"font-family: 'Apple SD Gothic Neo', 'sans-serif' !important; width: 400px; height: 600px; border-top: 4px solid #02b875; margin: 100px auto; padding: 30px 0; box-sizing: border-box;\">"		+ 
						"	<h1 style=\"margin: 0; padding: 0 5px; font-size: 28px; font-weight: 400;\">"																															+ 
						"		<span style=\"font-size: 15px; margin: 0 0 10px 3px;\"><h3 style=/'color':'#9083EC'>Promising</h3></span><br />"																													+ 
						"		<span style=\"color: #02b875\">임시 비밀번호</span> 발급 안내입니다."																																				+ 
						"	</h1>\n"																																																+ 
						"	<p style=\"font-size: 16px; line-height: 26px; margin-top: 50px; padding: 0 5px;\">"																													+ 
						
						
						"		<p style=\"color:#9083EC\">Promising</p> 계정을 찾아주셔서 진심으로 감사드립니다.<br />"																																						+ 
						"		아래 <b style=\"color: #02b875\">'임시 비밀번호'</b>를 통해 로그인 후 비밀번호 변경 부탁드립니다.<br />"																													+ 
						"		감사합니다."																																															+ 
						"	</p>"																																																	+ 
						
								"<h2>"+secret+"</h2>"+
								"		<p"																																																	+
								
						
						"	</a>"																																																	+
						"	<div style=\"border-top: 1px solid #DDD; padding: 5px;\"></div>"																																		+
						" </div>"
				);
		emailcontent.append("</body>");
		emailcontent.append("</html>");
		emailService.sendMail(username, "Promising 임시 비밀번호 발급 메일입니다.", emailcontent.toString());
		
		return "redirect:/member/login";
	}
	
	@GetMapping("/doublelogin")
	public void doublelogin() {
		
	}
	
	
	
	
	
	
	
}
		
