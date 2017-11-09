$(document).ready(function() {
	$(document).on("click", "#login", login);
});



function login() {
	var phone = $("#phone").val();
	var password = $("#password").val();
	if (phone == '') {
		closeAll();
		alert('请填写电话');
		return;
	}
	if (password == '') {
		alert('请填写密码');
		return;
	}
	$.post("doLogin", {
		phone : phone,
		password : password
	}, function(data) {
		if (data.code == 1000) {// 单角色
			var data = data.data;
			 localStorage.setItem("seekNm",data.seekNm);
			 localStorage.setItem("seekPhone",data.phone);
			goMain();// 跳转主画面
		}else {
			alert(data.msg);
		}
	}, "json");
}

// 跳转主画面
function goMain() {
	window.location.href = "index";
}