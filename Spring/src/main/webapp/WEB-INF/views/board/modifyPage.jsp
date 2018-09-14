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
					<input type="hidden" name="page" value="${criteria.page}" >
					<input type="hidden" name="perPageNum" value="${criteria.perPageNum}" >
					
				<div class="box-body">
					<div class="form-group">
						<label for="exampleInputEmail1">BNO</label> <input type="text"
							name='bno' class="form-control" value="${boardVO.bno}"
							readonly="readonly">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Title</label> <input type="text"
							name='title' class="form-control" value="${boardVO.title}">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Content</label>
						<textarea class="form-control" name="content" rows="3">${boardVO.content}</textarea>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Writer</label> <input type="text"
							name="writer" class="form-control" value="${boardVO.writer}">
					</div>
				</div>
				<!-- /.box-body -->
		
				<div class="box-footer">
					<button type="submit" class="btn btn-primary" id="">SAVE</button>
					<button type="submit" class="btn btn-warning" id="">CANCEL</button>
				</div>
            </form>
			</div>
			<!-- /.box -->
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->

<script>		
$(document).ready(function(){
	var formObj = $("form[role='form']");
	console.log(formObj); // (크롬)웹브라우저 개발자도구 콘솔창에서 로그 확인 
	
	$(".btn-primary").on("click", function(){     // 수정버튼 클릭  
		formObj.submit();                           
	});
	
	$(".btn-warning").on("click", function(){     // 취소버튼 클릭
		self.location = "/board/listPage?page=${criteria.page}&perPageNum=${criteria.perPageNum}";		
	});
});

</script>

<%@include file="../include/footer.jsp"%>