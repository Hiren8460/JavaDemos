<%@ page import="java.sql.*" %>  
<%  


String name=request.getParameter("val");  
if(name==null||name.trim().equals("")){  
out.print("<p>           Please enter name!         </p>");  
}else{  
try{  
  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","hdmi@9833");
PreparedStatement ps=con.prepareStatement("select * from employee where firstname like '"+name+"%'");  
ResultSet rs=ps.executeQuery();  
  
if(!rs.isBeforeFirst()) {      
 out.println("<p>No Record Found!</p>");   
}else{  
out.print("<table border='1' cellpadding='2' width='100%'>");  
out.print("<tr><th>Id</th><th>Name</th><th>lastname</th>  <th>Address</th><th>Gender</th><th>Salary</th><th>Birthdate</th></tr>");  
while(rs.next()){  
out.print("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td>  <td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td></tr>");  
}  
out.print("</table>");  
}//end of else for rs.isBeforeFirst  
con.close();  
}catch(Exception e){out.print(e);}  
}//end of else  
%>  