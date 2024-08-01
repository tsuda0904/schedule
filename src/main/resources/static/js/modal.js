/**
 * モーダル
 */

// ボタンがクリックされたとき
function modalOpen() {
	const modal = document.getElementById('easyModal');
	modal.style.display = 'block';
}

//バツ印がクリックされたとき
function modalClose() {
	const modal = document.getElementById('easyModal');
	modal.style.display = 'none';
}