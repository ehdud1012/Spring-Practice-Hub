<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/unitChangeCSS.css">
</head>
<body>
	<table id="${result.unit }">
		<tr>
			<th align="center" colspan="2">변환 결과</th>
		</tr>
		<tr>
			<td align="center">
				${result.num } ${result.unit1 }
			</td>
		</tr>
		<tr>
			<td align="center" colspan="2">
				↓
			</td>
		</tr>
		<tr>
			<td align="center">
				<fmt:formatNumber value="${result.result }" pattern="=#.0"></fmt:formatNumber>
				 ${result.unit2 }
			</td>
		</tr>
	</table>
</body>
</html>