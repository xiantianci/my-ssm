<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
$(function(){
	$("a").click(function(){
		var $td=$(this).parrnt().prev();
		$td.html(parseInt($td.html())+1);
	})
})
</script>
</head>
<body>
<table border="1">
	<tr>
		<td>资源名称</td>
		<td>下载次数</td>
		<td>操作</td>
	</tr>
	<c:forEach items="${fileList }" var="file">
	<tr>
		<td>${file.path }</td>
		<td>${file.count }</td>
		<td><a href="uploadFile?id=${file.id}&name=${file.path}">下载</a></td>		
	</tr>
	</c:forEach>
</table>
</body>
</html>