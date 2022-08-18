<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 회원가입 </h1>
	
	<form action="insertMembe" method="post">
	<div>
		<table border="1">
		<tr>
			<th> ID </th>
			<td> <input type="text" id="memberId" name="memberId"> </td>
		</tr>
		
		<tr>
			<th> PASS </th>
			<td> <input type="text" id="memberPass" name="memberPass"> </td>
		</tr>
		
		<tr>
			<th> NAME </th>
			<td> <input type="text" id="memberName" name="memberName"> </td>
		</tr>
		
		<tr>
			<th> ID </th>
			<td> <input type="radio" name="memberGender" value="male"> male 
				 <input type="radio" name="memberGender" value="female"> female 
			</td>
		</tr>
		
		</table>
	</div>
	<button type="submit"> 회원가입 </button>
	</form>
	
</body>
</html>