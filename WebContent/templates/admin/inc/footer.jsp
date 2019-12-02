<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
</div>
<!-- /. WRAPPER  -->
<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
<!-- JQUERY -->
<script src="<%=request.getContextPath()%>/templates/admin/assets/js/jquery-3.2.1.js"></script>
<!-- BOOTSTRAP SCRIPTS -->
<script src="<%=request.getContextPath()%>/templates/admin/assets/js/bootstrap.min.js"></script>
<!-- METISMENU SCRIPTS -->
<script src="<%=request.getContextPath()%>/templates/admin/assets/js/jquery.metisMenu.js"></script>
<!-- CUSTOM SCRIPTS -->
<script src="<%=request.getContextPath()%>/templates/admin/assets/js/custom.js"></script>
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
</body>
</html>