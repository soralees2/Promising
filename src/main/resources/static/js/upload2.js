$(function () {
  if (
    $("#nineteen").is(":checked") == true &&
    $("#phoneequalemail").is(":checked") == true &&
    $("#account").is(":checked") == true &&
    $("#refund").is(":checked") == true
  ) {
    $("#next").removeAttr("disabled");
  } else {
    $("#next").attr("disabled", "disabled");
  }
  
  $("#back").on("click", function () {
    history.back();
  });

  $(".checking").on("click", function () {
    if (
      $("#nineteen").is(":checked") == true &&
      $("#phoneequalemail").is(":checked") == true &&
      $("#account").is(":checked") == true &&
      $("#refund").is(":checked") == true
    ) {
      $("#next").removeAttr("disabled");
    } else {
      $("#next").attr("disabled", "disabled");
    }
  });
  $("#next").on("click", function () {
    location.href = "/project/auth/upload3";
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
