<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
		 <meta http-equiv="X-UA-Compatible" content="IE=edge">
		 <meta name="viewport" content="width=device-width, initial-scale=1">
		 <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
		 <title>Bootstrap 101 Template</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bs/css/bootstrap.min.css"/>
		<script src="${pageContext.request.contextPath}/bs/js/jquery-1.11.0.min.js"></script>
		<script src="${pageContext.request.contextPath}/bs/js/boots trap.min.js"></script>
		<title></title>
		<script type="text/javascript">
		
		</script>
		<style type="text/css">
		
		#ul li{
			display: block;
			width:100%;
			height: 50px;
			
			}
			
        #ul>li>a{
        text-decoration: none;
        font-size: 20px; 
        color:white;
        }
		</style>
	</head>
	<body>
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12" style="height: 100px; background-color: paleturquoise;">
					<h1 style="margin-left:650px; "><b>图书商城管理系统</b></h1>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12" style="height: 20px; background-color: #C0C0C0;" >
				</div>
			</div>
		
		
		
		<!-- 表格部分 -->
		<div class="container-fluid" style="height:700px" >
			<div class="row">
				<div class="col-lg-2" style="height: 800px; border: #000000 solid 1px; background-color: #23527C;">
					<ul id="ul">
					<li>
					<a href="producthoutai" >商品管理</a>
					</li>
					<li>
					<a href="findallleibie" >类别管理</a>
					</li>
					<li>
					<a href="findalldingdan" >订单管理</a>
					</li>
					</ul>
				</div>
				
				<div class="col-lg-10">
					<div class="col-lg-12" style="height: 100px; background-color: #D0E9C6;" >
					
						<span style="margin-left:600px;"><b>订单列表</b></span>
						
						
					</div>
					<div class="col-lg-12" style="border: #000000 solid 2px;">
						<table style="width: 100%;" border="2px">
							
								<thead>
								<tr style="background-color: lightsteelblue">
									<th>序号</th>
									<th>订单号</th>
									<th>订单总价</th>
									<th>订单状态</th>
									<th>下单时间</th>
									<th>收件人姓名</th>
									<th>收件人电话</th>
									<th>收件人地址</th>
									<th>订单详情</th>
								</tr>
							</thead>
							<tbody>
							
							 <c:forEach items="${dingdanlist}" var="list" varStatus="vs">
								<tr height="48px">
									<td> ${vs.count}</td>
									<td>${list.getDingdan_ID()}</td>
									<td>${list.getDingdan_zj()}</td>
									<td>${list.getDingdan_zt()==1?"已付款":"未付款"}</td>
									<td>${list.getDingdan_sj()}</td>
									<td>${list.getDingdan_sjr()}</td>
									<td>${list.getDingdan_sjrdz()}</td>
									<td>${list.getDingdan_sjrdh()}</td>
									<td><a href="javascript:void(0);" onclick="xiangqing'${list.getDingdan_ID()}')"><button>订单详情</button></a></td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
						
	</body>
</html>
