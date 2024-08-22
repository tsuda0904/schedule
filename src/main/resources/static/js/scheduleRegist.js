/**
 * スケジュール登録
 */

// エラーメッセージ表示
function execute(){
	console.log("execute");
	var meetingdayNode = document.querySelector('#meetingday');
	var meetingtimeNode = document.querySelector('#meetingtime');
	var meetingNode = document.querySelector('#meeting');
	var mnNode = document.querySelector('#meetingName');
	var placeNode = document.querySelector('#place');
	
	console.log(meetingdayNode.value);
	console.log(meetingtimeNode.value);
	console.log(meetingNode.value);
	console.log(mnNode.value);
	console.log(placeNode.value);
	
	var flg = true;
	var msg = '';
	
	if(!placeNode.value) {
		flg = false
		msg = '場所が入力されていません';
	}
	
	if(!mnNode.value) {
		flg = false
		msg = '議題が入力されていません';
	}

	if(!meetingNode.value) {
		flg = false
		msg = '会議が選択されていません';
	}
	
	if(!meetingtimeNode.value) {
		flg = false
		msg = '時間が入力されていません';
	}
			
		
	if(!meetingdayNode.value) {
		flg = false
		msg = '日付が入力されていません';
	}
	
	
	if (flg){
		var result = confirm('登録処理を実行します');
		if (result) {
			document.registform.submit();
		}
	}else{
		alert(msg);
	}

}

// キャンセル
function cancelClick(){
	history.back();
}