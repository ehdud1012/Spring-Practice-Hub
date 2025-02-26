function isEmpty(input){
	return !input.value;
}

function lessThan(input, len){
	return input.value.length < len;
}

function containsHS(input){
	var set = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890@-._";
	for(var i = 0; i < input.value.length; i++){
		if(set.indexOf(input.value[i]) == -1){
			return true;
		}
	}
}

function notEqual(input1, input2){
	return input1.value != input2.value;
}

function notContains(input, set) {
	for(var i = 0; i < input.value.length; i++){
			if(input.value.indexOf(set[i]) != -1);
		}
}

// input 
// 숫자일때만 true
function isNotNum(input) {
	return (isNaN(input.value) && input.value.indexOf(" ")== -1);
}

// 그 파일 아니면 True
function isNotType(input, type){
	type = "." +type;
	return input.value.toLowerCase().indexOf(type) == -1; // 소문자로
	
}


