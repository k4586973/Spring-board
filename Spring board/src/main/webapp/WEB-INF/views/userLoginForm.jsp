<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h1>로그인</h1>
	<form action="userLogin.do" method="post">
		아이디	<input type="text" name="id" placeholder="아이디를 입력하세요." required>	<br><br>
		비밀번호	<input type="password" name="pw" placeholder="비밀번호를 입력하세요." required>	<br><br>
		
		<input type="submit" value="로그인">
		<input type="button" value="회원가입" onclick="location.href='userJoinForm.do'">
		<input type="button" value="취소" onclick="location.href='index.jsp'">
	</form>
</body>
</html>