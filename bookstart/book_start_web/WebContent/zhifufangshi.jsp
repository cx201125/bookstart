<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="margin:100px 500px;">
<h1>请&nbsp;支&nbsp;付&nbsp;:${dingdan.dingdan_zj}元</h1>
<c:if test="${empty zhifufanghsi}">
<img  src="/pic/weixing.png" width="300px" height="400px">
</c:if>
<c:if test="${!empty zhifufanghsi}">
<img  src="/pic/zhifubao.jpg" width="300px" height="300px">
</c:if>
<button><a href="Index">已支付返回首页</a></button>
</div>

</body>
</html>