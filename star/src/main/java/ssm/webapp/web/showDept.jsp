<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
显示部门信息<br>
<table border ="1" style="width:50%">
  <tr>
     <th>部门编号</th>
     <th>部门名称</th>
     <th>部门地址</th>
     <th>编辑</th>
  </tr>
  <c:forEach items="${list}" var="dept">
    <tr>
     <td>${dept.id}</td>
     <td>${dept.deptName}</td>
     <td>${dept.deptAddress}</td>
     <td>
           <a href="${pageContext.request.contextPath}/dept/showUpdate.do?id=${dept.id}">修改</a>
           <a href="${pageContext.request.contextPath}/dept/deleteDept.do?id=${dept.id}">删除</a>
     </td>
    </tr> 
  </c:forEach>

</table>
</body>
</html>