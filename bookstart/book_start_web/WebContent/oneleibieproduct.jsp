<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<%@ include file="longo.jsp" %>
<!-- 导航栏部分 -->
<%@ include file="navigation.jsp" %>

<div  class="container">
	   <p>&nbsp;</p>
	    
	   <div class="row">
		<div class="col-lg-12" style="background-color: #f20c00;">
	   	<h1>${oneleibieproduct.getOnepageproduct()[1].getLeibie_lbm()}</h1>
		</div>
		</div>
		<div class="row" >
		<c:forEach items="${oneleibieproduct.getOnepageproduct()}" var="var">
			<div class="col-lg-2" style="border: #f20c00 solid 2px;" >
				<a href="${pageContext.request.contextPath}/Shoppingcart?dizhi=Oneleibie&dangqianpage=${oneleibieproduct.getDangqianpage()}&Tushu_ID=${var.getTushu_ID()}">
					<img src="/pic/${var.getTushu_images()}" width="170" height="170px" >
					</a>
					<p style="color: green;"><a href="${pageContext.request.contextPath}/Shoppingcart${pageContext.request.contextPath}/Shoppingcart?dizhi=Oneleibie&dangqianpage=${oneleibieproduct.getDangqianpage()}&Tushu_ID=${var.getTushu_ID()}">${var.getTushu_tsm()}</a></p>
				<p>
					<font size="" color="#FF0000">商城价：&yen;${var.getTushu_jg()}</font>
				</p>
			</div>
			</c:forEach>
	   </div>
	 
		<div class="row" style="margin-left: 500px">
	<nav aria-label="Page navigation">
  <ul class="pagination">
  <c:if test="${oneleibieproduct.getDangqianpage()==1}">
    <li class="disabled">
      <a href="javascript:void(0);" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
      </li>
   </c:if>
    <c:if test="${oneleibieproduct.getDangqianpage()!=1}">
    <li>
      <a href="${pageContext.request.contextPath}/Oneleibie?dangqianpage=${oneleibieproduct.getDangqianpage()-1}&Leibie_ID=${oneleibieproduct.getOnepageproduct()[0].getLeibie_ID()}" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
      </li>
   </c:if>
      <c:forEach begin="1" end="${oneleibieproduct.getZongpage()}" var="pagebean" >
     <c:if test="${oneleibieproduct.getDangqianpage()==pagebean}">
      <li class="active">
      <a href="${pageContext.request.contextPath}/Oneleibie?dangqianpage=${pagebean}&Leibie_ID=${oneleibieproduct.getOnepageproduct()[0].getLeibie_ID()}">${pagebean}</a>
      </li>
      </c:if>
       <c:if test="${oneleibieproduct.getDangqianpage()!=pagebean}">
      <li>
      <a href="${pageContext.request.contextPath}/Oneleibie?dangqianpage=${pagebean}&Leibie_ID=${oneleibieproduct.getOnepageproduct()[0].getLeibie_ID()}">${pagebean}</a>
      </li>
      </c:if>
      </c:forEach>
     
     <c:if test="${oneleibieproduct.getDangqianpage()==oneleibieproduct.getZongpage()}">
     <li class="disabled">
      <a href="javascript:void(0);" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
    </c:if>
    <c:if test="${oneleibieproduct.getDangqianpage()!=oneleibieproduct.getZongpage()}">
     <li>
      <a href="${pageContext.request.contextPath}/Oneleibie?dangqianpage=${oneleibieproduct.getDangqianpage()+1}&Leibie_ID=${oneleibieproduct.getOnepageproduct()[0].getLeibie_ID()}" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
    </c:if>
  </ul>
</nav>
		</div>
	   </div>
</body>
</html>