<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table id="loginedTbl">
<form action="member.info.go">
		<tr> 
			<td rowspan="2" align="center">
				<img id="profile" src="resources/pooh_Photo/${loginUser.pm_photo }">
			</td>
			<th colspan="2">● ${loginUser.pm_name }님  ●</th>
		</tr>
		<tr>
			<td align="center">
				<button>회원정보확인</button>
			</td>
	</form>
			<td align="center">
				<button onclick="logoutGo();">로그아웃</button>
			</td>
		</tr>
	</table>
	
	
</body>
</html>