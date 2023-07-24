/**
 * aside menu control을 위해 사용됨
 */
$(document).ready(function() {
	$('#stateMsgBtn').click(function(e) {	// 이벤트 등록
		$('#stateMsgInput').attr({'class': 'mt-2'});	// 입력창이 보이게 만듦
		$('#stateInput').attr({value: $('#stateMsg').text()});	// 입력창에 stateMsg 내용을 삽입
	});
	$('#stateMsgSubmit').click(changeStateMsg);	// onclick 이벤트등록을 여기서
});

function changeStateMsg() {
	$('#stateMsgInput').attr({'class': 'mt-2 d-none'});	// 입력창이 보이지 않게 만듦
	let stateInputVal = $('#stateInput').val();	// 입력한 입력값 받기
	$.ajax({	// ajax로 서버에 통신 타입은 겟방식으로
		type: 'GET',
		url: '/bbs/aside/stateMsg',
		data: {stateMsg: stateInputVal},
		success: function(e) {
			console.log('state message:', stateInputVal);
			$('#stateMsg').html(stateInputVal);
		}
	});
}