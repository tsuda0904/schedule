function getValue() {
	var checks = document.getElementsByClassName('checks');
	var str = '';
	
	for (i = 0; i < 6; i++) {
		if (checks[i].checked === true) {
			str += checks[i].value + "";
		}
	}
	alert(str);
}