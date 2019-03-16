<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%> <!--  이거 false로 되면 session을 이 페이지에서 사용할 수 없다. -->

<%@include file="../include/header.jsp"%>

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->

			<div class="box">
			<div class="box-header with-border">
					<h3 class="box-title">Search PAGE</h3>
				</div>
				<div class="box-body">
				
					<select name="searchType" id="searchType">
						<option value="title">제목</option>
						<option value="writer">작성자</option>
					</select>
					<input type="text" name="searchKeyword" id="searchKeyword">
					<button id = "searchBtn" class="btn btn-xs">Search</button>
					<button id = "newBtn" class="btn btn-xs">New Board</button>
					
				</div>
			</div>
				
			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">LIST ALL PAGE</h3>
				</div>
				<div class="box-body">
				
<table class="table table-bordered">
	<tr>
		<th style="width: 10px">BNO</th>
		<th>TITLE</th>
		<th>WRITER</th>
		<th>REGDATE</th>
		<th style="width: 40px">VIEWCNT</th>
	</tr>

<tbody id="tbody">
<c:forEach items="${list}" var="boardVO">

	<tr>
		<td>${boardVO.seq}</td>
		<td><a href=''>${boardVO.title}</a></td>
		<td>${boardVO.writer}</td>
		<td>${boardVO.regdate}</td>
		<td><span class="badge bg-red">${boardVO.cnt }</span></td>
	</tr>

</c:forEach>
</tbody>

</table>

				</div>
				<!-- /.box-body -->
				<div class="box-footer">Footer</div>
				<!-- /.box-footer-->
			</div>
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<script>
    /* 
    var result = '${msg}';
    
    if(result == 'SUCCESS'){
    	alert("처리가 완료되었습니다.");
    }
     */
     
     $(document).ready(function(){
    	 $("#searchBtn").click(function(){
    		$.ajax({
    			url : "search.do",
    			type : "post",
    			data : {searchType:$("#searchType").val(), searchKeyword :$("#searchKeyword").val()},
    			dataType : "json",
    			success : function(ary){
    				var txt = "";
    				$("#tbody").empty(txt);
    				$.each(ary, function(idx, obj){
    					txt += "<tr><td>"+obj.seq+"</td>" ;
    					
    					txt += "<td><a href=javascript:showModal('"+obj.title+"')>"+obj.title+"</td>" ;
    					txt += "<td>"+obj.writer+"</td>" ;
    					txt += "<td>"+obj.regdate+"</td>" ;
    					txt += "<td>"+obj.cnt+"</td></tr>" ;
    				});
    				
    				$("#tbody").append(txt);
    			}
    		}) 
    	 });
    	 
    	 $("#newBtn").click(function(){
    		location.href="register.do"; 
    	 });
     });
     
     function showModal(seq){
    	 alert(seq);
     }
     
    </script>

<%@include file="../include/footer.jsp"%>
