$(function(){
    $('.table-box tr').on({
		mouseover : function(){
			$(this).css('background-color', '#EEE');
		},
		mouseout : function(){
			$(this).css('background-color', '#FFF');
		} 
	});
    
    
    // 分页点击事件
    $(document).on('click', 'div.pagination-box>div>ul>li', function(){
    	if ($(this).is('.pagination-disable') || $(this).is('.pagination-selected')){
    		return;
    	}
    	
    	// 获取参数
    	var page = $(this).attr('data-page');
    	var size = 20;
    	
    	pageJump(page, size);
    });
    
    
    // 删除按钮
    $(document).on('click', 'button.delete-button', function(){
    	var transcriptId = parseInt($(this).attr('data-transcript-id'));
    	var tr = $(this).parent('td').parent('tr');
    	$.post('/transcript/delete', {
    		id: transcriptId
    	}, function(json){
    		if ($.trim(json.result) == 'success'){
    			// 删除对应项
    			tr.remove();
    			
    			// 判断是否还有数据
    			var count = 0;
    			$.each($('div.table-box tr'), function(i, n){
    				count++;
    			});
    			if (count == 1){
    				var page = $('div.pagination-box>div>ul>li.pagination-selected').attr('data-page');
    				// 没有数据，跳转到上一页
    				if ((page - 1) <= 0){
    					page = 1;
    				} else {
    					page -= 1;
    				}
    				pageJump(page, 20);
    			}
    		}
    	}, 'json');
    });
});


// 分页跳转
function pageJump(page,size){
	// 构造URL
	var url = '/transcript?page=' + page + '&size=' + size;
	$(window).attr('location', url);
}