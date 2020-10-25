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
		//删除
		function remove(Leibie_ID) {
			var isDel=confirm("你是否要删除");
			if(isDel){
				location.href="${pageContext.request.contextPath}/deleteleibie?Leibie_ID="+Leibie_ID;
			}
		}
		//更改
		function update(Leibie_ID) {
			if(isDel){
				var Leibie_lbm=$("#Leibie_lbm")[0].value;
				location.href="${pageContext.request.contextPath}/updateleibie?Leibie_ID="+Leibie_ID+"&Leibie_lbm="+Leibie_lbm;
			}
		}
		
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
					
						<span style="margin-left:600px; font-size: 27px;"><b>类别列表</b></span>
						<button><a href="${pageContext.request.contextPath}/addleibie.jsp">添加</a></button>
						
					</div>
					<div class="col-lg-12" style="border: #000000 solid 2px;">
					<spn style="color:red;  display:inline-block; margin-left:800px;"><strong>${shibai}</strong></spn>
					<spn style="color:red;  display:inline-block; margin-left:1000px;"><strong>${ggshibai}</strong></spn>
						<table style="width: 100%;" border="2px">
							
								<thead>
								<tr style="background-color: lightsteelblue">
									<th>序号</th>
									<th>类别名称</th>
									<th>编辑</th>
									<th>删除</th>
								</tr>
							</thead>
							<tbody>
							
							 <c:forEach items="${leibie}" var="list" varStatus="vs">
							 
								<tr height="48px">
									<td>${vs.count}</td>
									<td><input type="text" value="${list.getLeibie_lbm()}" id="Leibie_lbm"></td>
									<td><a href="javascript:void(0);" onclick="update('${list.getLeibie_ID()}')"style="margin-left: 80px;"><button>更改</button></a></td>
									<td><a href="javascript:void(0);" onclick="remove('${list.getLeibie_ID()}')" style="margin-left: 80px;"><button>删除</button></a></td>
								</tr>
								
								</c:forEach>
							</tbody>
						</table>
						
				
					</div>
					</div>
				</div>
			</div>
		
	</body>
</html>
