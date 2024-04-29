package com.org.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class User {

	private int id;
	
	private String name;
	
	private int age;
	
	private String email;
	
	private String password;
	
	private long mobile;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public User fetchUserById() {
		try {
			Class.forName("com.mysl.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_mgmt","root","root");
			
			PreparedStatement pst=con.prepareStatement("select * from user where id=?");
			pst.setInt(1, id);
			ResultSet rst=pst.executeQuery();
			
			if(rst.next())
			{
				User user=new User();
				user.setId(rst.getInt("id"));
				user.setName(rst.getString("name"));
				user.setAge(rst.getInt("age"));
	            user.setEmail(rst.getString("email"));
	            user.setPassword(rst.getString("password"));
	            user.setMobile(rst.getLong("mobile"));
	            
	            return user;
				
				
			}
			con.close();
		} catch (ClassNotFoundException|SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List<User> fetchAllUser() {
		
		List<User> list=new ArrayList<>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_mgmt","root","root");
			
			PreparedStatement pst=con.prepareStatement("select * from user ");
			
			ResultSet rst=pst.executeQuery();
			while(rst.next()) {
				User user = new User();
                user.setId(rst.getInt("id"));
                user.setName(rst.getString("name"));
                user.setAge(rst.getInt("age"));
                user.setEmail(rst.getString("email"));
                user.setPassword(rst.getString("password"));
                user.setMobile(rst.getLong("mobile"));
                list.add(user);
		}
		con.close();
		
		} catch (ClassNotFoundException|SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
