//<--xoa dau utf8

$(document).ready(function(){
	xoa_dau = function xoa_dau(str) {
		str = str.toLowerCase();
	    str = str.replace(/à|á|ạ|ả|ã|â|ầ|ấ|ậ|ẩ|ẫ|ă|ằ|ắ|ặ|ẳ|ẵ/gi, "a")
	    .replace(/è|é|ẹ|ẻ|ẽ|ê|ề|ế|ệ|ể|ễ/gi, "e")
	    .replace(/ì|í|ị|ỉ|ĩ/gi, "i")
	    .replace(/ò|ó|ọ|ỏ|õ|ô|ồ|ố|ộ|ổ|ỗ|ơ|ờ|ớ|ợ|ở|ỡ/gi, "o")
	    .replace(/ù|ú|ụ|ủ|ũ|ư|ừ|ứ|ự|ử|ữ/gi, "u")
	    .replace(/ỳ|ý|ỵ|ỷ|ỹ/gi, "y")
	    .replace(/đ/gi, "d")
	    .replace(/^\-+|\-+$/gi, "");
	    return str;
	}
	//xoa dau utf8-->
	date = function  date(input){
		var date = new Date(parseInt(input));
		var dd = date.getDate();
		var mm = date.getMonth()+1;
		var yyyy = date.getFullYear();
		if(dd<10){
		    dd='0'+dd;
		} 
		if(mm<10){
		    mm='0'+mm;
		} 
		return dd+'/'+mm+'/'+yyyy;
	}
	$(function () {
		var token = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");
		$(document).ajaxSend(function(e, xhr, options) {
			xhr.setRequestHeader(header, token);
		});
	});
	//delete role
	$(".deleteRole").click(function(){
		var r = confirm("Bạn thật sự muốn xoá?");
		if(r){
			var self = $(this);
			var id = $(this).attr('data-id');
			$.ajax({
				url:"/Club-IVS/api/deleteRole",
				type:"GET",
				data:{
					id:id
				},
				success:function(data){
						if(data="true"){
						self.closest("tr").remove();
					}	
				}
			})	
		}			
	});// end delete role
	
	//modal edit role
	$(".editRole").click(function(){
		var id = $(this).attr('data-id');
		$.ajax({
			url:"/Club-IVS/api/getRoleById",
			type:"POST",
			data:{
				id:id
			},
			success:function(data){				
				if(data.status==200){
					$("#nameEditRole").val(data.role.nameRole);
					$("#codeEditRole").val(data.role.codeRole);
					$("#idEditRole").val(id);					
				}else{
					$("errorGetRole").append("Xảy ra lỗi khi lấy dữ liệu!");
				}
			}
		})	
	});//end modal edit role
	
	//start change role
	$("#saveChangeRole").click(function(){
		var id  = $("#idEditRole").val();
		var name = $("#nameEditRole").val();		
		var code = $("#codeEditRole").val();
		$.ajax({
			url:"/Club-IVS/api/saveChangeRole",
			type:"POST",
			data:{
				idRole:id,
				nameRole:name,
				codeRole:code
			},
			success:function(data){
				if(data.status==200){					
					location.reload();
				}else{
					$("errorGetRole").append("Xảy ra lỗi khi lưu!");
				}
				
			}
		})	
	})//end change role
	
	//delete Dow
	$(".deleteDow").click(function(){
		var r = confirm("Bạn thật sự muốn xoá?");
		if(r){
			var self = $(this);
			var id = $(this).attr('data-id');
			$.ajax({
				url:"/Club-IVS/api/deleteDow",
				type:"GET",
				data:{
					id:id
				},
				success:function(data){
					if(data="true"){
						self.closest("tr").remove();
					}
				}
			})	
		}	
	})// end delete Dow
	//script schedule
	$(".deleteSchedule").click(function(){
		var r = confirm("Bạn thật sự muốn xoá?");
		if(r){
			var self = $(this);
			var id = $(this).attr('data-id');
			$.ajax({
				url:"/Club-IVS/api/deleteSchedule",
				type:"GET",
				data:{
					idSchedule:id
				},
				success:function(data){
					if(data="true"){
						self.closest("tr").remove();
					}	
				}
			})	
		}
			
	});
});
//
$(document).ready(function(){
	$(".deleteTrain").click(function(){
		var r = confirm("Bạn thật sự muốn xoá?");
		if(r){
			var self = $(this);
			var id = $(this).attr('data-id');
			$.ajax({
				url:"/Club-IVS/api/deleteTrain",
				type:"GET",
				data:{
					idTrain:id
				},
				success:function(data){
					if(data="true"){
						self.closest("tr").remove();
					}	
				}
			})	
		}
			
	});
	//member	
	function docheck(strin){ 
		$(".nameMemberErro").html("");
		$.ajax({
			type : "POST",
			url : "/Club-IVS/api/checkMember",
			data : {
				name : strin,
			},
			success : function(data) {
				if(data.status=="200"){
					 $("#userNameMember").addClass("is-invalid");
					 $(".nameMemberErro").append("Trùng tên với một người nào đó!");
				}else{
					 $("#userNameMember").removeClass("is-invalid");
				}
			}
		});
	 }
	$("#nameMember").blur(function(){
		var name = $("#nameMember").val();		
		if(name!=""){	
			var out="";					
			$.ajax({
				type : "POST",
				url : "/Club-IVS/api/VNI",
				data : {
					text : name,
				},
				success : function(data) {
					out=data.text;
					var arr = out.split(" ");	
					var text = "";
					var lenght = arr.length;
					  for (var i = 0; i < lenght -1 ; i++) {
					     text += arr[i].slice(0,1);
					  }
					 text += arr[lenght-1];
					 text = text.toLowerCase();
					 text +="@gmail.com";
					 $("#userNameMember").val(text);
					 var pass = "abc123";
					 $("#passWordMember").val(pass); 
					 docheck(text);	
					 $("#userNameMember").blur(function(){
						 var email = $("#userNameMember").val();
						docheck(email);
					 })
				}
			});
		}
		
	});//end member
	
	
	//attendence
	$(".diemdanh").click(function(){
		$("#ListAttendace").empty();
		var view;
		var id = $(this).attr('data-id');
		$.ajax({
			url:"/Club-IVS/api/getJoinClubByTrain",
			type:"POST",
			data:{
				"idTrain":id,				
			},
			success:function(data){
				if(data.status==200){					
					$.each(data.listJoinClubByClub, function (index, row) {
						
						if(row.attendance==true){
							view += "<tr>" +
							"<td>"+row.member.nameMember+"</td>" +
							"<td>"+row.member.sexMember+"</td>" +
							"<td>"+row.member.userNameMember+"</td>" +
							"<td>"+
									"<label class='switch' >"+
										 " <input id='tick' type='checkbox' checked onclick=myFunction("+row.attendanceID.idMember+","+row.attendanceID.idTrain+","+row.attendance+")>"+
										 " <span class='slider round'></span>"+
										"</label></td>" +
							"</tr>";
						}else{
							view += "<tr>" +
							"<td>"+row.member.nameMember+"</td>" +
							"<td>"+row.member.userNameMember+"</td>" +
							"<td>"+
									"<label class='switch' >"+
										 " <input id='tick' type='checkbox' onclick=myFunction("+row.attendanceID.idMember+","+row.attendanceID.idTrain+","+row.attendance+")>"+
										 " <span class='slider round'></span>"+
										"</label></td>" +
							"</tr>";
						}					
							
						})	
						$("#ListAttendace").append(view);
				}else{
					
				}
				console.log(data);
			}
		});		
	});
	
	//end
});
function myFunction(idMember, idTrain,attendance) {
	if(attendance==true){
		$("#tick").val(false);
		attendance=false
	}
	else{
		$("#tick").val(true);
		attendance=true
	}
	var inputTitle = $( "#tick" ).attr( "onclick" );
	$.ajax({
		url:"/Club-IVS/api/attendance",
		type:"POST",
		data:{
			"idMember":idMember,	
			"idTrain":idTrain,
			"attendance":attendance
		},
		success:function(data){
			console.log(data);
			if(data.status=="200"){	
				$( "#tick" ).removeAttr( "onclick" );
				$( "#tick" ).attr( "onclick",  "myFunction("+idMember+","+idTrain+","+attendance+")");
			}else{
				
			}
			
		}
	});		
	}