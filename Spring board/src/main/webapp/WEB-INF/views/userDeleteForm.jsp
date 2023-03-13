<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Delete</title>
</head>
<body>
<%-- 
<%
	String id = "";
	
	if (session.getAttribute("id") != null) {
    	id = (String) session.getAttribute("id");
    	System.out.println(id);
	}
%> --%>
<form action="userDelete.do" method="post">
	아이디 <input type="text" name="id" placeholder="아이디를 입력해주세요." required>
	비밀번호 <input type="password" name="pw" placeholder="비밀번호를 입력해주세요." required>
	
	<input type="submit" value="회원탈퇴">	<br>
	<input type="button" value="취소" onclick="location.href='index.jsp'">	
</form>


</body>
</html>