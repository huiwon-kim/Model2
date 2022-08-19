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
	<a href="${pageContext.request.contextPath}/boardList"> 게시판 보기 </a>
	<a href="${pageContext.request.contextPath}/memberOne"> 회원정보 보기 </a>
	<a href="${pageContext.request.contextPath}/logout"> 로그아웃 </a>
	<a href="${pageContext.request.contextPath}/memberOut"> 회원탈퇴 </a>

<h1> 회원정보 상세보기 </h1>
<form action="memberUpdate" method="get">
<table border="1">
<tr>
	<td>ID</td>
	<td> <input type="text" id="memberId" name="memberId" value="${loginMember.memberId}" readonly='readonly'></td>
</tr>
<tr>
	<td>NAME</td>
	<td> <input type="text" id="memberName" name="memberName" value="${loginMember.memberName}" readonly='readonly'></td>
</tr>
<tr>
	<td>GENDER</td>
	<td> <input type="text" id="memberGender" name="memberGender" value="${loginMember.memberGender}" readonly='readonly'></td>
</tr>
<tr>
	<td>ADDR</td>
	<td> <input type="text" id="memberAdd" name="memberAdd" value="${loginMember.memberAdd}" readonly='readonly'></td>
</tr>
<tr>
	<td>DETAIL ADDR</td>
	<td> <input type="text" id="memberDetailAdd" name="memberDetailAdd" value="${loginMember.memberdetailAdd}" readonly='readonly'></td>
</tr>
<tr>
	<td>JOIN DAY</td>
	<td> <input type="text" id="createDate" name="createDate" value="${loginMember.createDate}" readonly='readonly'></td>
</tr>

</table>

<button type="submit"> 수정하기 </button>
</form>
</body>
</html>