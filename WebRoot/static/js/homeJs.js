$(document).ready(function() {
	$('#btn_search').click(function() {
		var keyword = $('#keyword').value;
		location.href = "Search?keyword=" + keyword;
	});
	
	$('#btn-search-head').click(function() {
		var keyword = $('#keyword-head').value;
		location.href = "DetailsSearch?keyword=" + keyword;
	});
});