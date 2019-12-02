<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/inc/header.jsp" %>
<%@ include file="/templates/admin/inc/leftbar.jsp" %>
<div id="page-wrapper">
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>TRANG QUẢN TRỊ VIÊN</h2>
            </div>
        </div>
        <!-- /. ROW  -->
        <hr />
        <div class="row">
            <div class="col-md-4 col-sm-4 col-xs-4">
                <div class="panel panel-back noti-box">
                    <span class="icon-box bg-color-green set-icon">
                    <i class="fa fa-bars"></i>
                </span>
                    <div class="text-box">
                        <p class="main-text"><a href="<%=request.getContextPath()%>/admin/cat" title="" style="font-size: 20px; text-decoration: none">Quản lý danh mục</a></p>
                   		<%if(request.getAttribute("countCategories")!=null){%>
                   			 <p class="text-muted"><%=request.getAttribute("countCategories")%></p>
                   		<%} else{%>
                   			 <p class="text-muted">Không có danh mục nào</p>
                   		<%}%>
                       
                    </div>
                </div>
            </div>
            <div class="col-md-4 col-sm-4 col-xs-4">
                <div class="panel panel-back noti-box">
                    <span class="icon-box bg-color-blue set-icon">
                    <i class="fa fa-bell-o"></i>
                </span>
                    <div class="text-box">
                        <p class="main-text"><a href="<%=request.getContextPath()%>/admin/song" title="" style="font-size: 20px; text-decoration: none" >Quản lý bài hát</a></p>
                        <%if(request.getAttribute("countSongs")!=null){%>
                   			 <p class="text-muted"><%=request.getAttribute("countSongs")%></p>
                   		<%} else{%>
                   			 <p class="text-muted">Không có bài hát nào</p>
                   		<%}%>
                    </div>
                </div>
            </div>
            <div class="col-md-4 col-sm-4 col-xs-4">
                <div class="panel panel-back noti-box">
                    <span class="icon-box bg-color-brown set-icon">
                    <i class="fa fa-rocket"></i>
                </span>
                    <div class="text-box">
                        <p class="main-text"><a href="<%=request.getContextPath()%>/admin/user" title="" style="font-size: 20px; text-decoration: none" >Quản lý người dùng</a></p>
                       	  <%if(request.getAttribute("countUsers")!=null){%>
                   			 <p class="text-muted"><%=request.getAttribute("countUsers")%></p>
                   		<%} else{%>
                   			 <p class="text-muted">Không có người dùng nào</p>
                   		<%}%>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
<script>
    document.getElementById("index").classList.add('active-menu');
</script>
<!-- /. PAGE WRAPPER  -->
<%@ include file="/templates/admin/inc/footer.jsp" %>