<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 목록</title>
</head>
<body>
	<h1>사용자 전체 명단</h1>
	<hr>
	
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>ID</th>
				<th>PW</th>
				<th>생년월일</th>
				<th>전화번호</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${alist }">
				<tr>
					<td>${user.uno }</td>
					<td>${user.name }</td>
					<td>${user.id }</td>
					<td>${user.pw }</td>
					<td>${user.birth }</td>
					<td>${user.tel }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

 <a href="loginForm.do">로그인</a>
 <a href="userJoinForm.do">회원가입</a>
 <a href="userDeleteForm.do">회원탈퇴</a>

</body>
</html>