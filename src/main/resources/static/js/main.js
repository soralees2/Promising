$(function(){
	
	$("#seeMoreBtn").on("click",function(){
		location.href="/project/list";
	})
	
	$("#popularPro").on("click",function(){
		$("#f1").submit();
	})
	
	$("#newPro").on("click",function(){
		$("#f2").submit();
	})
	
	$("#closePro").on("click",function(){
		$("#f3").submit();
	})
	
	
	
})