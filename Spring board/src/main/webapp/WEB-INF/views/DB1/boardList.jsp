<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 목록</title>

</head>
<body>
	<table border="1" >
		<tr>
			<th bgcolor="" width="50">no</th>
			<th bgcolor="" width="200">제목</th>
			<th bgcolor="" width="150">작성자</th>
			<th bgcolor="" width="150">작성일</th>
			<th bgcolor="" width="100">조회수</th>
		</tr>
		<c:choose>
			<c:when test="${!empty boardList}">
				<c:forEach items="${boardList }" var="board">
					<tr>
						<td>${board.bno }</td>
						<td align="left"><a href="getContent.do?bno=${board.bno }">
								${board.title }</a></td>
						<td>${board.writer }</td>
						<td><fmt:formatDate value="${board.regDate }" pattern="yyyy-MM-dd"/></td>
						<td>${board.cnt }</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="5">등록된 글이 없습니다.</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>
	<br>
	<!-- 여기서 사용할 페이징 정보 조회해오기 -->
	<c:set var="pageSize" value="10"></c:set> <!-- 얼마씩 나올지 결정 -->
	
	<form name="bfrm" action="/project/getBoardList.do">
	<input type="hidden" name="pageNum" value="${vo.pageNum}"> <!-- 페이지 번호 누를때 변경하고 submit -->
	<input type="hidden" name="amount" value="${pageSize}">
	</form>
	<div class="page_wrap">
		<c:set var="lastPage" value="${totalCount / pageSize + (totalCount % pageSize == 0 ? 0 : 1)}"></c:set> <!-- 페이지 노출해야하는 수량 -->
		<c:set var="leftLastPage" value="${(vo.pageNum / pageSize) * pageSize + 1}"></c:set> <!-- 왼쪽 마지막 페이지 번호 -->
		<c:set var="rightLastPage" value="${vo.pageNum / pageSize + pageSize}"></c:set> <!-- 오른쪽 마지막 페이지 번호 -->
		
		<c:forEach var="idx" begin="${vo.startPage}" end="${vo.lastPage}" step="1">
		<!-- 페이징 마지막이면 그냥 break ${idx} ${lastPage} -->
			<c:if test="${lastPage >= idx}">
			<span onclick="loadList(${idx})" class="${idx eq vo.pageNum ? 'active' : ''}">${idx}</span>
		    </c:if>
		</c:forEach>
	    
	</div>
	<script>
	function loadList(pageNo){
//		$('input[name=pageNum]').val(pageNo);
//		$('form[name=bfrm]').submit();

		var pageNoTag = document.getElementsByName('pageNum');
		pageNoTag[0].value = pageNo;
		var bfrmTag = document.getElementsByName('bfrm');
		bfrmTag[0].submit();
	}
	</script>

	<a href="moveInsertBoard.do">글 쓰기</a>
</body>
</html>