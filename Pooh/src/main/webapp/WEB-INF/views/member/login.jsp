<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<table id="loginPage">
	<form action="login.do" method="post" name="loginForm" onsubmit="loginCheck();">
			<tr>
				<td>
					<input name="pm_id" placeholder="아이디">
				</td>
				<td>
					<input name="pm_pw" placeholder="비번">
				</td>
				<td>
					<button>로그인</button>
				</td>
	</form>
				<td><button onclick="joinGo();">회원가입</button></td>
			</tr>
		</table>
</body>
</html>