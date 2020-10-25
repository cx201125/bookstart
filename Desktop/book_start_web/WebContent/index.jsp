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
   <style type="text/css">

   .container{
   background: white;
   color: white;
   }
    #box2{
      background-color:deepskyblue;
      height: 200px;
    }
    #box2 p{
      text-align: center;
      font-family: "微软雅黑";
    }
    #box2 span{
      color: red;
    }
   
   </style>
  </head>
  <body>
<!-- 头部分 -->
    <%@include file="/longo.jsp" %>
<!-- 导航部分 -->
	<%@include file="/navigation.jsp" %>
   
   <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
     <!-- Indicators -->
     <ol class="carousel-indicators">
       <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
       <li data-target="#carousel-example-generic" data-slide-to="1"></li>
       <li data-target="#carousel-example-generic" data-slide-to="2"></li>
      
      
     </ol>
   
     <!-- Wrapper for slides -->
	<!-- 滚动页面 -->
	<div class="container" >
     <div class="carousel-inner" role="listbox">
     
       <div class="item active">
         <img src="/pic/logon1.png" alt="...">
         <div class="carousel-caption">
         
         </div>
       </div>
       
       <div class="item">
         <img src="/pic/logon2.png" alt="..." >
         <div class="carousel-caption">

         </div>
       </div>
       
          <div class="item">
         <img src="/pic/logon3.png" alt="..." >
         <div class="carousel-caption">

         </div>
       </div>
        
     </div>
    <!-- Controls -->
   </div>
  </div>
   <div  class="container">
	   <p>&nbsp;</p>
	   
	   
	  <!-- 热销商品-->
	   <div class="row">
		<div class="col-lg-12" style="background-color: #f20c00;">
	   	<h1>热销商品</h1>
		</div>
		</div>
		<div class="row" >
		<c:forEach items="${heattushu}" var="var">
			<div class="col-lg-2" style="border: #f20c00 solid 2px;" >
				<a href="${pageContext.request.contextPath}/Shoppingcart?dizhi=Index&Tushu_ID=${var.getTushu_ID()}">
					<img src="/pic/${var.getTushu_images()}" width="170" height="190px" >
					</a>
					<p style="color: green;"><a href="${pageContext.request.contextPath}/Shoppingcart?dizhi=Index&Tushu_ID=${var.getTushu_ID()}">${var.getTushu_tsm()}</a></p>
				<p>
					<font size="" color="#FF0000">商城价：&yen;${var.getTushu_jg()}</font>
				</p>
			</div>
			</c:forEach>
			
		</div>
	   </div>
	   
 <div  class="container">
	   <p>&nbsp;</p>
	   
	   
	  <!-- 最新商品 -->
	   <div class="row">
		<div class="col-lg-12" style="background-color:#f20c00;">
	   	<h1>最新商品</h1>
		</div>
		</div>
		<div class="row" >
		<c:forEach items="${newtushu}" var="var">
			<div class="col-lg-2" style="border: red solid 2px;" >
				<a href="${pageContext.request.contextPath}/Shoppingcart?dizhi=Index&Tushu_ID=${var.getTushu_ID()}">
					<img src="/pic/${var.getTushu_images()}" width="170" height="170px" >
					</a>
					<p style="color: green;"><a href="${pageContext.request.contextPath}/Shoppingcart?dizhi=Index&Tushu_ID=${var.getTushu_ID()}">${var.getTushu_tsm()}</a></p>
				<p>
					<font size="" color="#FF0000">商城价：&yen;${var.getTushu_jg()}</font>
				</p>
			</div>
			</c:forEach>
			
		</div>
	   </div>
	    <div  class="container">
	   <p>&nbsp;</p>
	   
	   
	  <!-- 特价商品 -->
	   <div class="row">
		<div class="col-lg-12" style="background-color: #f20c00;">
	   	<h1>特价商品</h1>
		</div>
		</div>
		<div class="row" >
		<c:forEach items="${bargaintushu}" var="var">
			<div class="col-lg-2" style="border: red solid 2px;" >
				<a href="${pageContext.request.contextPath}/Shoppingcart?dizhi=Index&Tushu_ID=${var.getTushu_ID()}">
					<img src="/pic/${var.getTushu_images()}" width="170" height="170px" >
					</a>
					<p style="color: green;"><a href="${pageContext.request.contextPath}/Shoppingcart?dizhi=Index&Tushu_ID=${var.getTushu_ID()}">${var.getTushu_tsm()}</a></p>
				<p>
					<font size="" color="#FF0000">商城价：&yen;${var.getTushu_jg()}</font>
				</p>
			</div>
			</c:forEach>
			
		</div>
	   </div>
	   
	  <div  class="container">
	   <p>&nbsp;</p>
	   
	   
	  <!-- 特价商品 -->
	   <div class="row">
		<div class="col-lg-12" style="background-color: #f20c00;">
	   	<h1>浏览记录</h1>
		</div>
		</div>
		<div class="row" style="height:500px; border: 1px solid red;">
		<c:forEach items="${arrlist}" var="var">
			<div class="col-lg-2" style="border: red solid 2px;" >
				<a href="${pageContext.request.contextPath}/Shoppingcart?dizhi=Index&Tushu_ID=${var.getTushu_ID()}">
					<img src="/pic/${var.getTushu_images()}" width="170" height="170px" >
					</a>
					<p style="color: green;"><a href="${pageContext.request.contextPath}/Shoppingcart?dizhi=Index&Tushu_ID=${var.getTushu_ID()}">${var.getTushu_tsm()}</a></p>
				<p>
					<font size="" color="#FF0000">商城价：&yen;${var.getTushu_jg()}</font>
				</p>
			</div>
			</c:forEach>
			
		</div>
	   </div>
	   
	    <div id="box2">
  <p>2020年著作权城市职业学院所有权</p>
  <p><span>NBA.com/China</span>上除去<span>使用条款</span>中所特别提及的部分之外，其他任何内容都不得以任何形式被复制、再传播、或篡改</p>
  <p>进入<span>NBA.com/China</span>后，即表示阁下同意遵守，<span>NBA.com/China</span>的<span>隐私政策</span>和<span>使用条款</span>。</p>
  <p>有任何的建议和意见，都欢迎联络我们：<span>2543139363@qq.com</span></p>
  <p>有关NBA商品授权合作事宜，敬请联系：<span>2543139363@qq.com</span></p>
</div>
  </body>
</html>
