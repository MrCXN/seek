var name=$("#searchInput").val()||'';
$(document).ready(function() {
	getCompanyList(name);
	
	$(document).on("click", "#ai-topsearch", function(){
		name=$("#searchInput").val()
		getCompanyList(name);
	});
	//进入公司广告
	$(document).on("click", "#company", function(){
		sessionStorage.companyId = $(this).attr("companyId");
		window.location.href="company/advertisingIndex";
	});
	
});

/*
 * 公司对应的广告列表
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

