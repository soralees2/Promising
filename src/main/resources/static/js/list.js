$(function(){
	
	$("#seeMoreBtn").on("click",function(){
		location.href="/project/list";
	})
	
	$("#newPro").on("click",function(){
		$("#f1").submit();
	})
	
	$("#closePro").on("click",function(){
		$("#f2").submit();
	})
	
	
	
})