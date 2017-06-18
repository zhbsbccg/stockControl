/**
 * 
 */
(function($) {
	$.extend({
		postJson: function(url, data, successFun, errorFun, completeFun, async) {
			$.ajax({
		  		 type: "POST",
		         url: url,
		         contentType: "application/json;charset=utf-8",
		         data: JSON.stringify(data),
		         dataType: "json",
		         async: arguments.length == 6 ? async: true,
		         success: successFun,
		         error: errorFun,
		         complete: completeFun
		  	});
		},
		postJsonSync: function(url, data, successFun, errorFun, completeFun) {
			this.postJson(url, data, successFun, errorFun, completeFun, false);
		}
	});
})(jQuery);

var usersUtil = {
		/**
		 * 从session拿到当前用户数据
		 */
		getCurrentUser: function() {
			
		}
}