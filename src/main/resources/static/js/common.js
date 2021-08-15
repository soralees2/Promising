$(function(){
	  $("#search").on("click",function(){
        if($(".lookaround").css("display") == 'none'){
            $(".lookaround").css("display","block");
            $('body').css({"height":"100vh", "overflow":"hidden"});
        };
		console.log("버튼눌림")
    });

    $("#search_close").on("click",function(){
        $(".lookaround").css("display","none");
        $('body').css({"height":"auto", "overflow":"auto"});
    });
    
    $("#searchBtn").on("click",function(){
    	
    });
})
