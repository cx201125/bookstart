<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.util.*" %>
    <%@ page  import="com.chenxin.web.*" %>
    <%@ page  import="java.text.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
		 <meta http-equiv="X-UA-Compatible" content="IE=edge">
		 <meta name="viewport" content="width=device-width, initial-scale=1">
		 <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
		 <title>Bootstrap 101 Template</title>
		<link rel="stylesheet" type="text/css" href="bs/css/bootstrap.min.css"/>
		<script src="bs/js/jquery-1.11.0.min.js"></script>
		<script src="bs/js/bootstrap.min.js"></script>
		<title></title>
		<style type="text/css">
			#submit{
				height:30px;
				width:120px;
				background-color:red;
				display:inline-block;
			}
		</style>
	</head>
	<body>
	<!-- 头部分 -->
    <%@include file="/longo.jsp" %>
    <!-- 导航部分 -->
	<%@include file="/navigation.jsp" %>
		<div class="container">
			
		
		<div class="col-lg-12" style="height: 45px; background-color: #D0E9C6;" >
			<span style="margin-left:500px; font-size: 20px;"><b>购物车</b></span>
			
		</div>
		<div class="col-lg-12" >
		<c:if test="${empty tradecart}">
		<span style="font-size: 30px; display: block; margin: 200px 300px">购物车没有商品快去选购吧</span>
		</c:if>
		<c:if test="${!empty tradecart}">
			<table style="width: 100%;" border="2px">
				
					<thead>
					<tr style="background-color: lightsteelblue">
						<th>商品图片</th>
						<th>商品名称</th>
						<th>商品价格</th>
						<th>数量</th>
						<th>小计</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
				
				<c:forEach items="${tradecart.getTushumap()}" var="var">
					<tr height="40px">
						<td><img src="/pic/${var.value.getTushu().getTushu_images()}" width="45px" height="40px"></td>
						<td><span>${var.value.tushu.tushu_tsm}</span></td>
						<td><span>${var.value.getTushu().getTushu_jg()}</span></td>
						<td><span>${var.value.getNumber()}</span></td>
						<td><span>${var.value.getSubtotal()}</span></td>
						<td style="width:130px;"><a href="#"><button>购买</button></a>
						<a href="DelectSubTrade?Tushu_ID=${var.key}"><button>删除</button></a></td>
					</tr>
					</c:forEach>
					<tr><td colspan="6"><span style="margin-left:800px;">赠送积分:${tradecart.getTotal()}
					商品总计：${tradecart.getTotal()}</span></td>
					</tr>
					<form action="${pageContext.request.contextPath}/Dingdan" method="post">
					<tr><td colspan="6"><span style="margin-left:900px;"><a href="DelectTradecart"> 清空购物车</a> 
					<input type="submit" value="全部购买" id="submit"/></span></td></tr>
				</form>
				</tbody>
			</table>
			</c:if>
			
			
		</div>
		</div>
	</body>
</html>
