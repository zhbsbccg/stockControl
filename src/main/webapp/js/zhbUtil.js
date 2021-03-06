/**
 * 
 */
(function($) {
	$.extend({
		
		
		
		/**
		 * json数据发送
		 */
		postJson: function(url, data, successFun, jsonErrorFun, errorFun, completeFun, async) {
			return $.ajax({
		  		 type: "POST",
		         url: url,
		         contentType: "application/json;charset=utf-8",
		         data: JSON.stringify(data),
		         dataType: "json",
		         async: arguments.length == 6 ? async: true,
		         success: function(data) {
		        	 if(data.errorNum > 0) {
		        		 if(!jsonErrorFun ){
		        			 alert(data.errorMessage);
		        		 } else {
		        			 jsonErrorFun(data);
		        		 }
		        	 } else {
		        		 if(successFun) {
		        			 successFun(data);
		        		 }
		        	 }
		         },
		         error: errorFun,
		         complete: completeFun
		  	});
		},
		postJsonSync: function(url, data, successFun, errorFun, completeFun) {
			return this.postJson(url, data, successFun, errorFun, completeFun, false);
		}
	});
	
	
	$.fn.formToJson = function() {
		var datas = $(this).serialize();
		console.log(datas);
		datas = decodeURIComponent(datas);
		var jsonData = {};
		if(datas){
			var dataArr = datas.split("&");
			$.each(dataArr, function() {
				var　this_arr = this.split("=");
				jsonData[this_arr[0]] = this_arr[1];
			});
		}
		return jsonData;
	}
	
})(jQuery);
/**
 * 表格检查工具
 */
var formCheck = {
	formRequired : function(form) {
		
		
	}
		
		
}



var usersUtil = {
		currentUser: {},
		/**
		 * 从session拿到当前用户数据
		 */
		getCurrentUser: function() {
			if(!usersUtil.currentUser.id) {
				$.postJsonSync("/getCurrentUser.action", {}, function(data) {
					if(data && data.errorNum == 0) {
						usersUtil.currentUser = data.response;
					} else {
						window.location.href= "/in.action";
					}
				});
			}
			return usersUtil.currentUser;
		}
}