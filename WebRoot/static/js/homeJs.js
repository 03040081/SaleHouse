$(document).ready(function() {
	$('#btn_search').click(function() {
		var keyword = document.getElementById("keyword").value;
		location.href = "Search?keyword=" + keyword;
	});
	
	$('#btn-search-head').click(function() {
		var keyword = document.getElementById("keyword-head").value;
		location.href = "DetailsSearch?keyword=" + keyword;
	});
});