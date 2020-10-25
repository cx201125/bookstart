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
		//单个删除
		function remove(Tushu_ID) {
			var isDel=confirm("你是否要删除");
			if(isDel){
				location.href="${pageContext.request.contextPath}/deleteproduct?Tushu_ID="+Tushu_ID;
			}
		}

		//批量删除
		function batchdelete(){
			var isDel=confirm("是否要批量删除");
			if(isDel){
			document.getElementById('form').submit()
			}
		}
			
			$(function(){
			    	//指定商品类别默认显示
				$("#leibieid option[value='${vobean.getShangpinleibie()}']").prop("selected",true);
		             //指定商品状态默认显示
				$("#zhuangtai option[value='${vobean.getIshod()}']").prop("selected",true);
					});
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
					<form action="findproduct" method="post">
					商品名称<input type="text" name="shangpinname" value="${vobean.getShangpinname()}">
					
					是否热门<select name="ishod"  id="zhuangtai">
					       <option value="">不限</option>
							<option value ="2">是</option>
							<option value ="1">否</option>
							</select>
					商品类别<select name="shangpinleibie" id="leibieid">
					<option value="">不限</option>
					<c:forEach items="${Allleibiefind}" var="var">
					<option value ="${var.getLeibie_ID()}">${var.getLeibie_lbm()}</option>
					</c:forEach>
					</select>
					<input type="submit"  value="搜索">
					</form>
						<span style="margin-left:600px;"><b>商品列表</b></span>
						<button><a href="${pageContext.request.contextPath}/findproductfenlei">添加</a></button>
						<button><a href="javascript:void(0);" onclick="batchdelete()">批量删除</a></button>
					</div>
					<div class="col-lg-12" style="border: #000000 solid 2px;">
					<spn style="color:red;  display:inline-block; margin-left:800px;"><strong>${sshibai}</strong></spn>
					
						<table style="width: 100%;" border="2px">
							
								<thead>
								<tr style="background-color: lightsteelblue">
									<th>序号</th>
									<th>商品图片</th>
									<th>商品名称</th>
									<th>商品价格</th>
									<th>是否热门</th>
									<th>编辑</th>
									<th>删除</th>
								</tr>
							</thead>
							<tbody>
							
							<form action="deleteproducts" method="post" id="form">
							 <c:forEach items="${Allproduct.getOnepageproduct()}" var="list" varStatus="vs">
								<tr height="48px">
									<td> <input type="checkbox" value="${list.getTushu_ID()}" id="checkbox" name="${vs.count}">${vs.count}</td>
									<td><img src="/pic/${list.getTushu_images()}" width="36px" height="44px"></td>
									<td>${list.getTushu_tsm()}</td>
									<td>${list.getTushu_jg()}</td>
									<td>${list.getTushu_zt()!=1?"是":"否"}</td>
									
									<td><a href="${pageContext.request.contextPath}/updateproduct?Tushu_ID=${list.getTushu_ID()}">编辑</a></td>
									<td><a href="javascript:void(0);" onclick="remove('${list.getTushu_ID()}')">删除</a></td>
									
								</tr>
								</c:forEach>
								</form>
							</tbody>
						</table>
						
						<div class="row" style="margin-left: 500px">
						 <nav aria-label="Page navigation">
						 <ul class="pagination">
						 <c:if test="${Allproduct.getDangqianpage()==1}">
						 <li class="disabled"><a href="javascript:void(0);" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
						</c:if>
						 <c:if test="${Allproduct.getDangqianpage()!=1}">
						 <li><a href="${pageContext.request.contextPath}/findproduct?dangqianpage=${Allproduct.getDangqianpage()-1}&ishod=${vobean.getIshod()}&shangpinleibie=${vobean.getShangpinleibie()}&shangpinname=${vobean.getShangpinname()}" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
						</c:if>
						
						<c:forEach begin="1" end="${Allproduct.getZongpage()}" var="var">
						<c:if test="${Allproduct.getDangqianpage()==var}">
						<li class="active">
						<a href="${pageContext.request.contextPath}/findproduct?dangqianpage=${var}&ishod=${vobean.getIshod()}&shangpinleibie=${vobean.getShangpinleibie()}&shangpinname=${vobean.getShangpinname()}">${var}<span class="sr-only">(current)</span></a></li>
						</c:if>
						<c:if test="${Allproduct.getDangqianpage()!=var}">
						<li>
						<a href="${pageContext.request.contextPath}/findproduct?dangqianpage=${var}&ishod=${vobean.getIshod()}&shangpinleibie=${vobean.getShangpinleibie()}&shangpinname=${vobean.getShangpinname()}">${var}<span class="sr-only">(current)</span></a></li>
						</c:if>
						</c:forEach>
						
						 <c:if test="${Allproduct.getDangqianpage()==Allproduct.getZongpage()}">
						 <li class="disabled"><a href="javascript:void(0);" aria-label="Next">
						 <span aria-hidden="true">&raquo;</span>
						 </a></li>
						</c:if>
						
						 <c:if test="${Allproduct.getDangqianpage()!=Allproduct.getZongpage()}">
						 <li><a href="${pageContext.request.contextPath}/findproduct?dangqianpage=${Allproduct.getDangqianpage()+1}&ishod=${vobean.getIshod()}&shangpinleibie=${vobean.getShangpinleibie()}&shangpinname=${vobean.getShangpinname()}" aria-label="Next">
						 <span aria-hidden="true">&raquo;</span>
						 </a></li>
						</c:if>
						     </ul>
                       </nav>
                       </div>
					</div>
					</div>
				</div>
			</div>
		
	</body>
</html>