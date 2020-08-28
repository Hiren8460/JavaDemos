package com.management.employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class controller
 */
@WebServlet("/controller")
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   @Resource(name="jdbc/managementdb")
	DataSource ds;
	Connection con=null;
	DButil dbutil=null;
	
	
    public controller() {
        super();
        
    }

	public void init(ServletConfig config) throws ServletException {
		
		dbutil = new DButil(ds);
	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		
		
		
		String command = request.getParameter("cmd");
		
		
		if(command==null) {
			
			command="List";
			
			
		}
		
		switch(command) {
		
		
		case "Add":
			
			try {
				addEmployee(request,response);
			} catch (SQLException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
			break;
			
		case "List":
			
			out.println("list method");
			try {
				listEmployee(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
			
		case "Delete":
			
			
			try {
				deleteEmployee(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
		out.println("delete");	
		break;
		case "Load":
			
			try {
				loadEmployee(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
	
		case "Update":
			
			try {
				updateEmployee(request,response);
			} catch (SQLException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
			
		}
		
		
		
	
	
	
	}

	private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ParseException, ServletException {
		int id =Integer.parseInt(request.getParameter("id"));
		PrintWriter out =response.getWriter();
		int i=0;
		String firstname =request.getParameter("fname");
		String lastname =request.getParameter("lname");
		String date= request.getParameter("date");
		String address =request.getParameter("Address");
		String gender =request.getParameter("gender");
		double salary = Integer.parseInt(request.getParameter("salary"));
		String skill []=request.getParameterValues("skill");
		
		
		byte gen =Byte.valueOf(gender);
		
		
		
		byte[] skills = new byte[skill.length] ;
	    for(String s:skill ) {
	        skills[i]=Byte.valueOf(s);
	        i++;
	    }
	  
	   
	    
	    Employee e = new Employee(id,firstname,lastname,date,address,gen,salary,skills);
		
		
	   dbutil.updateEmployee(e);
	    
		listEmployee(request, response);
		

			
	}

	private void loadEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
		
		int id =Integer.parseInt(request.getParameter("id"));
		
	
		Employee e = dbutil.getEmplyee(id);
		
		request.setAttribute("load", e);


		RequestDispatcher dispatcher = request.getRequestDispatcher("/update-form.jsp");
		dispatcher.forward(request, response);
		
		
	}

	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
		PrintWriter out =response.getWriter();
		int id =Integer.parseInt(request.getParameter("id"));
			dbutil.deleteEmployee(id);
		
		
			

			listEmployee(request, response);
		
		
		
		
	}

	private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
	
		List <Employee> record= DButil.getEmployee();
		
		
		request.setAttribute("list", record);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/View.jsp");
		dispatcher.forward(request, response);
	
		
		
		
	}

	private void addEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ParseException, ServletException {
		
		PrintWriter out =response.getWriter();
		int i=0;
		
		String firstname =request.getParameter("fname");
		String lastname =request.getParameter("lname");
		String date= request.getParameter("date");
		String address =request.getParameter("Address");
		String gender =request.getParameter("gender");
		double salary = Integer.parseInt(request.getParameter("salary"));
		String skill []=request.getParameterValues("skill");
		
		byte gen =Byte.valueOf(gender);
		
		out.println("date"+date);
		
		
		out.println("gender ="+gen);
		
		byte[] skills = new byte[skill.length] ;
	    for(String s:skill ) {
	        skills[i]=Byte.valueOf(s);
	        i++;
	    }
	  //  out.println(firstname+"   "+lastname+"  "+date+"  "+ address+" "+gender);
	    
	    
	    
	    Employee emp = new Employee(firstname,lastname,date,address,gen,salary,skills);
	    
	    
	    dbutil.addEmployee(emp);
	    
	    listEmployee(request,response);
	}

}
