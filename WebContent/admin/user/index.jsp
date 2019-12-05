<%@page import="model.bean.Users"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/inc/header.jsp"%>
<%@ include file="/templates/admin/inc/leftbar.jsp"%>
<div id="page-wrapper">
	<div id="page-inner">
		<div class="row">
			<div class="col-md-12">
				<h2>Quản Lý Người Dùng</h2>
			</div>
		</div>
		<!-- /. ROW  -->
		<hr />
		<div class="row">
			<div class="col-md-12">
				<!-- Advanced Tables -->
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="table-responsive">
							<div class="row">
								<div class="col-sm-6">
									<a href="<%=request.getContextPath()%>/admin/user/add"
										class="btn btn-success btn-md">Thêm</a>
								</div>
								<div class="col-sm-6" style="text-align: right;">
									<form method="post">
										<input type="submit" name="search" value="Tìm kiếm"
											class="btn btn-warning btn-sm" style="float: right" /> <input
											type="search" class="form-control input-sm"
											placeholder="Nhập người dùng"
											style="float: right; width: 300px;" />
										<div style="clear: both"></div>
									</form>
									<br />
								</div>
							</div>
							<form id="form_id" method="post" action="">
								<table class="table table-striped table-bordered table-hover"
									id="dataTables-example">
									<thead>
										<tr>
											<th>ID</th>
											<th>Tên Người Dùng</th>
											<th>Full Name</th>
											<th width="160px">Chức năng</th>
										</tr>
									</thead>
									<tbody>
										<%if(request.getAttribute("alUsers")!=null){    
	                                ArrayList<Users> alUsers = (ArrayList<Users>) request.getAttribute("alUsers");
	                                for(Users objUsers : alUsers){
	                                %>
										<tr>
											<td><%=objUsers.getId()%></td>
											<td><%=objUsers.getUserName()%></td>
											<td class="center"><%=objUsers.getFullName()%></td>
											<td class="center"><a href="" title=""
												class="btn btn-primary"><i class="fa fa-edit "></i> Sửa</a>
												<button name="id" title="" value="<%=objUsers.getId()%>"
													class="btn btn-danger">
													<i class="fa fa-pencil"></i> Xóa
												</button></td>
										</tr>
										<%  }} %>
									</tbody>
								</table>
							</form>
						</div>
					</div>
				</div>
				<!--End Advanced Tables -->
			</div>
		</div>
	</div>
</div>
<script>
    document.getElementById("song").classList.add('active-menu');
</script>
<!-- /. PAGE INNER  -->
<%@ include file="/templates/admin/inc/footer.jsp"%>
<script>
$(".btn-danger").on("click", function(e){
	var result = confirm("Do you want delete it.");
	var URL = "<%=request.getContextPath()%>/admin/user/deletes";
	if(result == true){
		$('#form_id').attr('action', URL).submit();
	} else{
		return false;
	}
});
</script>

