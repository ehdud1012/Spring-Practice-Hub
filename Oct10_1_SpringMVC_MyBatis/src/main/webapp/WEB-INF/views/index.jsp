<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${result }
	<form action="menu.reg?token=" + ${token }>
		<input name="token" value="${token }" type="hidden">
		<input name="m_name" placeholder="메뉴명을 입력하세요"> <p>
		<input name="m_price" placeholder="가격을 입력하세요"> <p>
		<button>등록</button>
	</form>
	<hr>
	메뉴판 <p>
	<c:forEach var="m" items="${menus }">
		${m.m_no })  ${m.m_name } : ${m.m_price }원 <p>
	</c:forEach>
	
</body>
</html>