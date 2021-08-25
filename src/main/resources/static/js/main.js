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
		typeStr = $(this).text();
		keywordStr = $(this).text();
		
		$("#f5").find("[name='type']").val(typeStr);
		$("#f5").find("[name='keyword']").val(keywordStr);
		$("#f5").submit();
	})
	
	$("#perfume").on("click",function(){
		typeStr = $(this).text();
		keywordStr = $(this).text();
		
		$("#f5").find("[name='type']").val(typeStr);
		$("#f5").find("[name='keyword']").val(keywordStr);
		$("#f5").submit();
	})
	
	$("#design").on("click",function(){
		typeStr = $(this).text();
		keywordStr = $(this).text();
		
		$("#f5").find("[name='type']").val(typeStr);
		$("#f5").find("[name='keyword']").val(keywordStr);
		$("#f5").submit();
	})
	
	$("#knowledge").on("click",function(){
		typeStr = $(this).text();
		keywordStr = $(this).text();
		
		$("#f5").find("[name='type']").val(typeStr);
		$("#f5").find("[name='keyword']").val(keywordStr);
		$("#f5").submit();
	})
	
	$("#trend").on("click",function(){
		typeStr = $(this).text();
		keywordStr = $(this).text();
		
		$("#f5").find("[name='type']").val(typeStr);
		$("#f5").find("[name='keyword']").val(keywordStr);
		$("#f5").submit();
	})
	
	$("#publishing").on("click",function(){
		typeStr = $(this).text();
		keywordStr = $(this).text();
		
		$("#f5").find("[name='type']").val(typeStr);
		$("#f5").find("[name='keyword']").val(keywordStr);
		$("#f5").submit();
	})
	
	$("#media").on("click",function(){
		typeStr = $(this).text();
		keywordStr = $(this).text();
		
		$("#f5").find("[name='type']").val(typeStr);
		$("#f5").find("[name='keyword']").val(keywordStr);
		$("#f5").submit();
	})
	
	$("#animal").on("click",function(){
		typeStr = $(this).text();
		keywordStr = $(this).text();
		
		$("#f5").find("[name='type']").val(typeStr);
		$("#f5").find("[name='keyword']").val(keywordStr);
		$("#f5").submit();
	})
	
	
	
})