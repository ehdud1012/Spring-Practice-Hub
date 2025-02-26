<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/unitChangeCSS.css">
</head>
<body>
	<form action="Calculate.do">
		<table>
			<tr><th align="center" colspan="2">단위변환</th></tr>
			<tr align="center">
				<td class="td1">변환할 값</td>
				<td>
					<input name="input" class="textType">
				</td>
			</tr>
			<tr align="center">
				<td class="td1">단위</td>
				<td>
					<select name="unit">
						<option value="len">cm → inch</option>
						<option value="size">㎡ → 평</option>
						<option value="temp">℃ → ℉</option>
						<option value="spd">km/h → mi/h</option>
					</select>
				</td>
			</tr>
			<tr>
				<td align="center" colspan="2">
					<button>변환</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>