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
});
