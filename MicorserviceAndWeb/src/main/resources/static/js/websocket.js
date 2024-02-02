

    var websocket = null;

    //判断当前浏览器是否支持WebSocket
    if('WebSocket' in window){
    websocket = new WebSocket("ws://localhost:8080/websocket");
}else{
    alert('Not support websocket')
}

    //连接发生错误的回调方法
    websocket.onerror = function(){
    setMessageInnerHTML("发生错误");
};

    //连接成功建立的回调方法
    websocket.onopen = function(event){
    setMessageInnerHTML("Establishing the connection");
}

    //接收到消息的回调方法
    websocket.onmessage = function(event){
    console.log(event.data)
    setMessageInnerHTML(event.data);
    $(".progress-bar").attr("style","width:"+event.data+"%")
}

    //连接关闭的回调方法
    websocket.onclose = function(){
    setMessageInnerHTML("Close the connection");
}

    //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
    window.onbeforeunload = function(){
    alert("已关闭连接");
    websocket.close();
}

    //将消息显示在网页上
    function setMessageInnerHTML(innerHTML){
    document.getElementById('message').innerHTML = innerHTML + '<br/>';
}

    //关闭连接
    function closeWebSocket(){
    alert("已关闭连接");
    websocket.close();
}
    //开始
    $("#btn").click(function(){
    $.ajax({
        url: "http://localhost:8080/picture/send",
        type:'post',
        success: function(HTML) {//返回页面内容
            console.log(HTML);
        }
    });
})
