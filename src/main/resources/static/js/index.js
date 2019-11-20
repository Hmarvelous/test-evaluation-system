$(function(){
	
	// 获取全部试卷信息
	getAllPapers();

	
	// 开始答题按钮点击事件
	$(document).on('click', 'button.start-answer-button', function(){
		var paperId = $(this).attr('data-paper-id');
		
		// 跳转页面
		$(window).attr('location', '/answer?id=' + paperId);
	});
	
	
	// 继续作答按钮单击事件
	$(document).on('click', 'div.processing>button', function(){
		var paperId = $(this).attr('data-paper-id');
		$(window).attr('location', '/answer?id=' + paperId);
	});
});


// 获取全部试卷信息
function getAllPapers(){
	$.get('/papers', function(json){
		var paperArea = $('div.paper-area');
		// 遍历试卷信息
		$.each(json, function(i, n){
			// 添加试卷项
			var html = analysisPaper(n);
			paperArea.append(html);
		});
		
		// 获取正在作答试卷ID
		getPaper();
	}, 'json');
}


// 获取正在作答的试卷ID
function getPaper(){
	$.get('/getPaper', function(data){
		if (data == 0){
			return;
		}
		// 获取试卷名称
		var paperName = $('div.paper-bottom>button[data-paper-id=' + data + ']').parent('div.paper-bottom').prev('span.paper-title').text();
		var html = '<div class="processing">';
		html += '<span>正在作答《' + paperName + '》</span>';
		html += '<button data-paper-id="' + data + '">继续作答</button>';
		html += '</div>';
		$('div.show-user-area').after(html);
	});
}


// 解析试卷
function analysisPaper(paper){
	html = '';
	html += '<div class="paper-item">';
	html += '<span class="paper-title">' + paper.name + '</span>';
	html += '<div class="paper-bottom">';
	html += '<span>共&nbsp;' + paper.count + '&nbsp;题</span>';
	html += '<button class="start-answer-button" data-paper-id="' + paper.id + '">开始答题</button>';
	html += '</div>';
	html += '</div>';
	return html;
}