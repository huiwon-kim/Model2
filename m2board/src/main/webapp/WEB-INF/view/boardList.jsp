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
	<h1> 게시판 목록 </h1>
	
	
	<div>											<!--겟은 ? 포스트는 액션 -->
		<a href="${pageContext.request.contextPath}/addBoard.jsp">
			글쓰기
		</a>
	</div>
	
	
	
	<table>
		<thead>
			<tr>
				<th> 번호 </th>
				<th> 제목 </th>
				<th> 작성자 </th>
				<th> 작성일 </th> 
				<th> 조회 </th> <!--  조회할때마다 업데이트 -->
				<th> 좋아요 </th> <!--  좋아요 누를 때마다 업데이트 --> <!-- 28~33 +상세보기까지 -->
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="b" items="${list}">
				<td> ${b.boardNo} </td> <!--  실제 호출? >>> b.getboardNo() -->
				<td> 
					<a href="${pageContext.request.contextPath}/boardOne?boardNo=${b.boardNo}">
						${b.title} 
					</a>
				</td>
				<td> ${b.writer} </td>
				<td> ${b.createDate} </td>
				<td> ${b.read} </td>
				<td> ${b.nice} </td>
			</c:forEach>
		</tbody>
		
		
	</table>
		<div>
		<c:if test="${currentPage > 1}">
			<a href="${pageContext.request.contextPath}/boardList?currentPage=${currentPage-1}"> 이전</a>
		</c:if>
			
		<c:if test="${currentPage < lastPage}">
			<a href="${pageContext.request.contextPath}/boardList?currentPage=${currentPage+1}"> 다음</a>
		</c:if>	
		</div>
	
</body>
</html>