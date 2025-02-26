<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src ="resources/KDYVaildChecker_v1.0.js"></script>
<script type="text/javascript" src ="resources/Sep04_1_check.js"></script>
<link rel="stylesheet" href="resources/Sep04_1_CSS.css">
</head>
<body>
	<form action="calculate.do" name="bmi" onsubmit="return Check();" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<th colspan="2" align="center">비만도 검사</th>
			</tr>
			<tr>
				<td class="oo">이름</td>
				<td>
					<input name="name">
				</td>
			</tr>
			<tr>
				<td class="oo">키</td>
				<td>
					<input name="height"> cm
				</td>
			</tr>
			<tr>
				<td class="oo">몸무게</td>
				<td>
					<input name="weight"> kg
				</td>
			</tr>
			<tr>
				<td class="oo">사진</td>
				<td>
					<input name="photo" type="file">
				</td>
			</tr>
			<tr>
				<td align="center" colspan="2" class="oo">
					<button>결과보기</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>