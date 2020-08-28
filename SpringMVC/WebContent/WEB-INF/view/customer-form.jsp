<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>
<title>Insert title here</title>

</head>
<body>
cust from


<div id="wrapper">
<div id="header">
<h1>Add Customer</h1>
</div>

<div id="comtainer">

<input type="button" value="Add customer" onclick="window.location.href='ShowFormForAdd';return false;" class="add-button">
<div id="content">


<form:form action="saveCustomer" modelAttribute="custObj" method="post">
<form:hidden path="id"/>
First name:<form:input path="fname"/>
<br>
Last name:<form:input path="lname"/>
<br>
Email:    <form:input path="email"/>
<br>
<input type="submit" value="save" class="save">

</form:form >


<p>

<a href="${pageContext.request.contextPath}/customer/list">back to list</a>

</p>

</div>
</div>
</div>

</body>
</html>