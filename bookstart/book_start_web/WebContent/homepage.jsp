<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.*" %>
 <%@ page import="com.chenxin.web.*" %>
 <%@ page import="java.text.*" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Bootstrap 101 Template</title>
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bs/css/bootstrap.min.css"/>
   <script src="${pageContext.request.contextPath}/bs/js/jquery-1.11.0.min.js"></script>
   <script src="${pageContext.request.contextPath}/bs/js/bootstrap.min.js"></script>
  </head>
  <body>
<!-- 头部分 -->
    <%@include file="/longo.jsp" %>
<!-- 导航部分 -->
	<%@include file="/navigation.jsp" %>
	<div class="container">
        <div class="row">
		<div class="col-lg-12" style="background-color: deepskyblue;">
	   	<h1>个人中心</h1>
		</div>
		</div>
		</div>
</body>
</html>