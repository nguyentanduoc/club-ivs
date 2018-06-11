<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- jQuery -->
<script src="<c:url value ="/resources/plugins/jquery/jquery.min.js"/>"></script>
<!-- jQuery UI 1.11.4 -->
<script src="<c:url value ="/resources/plugins/jquery/jquery-ui.min.js"/>"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button)
</script>
<!-- Bootstrap 4 -->
<script src="<c:url value ="/resources/plugins/bootstrap/js/bootstrap.bundle.min.js"/>"></script>
<!-- Morris.js charts -->
<script src="<c:url value = "/resources/plugins/raphael/raphael-min.js"/>"></script>
<script src="<c:url value = "/resources/plugins/morris/morris.min.js"/>"></script>
<!-- Sparkline -->
<script src="<c:url value = "/resources/plugins/sparkline/jquery.sparkline.min.js"/>"></script>

<!-- jQuery Knob Chart -->
<script src="<c:url value = "/resources/plugins/knob/jquery.knob.js"/>"></script>
<!-- daterangepicker -->
<script src="<c:url value = "/resources/plugins/moment/moment.min.js"/>"></script>
<script src="<c:url value = "/resources/plugins/daterangepicker/daterangepicker.js"/>"></script>
<!-- datepicker -->
<script src="<c:url value = "/resources/plugins/datepicker/bootstrap-datepicker.js"/>"></script>
<!-- Bootstrap WYSIHTML5 -->
<script src="<c:url value = "/resources/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"/>"></script>
<!-- Slimscroll -->
<script src="<c:url value = "/resources/plugins/slimScroll/jquery.slimscroll.min.js"/>"></script>
<!-- FastClick -->
<script src="<c:url value = "/resources/plugins/fastclick/fastclick.js"/>"></script>
<!-- AdminLTE App -->
<script src="<c:url value = "/resources/dist/js/adminlte.js"/>"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<!-- custom js -->
<script src="<c:url value ="/resources/dist/js/custom.js"/>"></script>