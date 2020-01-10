<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서목록 생성 페이지</title>
</head>
<body>
<h3>추가할 도서의 정보를 입력하세요.</h3>
	<form method="POST">
	
		<input type="text" name="b_code" placeholder="도서코드">
		<input type="text" name="b_name" placeholder="도서명">
		<input type="text" name="b_auther" placeholder="저자">
		<input type="text" name="b_comp" placeholder="출판사">
	    <input type="text" name="b_year" placeholder="구입일자">
		<input type="number" name="b_iprice" placeholder="구입가격, 숫자로 입력하세요">
		
		<button>저장</button>								
	</form>
</body>
</html>