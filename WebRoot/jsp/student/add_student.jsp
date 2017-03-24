<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加学生</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  	<script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js"></script>
  	<script>
  		function check(){
  			var user = $("#name").val();//获取表单元素值
  			var number = $("#number").val();
  			var age = $("#age").val();
  			if(user == "" || number =="" || age == ""){
  				$("#msg").text("姓名、学号和成绩不能为空!");
  				return false;
  			}else{
  				return true;
  			}
  		}
  	</script>
  </head>
  
  <body>
    <form action="student_add.do" method="post" enctype="multipart/form-data" onsubmit="return check()">
    	<input type="hidden" name="id" value="${student.id}">
    	姓名:<input type="text" name="name" id="name" value="${student.name}"/><br>
    	学号:<input type="text" name="number" id="number" value="${student.number}"/><br>
    	成绩:<input type="text" name="grade" id="age" value="${student.grade}"/><br>
    	性别:<select name="sex">
    			
    			<c:if test="${student.sex == true || empty student.sex}">
    				<option value="true" selected="selected">男</option>
					<option value="false">女</option>
				</c:if>
				<c:if test="${student.sex == false}">
					<option value="true">男</option>
					<option value="false" selected="selected">女</option>
				</c:if>
    		</select><br>
    	头像:<input type="file" name="headerimg"/><br><br>
    		<span id="msg" style="color:red;font-size:15px">${error}</span><br><br>
    	<div>
			<img alt="<%=session.getAttribute("picname")%>" src="./ima/<%=session.getAttribute("picname")%>" width="100px" height="100px">
		</div>
    		<input type="submit" value="添加"/>${message}
    </form>
  </body>
</html>
