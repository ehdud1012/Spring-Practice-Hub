<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="join.do" name="joinForm" onsubmit="return joinCheck();"
			method="post" enctype="multipart/form-data">
		<table id="joinTbl">
			<tr>
				<th>회원가입</th>
			</tr>
			<tr>
				<td class="label">아이디</td>
			</tr>
			<tr>
				<td>
					<input name="pm_id" placeholder="아이디" maxlength="10" autocomplete="off">
				</td>
			</tr>
			<tr>
				<td class="label">비밀번호</td>
			</tr>
			<tr>
				<td>
					<input type="password" name="pm_pw" placeholder="비번" maxlength="10" autocomplete="off">
				</td>
			</tr>
			<tr>
				<td class="label">비밀번호 확인</td>
			</tr>
			<tr>
				<td>
					<input name="pm_pwCk" placeholder="비번 확인" maxlength="10" autocomplete="off">
				</td>
			</tr>
			<tr>
				<td class="label">이름</td>
			</tr>
			<tr>
				<td>
					<input name="pm_name" placeholder="이름" maxlength="10" autocomplete="off">
				</td>
			</tr>
			<tr>
				<td class="label">생년월일</td>
			</tr>
			<tr>
				<td>
					<input name="pm_jumin1" id="one" placeholder="XXXXXX" maxlength="6">
					 - 
					 <input name="pm_jumin2" id="two" maxlength="1">XXXXXX
				</td>
			</tr>
			<tr>
				<td class="label">프로필 사진</td>
			</tr>
			<tr>
				<td>
					<input name="pm_photo" type="file" id="profile">
				</td>
			</tr>
			<tr>
				<td align="center">
					<button>가입</button>
				</td>
			</tr>
		</table>	
	</form>
</body>
</html>