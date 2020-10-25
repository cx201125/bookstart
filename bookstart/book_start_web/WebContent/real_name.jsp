<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
   
    <title>Bootstrap 101 Template</title>
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bs/css/bootstrap.min.css"/>
   <script src="${pageContext.request.contextPath}/bs/js/jquery-1.11.0.min.js"></script>
   <script src="${pageContext.request.contextPath}/bs/js/bootstrap.min.js"></script>
  <style type="text/css">
			body{
				background-color:#000000;
			}
			#zhuchei{
				margin-top: 222px;
				margin-left: 650px;
				background-color:white ;
				width:345px;
				height: 500px;
			}
			
			#emil,#truename,#number{
				width:302px;
				height: 40px;
			}
			#dl{
				font-size: 12px;
				margin-left: 130px;
			}
			#td1{
				border-bottom: #445566 solid 1px;
				height: 50px;
				width: 340px;
			}
			#submit{
				height:30px;
				width:300px;
				background-color:red;
				display:inline-block;
			}
			#checkbox{
				margin-left:100px;
				display:inline-block;
			}
			#checkboxspan{
				margin-left: 95px;
			}
		</style>
		
		<script type="text/javascript">
		$(function(){
			
			$("#submit").submit(function(){
			
				var emil=document.getElementById("emil").value;
				var emilspan=document.getElementById("emilspan");
		
				var truename=document.getElementById("truename").value;
				var truenamespan=document.getElementById("truenamespan");
			
				var number=document.getElementById("number").value;;
				var numberspan=document.getElementById("numberspan");
			
				var sex=document.getElementById("sex").value;
				var sexpan=document.getElementById("sexspan");
				
				var emilregex=new RegExp('\\w{5,12}@\\w{2,}.\\w{2,5}');
			
				var truenameregex=new RegExp('[\u4e00-\u9fa5]');
				var numberregex=new RegExp('([0-9]){15,18}');
			
					if(!emilregex.test(emil)){
						emilspan.innerHTML="<font size='2' color='red'>请输入正确的邮箱</font>";
						return false;
					}else if(!truenameregex.test(truename)){
						truenamespan.innerHTML="<font size='2' color='red'>请输入真实姓名</font>";
					 	return false;
					 }else  if(!numberregex.test(number)){
						numberspan.innerHTML="<font size='2' color='red'>请输入18位有效的身份证号</font>";
						return false;
					}else if(sex==3){
						sexspan.innerHTML="<font size='2' color='red'>请选择您的性别</font>";
						return false;
					}
			})
			
			$("#emil").blur(function(){
				
					var emilregex=new RegExp('\\w{5,12}@\\w{2,}.\\w{2,5}');
				
					var emil=document.getElementById("emil").value;
					
					if(!emilregex.test(emil)){
						document.getElementById("emilspan").innerHTML="<font size='2' color='red'>请输入正确的邮箱</font>";
					}else{
						document.getElementById("emilspan").innerHTML="&emsp;";
					}
			})
			
			$("#truename").blur(function(){
				
				  var  truenameregex=new RegExp('[\u4e00-\u9fa5]');
					var truename=document.getElementById("truename").value;
					
					if(!truenameregex.test(truename)){
						document.getElementById("truenamespan").innerHTML="<font size='2' color='red'>请输入正确的姓名</font>";
					}else{
						document.getElementById("truenamespan").innerHTML="&emsp;";
					}
			})
			
			$("#number").blur(function(){
				var number=document.getElementById("number").value;
				var numberregex=new RegExp('([0-9]){15,18}');
				if(!numberregex.test(number)){
					document.getElementById("numberspan").innerHTML="<font size='2' color='red'>身份证格式不正确</font>";
				}else{
					document.getElementById("numberspan").innerHTML="&emsp;";
				}
			})
			
		})
		</script>
	
</head>
<body bgcolor="green">
<div id="zhuchei">
		<table id="table">
			<form action="Real_name?user_ID=${user.getUser_id()}" method="post" id="submit">
			<tr>
				<td>&nbsp;&nbsp;&nbsp;</td>
			</tr>
			<tr>
				<td id="td1">&nbsp;&nbsp;&nbsp;<b><font size="4" color="#AAAACC">实名认证</font></b>
				<span id="dl">已实名<a href="Index" style="color: red;">返回首页</a></span>
				</td>
			</tr>
			<tr>
				<td>
					&#160;
				</td>
			</tr>
	      <tr>
		  <td >&nbsp;&nbsp;&nbsp;<span id="emilspan">
		  	&#160;
		  </span></td>
		  </tr>
			<tr>
				<td>&nbsp;&nbsp;&nbsp;
					<input type="text" name="user_mail" placeholder="邮箱:请输入有效的邮箱" maxlength="20"  id="emil"  />
					</td>
			</tr>
			<tr>
			<td>&nbsp;&nbsp;&nbsp;<span id="truenamespan">
			  &#160;
			  
			</span></td>
			</tr>
			<tr>
	
				<td>&nbsp;&nbsp;&nbsp;
					<input type="text" name="user_true_name" placeholder="真实姓名：请输入真实姓名" maxlength="4" id="truename"  ></td>
			</tr>
			<tr>
				
			<td> &nbsp;&nbsp;&nbsp;<span id="numberspan">
				&#160;
			</span></td>
			</tr>
			<tr>
				
				<td>&nbsp;&nbsp;&nbsp;
					<input type="text"  name="user_number" placeholder="身份证号：请输入有效的身份证号" maxlength="19"/ id="number" ></td>
			</tr>
			<tr>
			<td>&nbsp;&nbsp;&nbsp;<span id="sexspan">
				&#160;
			</span></td>
			</tr>
			<tr>
				
				<td>
					&nbsp;&nbsp;&nbsp;
					性别<select id="sex" name="user_sex">
					<option selected="" value="3">---请选择---</option>
					<option value="1">男</option>
					<option value="2">女</option>
					</select>
					</td>
			</tr>
			
             <tr>
				 <td>&nbsp;&nbsp;&nbsp;
					 <span id="checkboxspan">
					 	&#160;
					 </span>
				 </td>
			 </tr>
			<tr>
			<td>&nbsp;&nbsp;&nbsp;
			<input type="submit" value="实名认证" id="submit"/>
			</td></tr>
			<tr>
				<td>&nbsp;&nbsp;&nbsp;
				</td>
			</tr>
		</table>
		</form>
		</div>

</body>
</html>