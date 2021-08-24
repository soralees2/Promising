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
   
   });
   