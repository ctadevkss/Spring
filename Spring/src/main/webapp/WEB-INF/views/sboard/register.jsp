<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<!-- Main content -->
<section class="content">
	<div class="row">	
		<div class="col-md-12">	
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">REGISTER BOARD</h3>
				</div>		

				<form role="form" method="post" id="registForm">
					<div class="box-body">
						<div class="form-group">
							<label for="exampleInputEmail1">Title</label> <input type="text"
								name='title' class="form-control" placeholder="Enter Title">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Content</label>
							<textarea class="form-control" name="content" rows="3"
								placeholder="Enter ..."></textarea>
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Writer</label> <input type="text"
								name="writer" class="form-control" placeholder="Enter Writer">
						</div>
					</div>
					<!-- /.box-body -->

					<div class="box-footer">
						<button type="submit" class="btn btn-primary">Submit</button>
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
<!-- /.content-wrapper -->

<script>

$(document).ready(function(){

	$("#registForm").validate({
		rules: {
			title: {
				required: true,
				minlength: 2
			},
			content: {
				required: true,
				minlength: 2
			}
		},
		messages: {
			title: {
				required: "2글자 이상 입력하세요.",
				minlength: "Title must consist of at least 2 characters"
			},
			content: {
				required: "2글자 이상 입력하세요.",
				minlength: "Title must consist of at least 2 characters"
			}
			
		}
	
	});
	
});
</script>


<%@include file="../include/footer.jsp"%>
