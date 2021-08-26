package com.promising.controller;

import java.util.Random;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.promising.service.EmailService;

@Controller
@RequestMapping("/email")
public class EmailController {

	@Autowired
	private EmailService emailService;
	
	@PostMapping("/send/{username}")
	@ResponseBody
	public String sendmail(@PathVariable("username") String username) throws MessagingException {
		String secret=emailService.secretKey();
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
						"		<span style=\"color: #02b875\">메일인증</span> 안내입니다."																																				+ 
						"	</h1>\n"																																																+ 
						"	<p style=\"font-size: 16px; line-height: 26px; margin-top: 50px; padding: 0 5px;\">"																													+ 
																																																				
																																																	
						"		<p style=\"color:#9083EC\">Promising</p>에 가입해 주셔서 진심으로 감사드립니다.<br />"																																						+ 
						"		아래 <b style=\"color: #02b875\">'메일 인증'</b> 인증번호를 입력하여 회원가입을 완료해 주세요.<br />"																													+ 
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
		emailService.sendMail(username, "Promising 이메일 인증입니다.", emailcontent.toString());
		return secret;
	}
	

}
