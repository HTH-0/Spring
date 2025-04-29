<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>/file/list</h1>
	<div>UPLOAD DIR : ${uploadPath}</div>
	<c:forEach items='${uploadPath.listFiles()}' var='subdir'>
		<hr />
		FOLDER : ${subdir.getPath()}
		
		<c:forEach items='${subdir.listFiles()}' var='file'>
			<br />
		- FILE : ${file.getPath()}
	

		</c:forEach>

	</c:forEach>

</body>
</html>