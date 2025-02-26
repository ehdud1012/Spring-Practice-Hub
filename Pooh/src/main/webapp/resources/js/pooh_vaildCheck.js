function joinCheck() {
	var idField = document.joinForm.pm_id;
	var pwwField = document.joinForm.pm_pw;
	var pwckField = document.joinForm.pm_pwCk;
	var nameField = document.joinForm.pm_name;
	var jumin1Field = document.joinForm.pm_jumin1;
	var jumin2Field = document.joinForm.pm_jumin2;
	var photoField = document.joinForm.pm_photo;
	
	if (isEmpty(idField) || containsHS(idField)){
		alert("ID ?");
		idField.value = "";
		idField.focus();
		return false;
	}

	if (isEmpty(pwwField) || notEqual(pwwField, pwckField) || notContains(pwwField, "1234567890")){
			alert("PW ?");
			pwwField.value="";
			pwckField.value="";
			pwwField.focus();
			return false;
	}
	
	if (isEmpty(nameField)){
		alert("name ?");
		nameField.value = "";
		nameField.focus();
		return false;
	}
	
	if(isEmpty(jumin1Field) || isNotNum(jumin1Field) || lessThan(jumin1Field, 6)
			|| isEmpty(jumin2Field) || isNotNum(jumin2Field) || lessThan(jumin2Field, 1)){
		alert("birthday ?");
		jumin1Field.value = "";
		jumin2Field.value = "";
		jumin1Field.focus();
		return false;
	}
	
	if (isEmpty(photoField) || 
			(isNotType(photoField, "png") && isNotType(photoField, "gif") && isNotType(photoField, "jpg"))) {
			alert("photo ?");
			photoField.value="";
			return false;
	}
	return true;
}

function loginCheck(){
	var idField = document.loginForm.pm_id;
	var pwField = document.loginForm.pm_pw;
	
	if (isEmpty(idField) || isEmpty(pwField)){
			alert("?");
			idField.value = "";
			pwField.value = "";
			idField.focus();
			return false;
		}
	
	
	return true;
}

function updateCheck() {
	var pwField = document.updateForm.pm_pw;
	var pwckField = document.updateForm.pm_pwchk;
	var nameField = document.updateForm.pm_name;
	var photoField = document.updateForm.pm_photo;

	if (isEmpty(pwField) || notEqual(pwField, pwckField) || notContains(pwField, "1234567890")) {
			alert("pw?");
			pwField.value = "";
			pwckField.value = "";
			pwField.focus();
			return false;
		}
	if (isEmpty(nameField)){
		alert("name ?");
		nameField.value = "";
		nameField.focus();
		return false;
	}
	if(isEmpty(photoField)) { // 프사 선택 안함
		return true; // 정상
	}
	
	// 뭔가 선택을 함 -> 근데 파일종류 안맞음
	if (isNotType(photoField, "png") && isNotType(photoField, "gif") && isNotType(photoField, "jpg")) {
			alert("photo ?");
			photoField.value="";
			return false;
	}
	
	return true;
}

function snsWriteCheck() {
	if(isEmpty(document.regForm.ps_txt)){
		alert("txt ?");
		return false;
	}
}
function snsReplyWriteCheck(ff) {
	// 안되는 이유 
	// document.form이름.input이름 
	// 반복문 속에 들어있어 똑같은 이름이 여러 개라서 인식 X
	var txtField = ff.psr_txt
	
	if(isEmpty(txtField)){
		alert("txt ?");
		return false;
	}
}

function photoUpload() {
	var titleField = document.uploadForm.pg_title;
	var fileField = document.uploadForm.pg_file;
	
	if(isEmpty(titleField)){
		alert("title ?");
		titleField.value="";
		titleField.focus();
		return false;
	}
	
	if (isEmpty(fileField) || 
			(isNotType(fileField, "png") && isNotType(fileField, "gif") && isNotType(fileField, "jpg"))) {
			alert("photo ?");
			fileField.value="";
			fileField.focus();
			return false;
	}
	return true;
}
