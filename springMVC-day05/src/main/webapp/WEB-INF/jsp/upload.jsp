<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/4/6
  Time: 9:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>文件上传</title>
</head>
<body>
<form id="uploadForm" enctype="multipart/form-data" action="/file/upload" method="post">
    <input type="file" id="fileInput" name="filename">
    <button type="submit">上传</button>
</form>

<%--<script>--%>
<%--    var form = document.getElementById('uploadForm');--%>
<%--    var fileInput = document.getElementById('fileInput');--%>

<%--    form.addEventListener('submit', function(e) {--%>
<%--        e.preventDefault();--%>
<%--        var file = fileInput.files[0];--%>
<%--        var xhr = new XMLHttpRequest();--%>
<%--        xhr.open('POST', '/upload');--%>
<%--        xhr.setRequestHeader('Content-Type', 'application/octet-stream');--%>
<%--        xhr.onreadystatechange = function() {--%>
<%--            if (xhr.readyState === 4) {--%>
<%--                if (xhr.status === 200) {--%>
<%--                    console.log(xhr.responseText);--%>
<%--                    alert('上传成功！');--%>
<%--                } else {--%>
<%--                    alert('上传失败！');--%>
<%--                }--%>
<%--            }--%>
<%--        };--%>
<%--        xhr.send(file);--%>
<%--    });--%>
<%--</script>--%>
</body>
</html>