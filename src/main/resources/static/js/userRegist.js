/**
 * ユーザー登録
 */

// エラーメッセージ表示
function execute(){
	console.log("execute");
	var lnNode = document.querySelector('#lastName');
	var fnNode = document.querySelector('#firstName');
	var sexNode = document.querySelector('#sex');
	var birthNode = document.querySelector('#birthday');
	var telNode = document.querySelector('#tel');
	var mailNode = document.querySelector('#mail');
	var addressNode = document.querySelector('#address');
	
	console.log(lnNode.value);
	console.log(fnNode.value);
	console.log(sexNode.value);
	console.log(birthNode.value);
	console.log(telNode.value);
	console.log(mailNode.value);
	console.log(addressNode.value);
	
	var flg = true;
	var msg = '';


	if(!lnNode.value || !fnNode.value || !birthNode.value) {
		flg = false
		msg = '必須項目を入力して下さい';
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