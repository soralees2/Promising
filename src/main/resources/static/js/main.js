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
	
	
	$("#game").on("click",function(){
		location.href="project/list?page=1&size=12&type=게임&keyword=게임";
	})
	
	$("#perfume").on("click",function(){
		
	})
	
	$("#design").on("click",function(){
		
	})
	
	$("#knowledge").on("click",function(){
		
	})
	
	$("#trend").on("click",function(){
		
	})
	
	$("#publishing").on("click",function(){
		
	})
	
	$("#media").on("click",function(){
		
	})
	
	$("#animal").on("click",function(){
		
	})
	
	
	
})