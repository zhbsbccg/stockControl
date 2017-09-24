/**
 * 
 */
$(function() {
	var containerHeight = $("#pjax-container").height();
	$("#mainIframe").height(containerHeight - 100);
	
});

function toPage(url) {
	$("#mainIframe").attr("src", url);
}