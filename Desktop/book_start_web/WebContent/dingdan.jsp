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
			<span style="margin-left:500px; font-size: 20px;"><b>订单页面</b></span>
			
		</div>
		<div class="col-lg-12" >
		<span style="font-size: 20px;"><b>订单编号：${dingdan.dingdan_ID}</b></span>
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
				<c:forEach items="${dingdan.dingdanlist}" var="list">
					<tr height="40px">
						<td><img src="/pic/${list.tushu.tushu_images}" width="50px" height="50px"> </td>
						<td>${list.tushu.tushu_tsm}</td>
						<td>${list.tushu.tushu_jg}</td>
						<td>${list.count}</td>
						<td>${list.price}</td>
						
					</tr>
					</c:forEach>
					<tr><td colspan="6"><span style="margin-left:870px;">
					商品总计：${dingdan.dingdan_zj}</span></td>
					</tr>
					
				</tbody>
			</table>
			
			
			
		</div>
		</div>
		<div class="container" style="margin-top: 120px;">
			<span style="color: #C0A16B; font-size: 20px;"><b>收件人信息：</b></span>
			<form action="Dingdantijiao" method="post">
			<input type="hidden" name="dingdan_ID" value="${dingdan.dingdan_ID}">
			  <div class="form-group">
			  <span style="font-size: 20px; color:red;"><b>${shibai}</b></span>
			    <label for="exampleInputEmail1">收货人姓名</label>
			    <input type="text" class="form-control" id="exampleInputEmail1"  value="${user.user_true_name }" name="dingdan_sjr" placeholder="收件人姓名">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">收货人地址</label>
			    <input type="text" class="form-control" id="exampleInputPassword1" value="" name="dingdan_sjrdz"  placeholder="收件人地址">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">收货人手机号码</label>
			    <input type="text" class="form-control" id="exampleInputPassword1"  value="${user.user_dianhua}" name="dingdan_sjrdh" placeholder="收件人电话">
			  </div>
		
			<span style="color: #C0A16B; font-size: 20px;"><b>支付方式：</b></span>
			<span style="color: red; font-size: 20px;"><b>${goumaishibai}</b></span>
			<div class="radio">
			  <label>
			    <input type="radio" name="optionsRadios" id="optionsRadios1" value="weixing" checked>
			    <strong style="font-size: 20px;">微信支付</strong>
			  </label>
			</div>
			<div class="radio">
			  <label>
			    <input type="radio" name="optionsRadios" id="optionsRadios2" value="zhifubao">
			      <strong style="font-size: 20px;">支付宝支付</strong>
			  </label>
			</div>
			<a href="tradecart.jsp"><button>返回</button></a>
			<div class="row">
				<input type="submit" value="提交订单" id="submit"/>
			</div>
				</form>
		</div>
	</body>
</html>
