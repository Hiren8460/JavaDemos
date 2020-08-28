<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link type="text/css"  rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css";/>
<%-- <link type="text/css"  rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css}";/> --%>

</head>
<body>

<div id="wrapper">
<div id="header">
<h1>Customer list</h1>
</div>

</div>

<div id="comtainer">

<input type="button" value="Add customer" onclick="window.location.href='ShowFormForAdd';return false;" class="add-button">
<div id="content">

			<table>
			
							<tr>
							<th>Fistname</th>
							<th>Last name</th>
							<th>Email</th>
							<th>Action</th>
							</tr>

				<c:forEach var="data" items="${custlist}">
			
			
			<c:url var="UpdateLink" value="/customer/showFormForUpdate" >
					
					<c:param name="custId" value="${data.id}"/>
					
					</c:url>
					<c:url var="DeleteLink" value="/customer/showFormForDelete" >
					
					<c:param name="custId" value="${data.id}"/>
					
					</c:url>
			
					<tr>
					<td>${data.fname}</td>
					<td>${data.lname}</td>
					<td>${data.email}</td>
					<td> <a href="${UpdateLink}">Update</a> |
					 <a href="${DeleteLink}">Delete</a> </td>
					
					
					</tr>

				</c:forEach>
			
			</table>



</div>


</div>


</body>
</html>