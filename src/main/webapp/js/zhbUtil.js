/**
 * 
 */
(function($) {
	$.extend({
		postJson: function(url, data, successFun, errorFun, completeFun) {
			$.ajax({
		  		 type: "POST",
		         url: url,
		         contentType: "application/json;charset=utf-8",
		         data: JSON.stringify(data),
		         dataType: "json",
		         success: successFun,
		         error: errorFun,
		         complete: completeFun
		  	});
		}
	});
})(jQuery);