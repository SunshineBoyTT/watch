/**
 * Created by dxn on 2017/6/19.
 */
$(function () {
    connect();
});
/**
 * 服务器监控
 */
// function display_baoxiu_count(content){
//     var
// }
function display_list(content) {
    var cpu_info_list = content.cpu_info_list;
    var html = '';
    $.each(cpu_info_list,function(index,item){
        html += item.CpuName;
        html += item.CpuUseRate;//使用率

    })
    $('#cpu_info').html(html);
}
function connect() {

    if ('WebSocket' in window) {

        ipAddress = document.location.hostname;
        ws = new WebSocket("ws://" + ipAddress + ipPort + ctx+"/handle");

    } else {

        ws = new SockJS("http://" + ipAddress + ipPort + ctx+"/sockjs");

    }

    ws.onopen = function() {
    };
    ws.onmessage = function(event) {
//		alert(event.data);
        var res = eval('(' + event.data + ')');
        // display_baoxiu_count(res.list_day_report_by_hour);

        display_list(res);

    };
    ws.onclose = function(event) {
        //TODO:关闭连接
    };
}

//断开websocket连接
function disconnect() {
    if (ws != null) {
        ws.close();
        ws = null;
    }
}
