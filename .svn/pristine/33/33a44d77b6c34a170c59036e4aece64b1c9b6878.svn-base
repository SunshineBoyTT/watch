//计数参数
var count = 0;

$(function() {
	 initData();
	 loadIndex(1);
})

/** 函数区域 */
function loadIndex(id) {
	if (count != 0) {
		// 判断之前socket连接是否存在,假如存在先清空
		disconnect();
	}
	count += 1;
	$("#content").html("");
	$("#content").load('index?id=' + id);
}


function initData() {
	$.ajax({
		type : "GET",
		url : "monitor/list",
		data : {},
		async: false,
		dataType : "json",
		success : function(data) {
			if (data.code == 100) {
				console.log(data.list);
				var html = "<li class='sidebar-brand'><a href='#'>杭州华舰</a></li>";
				$.each(data.list, function(index, item) {
					html += "<li class='closeTT'><a href='#' onclick='loadIndex(" + item.tbmId + ")'><i></i>"
							+ item.tbmName + " </a></li>";
				})
				$("#sidebar-wrapper ul").html(html);
			} else {
				alert(data.message);
			}
		}
	});

}

