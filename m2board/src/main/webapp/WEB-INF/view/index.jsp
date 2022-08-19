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
	<h1> 성공했다면 여기로 </h1>
	
	<h1> ${loginMember.memberId}님 반갑습니다 </h1>
	
	<a href="${pageContext.request.contextPath}/boardList"> 게시판 보기 </a>
	<a href="${pageContext.request.contextPath}/memberOne"> 회원정보 보기 </a>
	<a href="${pageContext.request.contextPath}/logout"> 로그아웃 </a>
	<a href="${pageContext.request.contextPath}/memberOut"> 회원탈퇴 </a>
	
</body>
</html>

