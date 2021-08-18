let communityManager = (function(){
	
	console.log("ddd");

	let getAll = function(obj, callback){
		console.log("전부 출력");
		$.getJSON("/community/"+obj,callback)
	};
	
	let add = function(obj, callback){
		console.log("추가");
	};
	
	let update = function(obj, callback){
		console.log("수정");
	}
	
	let remove = function(obj, callback){
		console.log("삭제");
	}
		
	return {
		getAll : getAll,
		add : add,
		update : update,
		remove : remove
	}

})();