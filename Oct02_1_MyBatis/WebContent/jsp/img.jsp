<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="i" items="${img }">
		<table border="1" class="imgTable">
				<tr>
					<td>${i.o_title }</td>
				</tr>
				<tr>
					
					<td class="img"><img src="img/${i.o_file }"></td>
				</tr>
				<tr>
					<td align="center">
						<fmt:formatDate value="${i.o_date }" type="date" dateStyle="short"/>
					</td>
				</tr>
		</table>
	</c:forEach>
</body>
</html>