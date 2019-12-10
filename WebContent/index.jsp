<%@page import="model.bean.Song"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/public/inc/header.jsp" %>
<div class="content_resize">
  <div class="mainbar">
  <%ArrayList<Song> alSong = (ArrayList<Song>)request.getAttribute("alSong");%>
  <%for(Song song : alSong){%>
	  <div class="article">
      <h2><a href="" title="Đổi thay"><%=song.getName()%></a></h2>
      <p class="infopost">Ngày đăng: <%=song.getDateCreate()%> Lượt xem:<%=song.getCounter()%></p>
      <div class="clr"></div>
      <div class="img"><img src="<%=request.getContextPath()%>/uploads/<%=song.getPicture()%>" width="177" height="213" alt="Đổi thay" class="fl" /></div>
      <div class="post_content">
        <p><%=song.getDescription() %></p>
        <p class="spec"><a href="<%=request.getContextPath()%>/home/song?id<%=song.getId()%>" class="rm">Chi tiết &raquo;</a></p>
      </div>
      <div class="clr"></div>
    </div>
  <%}%>
    <p class="pages"><small><%=request.getAttribute("pageCurrent") %> of <%=request.getAttribute("numberPage")%></small>
    <%int numberPage = (Integer)request.getAttribute("numberPage");%>
    <%for(int i=1; i<=numberPage;i++){%>
    <a href="<%=request.getContextPath()%>/home/song?page=<%=i%>"><%=i%></a>
    <%}%>
  </div>
  <div class="sidebar">
      <%@ include file="/templates/public/inc/leftbar.jsp" %>
  </div>
  <div class="clr"></div>
</div>
<%@ include file="/templates/public/inc/footer.jsp" %>
