<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
		 <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
 <title>Bootstrap 101 Template</title>
		<link rel="stylesheet" type="text/css" href="bs/css/bootstrap.min.css"/>
		<script src="bs/js/jquery-1.11.0.min.js"></script>
		<script src="bs/js/bootstrap.min.js"></script>
		<style type="text/css">
			#table1 td{
				width: 300px;
				height: 50px;
			}
			#table2 td{
				height: 50px;
				font-size: 18px;
			}
		</style>
	</head>
	
	<body>
		<div class="container">
			<div class="row" style=" background-color: #31B0D5; margin-top: 10px;">
				<h3>商品详细信息</h3>
			</div>
			<div class="row" style="margin-top: 10px;">
				<div class="col-lg-5" style="margin: 0px;">
					<img src="/pic/${tushu.getTushu_images()}" width="400px" height="400px">
				</div>
				
				<div class="col-lg-7" style="background-color: #CCCCCC">
				<form action="${pageContext.request.contextPath}/Tradecart?dizhi=${dizhi}&dangqianpage=${dangqianpage}&Leibie_ID=${tushu.getLeibie_ID()}" method="post">
					<table id="table1">
						<tr>
							<td>图书名：${tushu.getTushu_tsm()}<br></td>
						</tr>
						<tr>
							<td>库存：${tushu.getTushu_kcl()}<br></td>
						</tr>
						<tr>
							<td>商城价：<span style="color: red;">${jg}</span>/本&nbsp;&nbsp;市场价:${tushu.getTushu_jg()}/本<br></td>
						</tr>
						<tr>
							<td>
							<c:if test="${tushu.getTushu_zkl()>=1||tushu.getTushu_zt()==2}">
							<span style="background-color: brown; color: white;">限时秒杀</span>
							</c:if>
							<c:if test="${tushu.getTushu_zkl()<1||tushu.getTushu_zt()==1}">
							<span style="background-color: brown; color: white;">限时秒杀</span>
							</c:if>
							</td>
						</tr>
						<tr>
							<td style="width: 360px; height: 140px; background-color: deepskyblue;"> 
							折扣：${tushu.getTushu_zkl()}<br><br>
							<input type="hidden" name="Tushu_ID" value="${tushu.getTushu_ID()}">
							购买数量：<input type="text" name="count" id="count"/><br>
							<span style="color: red;">${sbcg}</span>
							<button><a href="tradecart.jsp">我的购物车</a></button>
							<input type="submit"  value="加入购物车" style=" margin-left:120px; height: 30px; width:150px; background-color:orange; display:inline-block;"/>
							<br>
							</td>
						</tr>
						<tr>
							<td></td>
						</tr>
					</table>
					</form>
				 <div><a href="${pageContext.request.contextPath}/${dizhi}?dangqianpage=${dangqianpage}&Leibie_ID=${tushu.getLeibie_ID()}">返回</a></div>
					
				</div>
			</div>
			<div class="row" style="background-color: #C0C0C0; margin-top: 18px;">
				<h3><b>商品介绍</b></h3>
			</div>
			<div class="row" style="height: 300px; background-color: #46B8DA;">
				<div class="col-lg-5">
					<table id="table2">
						<tr>
							<td>编号：${tushu.getTushu_ID()}</td>
						</tr>
						<tr>
							<td>所属类别：${tushu.getLeibie_lbm()}</td>
						</tr>
						<tr>
							<td>出版社：${tushu.getTushu_cbs()}</td>
						</tr>
						<tr>
							<td>作者：${tushu.getTushu_zz()}</td>
						</tr>
						<tr>
							<td>出版日期：${tushu.getTushu_cbrq()}</td>
						</tr>
						
						
					</table>
				</div>
				<div class="col-lg-7">
					<span style="font-size: 20px;">内容简介：</span><br>
					<div style="height: 200px;width: 472px; background-color: white;">
						<span style="font-size: 16px;">我是一本好书</span>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
