function Check() {
	var nameField = document.bmi.name;
	var heightField = document.bmi.height;
	var weightField = document.bmi.weight;
	var photoField = document.bmi.photo;
	
	
	if (isEmpty(nameField)) {
		alert("name ?");
		return false;
	}
	if (isEmpty(heightField) || isNotNum(heightField)) {
		alert("height ?");
		return false;
	}
	if (isEmpty(weightField) || isNotNum(weightField)) {
		alert("weight ?");
		return false;
	}
	if (isEmpty(photoField) || 
			(isNotType(photoField, "png") && isNotType(photoField, "gif"))) {
			alert("photo ?");
			return false;
	}
		
	return true;
}