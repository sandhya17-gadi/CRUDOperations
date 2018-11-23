<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib  prefix="a" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- <table>
<tr>

<th>Name</th>
<th>Deg</th>
<th>Salary</th>
<th>Gender</th>
</tr>
<a:forEach var="emp" items="${temp}">
<a:if test="${emp.empId==eid}">


<tr>
<td>${emp.empName}</td>
<td>${emp.myDesignation}</td>
<td>${emp.empSalary}</td>
<td>${emp.empGender}</td>
</tr>

</a:if>
</a:forEach>
</table> --%>

<table>
<tr>

<th>Name</th>
<th>Deg</th>
<th>Salary</th>
<th>Gender</th>
</tr>




<tr>
<td>${temp.empName}</td>
<td>${temp.myDesignation}</td>
<td>${temp.empSalary}</td>
<td>${tSemp.empGender}</td>
</tr>


</table>
</body>
</html>