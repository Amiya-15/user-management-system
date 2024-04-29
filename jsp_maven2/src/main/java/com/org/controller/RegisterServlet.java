package com.org.controller;
import com.org.dto.User;

import com.org.dao.UserDao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/register")

public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=req.getParameter("name");
		String ageStr=req.getParameter("age");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String mobileStr=req.getParameter("mobile");
		
		int age=Integer.parseInt(ageStr);
		long mobile=Long.parseLong(mobileStr);
		
		User u=new User();
		u.setName(name);
		u.setAge(age);
		u.setEmail(email);
		u.setPassword(password);
		u.setMobile(mobile);
		
		UserDao obj= new UserDao();
		obj.saveUser(u);
		
		HttpSession session=req.getSession();
		session.setAttribute("success", "Registation Successful");
		
		resp.sendRedirect("register.jsp");
	}
}
