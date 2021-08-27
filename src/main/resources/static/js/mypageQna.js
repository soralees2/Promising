$(function(){
   //답장보내기 버튼눌렀을때 이름 적기
   $(".modalUp").on('click',function(){
      
   let taker=$(this).parents().closest(".card").find("#writergo").text();
   let QnaNo=$(this).parents().closest(".card").find(".originQnaNo").text();   
   let category =$(this).parents().closest(".card").find(".category").text();   
   $("#qna_category").val(category);

   $("#receiver").val(taker);
   
   $("#addQnaBtn").on('click', function(){
      let category = $("#qna_category").val();
      let contents = $("#qna_contents").val();      
      let receiver = $("#receiver").val();
      
if(category=="#"){
	alert("문의유형을 선택해주세요!")
	
}else if(contents==""){
	alert("문의내용을 입력해주세요!")
	
}else{
      let obj = {contents: contents,qnacategory:category, member:receiver,receiver:receiver};
        let url = '/member/' + obj.receiver;
       
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
            $('#qna_modal').modal('hide');
         })
	
	
	
}

  
   })
   
   
   });

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
   
   
});
   