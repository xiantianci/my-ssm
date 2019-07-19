<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
$(function() {
	$.post("show",function(data){
		var result="";
		for(var i=0;i<data.length;i++){
			result+="<dl>";
			result+="<dt style=cursor:pointer>"+data[i].name+"</dt>";
			for(var j=0;j<data[i].list.length;j++){
				result+="<dd>"+data[i].list[j].name+"</dd>";
			}
			result+="</dl>";
		}
		$("body").html(result)
	});
	
	$("dt").live("click",function(){
		$(this).siblings().slideToggle(4000);
	})
})
</script>
</head>
<body>

</body>
</html>