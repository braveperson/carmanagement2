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
  			if(user == "" || number ==""){
  				$("#msg").text("车主、电话和车牌、颜色、厂商不能为空!");
  				return false;
  			}else{
  				return true;
  			}
  		}
  	</script>
  </head>
  
  <body>
    <form action="${pageContext.request.contextPath}/car/add.do" method="post" enctype="application/x-www-form-urlencoded" onsubmit="return check()">
    	车牌:<input type="text" name="carNums" id="name"/><br>
    	车主:<input type="text" name="carOwnner" id="number"/><br>
    	电话:<input type="text" name="telePhone" id="number"/><br>
    	颜色:<input type="text" name="color" id="number"/><br>
    	厂家:<input type="text" name="factory" id="number"/><br>
    	备注:<input type="text" name="remarks" id="a"/><br>
    	<span id="msg" style="color:red;font-size:15px">${error}</span>
    		<input type="submit" value="添加"/>${message}
    </form>
  </body>
</html>
