<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/inc/header.jsp" %>
<%@ include file="/templates/admin/inc/leftbar.jsp" %>
<div id="page-wrapper">
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>Thêm Người Dùng</h2>
            </div>
        </div>
        <!-- /. ROW  -->
        <hr />
        <div class="row">
            <div class="col-md-12">
                <!-- Form Elements -->
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-12">
                                <form role="form" method="post"  id="form" action="<%=request.getContextPath()%>/admin/user/add">
                                    <div class="form-group">
                                        <label for="name">Username</label>
                                        <input type="text" id="name" value="" name="username" class="form-control" style="width:500px"/>
                                    </div>
                                 	<div class="form-group">
                                        <label for="name">Password</label>
                                        <input type="text" id="name" value="" name="password" class="form-control" style="width:500px"/>
                                    </div>
                                   	<div class="form-group">
                                        <label for="name">Fullname</label>
                                        <input type="text" id="name" value="" name="fullname" class="form-control" style="width:500px"/>
                                    </div>
                                    <input type="submit" name="submit" class="btn btn-success btn-md" value="Add"></input>
                                    <button type="reset" class="btn btn-success btn-md">Reset</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- End Form Elements -->
            </div>
        </div>
        <!-- /. ROW  -->
    </div>
    <!-- /. PAGE INNER  -->
</div>
<script>
    document.getElementById("song").classList.add('active-menu');
</script>
<!-- /. PAGE WRAPPER  -->
<%@ include file="/templates/admin/inc/footer.jsp" %>