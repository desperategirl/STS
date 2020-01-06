<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<style>
	.modal {
		display: none;
		display: 
		position: fixed;
		z-index: 10;
		left: 0;
		top: 0;
		width: 100%;
		height: 100%;
		background-color: rgba(0, 0, 0, 0, 4);
	}
	
	span.modal-close{
		color: white;
		float: right;
		font-size: 30px;
		font-weigth: bold;
	}
	
	span.modal-close:hover{
		color: #000;
		cursor: pointer;
	}
	
	.modal form {
		position: relative;
		width: ;
		padding: 10px;
		border: 1px solid #888;
		margin: auto;
		background-color: #fefefe;
		
		animation-name: form-ani;
		animation-duration: 0.9s;
		animation-fill-mode: forwards;
		
		/* 구글, 사파리 */
		-webkit-animation-name: form-ani;
		-webkit-animation-duration: 0.9s;
		-webkit-animation-fill-mode: forwards;
		
		/* 파이어폭스 */
		-moz-animation-name: form-ani;
		-moz-animation-duration: 0.9s;
		-moz-animation-fill-mode: forwards;
		
		/* 익스플로러 */
		animation-name: form-ani;
		animation-duration: 0.9s;
		animation-fill-mode: forwards;
		
		/* 오페라 */
		animation-name: form-ani;
		animation-duration: 0.9s;
		animation-fill-mode: forwards;
		
	}
</style>
<script type="text/javascript">
	$(function(){
		$("span.modal-close").click(function(){
			$("#myModal").css("display","none")
		})
	})
</script>
<div id="myModal" class="modal">
	<div>
		<span class="modal-close">&times;</span>
	</div>
</div>