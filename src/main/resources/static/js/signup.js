
	$(function() {
		var emailchecking = false;		// 이메일 인증 전 false
		$(".secret").hide();			// 이메일 키 입력하는 div hide
		var secretkey;					// 인증키 받기전 변수 선언
		$("#emailcheck").on("click",function(){			// 이메일 인증 버튼 클릭
			let obj=$("#id").val();
			let inputId = $("#id").val();
			let regId=/^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;
			let resultId = regId.test(inputId);
			if(resultId){
			$.ajax({										// 이메일 중복 검사
				url:'/member/idcheck/'+obj,
				type:'POST',
				 data : JSON.stringify({username:obj}),
		         contentType: 'application/json',
		         beforeSend: function (jqXHR, settings) {
                     let header = $("meta[name='_csrf_header']").attr("content");
                     let token = $("meta[name='_csrf']").attr("content");
                     jqXHR.setRequestHeader(header, token);
		         }
				}).done(function(data){
				if(data==="exist"){
					alert("이미 가입된 이메일입니다!")
				}else if(data==="can"){
					$(".secret").css("display","flex")
					alert("인증번호가 발송되었습니다 . 이메일을 확인해주세요!")
					$.ajax({									// 인증메일 발송
						url:'/email/send/'+obj,
						type:'POST',
						 data : JSON.stringify({username:obj}),
				         contentType: 'application/json',
				         beforeSend: function (jqXHR, settings) {
		                     let header = $("meta[name='_csrf_header']").attr("content");
		                     let token = $("meta[name='_csrf']").attr("content");
		                     jqXHR.setRequestHeader(header, token);
				         }
						}).done(function(data){
						secretkey=data;
					});
				}
			});
			}else{
				alert("이메일 양식을 확인해 주세요!");
			}
		})
		$("#emailsubmit").on("click",function(){			// 이메일 인증 완료
			if($("#keycheck").val()===secretkey){
				emailchecking=true;
				alert("이메일 인증이 완료되었습니다.");
				
			}else{
				alert("인증번호를 확인해주세요!");
			}
		})
		
		var unamechecking= false;
		
		$("#check").on(
				"click",
				function() {
					let unameInput =$("#uname").val();
					let unameReg = /^[a-z0-9A-Z가-힣]{1,10}$/;
					let resultUname = unameReg.test(unameInput);
					if (resultUname) {
						$.ajax({
							url:'/member/unamecheck/'+unameInput,
						type:'POST',
						 data : JSON.stringify({uname:unameInput}),
				         contentType: 'application/json',
				         beforeSend: function (jqXHR, settings) {
		                     let header = $("meta[name='_csrf_header']").attr("content");
		                     let token = $("meta[name='_csrf']").attr("content");
		                     jqXHR.setRequestHeader(header, token);
				         }
							}).done(function(data){
							if(data==="exist"){// 아이디 이미 존재
								alert("이미 사용중인 닉네임입니다.");
								
							}else{
								var unameUse = confirm("사용 가능한 닉네임입니다. 사용하시겠습니까?");
								if(unameUse){
								unamechecking = true;
																							
								}
							}
						});
						
					} else {
						alert("올바른 아이디를 입력해주세요!");
					}
				})
		$("#id").on("keyup", function() {
			emailchecking = false;
		})
		
		$("#uname").on("keyup", function() {
			unamechecking = false;
		})
		
	$("#back").on("click",function(){
		history.back();
	})
	
	
	
	document.getElementById("inp_pw02").onkeyup = function() {
			let chkPW = document.getElementById("inp_pw01").value;
			if (chkPW === this.value) {
				document.getElementById("pw-success").setAttribute("style",
						"display:block");
				document.getElementById("pw-danger").setAttribute("style",
						"display:none");
			} else {
				document.getElementById("pw-success").setAttribute("style",
						"display:none");
				document.getElementById("pw-danger").setAttribute("style",
						"display:block");

			}
		}

$("#searchcode").on("click",function(){

	 new daum.Postcode({
            oncomplete: function(data) {
                let roadAddr = data.roadAddress; // 도로명 주소 변수
                // 우편번호와 주소 정보를 해당 필드에 넣는다.
               $("#postcode").attr('value', data.zonecode);
                $("#address1").attr('value',roadAddr);
                
            }
        }).open();
        
})
	$("#inp_pw01")
		let pwInput = $("#inp_pw01").val();
		let nameInput = $("#realname").val();
		let uphoneInput =$("#phone").val();
		

		
		let pwReg = /^[^ㄱ-ㅎ]\S{8,16}$/;
		let nameRegex = /^[가-힣A-Za-z]+$/;
		let phoneReg=/^[0-9]{10,12}$/;


		let check = document.getElementById("checkForm");

		document.getElementById("send").onclick = function() {

		
			let resultPw = pwReg.test(pwInput);
			let resultName = nameRegex.test(nameInput);
			let resultPhone= phoneReg.test(uphoneInput);



		
			if (!resultPw) {
				alert("비밀번호는 8-16자 영문 대,소문자,숫자와 특수기호를 사용하세요.");
				return;
			}
			if (!resultName) {
				alert("이름은 한글과 영문 대,소문자를 사용하세요.(특수기호,공백 사용 불가)");
				return;
			}
			if(!emailchecking){
				alert("이메일 인증을 완료해 주세요.");
				return;
			}if(!unamechecking){
				alert("닉네임 중복확인을 진행해 주세요.");
				return;
			}if(!resultPhone){
				alert("전화번호를 확인해주세요");
				return;
			}
			
			check.submit();
		};
		})