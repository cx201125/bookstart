<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
#login1 {
	padding: 40px 50px;
}

#login2 {
	padding: 55px 0px;
}

a {
	text-decoration: none;
}
</style>
</head>
<body>
	<!--longo部分-->
	<div class="container">
		<div class="row">
			<div class="col-lg-2" id="login1">
				<img src="/pic/logon4.jpg">
			</div>
			<div class="col-lg-6" id="login1">
				<img src="/pic/logon5.png" width="100%" height="80px;">
			</div>
			<div class="col-lg-4" id="login2">
				<span id=""> <c:if test="${user==null}">
						<a href="${pageContext.request.contextPath}/login.jsp">登录</a>&nbsp;&nbsp;
			<a href="${pageContext.request.contextPath}/register.jsp">注册</a>&nbsp;&nbsp;
			</c:if> <c:if test="${user!=null}">
						<a href="#">欢迎您，<span style="color: red;">${user.getUser_username()}!</span>&nbsp;&nbsp;
						</a>
						<a href="Tuichu">退出&nbsp;&nbsp;</a>
					</c:if> <c:if test="${user.user_number!=null}">
						<a href="DingdanFind">我的订单</a>&nbsp;&nbsp;
			</c:if> <a href="tradecart.jsp">购物车</a>
				</span>
			</div>
		</div>
</body>
</html>