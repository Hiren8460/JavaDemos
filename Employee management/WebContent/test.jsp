<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<script type="text/javascript">

function validate(){
	
	var v=document.f.fname.value;
	if(v==""){
	
		alert("enter");
		return false;
		
	}else{
		
		
		return true;
	}
	
	
}


</script>
</head>
<body>


<form name="f" method="get" action="index.jsp" onsubmit="return validate()">

<input type="hidden" name="cmd" value="Add"/>
<input type="hidden" name="id" />

First name<input type="text" name="fname"  "/></br>
Last Name<input type="text" name="lname" " /></br>

       
Address<textarea name="Address" rows="10" cols="30">
    
    </textarea></br>
<h5>Gender </h5> </br>
 <input type="radio" name="gender" value="0" > Male<br>
 <input type="radio" name="gender" value="1"> Female<br>


Birth Date <input type="date" name="date"
       value="2018-07-22"
       min="1993-01-01" max="2018-12-31"></br>


<h5>Select your skill</h5>
  
<input type="checkbox" name="skill" value="1" >java<br>
<input type="checkbox" name="skill"" value="2"> C#<br>
<input type="checkbox" name="skill" value="3" >python<br> 
<input type="checkbox" name="skill" value="4" >Android<br>
<input type="checkbox" name="skill" value="5" >ios<br>
Salary<input type="text" name="salary" /></br>
<input type="submit" name="submit" value="Submit ">
</form>
</body>
</html>