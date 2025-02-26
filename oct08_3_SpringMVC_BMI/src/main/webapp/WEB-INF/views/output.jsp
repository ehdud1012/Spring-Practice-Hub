<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/Sep04_1_CSS.css">
</head>
<body>
	<table>
		<tr>
			<th colspan="2" align="center">결과</th>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<img src="resources/oct10_photo/${result.photo }">
			</td>
		</tr>
		<tr>
			<td class="oo">이름</td> <td>${result.name }</td>
		</tr>
		<tr>
			<td class="oo">키</td> <td>${result.height }cm</td>
		</tr>
		<tr>
			<td class="oo">몸무게</td> <td>${result.weight }kg</td>
		</tr>
		<tr>
			<td class="oo">bmi</td> 
			<td>
				<fmt:formatNumber value="${result.bmi }" pattern="#.0" />
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center" id="result">${result.result }</td>
		</tr>
	</table>
</body>
</html>