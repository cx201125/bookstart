<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				height:45px;
				width:150px;
				background-color:orange;
				display:inline-block;
				margin-top: 100px;
				margin-bottom: 100px;
				margin-left: 1000px;
			}
		</style>
	</head>
	<body>
		<div class="container">
			
		
		<div class="col-lg-12" style="height: 45px; background-color: #D0E9C6;" >
			<span style="margin-left:500px; font-size: 20px;"><b>我的订单</b></span>
			<a href="Index"><button>返回</button></a>
		</div>
		<div class="col-lg-12" >
		<c:forEach items="${dingdan}" var="var" >
		<span style="font-size: 20px;"><b>订单编号：${var.dingdan_ID}</b></span>
			<table style="width: 100%;" border="2px">
				
					<thead>
					<tr style="background-color: lightsteelblue">
						<th>商品图片</th>
						<th>商品名称</th>
						<th>商品价格</th>
						<th>数量</th>
						<th>小计</th>
						
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${var.dingdanlist}" var="list">
					<tr height="40px">
						<td><img src="/pic/${list.tushu.tushu_images}" width="50px" height="50px"> </td>
						<td>${list.tushu.tushu_tsm}</td>
						<td>${list.tushu.tushu_jg}</td>
						<td>${list.count}</td>
						<td>${list.price}</td>
					</tr>
					</c:forEach>
					<tr><td colspan="6"><span style="margin-left:870px;">
					商品总计：${var.dingdan_zj}</span></td>
					</tr>
					
				</tbody>
			</table>
			</c:forEach>
			
	</body>
</html>