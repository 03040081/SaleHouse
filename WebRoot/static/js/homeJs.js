$(document).ready(function() {
	$('#btn_search').click(function() {
		var keyword = document.getElementById('condition').value;
		if (keyword != null && keyword != "")
			location.href = "Search?condition=" + keyword;
	});
});