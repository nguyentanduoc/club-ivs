<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${title}</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Font Awesome -->
<link rel="stylesheet" href="<c:url value="/resources/plugins/font-awesome/css/font-awesome.min.css"/>">
<!-- Ionicons -->
<link rel="stylesheet" href='<c:url value="/resources/plugins/ionicons/ionicons.min.css"/>'>
<!-- DataTables -->
<link rel="stylesheet" href='<c:url value="/resources/plugins/datatables/dataTables.bootstrap4.min.css"/>'>
<!-- Theme style -->
<link rel="stylesheet" href="<c:url value="/resources/dist/css/adminlte.min.css"/>">
<!-- Bootstrap Color Picker -->
<link rel="stylesheet" href="<c:url value="/resources/plugins/colorpicker/bootstrap-colorpicker.min.css"/>">
<!-- Bootstrap time Picker -->
<link rel="stylesheet" href="<c:url value="/resources/plugins/timepicker/bootstrap-timepicker.min.css"/>">
<!-- Select2 -->
<link rel="stylesheet"  href="<c:url value="/resources/plugins/select2/select2.min.css"/>"> 
<!-- Bootstrap time Picker -->
<link rel="stylesheet" href="<c:url value="/resources/dist/css/style.css"/>">
<!-- iCheck for checkboxes and radio inputs -->
<link rel="stylesheet" href="<c:url value="/resources/plugins/iCheck/all.css"/>">
<!-- Date Picker -->
<link rel="stylesheet" href="<c:url value="/resources/plugins/datepicker/datepicker3.css"/>">
<!-- Daterange picker -->
<link rel="stylesheet" href="<c:url value="/resources/plugins/daterangepicker/daterangepicker-bs3.css"/>">
<!-- bootstrap wysihtml5 - text editor -->
<link rel="stylesheet" href="<c:url value="/resources/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css"/>">
<!-- Google Font: Source Sans Pro -->
<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
<meta name="_csrf" content="${_csrf.token}" />
<!-- default header name is X-CSRF-TOKEN -->
<meta name="_csrf_header" content="${_csrf.headerName}" /> 