<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<h2>Hello World!</h2>
</body>
<form id="fileupload"  action="/fileupload2.htm" method="post" enctype="multipart/form-data">

    <div><input type="file" name="file"/></div>

    <div><input type="file" name="file2"/></div>

    <div><input type="submit" value="上传"/></div>
</form>
</html>
