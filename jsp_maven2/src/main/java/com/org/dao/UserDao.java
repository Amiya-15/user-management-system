package com.org.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.org.dto.User;

public class UserDao {

	public void saveUser(User user)  {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user_mgmt","root","root");
			PreparedStatement pst=con.prepareStatement("insert into user(name,age,email,password,mobile) values(?,?,?,?,?)");
			pst.setString(1, user.getName());
			pst.setInt(2, user.getAge());
			pst.setString(3, user.getEmail());
			pst.setString(4, user.getPassword());
			pst.setLong(5, user.getMobile());
			
			pst.executeUpdate();
			
			con.close();
		} catch (ClassNotFoundException|SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public User fetchUserByEmailAndPassword(String email,String password)  {
//		User user=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_mgmt","root","root");
			
			PreparedStatement pst=con.prepareStatement("select * from user where email=? and password=?");
			
			pst.setString(1, email);
			pst.setString(2, password);
			
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
		} catch (ClassNotFoundException|SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
