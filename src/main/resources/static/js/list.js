$(function(){
	
	let percent = new Array();
	percent = $(".percent").val();
	console.log("d" + percent);
	
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
	
	$("#del").on("click",function(){
		$("#searchKeyword").val("");
	})
	
	$(".pagination a").click(function(e) {
            e.preventDefault();
            $("#f6").find("[name='page']").val($(this).attr("href"));
            $("#f6").submit();
         });
         
     let typeStr;
     let keywordStr;
     let keywordStr2;
         
     $("#searchType").on("change",function(){
    	 let state = $("#searchType option:selected").val();
    	 if(state == "category"){
    		 $("#selectStatus").hide();
    		 $("#inputTitle").hide();
    		 $("#selectCurrentMoney").hide();
    		 $("#selectCategory").show();
    	 }else if(state == "status"){
    		 $("#selectCategory").hide();
    		 $("#inputTitle").hide();
    		 $("#selectCurrentMoney").hide();
    		 $("#selectStatus").show();
    	 }else if(state == "title"){
    		 $("#selectCategory").hide();
    		 $("#selectStatus").hide();
    		 $("#selectCurrentMoney").hide();
    		 $("#inputTitle").show();
    	 }else if(state == "money"){
    		 $("#selectCategory").hide();
    		 $("#selectStatus").hide();
    		 $("#inputTitle").hide();
    		 $("#selectCurrentMoney").show();
    	 }
     });
         
     $(".searchGo").on("change", function(){
    	typeStr = $(this).find(":selected").val();
		keywordStr = $(this).val();
		
		$("#searchBtn2").hide();
		$("#searchBtn").show();
     });
     
     $("#searchKeyword").keyup(function(){
    	 typeStr = $("#title2").find(":selected").val();
    	 keywordStr = $(this).val();
    	 
    	 $("#searchBtn2").hide();
		 $("#searchBtn").show();
     })
     
     $("#current2").on("change", function(){
     	typeStr = $(this).find(":selected").val();
		keywordStr = $(this).val();
		keywordStr2 = $("#current2 > option:selected").attr("value2");
		
		$("#searchBtn").hide();
		$("#searchBtn2").show();
      });
     
     $("#searchBtn").on("click", function(){
    	 if($("#searchType option:selected").val() == ""){
    		 alert("검색 조건을 선택하세요.");
    		 return false;
    	 }
		$("#f6").find("[name='type']").val(typeStr);
		$("#f6").find("[name='keyword']").val(keywordStr);
		$("#f6").find("[name='page']").val("1");
		$("#f6").submit();
	 });
     
     $("#searchBtn2").on("click", function(){
    	 if($("#searchType option:selected").val() == ""){
    		 alert("검색 조건을 선택하세요.");
    		 return false;
    	 }
		$("#f4").find("[name='type']").val(typeStr);
		$("#f4").find("[name='keyword']").val(keywordStr);
		$("#f4").find("[name='keyword2']").val(keywordStr2);
		$("#f4").find("[name='page']").val("1");
		$("#f4").submit();
	 });

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