<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 로그인 </h1>

<form action="loginController" method="post">
	<div>
	<span>
		로그인아이디
		<input type="text" id="memberId" name="memberId">
	</span>	
	<span>
		로그인비밀번호
		<input type="password" id="memberPass" name="memberPass">
	</span>
		
		
		<button type="submit"> 로그인</button>		
		

	</div>
</form>

<a href="${pageContext.request.contextPath}/insertMember"> 회원가입 </a>


</body>
</html>