<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,user-scalable=no,initial-scale=1.0">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/index.css">
<link rel="stylesheet" href="resources/css/member.css">
<link rel="stylesheet" href="resources/css/sns.css">
<link rel="stylesheet" href="resources/css/gallery.css">
<script type="text/javascript" src="resources/js/move.js"></script>
<script type="text/javascript" src="resources/js/KDYVaildChecker_v1.0.js"></script>
<script type="text/javascript" src="resources/js/pooh_vaildCheck.js"></script>
</head>
<body>
	<table id="siteTitleArea">
		<tr>
			<td id="siteTitle">
				<a href="index.do">WINNE THE POOH</a>
				${result }
			</td>
		</tr>
		<tr>
			<td id="siteLoginArea" align="center">
				<jsp:include page="${loginPage }"></jsp:include>
			</td>
		</tr>
	</table>
	
	<table id="siteContentArea">
		<tr>
			<td align="center">
				<jsp:include page="${contentPage }"></jsp:include>
			</td>
		</tr>
	</table>
	
	<table id="siteMenuArea">
				<tr>
					<td align="center" class="td1">
						<a href="sns.go">SNS</a>
					</td>
					<td align="center" class="td1">
						<a href="photo.go">PHOTO</a>
					</td>
					<td align="center" class="td1">
						<a href="">??</a>
					</td>
				</tr>
			</table>
</body>
</html>