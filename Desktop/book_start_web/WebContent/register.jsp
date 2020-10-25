<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>Bootstrap 101 Template</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/bs/css/bootstrap.min.css" />
<script
	src="${pageContext.request.contextPath}/bs/js/jquery-1.11.0.min.js"></script>
<script src="${pageContext.request.contextPath}/bs/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
<style type="text/css">
body {
	background-image: url(images/snow.jpg);
}

#zhuchei {
	margin-top: 80px;
	margin-left: 420px;
	background-color: white;
	width: 530px;
	height: 600px;
}

#pass, #word, #user, #dianhua, #truename, #emil, #number {
	width: 500px;
	height: 32px;
}

#dl {
	font-size: 12px;
	margin-left: 250px;
}

#td1 {
	border-bottom: #445566 solid 1px;
	height: 50px;
	width: 340px;
}

#submit {
	height: 30px;
	width: 300px;
	background-color: red;
	display: inline-block;
	margin-left: 100px;
}

#checkbox {
	margin-left: 180px;
	display: inline-block;
}

#checkboxspan {
	margin-left: 95px;
}
</style>

<script type="text/javascript">
	//异步校验电话是否被注册
	var ff = false
	$(function() {
		$("#dianhua")
				.blur(
						function() {
							//创建正则表达式

							var dianhuaregex = new RegExp('1[0-9]{10}');
							//获取电话里面的内容
							var dianhua = this.value

							$
									.ajax({
										url : "Dianhua",
										async : false,
										type : "POST",
										data : {
											"dianhua" : dianhua
										},
										success : function(date) {
											ff = date.f

											if (!dianhuaregex.test(dianhua)) {
												document
														.getElementById("dianhuaspan").innerHTML = "<font size='2' color='red'>请输入11位有效的手机号码</font>";
											} else if (!ff) {
												document
														.getElementById("dianhuaspan").innerHTML = "<font size='2' color='red'>该电话已经被注册</font>";
											} else {
												document
														.getElementById("dianhuaspan").innerHTML = "&emsp;";
											}
										},
										dataType : "json"
									})
						})
	})

	function chenxin() {

		var user = document.getElementById("user").value;
		var userspan = document.getElementById("userspan");
		var word = document.getElementById("word").value;
		var wordspan = document.getElementById("wordspan");
		var pass = document.getElementById("pass").value;
		;
		var passspan = document.getElementById("passspan");
		var dianhua = document.getElementById("dianhua").value;
		var dianhuaspan = document.getElementById("dianhuaspan");

		var emil = document.getElementById("emil").value;
		var emilspan = document.getElementById("emilspan");

		var truename = document.getElementById("truename").value;
		var truenamespan = document.getElementById("truenamespan");

		var number = document.getElementById("number").value;
		;
		var numberspan = document.getElementById("numberspan");

		var sex = document.getElementById("sex").value;
		var sexpan = document.getElementById("sexspan");

		var emilregex = new RegExp('\\w{5,12}@\\w{2,}.\\w{2,5}');

		var truenameregex = new RegExp('[\u4e00-\u9fa5]');
		var numberregex = new RegExp('([0-9]){15,18}');

		var userregex = new RegExp('\\w{6,21}');
		var wordregex = new RegExp('\\w{8,21}');
		var dianhuaregex = new RegExp('1[0-9]{10}');
		var checkbox = document.getElementById("checkbox");
		if (!userregex.test(user)) {
			userspan.innerHTML = "<font size='2' color='red'>6-20位数字和字母</font>";
			return false;
		} else if (!wordregex.test(word)) {
			wordspan.innerHTML = "<font size='2' color='red'>8-20位数字和字母</font>";
			return false;
		} else if (pass != word) {
			passspan.innerHTML = "<font size='2' color='red'>两次密码不相同</font>";
			return false;
		} else if (!dianhuaregex.test(dianhua)) {
			//没有写该电话已经被注册的时候不能注册
			dianhuaspan.innerHTML = "<font size='2' color='red'>请输入11位有效的手机号码</font>";
			return false;
		} else if (checkbox.checked == false) {
			checkboxspan.innerHTML = "<font size='2' color='red'>接受服务条款才能注册</font>";
			return false;
		} else if (!ff) {
			dianhuaspan.innerHTML = "<font size='2' color='red'>该电话已经被注册</font>";
			return false;
		} else if (!emilregex.test(emil)) {
			emilspan.innerHTML = "<font size='2' color='red'>请输入正确的邮箱</font>";
			return false;
		} else if (!truenameregex.test(truename)) {
			truenamespan.innerHTML = "<font size='2' color='red'>请输入真实姓名</font>";
			return false;
		} else if (!numberregex.test(number)) {
			numberspan.innerHTML = "<font size='2' color='red'>请输入18位有效的身份证号</font>";
			return false;
		} else if (sex == 3) {
			sexspan.innerHTML = "<font size='2' color='red'>请选择您的性别</font>";
			return false;
		}
	}
	function chenxin1() {
		var userregex = new RegExp('\\w{6,21}');
		var user = document.getElementById("user").value;
		if (!userregex.test(user)) {
			document.getElementById("userspan").innerHTML = "<font size='2' color='red'>6-20位数字和字母</font>";
		} else {
			document.getElementById("userspan").innerHTML = "&emsp;";
		}
	}
	function chenxin2() {
		var wordregex = new RegExp('\\w{8,21}');
		var word = document.getElementById("word").value;
		if (!wordregex.test(word)) {
			document.getElementById("wordspan").innerHTML = "<font size='2' color='red'>8-20位数字和字母</font>";
		} else {
			document.getElementById("wordspan").innerHTML = "&emsp;";
		}
	}
	function chenxin3() {
		var word = document.getElementById("word").value;
		var pass = document.getElementById("pass").value;
		if (word != pass) {
			document.getElementById("passspan").innerHTML = "<font size='2' color='red'>两次密码不相同</font>";
		} else {
			document.getElementById("passspan").innerHTML = "&emsp;";
		}
	}
	$(
			function() {

				$("#emil")
						.blur(
								function() {

									var emilregex = new RegExp(
											'\\w{5,12}@\\w{2,}.\\w{2,5}');

									var emil = document.getElementById("emil").value;

									if (!emilregex.test(emil)) {
										document.getElementById("emilspan").innerHTML = "<font size='2' color='red'>请输入正确的邮箱</font>";
									} else {
										document.getElementById("emilspan").innerHTML = "&emsp;";
									}
								})

				$("#truename")
						.blur(
								function() {

									var truenameregex = new RegExp(
											'[\u4e00-\u9fa5]');
									var truename = document
											.getElementById("truename").value;

									if (!truenameregex.test(truename)) {
										document.getElementById("truenamespan").innerHTML = "<font size='2' color='red'>请输入正确的姓名</font>";
									} else {
										document.getElementById("truenamespan").innerHTML = "&emsp;";
									}
								})

				$("#number")
						.blur(
								function() {
									var number = document
											.getElementById("number").value;
									var numberregex = new RegExp(
											'([0-9]){15,18}');
									if (!numberregex.test(number)) {
										document.getElementById("numberspan").innerHTML = "<font size='2' color='red'>身份证格式不正确</font>";
									} else {
										document.getElementById("numberspan").innerHTML = "&emsp;";
									}
								})

			})
</script>
</head>
<body bgcolor="green">
	<a href="Index"><button>
			<strong>返回首页</strong>
		</button></a>
	<div id="zhuchei">
		<table id="table">
			<form action="Register" method="post" onsubmit=" return chenxin()">
				<tr>
					<td>&nbsp;&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td id="td1">&nbsp;&nbsp;&nbsp;<b><font size="4"
							color="#AAAACC">用户注册</font></b> <span id="dl">已注册可<a
							href="login.jsp">直接登录</a></span>
					</td>
				</tr>
				<tr>
					<td>&#160;</td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;&nbsp;<span id="userspan"> &#160;<span
							style="color: red; font-size: 15px">${requestScope.name}</span> <span
							style="color: red; font-size: 15px">${requestScope.user}</span>
					</span></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;&nbsp; <input type="text" name="username"
						placeholder="用户名:6-20位数字和字母" maxlength="20" id="user"
						onblur="chenxin1()" />
					</td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;&nbsp;<span id="wordspan"> &#160;<span
							style="color: red; font-size: 15px">${requestScope.pass}</span>

					</span></td>
				</tr>
				<tr>

					<td>&nbsp;&nbsp;&nbsp; <input type="password" name="password"
						placeholder="密码:8-20位数字和字母" maxlength="20" id="word"
						onblur="chenxin2()"></td>
				</tr>
				<tr>

					<td>&nbsp;&nbsp;&nbsp;<span id="passspan"> &#160;<span
							style="color: red; font-size: 15px">${requestScope.word}</span>
					</span></td>
				</tr>
				<tr>

					<td>&nbsp;&nbsp;&nbsp; <input type="password" name="queren"
						placeholder="请再次输入上面的密码" maxlength="14" / id="pass"
						onblur="chenxin3()"></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;&nbsp;<span id="dianhuaspan"> &#160;<span
							style="color: red; font-size: 15px">${requestScope.dianhua}</span>
					</span></td>
				</tr>
				<tr>

					<td>&nbsp;&nbsp;&nbsp; <input type="text" name="dianhua"
						maxlength="11" placeholder="请输入手机号码" id="dianhua"
						onblur="chenxin4()" /></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;&nbsp;<span id="emilspan"> &#160; </span></td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;&nbsp; <input type="text" name="mail"
						placeholder="邮箱:请输入有效的邮箱" maxlength="20" id="emil" />
					</td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;&nbsp;<span id="truenamespan"> &#160; </span></td>
				</tr>
				<tr>

					<td>&nbsp;&nbsp;&nbsp; <input type="text" name="true_name"
						placeholder="真实姓名：请输入真实姓名" maxlength="4" id="truename"></td>
				</tr>

				<td>&nbsp;&nbsp;&nbsp;<span id="sexspan"> &#160; </span></td>
				</tr>
				<tr>

					<td>&nbsp;&nbsp;&nbsp; 性别<select id="sex" name="sex">
							<option selected="" value="3">---请选择---</option>
							<option value="1">男</option>
							<option value="2">女</option>
					</select>
					</td>
				</tr>
				<tr>

					<td>&nbsp;&nbsp;&nbsp;<span id="numberspan"> &#160; </span></td>
				</tr>
				<tr>

					<td>&nbsp;&nbsp;&nbsp; <input type="text" name="number"
						placeholder="身份证号：请输入有效的身份证号" maxlength="19" / id="number"></td>
				</tr>
				<tr>
				<tr>
					<td>&nbsp;&nbsp;&nbsp; <input type="checkbox" style=""
						id="checkbox" value="1" /> <span style="font-size: 12px;">我已阅读并同意<a
							href="#">《用户注册协议》</a></span>
					</td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;&nbsp; <span id="checkboxspan"> &#160;
					</span>
					</td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;&nbsp; <input type="submit" value="同意以上协议并注册"
						id="submit" />
					</td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;&nbsp;</td>
				</tr>
		</table>
		</form>
	</div>

</body>
</html>