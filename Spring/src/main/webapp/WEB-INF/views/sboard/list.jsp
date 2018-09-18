<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
    
<%@include file="../include/header.jsp"%>

				<div class="box-header with-border">
					<h3 class="box-title">LIST PAGING</h3> &nbsp;
<%-- 					
					<select name="${criteria.perPageNum}" id="perPageNumCnt">
						<option value="10"
					        <c:out value="${criteria.perPageNum == 10 ?'selected':''}"></c:out>>10 개씩보기
						</option>
						<option value="20"
						    <c:out value="${criteria.perPageNum == 20 ?'selected':''}"></c:out>>20 개씩보기
						</option>
						<option value="30"
						    <c:out value="${criteria.perPageNum == 30 ?'selected':''}"></c:out>>30 개씩보기
						</option>
						<option value="50"
							<c:out value="${criteria.perPageNum == 50 ?'selected':''}"></c:out>>50 개씩보기
						</option>
						<option value="100"
							<c:out value="${criteria.perPageNum == 100 ?'selected':''}"></c:out>>100 개씩보기
						</option>
					</select>
					 --%>
				</div>
				<div class="box-body">
				
					<select name="searchType">
						<option value="n"
							<c:out value="${criteria.searchType==null?'selected':''}"/>>---------------------------------
						</option>
						<option value="t"
							<c:out value="${criteria.searchType eq 't'?'selected':''}"/>>Title
						</option>						
						<option value="c"
							<c:out value="${criteria.searchType eq 'c'?'selected':''}"/>>Content
						</option>
						<option value="w"
							<c:out value="${criteria.searchType eq 'w'?'selected':''}"/>>Writer
						</option>	
						<option value="tc"
							<c:out value="${criteria.searchType eq 'tc'?'selected':''}"/>>Title OR Content
						</option>
						<option value="cw"
							<c:out value="${criteria.searchType eq 'cw'?'selected':''}"/>>Content OR Writer
						</option>
						<option value="tcw"
							<c:out value="${criteria.searchType eq 'tcw'?'selected':''}"/>>Title OR Content OR Writer
						</option>																														
					</select>
					<input type="text" name="keyword" id="keywordInput" value="${criteria.keyword}">
					<button id="searchBtn">Search</button>
				    <button id="newBtn">NewBoard</button>
				
					<table class="table table-bordered">
						<tr>
							<th style="width: 10px">BNO</th>
							<th>TITLE</th>
							<th>WRITER</th>
							<th>REGDATE</th>
							<th style="width: 40px">VIEWCNT</th>
						</tr>

						<c:forEach items="${list}" var="boardVO">
							<tr>
								<td>${boardVO.bno}</td>
								<td><a href='/sboard/readPage${pageMaker.makeParameter(pageMaker.criteria.page)}&bno=${boardVO.bno}'>${boardVO.title}</a></td>
								<td>${boardVO.writer}</td>
								<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
								                    value="${boardVO.regdate}" /></td>
								<td><span class="badge bg-red">${boardVO.viewcnt}</span></td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<!-- /.box-body -->
			
<div class="box-footer">
	<div class="text-center">
		<ul class="pagination">
			<c:if test="${pageMaker.prev}">							
				<li><a href="list${pageMaker.makeParameter(pageMaker.startPage-1)}">&laquo;</a></li>
			</c:if>
			<c:forEach begin="${pageMaker.startPage }" 
			           end="${pageMaker.endPage }" var="idx">
				<li
					<c:out value="${pageMaker.criteria.page == idx?'class =active':''}"/>>							
					<a href="list${pageMaker.makeParameter(idx)}">${idx}</a>	         
				</li>
		   </c:forEach>
		   <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
			  <li>
			    <a href="list${pageMaker.makeParameter(pageMaker.endPage +1)}">
			             &raquo;</a>
			  </li>
			</c:if>
         </ul>
	  </div>
</div>
<!-- /.box-footer-->				
		
				
				
<%@include file="../include/footer.jsp"%>

<script>
$(document).ready(function() {

	$('#searchBtn').on("click",function(event) {
		self.location = "list?"
			//+ '${pageMaker.makeParameter(1)}'
			+ "page=1&perPageNum=${criteria.perPageNum}"
			+ "&searchType="
			+ $("select option:selected").val() // t,c,w,tc,cw,tcw
			+ "&keyword="
			+ $('#keywordInput').val();          // 검색어
	});
	
	$('#newBtn').on("click", function(event) {
		self.location = "register";
	});
			
	/* 	
	$('#perPageNumCnt').on('change', function(event) {
		 self.location = "list" +"?perPageNum=" 
				 + $("select option:selected").val();
	});
	 */
	var result = '${result}';     // var result = 'success';
	
	if(result == 'success') 
	{
		alert("처리 되었습니다.");
	}
});
</script>















