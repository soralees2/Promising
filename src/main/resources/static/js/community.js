var commentManager = (function(){
	
	var getAll  = function(obj, callback){
		console.log("get All....");
		
		$.getJSON('/com/cmt/'+obj,callback );
		
	};
	
	var getCount  = function(obj, callback){
		console.log("get Count....");
		
		$.getJSON('/com/count/'+obj,callback );
		
	};
	
	var add = function(obj, callback){
		
		console.log("add....");
		
		$.ajax({
			type:'post',
			url: '/com/cmtadd/'+ obj.community,
			data:JSON.stringify(obj), 
			dataType:'json',
			contentType: "application/json",
			beforeSend: function (jqXHR, settings) {
		           		let header = $("meta[name='_csrf_header']").attr("content");
		           		let token = $("meta[name='_csrf']").attr("content");
		           		jqXHR.setRequestHeader(header, token);
					},
			success:callback
		});
	};
	
	var update = function(obj, callback){
		console.log("update.......");
		
		$.ajax({
			type:'put',
			url: '/com/cmt/'+ obj.bno,
			dataType:'json',
			data: JSON.stringify(obj),
			contentType: "application/json",
			success:callback
		});
		
	};
	
	var remove = function(obj, callback){
		
		console.log("remove........");
		
		$.ajax({
			type:'delete',
			url: '/com/cmt/'+ obj.bno+"/" + obj.rno,
			dataType:'json',
			contentType: "application/json",
			success:callback
		});
	};
	
	return { 
		getAll: getAll,
		add:add,
		update:update,
		remove:remove
	}
		
})();
