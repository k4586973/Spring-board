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
	로그인 성공!!!!!!
	
	${id }님 환영합니다!!
	
	<a href="userUpdateForm.do">회원수정</a>
	<a href="userDeleteForm.do">회원탈퇴</a>
	<a href="userLogout.do">로그아웃</a><br><br><br>
	
	
	<a href="getBoardList.do">파일전송 게시판</a>
	<a href="">안만듬</a>
	<a href="">안만듬</a>
	
</body>
</html>