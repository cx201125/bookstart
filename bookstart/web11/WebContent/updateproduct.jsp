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
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bs/css/bootstrap.min.css"/>
		<script src="${pageContext.request.contextPath}/bs/js/jquery-1.11.0.min.js"></script>
		<script src="${pageContext.request.contextPath}/bs/js/bootstrap.min.js"></script>
		<title></title>
		<script type="text/javascript">
		$(function(){
			$("#Leibie_ID option[value='${oneproduct.getLeibie_ID()}']").prop("selected",true)
			
			$("#Tushu_zt option[value='${oneproduct.getTushu_zt()}']").prop("selected",true)
			
		});
		</script>
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
		</div>
		
		

		<div class="container-fluid" style="height:700px" >
			<div class="row">
				<div class="col-lg-2" style="height: 700px; border: #000000 solid 1px; background-color: #23527C;">
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
						<span style="margin-left:600px;"><b>商品管理</b></span>
					
					</div>
					<div class="col-lg-12" style="border: #000000 solid 2px;">
					<span style="color:red; font-size: 20px;"> ${filenull}</span>
						<form action="${pageContext.request.contextPath}/oneupdateproduct" method="post">
							
						<table style="width: 100%;" border="2px">
							<thead>
								<tr>
									
									<th colspan="6" style="padding-left: 600px; background-color: cadetblue;">添加商品   
							</thead>
							<tbody>
								<tr>
									<td>
										<td><b>商品名称</b></td>
										<td><input type="text" name="tushutsm" value="${oneproduct.getTushu_tsm()}"> </td>
									</td>
									<td>
										
										<td><b>是否热门</b></td>
										<td ><select name="tushuzt"  id="Tushu_zt">
											<option value ="2">是</option>
											<option value ="1">否</option>
										</select></td>
									</td>
								</tr>
								<tr>
									<td>
										<td><b>折扣率</b></td>
										<td><input type="text" name="tushuzkl" value="${oneproduct.getTushu_zkl()}"> </td>
									</td>
									<td>
										
										<td><b>商品价格</b></td>
										<td><input type="text" name="tushujg" value="${oneproduct.getTushu_jg()}"> </td>
									</td>
								</tr>
								<tr>
									<td >
									<td><b>商品图片</b></td>
									<td><input type="text" name="tushuimages" value="${oneproduct.getTushu_images()}"> </td>
									</td>
									<td>
									<td><b>库存量</b></td>
									<td><input type="text" name="tushukcl" value="${oneproduct.getTushu_kcl()}"></td>
									</td>
								</tr>
								<tr>
									<td>
									<td><b>商品分类</b></td>
									<td>
									<select name="leibieID" id="Leibie_ID">
									<c:forEach items="${Allleibieupdate}" var="list">
										<option value ="${list.getLeibie_ID()}">
											${list.getLeibie_lbm()}
										</option>
										</c:forEach>
									</select>
									</td>
									</td>
									<td>
									<td><b>作者</b></td>
									<td><input type="text" name="tushuzz" value="${oneproduct.getTushu_zz()}"></td>
									</td>
								</tr>
								<tr>
									<td >
									<td><b>出版社</b></td>
									<td><input type="text" name="tushucbs" value="${oneproduct.getTushu_cbs()}"> </td>
									</td>
									<td>
									<td><b>出版日期</b></td>
									<td><input type="text" name="tushucbrq" value="${oneproduct.getTushu_cbrq()}"></td>
									</td>
								</tr>
								
								<tr>
									<td >
									<td><b>总页数</b></td>
									<td><input type="text" name="tushuzys" value="${oneproduct.getTushu_zys()}"> </td>
									</td>
									<td>
									<input type="hidden" name="tushuID" value="${oneproduct.getTushu_ID()}">
									<td><b>上架时间</b></td>
									<td><input type="text" name="tushusjsj" value="${oneproduct.getTushu_sjsj()}"></td>
									</td>
								</tr>
								<tr>
									<td >
										<td><b>商品描述</b></td>
									<td><textarea rows="8" cols="50" wrap="physical" name="tushulrjj">${oneproduct.getTushu_lrjj()}</textarea></td>
									</td>
									
								</tr>
								<tr>
									
									<td colspan="6" style="padding-left: 600px;">
									<input type="submit"  value="确定" />
									<input type="reset" value="重置" />
									<button type="button"><a href="${pageContext.request.contextPath}/producthoutai">返回</a></button>
									</td>
								</tr>
							</tbody>
						</table>
						</form>
					</div>
				</div>
			</div>
		
		</div>
	</body>
</html>