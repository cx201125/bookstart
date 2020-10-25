<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
  <head>
   <script type="text/javascript">
   $(function(){
		   var count=""
			  $.post(
			    		"${pageContext.request.contextPath}/Leibie" ,
			    		function(bata){	
			    			if(bata.length>0){
			    				for(var i=0;i<bata.length;i++){
			    					count+="<li><a href='Oneleibie?Leibie_ID="+bata[i].Leibie_ID+"'>"+bata[i].Leibie_lbm+"</a></li>"
			    					 
			    				}
			    				$("#leibie").html(count);
			    			}
			    			
			    		},"json"
			      )
	      

	   

   })
   </script>
   
   <script type="text/javascript">
  $(function(){
	  
  $("#soushuo").keyup(function(){
	  var shousuo=this.value;
	  var count=""
		  $.post(
		    		"${pageContext.request.contextPath}/Search" ,
		    		{"shousuo":shousuo},
		    		function(bate){
		    			if(bate.length>0){
		    				for(var i=0;i<bate.length;i++){
		        				count+="<div class='showsan'style='padding:5px;cursor:pointer;' onmouseover='overOF(this)' onmouseout='outOF(this)' onclick='dianji(this)'>"+bate[i]+"</div>"
		        			}
		        			$("#show").html(count);
		        			$("#show").css("display","block");
		    			}
		    		},"json"
		      )
      
  })
 })
   </script>
  <script type="text/javascript">
  function dianji(obj){
	  $("#soushuo").val($(obj).html());
	  $("#show").css("display","none");
  }
  function overOF(obj){
	  $(obj).css("background-color","orange");
	 
  }
  function outOF(obj){
	  $(obj).css("background-color","white");
  }
  function blurOF(){
	  $("#show").css("display","none");
  }
  </script>
</head>
<body>
 <div class="row">
		 <div class="col-lg-12">
		 	<nav class="navbar navbar-inverse">
		 	  <div class="container-fluid">
		 	    <!-- Brand and toggle get grouped for better mobile display -->
		 	    <div class="navbar-header">
		 	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
		 	        <span class="sr-only">Toggle navigation</span>
		 	        <span class="icon-bar"></span>
		 	        <span class="icon-bar"></span>
		 	        <span class="icon-bar"></span>
		 	      </button>
		 	      <a class="navbar-brand" href="Index">首页</a>
		 	    </div>
		 	
		 	    <!-- Collect the nav links, forms, and other content for toggling -->
		 	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		 	    <ul class="nav navbar-nav">
		 	        <li class="active"><a href="Allproduct">产品中心<span class="sr-only">(current)</span></a></li>
		 	        <li class="dropdown">
                    <a href="#" class="dropdown-toggle"  data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">分类 <span class="caret"></span></a>
                   <ul class="dropdown-menu" id="leibie">
                   
                 
          </ul>
        </li>
		 	        <li><a href="#">产品介绍</a></li>
					<li><a href="gsjj.jsp">公司简介</a></li>
		 	      </ul>
				  
		 	      <form class="navbar-form navbar-left" >
		 	        <div class="form-group" style="position:relative;">
		 	          <input type="text" class="form-control" placeholder="Search" id="soushuo" ">
		 	          <div id="show" style="display:none;width:175px;background-color:white; position:absolute;z-index: 1000;" >  </div>
		 	        </div>
		 	        <button type="submit" class="btn btn-default">搜索</button>
		 	      </form>
		 	    </div><!-- /.navbar-collapse -->
		 	  </div><!-- /.container-fluid -->
		 	</nav>
		 </div>
	 </div>
   </div>
   
</body>
</html>