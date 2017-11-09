$(document).ready(function() {
	$(document).on("click", "#register", register);
});



function register() {
	var seekNm = $("#seekNm").val();
	var phone = $("#phone").val();
	var password = $("#password").val();
	var passwordRepeat = $("#passwordRepeat").val();
	if (seekNm == '') {
		closeAll();
		alert('请填写姓名');
		return;
	}
	if (phone == '') {
		closeAll();
		alert('请填写电话');
		return;
	}
	if (password == '') {
		alert('请填写密码');
		return;
	}
	if (passwordRepeat == '') {
		alert('请填写确认密码');
		return;
	}
	if(password!=passwordRepeat){
		alert('两次出入的密码不一致');
		return;
	}
	$.post("register", {
		seekNm:seekNm,
		phone : phone,
		password : password
	}, function(data) {
		if (data.code == 1000) {// 单角色
			goLogin();// 跳转主画面
		}else {
			alert(data.msg);
		}
	}, "json");
}

// 跳转主画面
function goLogin() {
	window.location.href = "../login";
}