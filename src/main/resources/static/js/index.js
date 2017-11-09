var name=$("#searchInput").val()||'';
$(document).ready(function() {
	var phone = localStorage.getItem("seekPhone")||"";
	var seekPhone = localStorage.getItem("seekNm")||"";
	if(seekPhone!=""){
		$("#ifLogin").hide();
	}else{
		$("#exit").hide();
	}
	
	getCompanyList(name);
	
	$(document).on("click", "#ai-topsearch", function(){
		name=$("#searchInput").val()
		getCompanyList(name);
	});
	
	//进入公司广告
	$(document).on("click", "#company", function(){
		sessionStorage.companyId = $(this).attr("companyId")||"-1";
		window.location.href="company/advertisingIndex";
	});
	
	$(document).on("click", "#exit", function(){
		 localStorage.setItem("seekNm","");
		 localStorage.setItem("seekPhone","");
		window.location.href="../login";
	});
	
});

/*
 * 公司列表
 */
function getCompanyList(name){
	$.post("company/getCompanyList", {
		name : name
	}, function(data) {
		var code =data.code;
		if (code == 1000) {// 单角色
			$("#companyList").empty();
			$("#companyListTmpl").tmpl(data.list).appendTo("#companyList");
		}else {
			alert(data.msg);
		}
	}, "json");
}

