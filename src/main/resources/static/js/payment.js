$(function(){

	$("#btn_payment02").on("click", function(){
		let payForm = $("#payForm");
		let payMoney = $("#payment_money span").text();
		let amount = payForm.find(".count").text();
		let pno = $("#pno").val();

		$("#price").val(payMoney); 
		$("#amount").val(amount);
		
		payForm.attr("action", "/project/payment/" + pno);
		payForm.submit();	
	
	});

});