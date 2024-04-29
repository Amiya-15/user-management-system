<%@page import="java.util.List"%>
<%@page import="com.org.dao.UserDao"%>
<%@page import="com.org.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="components/bootstap.jsp" %>
</head>
<body>
<%@ include file="components/homenavbar.jsp"%>
<%User user=(User)session.getAttribute("userObj");
if(user==null){
response.sendRedirect("login.jsp");
}else{

%>

<h1 class="text-context">
hey
<%User user1=(User)session.getAttribute("userObj"); %>
<%=user.getName() %>
 ,welcome to user Management System.</h1>
 <%} %>
 <div class="container-fluid p-3">
		<div class="row">
			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">User Details</p>
						<a href="add.jsp" class="text-decoration-none btn btn-primary">Add
							User</a>
						<table class="table">
							<thead>
								<tr>
									<th>Name</th>
									<th>Age</th>
									<th>Email</th>
									<th>Mobile</th>
									<th>Action</th>
								</tr>
								<%
								User dao=new User();
								List<User> list=dao.fetchAllUser();
								
								for(User u : list){
									if(user.getId()==u.getId())
								
								
								%>
								<tr>
								<td><%=u.getName() %></td>
								<td><%=u.getAge() %></td>
								<td><%=u.getEmail() %></td>
								<td><%=u.getMobile() %></td>
								<td>
								<a href="update.jsp?id=<%=u.getId() %>"class="btn btn-danger text-decoration-none">update</a>
								<a href="delete.jsp?id=<%=u.getId()%>"class="btn btn-danger text-decoration-none">delete</a>
								</td>
								
								</tr>
								<% } %>
								
								

							</thead>
							<tbody>
						</table>

					</div>
				</div>


			</div>

		</div>

 
</body>
</html>