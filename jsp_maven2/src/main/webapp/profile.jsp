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
<%User sessionUser=(User)session.getAttribute("userObj");
if(sessionUser == null){
	response.sendRedirect("login.jsp");
}else{%>
<%@ include file="components/homenavbar.jsp" %>
<h1>hello,

<%= sessionUser.getName() %>
welcome to profile page
</h1>
<%} %>
<div class="container-fluid p-3">
		<div class="row">
			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<table class="table">
							<thead>
								<tr>
									<th>Name</th>
									<th>Age</th>
									<th>Email</th>
									<th>Mobile</th>
									
								</tr>
								<%User dao=new User();
								List<User> list=dao.fetchAllUser();
								for(User u : list){
									if(sessionUser.getId()!=u.getId()){
										continue;
										
									}
								
								%>
								<tr>
								<td><%=u.getName() %></td>
								<td><%=u.getAge() %></td>
								<td><%=u.getEmail() %></td>
								<td><%=u.getMobile() %></td>
								
								
								
								</tr>
								<% } %>
								

							</thead>
							<tbody>
						</table>

					</div>
				</div>


			</div>

		</div>


	</div>
</body>
</html>