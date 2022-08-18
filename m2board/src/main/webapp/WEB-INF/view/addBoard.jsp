<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 글 입력하기 </h1>
	<form method="post" action="insertBoard">
	<table border="1">
	
			<tr>
				<th> 제목 </th>
				<td><input type="text" id="boardTitle" name="boardTitle"></td>
			</tr>
				
			<tr>	
				<th> 작성자 </th>
				<td><input type="text" id="memberId" name="memberId" value="${loginMember.memberId}" readonly='readonly'></td>
			</tr>
			<tr>	
				<th> 비밀번호 </th>
				<td><input type="password" id="boardPw" name="boardPw"></td>
			</tr>
			<tr>
				<th> 내용 </th> <!--  조회할때마다 업데이트 -->
					<td><input type="text" id="boardText" name="boardText"></td>
				 <!--  좋아요 누를 때마다 업데이트 --> <!-- 28~33 +상세보기까지 -->
			</tr>
	


	</table>
	<button type="submit">ㄱㄱ</button>
	<%-- <a href="${pageContext.request.contextPath}/insertBoard"> 입력 </a> --%>
	</form>
</body>
</html>