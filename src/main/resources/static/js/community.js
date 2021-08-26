var commentManager = (function(){
	
	var getAll  = function(obj, callback){
		console.log("get All....");
		
		$.getJSON('/com/cmt/'+obj,callback);
		
	};
	
	var getCount  = function(cno){
		console.log("get Count...");
		
		$.getJSON('/com/cmtnum/'+cno, callback);
	};
	
	var add = function(obj, callback){
		
		console.log("add....");
		
		$.ajax({
			type:'post',
			url: '/com/cmtadd/'+ obj.community,
			data:JSON.stringify(obj), 
			dataType:'json',
			contentType: "application/json",
			beforeSend: function (jqXHR, settings) {
		           		let header = $("meta[name='_csrf_header']").attr("content");
		           		let token = $("meta[name='_csrf']").attr("content");
		           		jqXHR.setRequestHeader(header, token);
					},
			success:callback
		});
	};
	
	var update = function(obj, callback){
		console.log("update.......");
		
		$.ajax({
			type:'put',
			url: '/com/cmt/'+ obj.bno,
			dataType:'json',
			data: JSON.stringify(obj),
			contentType: "application/json",
			success:callback
		});
		
	};
	
	var remove = function(obj,callback){
		
		console.log("remove........");
		$.ajax({
			type:'delete',
			url: '/com/cmtdel/'+ obj.commentno + '/' + obj.community,
			dataType:'json',
			contentType: "application/json",
			beforeSend: function (jqXHR, settings) {
		           		let header = $("meta[name='_csrf_header']").attr("content");
		           		let token = $("meta[name='_csrf']").attr("content");
		           		jqXHR.setRequestHeader(header, token);
					},
			success:callback
		});
	};
	
	return { 
		getAll: getAll,
		add:add,
		update:update,
		remove:remove
	}
		
})();

$(function(){

	// 후원하기 버튼 스크롤 이동
	$('.btn_sponsor').on("click", function(){
	    $('html, body').animate({
	        scrollTop: $( $(this).attr('href') ).offset().top
	    }, 500);
	    return false;
	});
	
	// QnA 문의하기
	$("#addQnaBtn").on('click', function(){
		let category = $("#qna_category option:selected").val();
		let contents = $("#qna_contents").val();		
		let receiver = $(".writer .name").text();
		
		if(category == ""){
			alert("문의유형을 선택해주세요.");
			return false;
		}else if(contents == ""){
			alert("내용을 입력해주세요.")
			return false;
		}
		
		
	 	let obj = { qnacategory:category, contents: contents, receiver: receiver, member :receiver};
	  	console.log(JSON.stringify(obj));
	  	
	  	let url = '/qna/' + obj.receiver;
	 	console.log(url);
	 	
		$.ajax({
			type:'post',
	  		url: decodeURI(url),
		  	data : JSON.stringify(obj),
		  	dataType:'json',
		  	contentType: "application/json",
		  	beforeSend: function (jqXHR, settings) {
	       		let header = $("meta[name='_csrf_header']").attr("content");
	       		let token = $("meta[name='_csrf']").attr("content");
	       		jqXHR.setRequestHeader(header, token);
				}
			}).done(function(){
				console.log("성공");
				$('#qna_modal').modal('hide');
			})
	 });
	 
	 
	 // 후원 금액 선택 
	$("#payment .btn_wrap button").on("click", function(){
		if($(this).hasClass("pay_01")){
			moneyPlus(5000);
		}else if($(this).hasClass("pay_02")){
			moneyPlus(10000);
		}else if($(this).hasClass("pay_03")){
			moneyPlus(30000);
		}else if($(this).hasClass("pay_04")){
			moneyPlus(50000);
		}
	});
	function moneyPlus(m){
		let paymoney = $("._01 .money strong");
		let total = Number(paymoney.text().substring(1));
		total += m;
		paymoney.text("+" + total);
		$("#btn_payment01").text(total + "원 후원하기");
	}

	// 결제 금액 입력
	/*
	$("#add_money").on("keyup", function(e){
		if ((e.keyCode < 48) || (e.keyCode > 57)){
			$(this).val("");
			alert("숫자만 입력해주세요.");
     	 }
      
		let number = parseInt($(".money strong").text().substring(1));
		let sprice = Number($(this).val());
		let price = $("._01 .money strong");
		let total;
		
		if($("#pay_01").hasClass("active")){
			total = 10000+sprice
		}else if($("#pay_02").hasClass("active")){
			total = 300000+sprice
		}else if($("#pay_03").hasClass("active")){
			total = 500000+sprice;
		}else if($("#pay_04").hasClass("active")){
			total = 1000000+sprice;
		}
		if(total >= 10000000){
			alert("최대 후원 가능 금액은 1000 만원 입니다.");
			$(this).val("");
			return false;
		}else{
			price.text("+" +total);
		}
		$("#btn_payment01").text(total +" 원 후원하기");
	});
	*/
	
	$(".payment .btn_wrap button").on("click", function(){
		$(this).addClass("active").siblings().removeClass("active");
	});
	
	// 결제 수량 선택 
	let count = 1; // 수량 초기값
	let moneyTxt = $(".payment._02 .money strong");
	let money = parseInt(moneyTxt.text().substring(1));
	$(".btn_minus").on("click", function(){
		if(count == 1){
			alert("수량은 1개 이상 선택 가능합니다.");
			return false;
		}				
		--count;
		let money_txt= (money*count);
		$(".incremental-input .count").text(count);
		moneyTxt.text(money_txt);
		$("#btn_payment02 .result_money").text(money_txt);
	});
	$(".btn_plus").on("click", function(){
		++count;
		let money_txt= (money*count);
		$(".incremental-input .count").text(count);
		moneyTxt.text("+" +money_txt);
		$("#btn_payment02 .result_money").text(money_txt);
	});	

	let pno = $("#pno").val();
	// 후원하기
	$("#btn_payment01").on("click", function(){
		let sponsorForm = $("#sponsorForm");
		let payMoney = sponsorForm.find(".money strong").text();
		let price = payMoney.substring(1);
		$("#sprice").val(price);
		
		sponsorForm.attr("action", "/project/payment/" + pno);
		sponsorForm.submit();	
	});
	
	// 결제 하기
	$("#btn_payment02").on("click", function(){
		let payForm = $("#payForm");
		let payMoney = $("#payment_money").text().substring(1);;
		let amount = payForm.find(".count").text();
		
		$("#price").val(payMoney);
		$("#amount").val(amount);
		payForm.attr("action", "/project/payment/" + pno);
		payForm.submit();	
	});
	
	
	// 로그인 여부 확인
	$(".loginCheck").on("click",function(){
	
		let loginUser = $("#user").text();
		if(loginUser == ""){
			alert("로그인이 필요한 서비스입니다.");
			location.href="/member/login";
		}
	})
	
	//남은일자 계산
	let date01 = $("#startDate").val();
	let date02 = $("#endDate").val();
	let start = new Date(date01);
	let end = new Date(date02);
	let elapsedMSec = end.getTime() - start.getTime();
	let elapsedDay = elapsedMSec / 1000 / 60 / 60 / 24; // 2
	$("#limitedDate").find("strong").text(elapsedDay);
	
		
	// 달성률 계산
	let target = $("#tgMoney").val();
	let current = $("#crMoney").val();
	let percent =  Math.ceil(current/target * 100);
	$("#percent").text(percent + "%");	
	$(".info .achivement").text(percent + "%");
	// 오픈예정 프로젝트 결제 비활성화 
	let prStatus = $("#status").val();
	if(prStatus == "N" || prStatus == "F"){
		$("#payment button").attr("disabled","disabled");
		$("#btn_payment02").attr("disabled","disabled");
	}
});

