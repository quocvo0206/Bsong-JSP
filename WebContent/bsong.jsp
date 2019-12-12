<%@page import="model.bean.Song"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/public/inc/header.jsp" %>
<div>
	<script>
		window.location.replace("<%=request.getContextPath()%>/home/song");
	</script>
</div>
<%@ include file="/templates/public/inc/footer.jsp" %>
