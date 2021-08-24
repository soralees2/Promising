$(function () {
	

	
	$("#pills-donated-tab").on("click",function(){
		
		alert("구현 예정인 기능입니다.")
		
	})

	$(".navlinkQ").on("click",function(){
		
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
		location.href="http://localhost/project/list?page=1&size=12&type=게임&keyword=게임";
	})
	
	$("#perfume").on("click",function(){
		location.href="http://localhost/project/list?page=1&size=12&type=향수&keyword=향수";
	})
	
	$("#design").on("click",function(){
		location.href="http://localhost/project/list?page=1&size=12&type=디자인&keyword=디자인";
	})
	
	$("#knowledge").on("click",function(){
		location.href="http://localhost/project/list?page=1&size=12&type=지식&keyword=지식";
	})
	
	$("#trend").on("click",function(){
		location.href="http://localhost/project/list?page=1&size=12&type=트렌드&keyword=트렌드";
	})
	
	$("#publishing").on("click",function(){
		location.href="http://localhost/project/list?page=1&size=12&type=출판&keyword=출판";
	})
	
	$("#media").on("click",function(){
		location.href="http://localhost/project/list?page=1&size=12&type=미디어&keyword=미디어";
	})
	
	$("#animal").on("click",function(){
		location.href="http://localhost/project/list?page=1&size=12&type=애완&keyword=애완";
	})
	
})