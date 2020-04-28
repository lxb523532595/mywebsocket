<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>单页聊天</title>
    <%--<link href="/css/index.css" rel="stylesheet" />--%>
    <%@include file="common/common.jsp"%>
    <script src="js/index.js"></script>
    <style >
        #message{
            margin-top:40px;
            border:1px solid gray;
            padding:20px;
        }
    </style>
</head>
<body>
<button onclick="connectWebSocket()">连接WebSocket</button>
<button onclick="closeWebSocket()">断开连接</button>
<hr />
<br />
消息：<input id="text" type="text" />
<button onclick="send()">发送消息</button>
<div id="message"></div>
</body>
</html>