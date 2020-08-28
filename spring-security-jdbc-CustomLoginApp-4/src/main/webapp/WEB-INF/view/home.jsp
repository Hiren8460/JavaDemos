 <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %> 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<hr>
User Name <security:authentication property="principal.username"/>
<br>
Role(s) <security:authentication property="principal.authorities"/>
<hr>
hello page

<security:authorize access="hasRole('EMPLOYEE')">
<p>
<a href="${pageContext.request.contextPath}/leaders">Leaders only</a>
</p>

</security:authorize>
<security:authorize access="hasRole('ADMIN')">
<p>
<a href="${pageContext.request.contextPath}/systems">admin only</a>
</p>

</security:authorize>

<form:form method="post" action="${pageContext.request.contextPath}/logout">

<input type="submit" value="Log Out">

</form:form>
</body>
</html>