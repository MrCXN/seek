var companyId=sessionStorage.companyId||-1;
$(document).ready(function() {
	var name = localStorage.getItem("seekNm")||"";
	var phone = localStorage.getItem("seekPhone")||"";
	if(name!=""){
		$("#ifLogin").hide();
	}else{
		$("#exit").hide();
	}
	getAdvertisingList(name);
	
	$(document).on("click", "#exit", function(){
		 localStorage.setItem("seekNm","");
		 localStorage.setItem("seekPhone","");
		window.location.href="../login";
	});
	
});

/*
 * 公司对应的广告列表
 */
function getAdvertisingList(name){
	$.post("../advertising/getAdvertisingList", {
		companyId : companyId
	}, function(data) {
		var code =data.code;
		if (code == 1000) {// 单角色
			//$("#cartTable").empty();
			var str="<div class='cart-table-th'>" +
						"<div class='wp'>" +
							"<div class='th th-item'>" +
								"<div class='td-inner'>工作信息</div>" +
							"</div>" +
							"<div class='th th-price'>" +
								"<div class='td-inner'>月薪</div>" +
							"</div>" +
							"<div class='th th-amount'>" +
								"<div class='td-inner'>年龄</div>" +
							"</div>" +
							"<div class='th th-sum'>" +
								"<div class='td-inner'>性别</div>" +
							"</div>" +
							"<div class='th th-op'>" +
								"<div class='td-inner'>操作</div>" +
							"</div>" +
						"</div>" +
					"</div>" 
				$("#cartTable").append(str);
			var len = data.list.length;
			if(len>0){
				$("#advertisingListTmpl").tmpl(data.list).appendTo("#cartTable");
			}else{
				$("#cartTable").append("<h1 align='center'><i><font color='red'>暂无工作招聘....抱歉!</font></i></h1>");
			}
			
			if(name==""||name==undefined){
				$(".jobs").text("请登录");
				$(document).on("click", "#employ", function(){
					window.location.href="../login";
				});
			}else{
				$(".jobs").text("应聘");
				$(document).on("click", "#employ", function(){
					sessionStorage.companyId = $(this).attr("companyId");
					window.location.href="../advertising/successIndex";
				});
			}
			
		}else {
			alert(data.msg);
		}
	}, "json");
}

