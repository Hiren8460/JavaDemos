<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript">

function validate(){
	
	var firstname=document.f.fname.value;
	var lastname=document.f.lname.value;	
	var Add =document.f.Address.value;
	var birth=document.getElementById("Bday");
	
	var x= new Date(birth);
	var cnow=new Date();
	
	if(firstname=="" || lastname==""){
	
		alert("enter first name and  lastname");
		return false;
		
	}if(Cnow.getFullYear()-xgetFullYear()<15){
		
		
		alert("you are not 15 year ");
		return false;
	}
	
	  return true;
}

</script>
</head>
<body style="background-color:#ffffcc;">

<h3 align="center">Enter employee details</h3>

<input type="button" value="Home" onclick="window.location.href='search.jsp'" />
<center>
<table border="1px !important">
<form name="f" method="get" action="controller"  onsubmit="return validate()">
<h2>Employee Form </h2>
<input type="hidden" name="cmd" value="Add"/>
<input type="hidden" name="id" />
<tr>
	<td>First name : </td> 
	<td><input type="text" name="fname" required /></br>
</td></tr>
<tr>
	<td>Last Name : </td><td><input type="text" name="lname" required />
</td></tr>
<tr>
	<td>Address : </td><td><textarea name="Address" rows="10" cols="30" maxlength="150" required></textarea>
</td></tr>
<tr>
	<td>Gender </td>
 	<td><input type="radio" name="gender" value="0" checked > Male
	<input type="radio" name="gender" value="1"> Female
</td></tr>
<tr>
	<td>Birth Date</td><td><input id="Bday" type="date" name="date" value="2018-07-22" min="1993-01-01" max="2019-02-28" required></br>
</td></tr>
<tr>
	<td>Select your skill</td>
<td><input type="checkbox" name="skill" value="1" >java<br>
	<input type="checkbox" name="skill"" value="2"> C#<br>
	<input type="checkbox" name="skill" value="3" >python<br> 
	<input type="checkbox" name="skill" value="4" >Android<br>
	<input type="checkbox" name="skill" value="5" >ios<br>
</tr>
<tr>
	<td>Salary</td><td><input type="text" name="salary" maxlength="9" required/></br>
</td></tr>
<tr>
     <td colspan = "2" style="text-aling: center !important;"><center><input type="submit" name="submit" value="Submit "></center>
</td></tr>
</form>
</table>
   </center>
</body>
</html>
<script>
</script>