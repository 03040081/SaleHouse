$(document).ready(function() {
	$('#btn_search').click(function() {
		var keyword = document.getElementById('keyword').value;
		location.href = "Search?keyword=" + keyword;
	});
});