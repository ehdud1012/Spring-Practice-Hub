<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table id="infoTbl">
<form action="member.info.update.go" method="post" name="updateForm" onsubmit="return updateCheck();" enctype="multipart/form-data">
		<tr>
			<th colspan="2">
				★ ${sessionScope.loginUser.pm_name }님 ★
			</th>
		</tr>
		<tr><td class="label">아이디</td></tr>
		<tr>
			<td class="noChange">
				${sessionScope.loginUser.pm_id }
			</td>
		</tr>
		<tr><td class="label">비밀번호</td></tr>
		<tr>
			<td>
				<input type="password" placeholder="비번" name="pm_pw"
					class="infoForm" value="${sessionScope.loginUser.pm_pw }">
			</td>
		</tr>
		<tr><td class="label">비밀번호 확인</td></tr>
		<tr>
			<td>
				<input placeholder="비번" name="pm_pwchk"
					class="infoForm" value="${sessionScope.loginUser.pm_pw }">
			</td>
		</tr>
		<tr><td class="label">이름</td></tr>
		<tr>
			<td>
				<input placeholder="이름" name="pm_name"
					value="${sessionScope.loginUser.pm_name }">
			</td>
		</tr>
		<tr><td class="label">생년월일</td></tr>
		<tr>
			<td class="noChange">
				<fmt:formatDate value="${sessionScope.loginUser.pm_birthday }"
						pattern="yyyy년 MM월 dd일 (E)"/>
			</td>
		</tr>
		<tr><td class="label">프사</td></tr>
		<tr>
			<td id="photoForm">
				<img id="profile" src="resources/pooh_Photo/${sessionScope.loginUser.pm_photo }"> <p> &nbsp;&nbsp;
				<span>프사 변경</span>
				<input name="pm_photo" type="file">
			</td>
		</tr>
		<tr>
			<td align="center" colspan="2">
				<button>수정</button>
</form>
				<button onclick="bye();">탈퇴</button>
			</td>
		</tr>
	</table>
</body>
</html>