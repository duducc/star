<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <form action="${pageContext.request.contextPath}/dept/update.do" method="post">
       <input type="hidden" name="id" value="${dept.id}">
    名称:<input type="text" name="name" value="${dept.deptName}"><br><br>
   
    地址:<input type="text" name="address" value="${dept.deptAddress}"><br><br>
  
    <input type="submit" value="修改"><br><br>
  
  </form>
</body>
</html>