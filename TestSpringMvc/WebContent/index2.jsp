<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="download?filename=github.txt" >xiazai</a>

<form action="upload" enctype="multipart/form-data" method="post">
	姓名<input type="text" name="name"> <br/>
	文件<input type="file" name="file"> <br/>
	<input type="submit" value="提交"/>
</form>
</body>
</html>