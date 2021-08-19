
$(function () {

    $("#PromodifyScroll").on("click", function () {

        if($(".fileUploadClass").is(":hidden")){
        $(".fileUploadClass").slideDown('fast',function(){
            $(".fileUploadClass").css("display", "inline-block")
        })}else{
            $(".fileUploadClass").slideUp('fast',function(){
                $(".fileUploadClass").css("display", "none")
            })}

         if($("#uploadDesc span").is(":visible")){
            $("#uploadDesc span").slideDown('fast',function(){
            $("#uploadDesc span").css("display", "none");
        })}else{
            $("#uploadDesc span").slideUp('fast',function(){
            $("#uploadDesc span").css("display", "inline-block");
        })}
        if($("#profileSaveBtn").is(":visible")){
            $("#profileSaveBtn").slideUp('fast',function(){
            $("#profileSaveBtn").css("display", "none")
        })}else{
            $("#profileSaveBtn").slideDown('fast',function(){
            $("#profileSaveBtn").css("display", "inline-block")
        })}

        // if($(".fileUploadClass").is(":visible")){
        //     $(".fileUploadClass").css("display", "none");
        // }else{
        //     $(".fileUploadClass").css("display", "inline-block");
        // }

        // if($("#uploadDesc span").is(":visible")){
        //     $("#uploadDesc span").css("display", "none");
        // }else{
        //     $("#uploadDesc span").css("display", "inline-block");
        // }
        // if($("#profileSaveBtn").is(":visible")){
        //     $("#profileSaveBtn").css("display", "none")
        // }else{
        //     $("#profileSaveBtn").css("display", "inline-block")
        // }

    })

    $("#nameModifyScroll").on("click", function () {

        if($("#nameNBlank").is(":visible")){
                $("#nameNBlank").slideUp('fast',function(){
                    $("#nameNBlank").css("display", "none");
                })}else{
                    $("#nameNBlank").slideDown('fast',function(){
                    $("#nameNBlank").css("display", "inline-block");
                })}
    //   if($("#userName").is(":visible")){
    //     $("#userName").slideUp('slow',function(){
    //         $("#userName").css("display", "none");
    //     })}else{
    //         $("#userName").slideDown('slow',function(){
    //         $("#userName").css("display", "inline-block");
    //     })}

    //     if($(".Namesavebutton").is(":visible")){
    //         $(".Namesavebutton").slideUp('slow',function(){
    //         $(".Namesavebutton").css("display", "none");
    //     })}else{
    //         $(".Namesavebutton").slideDown('slow',function(){
    //         $(".Namesavebutton").css("display", "inline-block");
    //     })}

    })
    $("#emailModifyScroll").on("click", function () {
     
        if($("#emailblankNButton").is(":visible")){
            $("#emailblankNButton").slideUp('fast',function(){
                $("#emailblankNButton").css("display", "none");
            })}else{
                $("#emailblankNButton").slideDown('fast',function(){
                $("#emailblankNButton").css("display", "inline-block");
            })}


    })
    $("#pwModifyScroll").on("click", function () {

        if($("#pwblankNButton").is(":visible")){
            $("#pwblankNButton").slideUp('fast',function(){
                $("#pwblankNButton").css("display", "none");
            })}else{
                $("#pwblankNButton").slideDown('fast',function(){
                $("#pwblankNButton").css("display", "inline-block");
            })}

    })

    $("#contactModifyScroll").on("click", function () {


        if($("#contactblankNButton").is(":visible")){
            $("#contactblankNButton").slideUp('fast',function(){
                $("#contactblankNButton").css("display", "none");
            })}else{
                $("#contactblankNButton").slideDown('fast',function(){
                $("#contactblankNButton").css("display", "inline-block");
            })}
        })



/*$("#searchAddress").on("click",function(){
	
	 new daum.Postcode({
            oncomplete: function(data) {
                let roadAddr = data.roadAddress; // 도로명 주소 변수
                // 우편번호와 주소 정보를 해당 필드에 넣는다.
               $("#postCode").attr('value', data.zonecode);
                $("#addressScope").attr('value',roadAddr);
                
            }
        }).open();//팝업을 띄우려면 오픈만해줘
        
})

$("#modifyComp").on("click",function(){
	var realName=$("#inputReceiverName").val();
	var uphone=$("#inputReceiverContact").val();
	var address1=$("#addressScope").val();
	var postcode=$("#postCode").val();
	var address2=$("#addressDetail").val();
	
	var obj ={"realName":realName,"uphone":uphone, "address1":address1,"postcode":postcode,"address2":address2}
							
$.ajax({
		type : 'POST',
		url : '/member/uphoneUpdate/'+ modifyContact,
data : JSON.stringify({uphone : modifyContact}),
	contentType : "application/json",
	beforeSend : function(
	jqXHR, settings) {
	let header = $("meta[name='_csrf_header']").attr("content");
	let token = $("meta[name='_csrf']").attr("content");
	jqXHR.setRequestHeader(header,token);
},success : function(data) {
	alert("갱신 성공");
console.log(data);
location.reload();}
,error : function(request,status, error) {
alert("올바른 값을 입력했는지 확인해주세요."); // 실패 시 처리
}
})
	
}

	

})
})
*/




    