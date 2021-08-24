$(function(){
   //답장보내기 버튼눌렀을때 이름 적기
   $(".modalUp").on('click',function(){
      
   let taker=$(this).parents().closest(".card").find("#writergo").text();
   let QnaNo=$(this).parents().closest(".card").find(".originQnaNo").text();   
      
      console.log(taker);

   $("#receiver").val(taker);
   
   $("#addQnaBtn").on('click', function(){
      let category = $("#qna_category option:selected").val();
      let contents = $("#qna_contents").val();      
      let receiver = $("#receiver").val();
      console.log("receiver : " + receiver);
      console.log("category : " + category);
      console.log("contents : " + contents);
      
      let obj = {contents: contents,qnacategory:category, member:receiver,receiver:receiver};
        console.log(JSON.stringify(obj));
        let url = '/member/' + obj.receiver;
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
   
   
});
   