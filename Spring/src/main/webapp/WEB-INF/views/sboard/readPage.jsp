<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../include/header.jsp"%>

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">READ BOARD</h3>
				</div>
				<!-- /.box-header -->

                
				<form role="form" method="post">
					<input type='hidden' name='bno' value="${boardVO.bno}">
					<input type='hidden' name='page' value="${criteria.page}">
					<input type='hidden' name='perPageNum' value="${criteria.perPageNum}">
					<input type='hidden' name='searchType' value="${criteria.searchType}">
					<input type='hidden' name='keyword' value="${criteria.keyword}">
				</form>
 				<!-- 					
					게시글 번호 - bno ,	현재페이지 번호 - page, 데이터 갯수 - perPageNum
			     -->
				<div class="box-body">
					<div class="form-group">
						<label for="exampleInputEmail1">Title</label> <input type="text"
							name='title' class="form-control" value="${boardVO.title}"
							readonly="readonly">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Content</label>
						<textarea class="form-control" name="content" rows="3"
							readonly="readonly">${boardVO.content}</textarea>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Writer</label> <input type="text"
							name="writer" class="form-control" value="${boardVO.writer}"
							readonly="readonly">
					</div>
				</div>
				<!-- /.box-body -->

				<div class="box-footer">
					<button type="submit" class="btn btn-warning" id="modifyBtn">Modify</button>
					<button type="submit" class="btn btn-danger" id="removeBtn">REMOVE</button>
					<button type="submit" class="btn btn-primary" id="goListBtn">LIST ALL</button>
				</div>

			</div>
			<!-- /.box -->
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->

<div class="row">
	<div class="col-md-12">
		<div class="box box-success">
			<div class="box-header">
				<h3 class="box-title">ADD NEW REPLY</h3>
			</div>
			<div class="box-body">
				<label for="exampleInputEmail">Writer</label>
				<input class="form-control" 
				type="text" placeholder="USER ID" id="newReplyWriter">
				<label for="exampleInputEmail">Reply Text</label>
				<input class="form-control" type="text"
				placeholder="REPLY TEXT" id="newReplyText">
			</div>
			<div class="box-footer">
				<button type="submit" class="btn btn-primary" id="replyBtn">
				ADD REPLY</button>
			</div>
		</div>
	</div>
</div>

<!-- The time line -->
<ul class="timeline">
	<li class="time-label" id="repliesDiv">
		<span class="bg-green">Replies List</span>
	</li>
</ul>

<div class="text-center">
	<ul id="pagination" class="pagination pagination-sm no-margin">
	
	</ul>
</div>


<script id="template" type="text/x-handlebars-template">
	{{#each .}}
	<li class="replyLi" data-rno={{rno}}>
	<i class="fa fa-comments bg-blue"></i>
	 <div class="timeline-item">
       <span class="time">
		  <i class="fa fa-clock-o"></i>{{prettifyDate regdate}}
	   </span>
       <h3 class="timeline-header"><strong>{{rno}}</strong> -{{replyer}}</h3>
       <div class="timeline-body">{{replytext}}</div>
		<div class="timeline-footer">
			<a class="btn btn-primary btn-xs" data-toggle="modal" 
                      data-target="#modifyModal">Modify</a>
        </div>
       </div>
     </li>
	{{/each}}
</script>

<script>
	
	Handlebars.registerHelper("prettifyDate", function(timeValue){
		var dateObj = new Date(timeValue);
		var year = dateObj.getFullYear();
		var month = dateObj.getMonth() + 1;
		var date = dateObj.getDate();
		return year+"/"+month+"/"+date;
	});
	
	var printData = function(replyArr, target, templateObject) {
		var template = Handlebars.compile(templateObject.html());
		var html = template(replyArr);
		$(".replyLi").remove();
	}
	
</script>


<script>
	
	var bno = ${boardVO.bno};
	var replyPage = 1;
	
	function getPage(pageInfo) {
		$.getJSON(pageInfo, function(data){
				printData(data.list, $("#repliesDiv"), $("#template"));
				printPaging(data.pageMaker, $(".pagination"));
		});
	}
	
	var printPaging = function(pageMaker, target) {
		var str = "";
		
		if(pageMaker.prev){
			str += "<li><a href='"+(pageMaker.startPage - 1)+"'> << </a></li>";
		}
		
		for(var i=pageMaker.startPage, len=pageMaker.endPage; i<=len; i++){
			var strClass = pageMaker.criteria.page == i?'class=active':'';
			str += "<li " + strClass + "><a href='" + i +"'>" + i + "</a></li>"; 
		}
		
		if(pageMaker.next){
			str += "<li><a href='"+(pageMaker.endPage + 1)+"'> >> </a></li>";
		}
		
		target.html(str); // $(".pagination").html(str);
	}

</script>



<script>		
$(document).ready(function(){
	var formObj = $("form[role='form']");
	console.log(formObj); // (크롬)웹브라우저 개발자도구 콘솔창에서 로그 확인 
	
	$("#modifyBtn").on("click", function(){       // 수정버튼을 클릭했을때  
		formObj.attr("action", "/sboard/modifyPage");  // controller @RequestMapping(value = "/modify" 
		formObj.attr("method", "get");		      // , method = RequestMethod.GET)
		formObj.submit();                         // <input type='hidden' name='bno' value="${boardVO.bno}">
	});
	
	$("#removeBtn").on("click", function(){     
		formObj.attr("action", "/sboard/removePage");
		formObj.submit();
	});
	
	$("#goListBtn").on("click", function(){
		
		formObj.attr("method", "get");
		formObj.attr("action", "/sboard/list");
		formObj.submit();  
	});
	
	
	$("#repliesDiv").on("click", function(){
		
		if($(".timeline li").size() > 1) {
			return;
		}
		
		getPage("/replies/" + bno + "/1");
	});
	
	$("#pagination").on("click", "li a", function(event){
		
		event.preventDefault(); // 기존이벤트를 취소 
		
		replyPage = $(this).attr("href");
		getPage("/replies/"+bno+"/"+replyPage);
	});
	
});

</script>

<%@include file="../include/footer.jsp"%>