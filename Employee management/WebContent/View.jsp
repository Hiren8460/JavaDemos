<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Employee</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
#customers {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
</style>
</head>
<body>


<input type="button" value="Home" onclick="window.location.href='search.jsp'" />
<table id="customers">
  <tr>
    <th>Employee Id</th>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Birth Date</th>
    <th>Address</th>
    <th>Gender</th>
    <th>Salary</th>
    <th colspan="2"><center>Action</center></th>
  </tr>

<c:forEach var="data" items="${list}">
  <tr>
    <td>${data.id}</td>
    <td>${data.firstname}</td>
    <td>${data.lastname}</td>
     <td>${data.date}</td>
      <td>${data.address}</td>
       <td>${data.gender}</td>
        <td>${data.salary}</td>
        
        <td><a href="controller?cmd=Load&id=${data.id}">Update</a></td>
        <td><a href="controller?cmd=Delete&id=${data.id}" Onclick="ConfirmDelete()"><i class="fas fa-trash-alt"></i>Delete</a></td>
  </tr>





</c:forEach>

</table>



</body>
</html>