
$(function(){
	$("#findbtn").on("click",function(){			// 이메일 인증 버튼 클릭
			let obj=$("#username").val();
			let inputId = $("#username").val();
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
					alert("메일이 발송되었습니다.")
					$("#findform").submit();
				}else if(data==="can"){
					alert("가입되지 않은 이메일입니다.");
				}
			});
			}else{
				alert("이메일 양식을 확인해 주세요!");
			}
		});
})
