
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
                $("#nameNBlank").slideUp('slow',function(){
                    $("#nameNBlank").css("display", "none");
                })}else{
                    $("#nameNBlank").slideDown('slow',function(){
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
            $("#emailblankNButton").slideUp('slow',function(){
                $("#emailblankNButton").css("display", "none");
            })}else{
                $("#emailblankNButton").slideDown('slow',function(){
                $("#emailblankNButton").css("display", "inline-block");
            })}


    })
    $("#pwModifyScroll").on("click", function () {

        if($("#pwblankNButton").is(":visible")){
            $("#pwblankNButton").slideUp('slow',function(){
                $("#pwblankNButton").css("display", "none");
            })}else{
                $("#pwblankNButton").slideDown('slow',function(){
                $("#pwblankNButton").css("display", "inline-block");
            })}

    })

    $("#contactModifyScroll").on("click", function () {


        if($("#contactblankNButton").is(":visible")){
            $("#contactblankNButton").slideUp('slow',function(){
                $("#contactblankNButton").css("display", "none");
            })}else{
                $("#contactblankNButton").slideDown('slow',function(){
                $("#contactblankNButton").css("display", "inline-block");
            })}
        })








        
})







    