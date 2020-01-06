<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 홈페이지</title>
<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
<script>
	$(function(){
		
		$("#login").click(function(){
			
			$("#mymodal").css("display","block")
		})
	})
</script>
<style>
   * {
      margin:0;
      padding:0;
      box-sizing: border-box;
    }
    
    header {
       padding:2rem 1rem;
       margin-bottom:2rem;
       background-color: #E9ECEF;
       border-radius: 0.3rem;
    }
    
    table {
       border-collapse: collapse;
       width:95%;
       margin: 0 auto;
       border : 1px solid gray;
    }
    
    table.input tr, table.input td, table.input th {
		padding: 10px;
    }
    
    table.list tr, table.list td, table.list th {
    	border : 1px solid gray;
    }
    
    /* line-through : 취소선 */
    .line-through {
    	text-decoration: line-through;
    }
   
</style>

</head>
<body>
<header>
<nav>
	<ul>
		<li id="login">login</li>
	</ul>
</nav>
	<h3>TO DO LIST</h3>
</header>
<section>
	<article id="input">
		<form method="POST">
			<input type="hidden" name="td_seq" 
				value='<c:out value="${todoDTO.td_seq}"
				default="0"/>'>
			<input type="hidden" name="td_complete" value="${todoDTO.td_complete}">
			<input type="hidden" name="td_date" value="${todoDTO.td_date}">
			<input type="hidden" name="td_time" value="${todoDTO.td_time}">
			<table class="input">
				<tr>
					<th>작성일</th>
					<td><input type="date" name="tdDate"></td>
					<th>작성시각</th>
					<td><input type="time" name="tdTime"></td>
				</tr>
				
				<tr>
					<th>할 일</th>
					<td>
						<label for="td_flag">중요도</label>
						<input id="tdFlag" type="number" 
						value="<c:out var="${todoDTO.td_flag}" default="1"/>"
						min="1" max="5" name="td_flag">
					</td>
				
					<td>
						<input type="text" value="${todoDTO.td_subject}" name="td_subject">
					</td>
					
					<td>
						<input type="checkbox" id="tdAlarm" name="td_alarm" 
						
						<c:if test="${todoDTO.td_alarm == 'Y'}">
							checked="checked"
						</c:if>
						
						value="Y">
						<label for="td_alarm">알람설정</label>
					</td>
					
					<td>
						<button>저장</button>
						<a href="${rootPath}/">새로작성</a>
					</td>
				</tr>
			</table>
		</form>
	</article>
	
	<article id="list">
		<c:if test="${!empty todoList}">
		<table class="list">
			<tr>
				<th>Flag</th>
				<th>제목</th>
				<th>완성</th>
				<th>알람</th>
				<th>명령</th>
			</tr>
			
			<c:forEach items="${todoList}" var="todo" varStatus="index">
				<tr>
					<td>${index.index}</td>
					<td>${todo.tdFlag}</td>
					<td <c:if test="${todo.tdComplete == 'Y'}" class="line-through"</c:if>>${todo.tdSubject}</td>
					
					<td><a href="#{rootPath}/complete?tdSeq=${todo.tdSeq}">${todo.tdComplete}</a></td>
						
					<td>${todo.tdComplete}</td>
					<td>${todo.tdAlarm}</td>
					
					<td>	
					<a href="${rootPath}/update?tdSeq=${todo.tdSeq}">수정</a>
					<a href="${rootPath}/delete?tdSeq=${todo.tdSeq}">삭제</a>
					</td>
				</tr>	
			</c:forEach>
			
		</table>
		</c:if>
	</article>
</section>
<%@ include file="/WEB-INF/views/modal-box.jsp" %>
</body>
</html>