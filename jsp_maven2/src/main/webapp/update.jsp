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
<%@ include file="components/homenavbar.jsp" %>
<h1>Ready Hela au</h1>
<%String strId=request.getParameter("id");
int id=Integer.parseInt(strId);
User dao=new User();
User user=dao.fetchUserById();%>
</body>
</html>