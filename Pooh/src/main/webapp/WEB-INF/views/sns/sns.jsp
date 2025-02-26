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
	<c:if test="${page != 1}">
		<table id="pageMoveLeft" onclick="snsPageChange(${page - 1});">
			<tr><td align="center">&lt;</td><tr>
		</table>
	</c:if>
	<c:if test="${page != pageCount}">
		<table id="pageMoveRight" onclick="snsPageChange(${page + 1});">
			<tr><td align="center">&gt;</td><tr>
		</table>
	</c:if>
	<table id="snsTbl">
		<tr>
			<th>게시판</th>
		</tr>
		<tr> 
			<td align="center">
				<c:forEach var="p" items="${SNSPost }">
					<table id="contentTable">
							<c:if test="${p.ps_writer == sessionScope.loginUser.pm_id }">
								<tr class="bg">
									<td align="right" colspan="2" class="button">
										<button onclick="goSnsUpdate(${p.ps_no}, '${p.ps_txt }', ${page });">수정</button>
										<button onclick="goSnsDelete(${p.ps_no});">삭제</button>
									</td>
								</tr>
							</c:if>
							<tr class="bg">
								<td align="left" class="writer">${p.ps_writer }</td>
								<td align="right" class="date">
									<fmt:formatDate value="${p.ps_date }" type="date" pattern="yyyy년 MM월 dd일"/>
								</td>
							</tr>
							<tr>
								<td rowspan="3" class="profileForm" align="center">
									<img class="writerProfile" src="resources/pooh_Photo/${p.pm_photo }">
								</td>
								<td colspan="2" class="txt">
									${p.ps_txt }
								</td>
							</tr>
							<tr>
								<td colspan="2" class="button">
									<form action="sns.reply.write" name="replyReg" onsubmit="return snsReplyWriteCheck();">
										<div>댓글</div>
										<input name="token" value="${token }" type="hidden">
										<input name="ps_no" value="${p.ps_no }" type="hidden">
										<input id ="replyW" name="psr_txt" maxlength="80">
										<button>쓰기</button> <p>
									</form>
								</td>
							</tr>
							<tr>
								<td>
									<c:forEach var="r" items="${p.sr_replys}">
										<table class="replyTbl">
											<tr>
												<td class="r_writer" rowspan="2">${r.psr_writer }</td>
												<td align="right">
													<c:if test="${r.psr_writer == sessionScope.loginUser.pm_id }">
														<button onclick="goReplyUpdate(${r.psr_no},'${r.psr_txt}', ${page });">수정</button>
														<button onclick="goSnsReplyDelete(${r.psr_no})">삭제</button>
													</c:if>
												</td>
											</tr>	
											<tr>
												<td class="r_date" align="right">
													<fmt:formatDate value="${r.psr_date }" type="date" pattern="yy.MM.dd"/>
												</td>
											</tr>
											<tr>
												<td class="r_txt" class="r_txt" colspan="2">${r.psr_txt }</td>
											</tr>
										</table>
									</c:forEach>
								</td>
							</tr>
						</table>
				</c:forEach>
			</td>
		</tr>
		<tr>
			<td align="right">
				<form action="sns.searchPost.go">
					<table id="searchArea">
						<tr>
							<td align="center">
								<input id="searchInput" name="search" placeholder="&nbsp;검색어를 입력하세요">
								<button id="searchBtn">검색</button>
							</td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>
	
	<c:if test="${sessionScope.loginUser != null }">
		<form action="sns.post.write" name="regForm" onsubmit="return snsWriteCheck();">
			<input name="token" value="${token }" type="hidden">
			<table id="noticeRegTable">
				<tr>
					<td align="right" valign="bottom">
							<button>등록</button>
					</td>
				</tr>
				<tr>
					<td align="center">
						<textarea name="ps_txt" placeholder="내용"
										autocomplete="off" maxlength="450"></textarea>
					</td>
				</tr>
			</table>
		</form>
	</c:if>
</body>
</html>