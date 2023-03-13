<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>user Update</title>
<script>
	function checkInfo() {
		if(document.userInfo.pw.value != document.userInfo.pw2.value) {
			alert("동일한 비밀번호를 입력해주세요.");
			return false;
		}
	}
</script>
</head>
<body>
<%-- <%
String id = "";

if (session.getAttribute("id") != null) {
	id = (String) session.getAttribute("id");
}
%> --%>

<h1>회원수정</h1>
	
	<form action="userUpdate.do" method="post" onsubmit="return checkInfo()" name="userInfo">
		아이디	<input type="text" name="id" value = ${id } readonly>	<br><br>
		비밀번호	<input type="password" name="pw" placeholder="비밀번호를 입력하세요." required>	<br><br>
		비밀번호 확인	<input type="password" name="pw2" placeholder="비밀번호를 다시 입력하세요." required>	<br><br>
		이름	<input type="text" name="name" placeholder="이름을 입력하세요." required>	<br><br>
		생년월일	<input type="date" name="birth" placeholder="생년월일을 입력하세요." required>	<br><br>
		전화번호	<input type="text" name="tel" placeholder="예) 010-0000-0000" required>	<br><br>
		
		<input type="submit" value="회원수정">	<br>
		<input type="button" value="취소" onclick="location.href='index.jsp'">
	</form>

</body>
</html>