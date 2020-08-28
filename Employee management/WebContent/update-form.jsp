<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Details</title>
</head>
<body style="background-color:#ffffcc;">
<h3 align="center">Update details</h3>
<input type="button" value="Home" onclick="window.location.href='search.jsp'" />
<center>
<table border="1px !important">
<form method="get" action="controller">

<input type="hidden" name="cmd" value="Update" />
<input type="hidden" name="id" value="${load.id}" />

<tr>
	<td>First name : </td> 
	<td><input type="text" name="fname" value="${load.firstname}" required /></br>
</td></tr>


<tr>
	<td>Last Name : </td><td><input type="text" name="lname" value="${load.lastname}"  required />
</td></tr>
<tr>


<tr>
	<td>Address : </td><td><textarea name="Address" rows="10" cols="30"  maxlength="150" required>${load.address} </textarea>
</td></tr>
<tr>

<tr>
	<td>Gender </td>
 	<td><input type="radio" name="gender" value="0" checked > Male
	<input type="radio" name="gender" value="1"> Female
</td></tr>
<tr>

<tr>
	<td>Birth Date</td><td><input id="Bday" type="date" name="date"  value="${load.date}" min="1993-01-01" max="2019-02-28" required></br>
</td></tr>
<tr>
<tr>
	<td>Select your skill</td>
<td><input type="checkbox" name="skill" value="1" >java<br>
	<input type="checkbox" name="skill"" value="2"> C#<br>
	<input type="checkbox" name="skill" value="3" >python<br> 
	<input type="checkbox" name="skill" value="4" >Android<br>
	<input type="checkbox" name="skill" value="5" >ios<br>
</tr>
<tr>
	<td>Salary</td><td><input type="text" name="salary" value="${load.salary}"  maxlength="9" required/></br>
</td></tr>
<tr>

<td colspan = "2" style="text-aling: center !important;"><center><input type="submit" name="submit" value="Submit "></center>
</form>
</table>
</center>

</body>
</html>