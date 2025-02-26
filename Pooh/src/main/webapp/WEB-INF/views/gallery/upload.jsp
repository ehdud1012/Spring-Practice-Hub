<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="photo.upload.do" method="post" enctype="multipart/form-data"
			name="uploadForm" onsubmit="return photoUpload();">
		<input name="token" value="${token }" type="hidden">
		<table id="uploadTbl">
			<tr>
				<th>UPLOAD</th>
			</tr>
			<tr>
				<td class="label">제목</td>
			</tr>
			<tr>
				<td>
					<input name="pg_title">
				</td>
			</tr>
			<tr>
				<td class="label">사진 업로드</td>
			</tr>
			<tr>
				<td id="file">
					<input name="pg_file" type="file">
				</td>
			</tr>
			<tr>
				<td align="center">
					<button>등록</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>