$(function(){
	$("#inputmoney").keyup(function(){
		let fmoney=$("#inputmoney").val();
		var susu3=fmoney*0.03+(fmoney*0.03)*0.1;
		var susu5=fmoney*0.05+(fmoney*0.05)*0.1;
		var susu=susu3+susu5;
		var total=fmoney-susu;
	$("#paysusu").text(susu3+"원");
	$("#platsusu").text(susu5+"원");
	$("#totalsusu").text(susu+"원");
	$("#expect").text(total+"원");
	})
	
	
  $("#summernote").summernote({
                 
    height: 300, // 에디터 높이
    focus: true, // 에디터 로딩후 포커스를 맞출지 여부
    lang: "ko-KR", // 한글 설정
    placeholder: "내용을 입력하세요.",
    toolbar: [
        // [groupName, [list of button]]
        ['fontname', ['fontname']],
        ['fontsize', ['fontsize']],
        ['style', ['bold', 'italic', 'underline',
                'strikethrough', 'clear']],
        ['color', ['forecolor', 'color']],
        ['table', ['table']],
        ['para', ['ul', 'ol', 'paragraph']],
        ['height', ['height']],
        ['insert', ['picture', 'link', 'video']],
        ['view', ['fullscreen', 'help']]],
    fontNames: ['Arial', 'Arial Black', 'Comic Sans MS',
        'Courier New', '맑은 고딕', '궁서', '굴림체', '굴림', '돋움체',
        '바탕체'],
    fontSizes: ['8','9', '10', '11', '12', '14', '16', '18',
        '20', '22', '24', '28', '30', '36', '50', '72'],
        
       callbacks: {
  onImageUpload: function(imagefiles) {
    let editor =this; //summernote 인스턴스의 주소를 editor 변수에 저장
    let file = imagefiles[0];//업로드 해야 하는 파일 인스턴스
    let form = new FormData(); //html<form action="">
    form.append("file",file);//input type=file name 속성
    
   $.ajax({
    data:form,
    type:"post",
    url:"${pageContext.request.contextPath}/upload.file",
    contentType:false,
    processData:false
   }).done(function(resp){
     $(editor).summernote('insertImage',"${pageContext.request.contextPath}" +resp);
     //editor 인스턴스의 Image 기능으로 이미지를 화면에 출력
   });
  }
  } 
  
  });
})
