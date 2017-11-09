$(document).ready(function() {
	
	var phone = localStorage.getItem("seekPhone")||"";
	var name = localStorage.getItem("seekNm")||"";
	if(name!=""){
		$("#ifLogin").hide();
	}else{
		$("#exit").hide();
	}
	$("#name").text("姓名："+name);
	$("#phone").text("联系电话："+phone);
	
	$(document).on("click", "#exit", function(){
		 localStorage.setItem("seekNm","");
		 localStorage.setItem("seekPhone","");
		window.location.href="../login";
	});
});

