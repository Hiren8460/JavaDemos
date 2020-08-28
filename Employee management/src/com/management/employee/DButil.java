package com.management.employee;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class DButil {

	private static DataSource data;



	public DButil(DataSource ds) {
		// TODO Auto-generated constructor stub
		
		this.data = ds;	
	
	}



	public void addEmployee(Employee emp) throws SQLException, ParseException {
		Connection con=null;
		PreparedStatement ps=null;
		con=data.getConnection();
		Connection con_two =data.getConnection();
		byte skill []= emp.getSkill();
		int id=0;
		
		//DateFormat formatter ; 
	     //formatter = new SimpleDateFormat("dd-MM-yyyy");
	      // java.util.Date date= formatter.parse(emp.getDate());
	       //java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		
		String sql ="insert into employee(firstname,lastname,address,gender,salary,birthdate)values(?,?,?,?,?,?)";
		String skill_sql ="insert into employeeSkill(employeeId,skillId) values(?,?)";
		
		//String skill_sql="insert into employeeSkill(employeeId,skillId)values(?,?)";
		
		ps =con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		
		
		
		ps.setString(1,emp.getFirstname());
		ps.setString(2,emp.getLastname());
		ps.setString(3, emp.getAddress());
		ps.setInt(4, emp.getGender());
		ps.setDouble(5, emp.getSalary());
		ps.setString(6, emp.getDate());
		
		ps.execute();
		
		ResultSet rs=ps.getGeneratedKeys();
		
		

		if(rs.next()){
		 id=rs.getInt(1);
		System.out.println(id);
		}
		
		ps =con_two.prepareStatement(skill_sql);
		
		
		for(int i=0;i<skill.length;i++) {
			
			
			ps.setInt(1,id);
			ps.setInt(2, skill[i]);
		
			ps.addBatch();
		}
		
		
		
		ps.executeBatch();
		
		
		
		
	}



	public static List<Employee> getEmployee() throws SQLException {
		
		List <Employee> recoard = new ArrayList<>();
		
		//Connection con = null;
		Statement st =null;
		ResultSet rs=null;
		Connection con=data.getConnection();
		try {
			
			
		String sql = "select * from employee";
		st= con.createStatement();
		rs= st.executeQuery(sql);
		
		while(rs.next()) {
			
			
			int id=rs.getInt("employeId");
			String firstname =rs.getString("firstname");
			String lastname =rs.getString("lastname");
			String dob =rs.getString("birthdate");
			String address =rs.getString("address");
			byte gender =rs.getByte("gender");
			double salary = rs.getDouble("salary");
					
		//	System.out.println(firstname+""+lastname+""+dob+""+address+""+gender+""+salary);		
					
			Employee e=new Employee(id,firstname,lastname,dob,address,gender,salary); 
		   recoard.add(e);
		}
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return recoard;
	}



	public void deleteEmployee(int id) throws SQLException {
		// TODO Auto-generated method stub
	
		PreparedStatement ps=null;
		ResultSet rs=null;
		Connection con=data.getConnection();
		
		String sql ="delete from employeeskill where employeeId=?";
		
		ps=con.prepareStatement(sql);
		
		ps.setInt(1, id);
		
		ps.execute();

		
		Connection con_two=data.getConnection();
		String sql_two="delete from employee where employeId=?";
		
		
		ps=con_two.prepareStatement(sql_two);
		ps.setInt(1, id);
		
		ps.execute();
		
		
	}



	public Employee getEmplyee(int eid) throws SQLException {
	
		 Employee e=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Connection con=data.getConnection();
		
		String sql ="select* from employee where employeId=?";
		
		ps=con.prepareStatement(sql);
		
		ps.setInt(1, eid);
		
		rs=ps.executeQuery();
      if(rs.next()) {
			
			
			int id=rs.getInt("employeId");
			String firstname =rs.getString("firstname");
			String lastname =rs.getString("lastname");
			String dob =rs.getString("birthdate");
			String address =rs.getString("address");
			byte gender =rs.getByte("gender");
			double salary = rs.getDouble("salary");
					
			//System.out.println(firstname+""+lastname+""+dob+""+address+""+gender+""+salary);		
					
			e=new Employee(id,firstname,lastname,dob,address,gender,salary);	
		   
		}
       
		
		
		
		
		return e;
	}



	public void updateEmployee(Employee emp) throws SQLException, ParseException {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		ResultSet rs=null;
		Connection con=data.getConnection();
		Connection con_two=data.getConnection();
		DateFormat formatter ; 
        formatter = new SimpleDateFormat("dd-MM-yyyy");
       java.util.Date date= formatter.parse(emp.getDate());
       java.sql.Date sqlDate = new java.sql.Date(date.getTime());
       byte skill []= emp.getSkill();
		int id=0;
       
       
       
       //System.out.println(emp.getAddress()+" "+emp.getId() );
		
		String sql_two="update employeeskill set skillId =? where employeeId=?";
		String sql = "update employee set firstname=?,lastname=?,birthdate=?,address=?,gender=?,salary=? where employeId=?";
		ps=con.prepareStatement(sql);
		
		
		ps.setString(1, emp.getFirstname());
		ps.setString(2, emp.getLastname());
		ps.setDate(3, sqlDate);
		ps.setString(4, emp.getAddress());
		ps.setInt(5, emp.getGender());
		ps.setDouble(6, emp.getSalary());
		ps.setInt(7, emp.getId());
		
		ps.execute();
		
		
		ps =con_two.prepareStatement(sql_two);
		
			for(int i=0;i<skill.length;i++) {
			
			
			ps.setInt(1,skill[i]);
			ps.setInt(2, emp.getId());
		
			ps.addBatch();
		}
		
	}




	
	
	
	
	
	
	
	
	
}
