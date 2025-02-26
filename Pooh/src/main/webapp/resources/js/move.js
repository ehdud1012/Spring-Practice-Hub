function joinGo() {
	location.href = "join.go"
}
function logoutGo() {
	location.href = "logout.go"
}

function goSnsDelete(no) {
	location.href = "sns.post.delete?ps_no=" + no;
}
function goSnsReplyDelete(no) {
	location.href = "sns.post.reply.delete?psr_no=" + no;
}
function goSnsUpdate(no, txt, page) {
	txt = prompt("수정", txt);
	if(txt != null && txt.length > 0 && txt.length <= 450){
		location.href = "sns.post.update?ps_txt=" + txt + "&ps_no=" + no + "&page=" + page;
	}
}
function goReplyUpdate(no, r_txt, page) {
	r_txt = prompt("댓글수정", r_txt);
	if(r_txt != null && r_txt.length > 0 && r_txt.length <= 80){
		location.href = "sns.post.reply.update?psr_txt=" + r_txt + "&psr_no=" + no + "&page=" + page;
	}
}

function snsPageChange(page) {
	location.href = "sns.postPage.go?page=" + page;
}

function bye() {
	var t = prompt("탈퇴하려면 ㅂㅇ 입력")
	if (t == "ㅂㅇ"){
		location.href = "member.bye.go";
	}
}
function goGalleryPostDelete(no) {
	location.href = "photo.delete.do?pg_no=" + no;
}

function galleryPageChange(g_page) {
	location.href = "gallery.postPage.go?g_page=" + g_page;
}
