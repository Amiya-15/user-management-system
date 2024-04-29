<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
body{
text-align:center;


}

</style>
<body>
<p>Are you sure you want to logout?</p>
    <form action="logout" method="post">
        <input type="submit" name="confirm" value="Yes">
        
        <button><a href="home.jsp">No</a></button>
        
    </form>
</body>
</html>