$(function(){

    // 登录按钮点击事件
    $('div.login-button>button').click(function(){
        // 效验输入正确性
//    	if (!loginEvent()){
//    		return;
//    	}

    	// 请求登录
    	loginRequest();
    });
    
    
    // 密码输入框回车事件
    $('div.input-box>input[type=password]').on('keypress',function(event){ 
    	// 效验输入正确性
    	if(event.keyCode == 13) {  
        	if (!loginEvent()){
        		return;
        	}
        	
        	// 请求登录
        	loginRequest();
        }  
   });
});



// 登录事件
function loginEvent(){
	var $this = $('div.login-button>button');
    // 获取参数
    var username = $('div.input-box>input[type=text]').val();
    var password = $('div.input-box>input[type=password]').val();

    if (username == ''){
        $(this).text('请输入用户名');
        $(this).css('background-color', '#FF0033');
        var t = setInterval(function(){
            $this.text('登录');
            $this.css('background-color', '#FF6600');
            clearInterval(t);
        }, 2000);
        return false;
    }
    if (password == ''){
        $(this).text('请输入密码');
        $(this).css('background-color', '#FF0033');
        var t = setInterval(function(){
            $this.text('登录');
            $this.css('background-color', '#FF6600');
            clearInterval(t);
        }, 2000);
        return false;
    }
    
    return true;
}


// 登录请求
function loginRequest(){
	// 获取参数
    var username = $('div.input-box>input[type=text]').val();
    var password = $('div.input-box>input[type=password]').val();
	
    $.post('/doLogin', {
    	username: username,
    	password: password
    }, function(json){
    	if ($.trim(json.result) == 'success'){
    		$(window).attr('location', '/index');
    	} else {
    		alert(json.result);
    	}
    }, 'json');
}
