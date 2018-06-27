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
<!-- DataTables -->
<script src="<c:url value ="/resources/plugins/datatables/jquery.dataTables.min.js"/>"></script>
<script src="<c:url value ="/resources/plugins/datatables/dataTables.bootstrap4.min.js"/>"></script>
<!-- Select2 -->
<script src="<c:url value = "/resources/plugins/select2/select2.full.min.js"/>"></script>


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

<!-- bootstrap color picker -->
<script src="<c:url value = "/resources/plugins/colorpicker/bootstrap-colorpicker.min.js"/>"></script>
<!-- bootstrap time picker -->
<script src="<c:url value = "/resources/plugins/timepicker/bootstrap-timepicker.min.js"/>"></script>

<!-- Bootstrap WYSIHTML5 -->
<script src="<c:url value = "/resources/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"/>"></script>
<!-- Slimscroll -->
<script src="<c:url value = "/resources/plugins/slimScroll/jquery.slimscroll.min.js"/>"></script>
<!-- iCheck 1.0.1 -->
<script src="<c:url value = "/resources/plugins/iCheck/icheck.min.js"/>"></script>
<!-- FastClick -->
<script src="<c:url value = "/resources/plugins/fastclick/fastclick.js"/>"></script>
<!-- AdminLTE App -->
<script src="<c:url value = "/resources/dist/js/adminlte.js"/>"></script>

<!-- AdminLTE dashboard demo (This is only for demo purposes) -->

<script>
  $(function () {
	  	$("#example1").DataTable();
	    $('#example2').DataTable({
	      "paging": false,
	      "lengthChange": false,
	      "searching": false,
	      "ordering": true,
	      "info": true,
	      "autoWidth": false
	    });
	    $('.datepicker').datepicker();
	   //month
	  $(".month-piker").datepicker( {			  
		  	update: new Date(),
		    format: "mm-yyyy",
		    viewMode: "months", 
		    minViewMode: "months"
		});
	  $('.month-piker').datepicker('update', new Date());
    //Initialize Select2 Elements
    $('.select2').select2();

    //Datemask dd/mm/yyyy
    //$('#datemask').inputmask('dd/mm/yyyy', { 'placeholder': 'dd/mm/yyyy' })
    //Datemask2 mm/dd/yyyy
   // $('#datemask2').inputmask('mm/dd/yyyy', { 'placeholder': 'mm/dd/yyyy' })
    //Money Euro
    //$('[data-mask]').inputmask() */

    $('.datepicker').datepicker();
    //Date range picker
    $('#reservation').daterangepicker()
    //Date range picker with time picker
    $('#reservationtime').daterangepicker({
      timePicker         : true,
      timePickerIncrement: 30,
      format             : 'MM/DD/YYYY h:mm A'
    })
    //Date range as a button
    $('#daterange-btn').daterangepicker(
      {
        ranges   : {
          'Today'       : [moment(), moment()],
          'Yesterday'   : [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
          'Last 7 Days' : [moment().subtract(6, 'days'), moment()],
          'Last 30 Days': [moment().subtract(29, 'days'), moment()],
          'This Month'  : [moment().startOf('month'), moment().endOf('month')],
          'Last Month'  : [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
        },
        startDate: moment().subtract(29, 'days'),
        endDate  : moment()
      },
      function (start, end) {
        $('#reportrange span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'))
      }
    )

    //iCheck for checkbox and radio inputs
    $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
      checkboxClass: 'icheckbox_minimal-blue',
      radioClass   : 'iradio_minimal-blue'
    })
    //Red color scheme for iCheck
    $('input[type="checkbox"].minimal-red, input[type="radio"].minimal-red').iCheck({
      checkboxClass: 'icheckbox_minimal-red',
      radioClass   : 'iradio_minimal-red'
    })
    //Flat red color scheme for iCheck
    $('input[type="checkbox"].flat-red, input[type="radio"].flat-red').iCheck({
      checkboxClass: 'icheckbox_flat-green',
      radioClass   : 'iradio_flat-green'
    })

    //Colorpicker
    $('.my-colorpicker1').colorpicker()
    //color picker with addon
    $('.my-colorpicker2').colorpicker()

    //Timepicker
    $('.timepicker').timepicker({
      showInputs: false
    })
 });
</script>
<!-- custom js -->
<script src="<c:url value ="/resources/dist/js/custom.js"/>"></script>
