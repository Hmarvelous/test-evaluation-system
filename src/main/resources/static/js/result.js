$(function(){
	
	// 遍历答题卡
	$.each($('div.result-area>ul>li'), function(i, n){
		var status = $(n).attr('data-status');
		if (status == 'true'){
			// 已做答
			$(n).addClass('correct');
		} else if (status == 'false'){
			$(n).addClass('error');
		}
	});
});