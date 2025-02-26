<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<table id="galleryTbl">
			<tr>
				<th colspan="2">GALLERY</th>
			</tr>
			<tr>
				<td align="left" id="searchTbl">
					<form action="photo.search.go">
							<input id="searchInput" name="g_search" placeholder="&nbsp;검색어를 입력하세요">
							<button id="searchBtn">검색</button>
					</form>
				</td>
				<td align="right" id="a">
					<a href="photo.upload.go" id="goUpload">업로드하러가기</a>				
				</td>
			</tr>
			<tr>
				<td align="center" colspan="2">
					<c:forEach var="g" items="${GalleryPost}">
						<table class="postsTbl">
							<tr>
								<td colspan="2" align="center">
									<c:if test="${g.pg_writer == sessionScope.loginUser.pm_id }">
										<button onclick="goGalleryPostDelete(${g.pg_no});">
											<img class="icon" src="resources/img/delete.png">
										</button>
									</c:if>
									<a href="resources/pooh_PhotoGallery/${g.pg_file }">
										<img class="icon" src="resources/img/download.png">
									</a>
								</td>
							</tr>
							<tr>
								<td colspan="2" align="center">
									<img id="postPhoto" src="resources/pooh_PhotoGallery/${g.pg_file }">
								</td>
							</tr>
							<tr>
								<td colspan="2" class="pg_title">
									${g.pg_title }
								</td>
							</tr>
							<tr>
								<td class="pg_writer">
									Upload : ${g.pg_writer }
								</td>
								<td class="pg_date" align="right">
									<fmt:formatDate value="${g.pg_date }" type="date" pattern="yy.MM.dd"/>
								</td>
							</tr>
						</table>
					</c:forEach>
				</td>	
			</tr>
			<tr>
				<td colspan="2">
					<c:if test="${g_page != g_pageCount}">
						<table id="pageMoveDown" onclick="galleryPageChange(${g_page + 1});">
							<tr>
								<td align="center">
									<img class="icon" src="resources/img/keyboard_down.png">
								</td>
							<tr>
						</table>
					</c:if>
				</td>
			</tr>
		</table>
</body>
</html>