/**
 * 会議選択
 */

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

function isCheck() {
    let arr_checkBoxes = document.getElementsByClassName("meetingClass");
    let count = 0;
    for (let i = 0; i < arr_checkBoxes.length; i++) {
        if (arr_checkBoxes[i].checked) {
            count++;
        }
    }
    if (count > 0) {
        return true;
    } else {
        window.alert("会議を1つ以上選択してください。");
        return false;
    };
 
}