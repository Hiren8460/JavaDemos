 <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:if test="${param.error!=null}">
<i> Invalid  user and pwd</i>

</c:if>

<c:if test="${param.logout!=null}">
<i> you just logout</i>

</c:if>
<form:form action="${pageContext.request.contextPath}/authenticatedTheUser" method="post">

<p>

User name&nbsp<input type="text" name="username">
<br>
Password&nbsp&nbsp&nbsp<input type="password" name="password">

<br>
<input type="submit" value="Login">


</p>

</form:form>


</body>
</html>