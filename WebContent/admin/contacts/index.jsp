<%@page import="model.bean.Contacts"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/inc/header.jsp" %>
<%@ include file="/templates/admin/inc/leftbar.jsp" %>
<div id="page-wrapper">
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>Quản lý Liên Hệ</h2>
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
                                </div>
                                <div class="col-sm-6" style="text-align: right;">
                                    <form method="post" action="">
                                        <input type="submit" name="search" value="Tìm kiếm" class="btn btn-warning btn-sm" style="float:right" />
                                        <input type="search" class="form-control input-sm" placeholder="Nhập người dùng" style="float:right; width: 300px;" />
                                        <div style="clear:both"></div>
                                    </form><br />
                                </div>
                            </div>

                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Tên</th>
                                        <th>Email</th>
                                        <th>Website	</th>
                                        <th>Messages</th>
                                        <th width="100px">Chức năng</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <%if(request.getAttribute("alContacts")!=null){    
                                ArrayList<Contacts> alContacts = (ArrayList<Contacts>) request.getAttribute("alContacts");
                                for(Contacts objContacts : alContacts){
                                %>
                                    <tr>
                                    	<td><%=objContacts.getId()%></td>
                                        <td><%=objContacts.getName()%></td>
                                        <td><%=objContacts.getEmail()%></td>
                                        <td><%=objContacts.getWebsite()%></td>
                                        <td class="center"><%=objContacts.getMessage()%></td>                                    
                                        <td class="center">
                                            <a href="<%=request.getContextPath()%>/admin/contacts/delete?idContacts=<%=objContacts.getId()%>" title="" class="btn btn-danger"><i class="fa fa-pencil"></i> Xóa</a>
                                        </td>
                                    </tr>
								 <%  }} %>
                                </tbody>
                            </table>
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
<%@ include file="/templates/admin/inc/footer.jsp" %>