<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/inc/header.jsp" %>
<%@ include file="/templates/admin/inc/leftbar.jsp" %>
<div id="page-wrapper">
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>Quản lý bài hát</h2>
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
                                    <a href="<%=request.getContextPath()%>/admin/song/add" class="btn btn-success btn-md">Thêm</a>
                                </div>
                                <div class="col-sm-6" style="text-align: right;">
                                    <form method="post" action="">
                                        <input type="submit" name="search" value="Tìm kiếm" class="btn btn-warning btn-sm" style="float:right" />
                                        <input type="search" class="form-control input-sm" placeholder="Nhập tên bài hát" style="float:right; width: 300px;" />
                                        <div style="clear:both"></div>
                                    </form><br />
                                </div>
                            </div>
							<form id="form_id" method="post" action="<%=request.getContextPath()%>/admin/song/delete">
                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Tên bài hát</th>
                                        <th>Danh mục</th>
                                        <th>Lượt đọc</th>
                                        <th>Hình ảnh</th>
                                        <th width="160px">Chức năng</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <%if(request.getAttribute("alSong")!=null){
                                	ArrayList<Song> alSong = (ArrayList<Song>)request.getAttribute("alSong");
                                	for(Song objSong : alSong){ %>
                                	
                                    <tr>
                                        <td><%=objSong.getId()%></td>
                                        <td class="center"><%=objSong.getName() %></td>
                                        <td class="center"><%=objSong.getObjCat().getName()%></td>
                                        <td class="center"><%=objSong.getCounter()%></td>
                                        <td class="center">
											<img width="200px" height="200px" src="<%=request.getContextPath()%>/uploads/<%=objSong.getPicture()%>"/>
                                        </td>
                                        <td class="center">
                                            <a href="" title="" class="btn btn-primary"><i class="fa fa-edit "></i> Sửa</a>
                                            <button name="id" title="" value="<%=objSong.getId()%>" class="btn btn-danger"><i class="fa fa-pencil"></i> Xóa</button>
                                         </td>
                                    </tr>
                                    <%}} %>
                                </tbody>
                            </table>
                            </form>
                            <div class="row">
                                <div class="col-sm-6">
                                    <div class="dataTables_info" id="dataTables-example_info" style="margin-top:27px">Hiển thị từ 1 đến 5 của 24 truyện</div>
                                </div>
                                <div class="col-sm-6" style="text-align: right;">
                                    <div class="dataTables_paginate paging_simple_numbers" id="dataTables-example_paginate">
                                        <ul class="pagination">
                                            <li class="paginate_button previous disabled" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_previous"><a href="#">Trang trước</a></li>
                                            <%int page1 = (Integer)request.getAttribute("page"); %>
                                            <%int number = (Integer)request.getAttribute("numberPage");%>
                                            <%for(int i = 1; i <= number; i++){ %>
                                            <li class="paginate_button <%if(page1==i){%>active<%}%>" aria-controls="dataTables-example" tabindex="0"><a href="<%=request.getContextPath()%>/admin/song?page=<%=i%>"><%=i%></a></li>
                                            <%} %>
                                            <li class="paginate_button next" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_next"><a href="#">Trang tiếp</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
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