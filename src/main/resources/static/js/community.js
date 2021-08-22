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
	$("#pay_01").on("click", function(){
		$("#btn_payment").text("1 만 원 후원하기");
		$("._01 .money strong").text("+10000");
	});
	$("#pay_02").on("click", function(){
		$("#btn_payment").text("30 만 원 후원하기");
		$("._01 .money strong").text("+300000");
	});
	$("#pay_03").on("click", function(){
		$("#btn_payment").text("50 만 원 후원하기");
		$("._01 .money strong").text("+500000");
	});
	$("#pay_04").on("click", function(){
		$("#btn_payment").text("100 만 원 후원하기");
		$("._01 .money strong").text("+1000000");
	});

	// 결제 금액 입력
	$("#add_money").on("keypress", function(){
		let number = $(".money strong").text().replace(",", "");
		console.log(number);
		let money = console.log("수량 : " + count);
		console.log(money);
		money = money + parseInt($(this).val());
		console.log(money);
		$("._01 .money strong").text(money);
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
		$("#btn_payment .result_money").text(money_txt);
	});
	$(".btn_plus").on("click", function(){
		++count;
		let money_txt= (money*count);
		$(".incremental-input .count").text(count);
		moneyTxt.text(money_txt);
		$("#btn_payment .result_money").text(money_txt);
	});	

})

