$(document).ready(function() {
	$('#btn_search').click(function() {
		var keyword = document.getElementById('keyword').value;
		if (keyword != null && keyword != "")
			location.href = "Search?keyword=" + keyword;
	});
});