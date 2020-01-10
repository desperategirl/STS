<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<head>
	<title>독서록 HOME</title>
	
<script src="http://code.jquery.com/jquery-latest.min.js"></script> 
<!-- include summernote css/js -->

<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-lite.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-lite.js"></script>
<script src="${rootPath}/javascript/summernote-ko-KR.js" type="text/javascript"></script>

<link href="https://cdnjs.cloudflare.com/ajax/libs/jquery-contextmenu/2.9.0/jquery.contextMenu.min.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-contextmenu/2.9.0/jquery.contextMenu.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-contextmenu/2.9.0/jquery.ui.position.min.js"></script>

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">

	

<style>
	* {
		margin:0px;
		padding:0px;
	}
	
	title {
		color : red;
	}
</style>

<script>
	$(function(){
		
		
		
	})
</script>

</head>
<body>
<h1>
	나만의 독서록을 기록할 수 있는 웹 어플리케이션 서비스 ♡ ○ º＊─.
</h1>

<P>이 곳은 독서록 WAS 홈페이지 입니다. </P>

<p>도서 목록을 선택하면 수정과 삭제를 할 수 있습니다.</p>

<a href="${rootPath}/insert"><button>새로운 도서목록을 추가하려면 여기를 누르세요.</button></a>
<a href="${rootPath}/login"><button>로그인</button></a>
<a href="${rootPath}/logout"><button>로그아웃</button></a>
<a href="${rootPath}/join"><button>회원가입</button></a>
<a href="${rootPath}/join"><button>독서록 작성</button></a>
<table>
      <tr>
         <th>NO</th>
         <th>도서제목</th>
         <th>저자</th>
         <th>출판사</th>
         <th>페이지수</th>
         <th>구입가격</th>
      </tr>
      <c:choose>
         <c:when test="${empty booksSelectAll}">
            <tr>
               <td colspan="6">책 정보가 없음</td>
         </c:when>
         <c:otherwise>
            <c:forEach items="${booksSelectAll}" var="book" varStatus="index">
               <tr class="content-body" data-id="${book.b_code}"
                  data-auth="${book.b_auther}">
                  <td>${index.count}</td>
                  <td>${book.b_name}</td>
                  <td>${book.b_auther}</td>
                  <td>${book.b_comp}</td>
                  <td>${book.b_year}</td>
                  <td>${book.b_iprice}</td>
               </tr>
            </c:forEach>
         </c:otherwise>
      </c:choose>
</table>
	


</body>
</html>
