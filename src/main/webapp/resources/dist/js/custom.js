//<--xoa dau utf8
xoa_dau = function xoa_dau(str) {
    str = str.replace(/à|á|ạ|ả|ã|â|ầ|ấ|ậ|ẩ|ẫ|ă|ằ|ắ|ặ|ẳ|ẵ/g, "a");
    str = str.replace(/è|é|ẹ|ẻ|ẽ|ê|ề|ế|ệ|ể|ễ/g, "e");
    str = str.replace(/ì|í|ị|ỉ|ĩ/g, "i");
    str = str.replace(/ò|ó|ọ|ỏ|õ|ô|ồ|ố|ộ|ổ|ỗ|ơ|ờ|ớ|ợ|ở|ỡ/g, "o");
    str = str.replace(/ù|ú|ụ|ủ|ũ|ư|ừ|ứ|ự|ử|ữ/g, "u");
    str = str.replace(/ỳ|ý|ỵ|ỷ|ỹ/g, "y");
    str = str.replace(/đ/g, "d");
    str = str.replace(/À|Á|Ạ|Ả|Ã|Â|Ầ|Ấ|Ậ|Ẩ|Ẫ|Ă|Ằ|Ắ|Ặ|Ẳ|Ẵ/g, "A");
    str = str.replace(/È|É|Ẹ|Ẻ|Ẽ|Ê|Ề|Ế|Ệ|Ể|Ễ/g, "E");
    str = str.replace(/Ì|Í|Ị|Ỉ|Ĩ/g, "I");
    str = str.replace(/Ò|Ó|Ọ|Ỏ|Õ|Ô|Ồ|Ố|Ộ|Ổ|Ỗ|Ơ|Ờ|Ớ|Ợ|Ở|Ỡ/g, "O");
    str = str.replace(/Ù|Ú|Ụ|Ủ|Ũ|Ư|Ừ|Ứ|Ự|Ử|Ữ/g, "U");
    str = str.replace(/Ỳ|Ý|Ỵ|Ỷ|Ỹ/g, "Y");
    str = str.replace(/Đ/g, "D");
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
$(document).ready(function(){
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
				type:"POST",
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
	//delete Branch
	$(".deleteBranch").click(function(){
		var r = confirm("Bạn thật sự muốn xoá?");
		if(r){
			var self = $(this);
			var id = $(this).attr('data-id');
			$.ajax({
				url:"/Club-IVS/api/deleteBranch",
				type:"POST",
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
	})
	$(".editBranch").click(function(){
		$("#memberEditBranch").empty();
		var id = $(this).attr('data-id');
		$.ajax({
			url:"/Club-IVS/api/getBranchById",
			type:"POST",
			data:{
				id:id
			},
			success:function(data){
				if(data.status==200){
					var view="";
					$("#idEditBranch").val(data.branch.idBranch);
					$("#nameEditBranch").val(data.branch.nameBranch);
					$("#addressEditBranch").val(data.branch.addressBranch);					
					if(data.branch.member!=null){
						$.each(data.members, function (index, row) {						
							if(row.idMember==data.branch.member.idMember){
								 view += "<option value='" + row.idMember + "' selected>" + row.nameMember + " - " + row.userNameMember + "</option>";
							}else{
								view += "<option value='" + row.idMember + "'>" + row.nameMember + "-" + row.userNameMember + "</option>";
							}                       
	                    })
					}else{
						view += "<option value='0'>---Chọn Nhân Viên---</option>";   
						$.each(data.members, function (index, row) {
							view += "<option value='" + row.idMember + "'>" + row.nameMember + "-" + row.userNameMember + "</option>";             
	                    })
					}					
                    $("#memberEditBranch").append(view);
				}else{
					$("errorGetRole").append("Xảy ra lỗi khi lấy dữ liệu!");
				}
			}
		})	
	})	
	$("#saveChangeBranch").click(function(){		
		var err=false;
		var id = $("#idEditBranch").val();
		var nameBranch =$("#nameEditBranch").val();
		var addressBranch= $("#addressEditBranch").val();
		var member= $("#memberEditBranch").val();
		
		$("#errMemberEditBranch").empty();
		$("#errNameEditBranch").empty();
		$("#errAddressEditBranch").empty();
		if(member==0){			
			err = true;
			$("#errMemberEditBranch").append("Chọn nhân viên!");
		}
		if(nameBranch==""){			
			err = true;
			$("#errNameEditBranch").append("Nhập tên chi nhánh");
		}
		if(addressBranch==""){
			err = true;
			$("#errAddressEditBranch").append("Nhập tên chi nhánh");
		}	
		console.log(addressBranch);
		if(err==false){
			$.ajax({
				url:"/Club-IVS/api/saveChangeBranch",
				type:"POST",
				data:{
					"idBranch":id,
					"nameBranch":nameBranch,
					"addressBranch":addressBranch,
					"member.IdMember":member
				},
				success:function(data){
					if(data.status==200){					
						location.reload();
					}else{
						$("errorGetRole").append("Xảy ra lỗi khi lưu!");
					}					
				}
			});
		}
	});
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
					id:id
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
					id:id
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
			url : "/Club-IVS/member/check",
			data : {
				name : strin,
			},
			success : function(data) {
				if(data.status=="200"){
					 $("#userNameMember").addClass("is-invalid");
					 $(".nameMemberErro").append("Trùng tên với một người nào đó!");
					 $("#userNameMember").removeAttr("readonly");
				}else{
					 $("#userNameMember").removeClass("is-invalid");
					 $("#userNameMember").attr("readonly","true");
				}
			}
		});
	 }
	$("#nameMember").blur(function(){
		var name = $("#nameMember").val();		
		var name =  name.trim().replace(/\s+/g, " ");
		if(name!=""){
			$("#nameMember").val(name);
			var arr = name.split(" ");
			var text = "";
			var lenght = arr.length;
			  for (var i = 0; i < lenght -1 ; i++) {
			     text += arr[i].slice(0,1);
			  }
			 text += xoa_dau(arr[lenght-1]);
			 text = text.toLowerCase();
			 text +="@gmail.com";
			 $("#userNameMember").val(text); 

			 var pass = "abc123";
			 /*var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
			 for (var i = 0; i < 8; i++)
				  pass += possible.charAt(Math.floor(Math.random() * possible.length));*/
			 $("#passWordMember").val(pass);		 
			 			 
			 docheck(text);	
			 
			 $("#userNameMember").blur(function(){
				 var email = $("#userNameMember").val();
				 docheck(email);
			 })
		}
		
	});//end member
	//club
	$(".editClub").click(function(){
		var id = $(this).attr('data-id');
		$("#memberEditClub").empty();
		$("#branchEditClub").empty();
		var viewMember, viewBranch;
		$.ajax({
			type : "POST",
			url : "/Club-IVS/api/getClubById",
			data : {
				id:id
			},
			success : function(data) {
				if(data.status==200){
					$("#idEditClub").val(data.club.idClub);
					$("#nameEditClub").val(data.club.nameClub);
					$.each(data.members, function (index, row) {
						if(row.idMember==data.club.member.idMember){
							viewMember += "<option value='" + row.idMember + "' selected>" + row.nameMember + " - " + row.userNameMember + "</option>";
						}else{
							viewMember += "<option value='" + row.idMember + "'>" + row.nameMember + "-" + row.userNameMember + "</option>";
						}                        
                    })
                    $("#memberEditClub").append(viewMember);
					$.each(data.branchs, function (index, row) {
						if(row.idBranch==data.club.branch.idBranch){
							viewBranch += "<option value='" + row.idBranch + "' selected>" + row.nameBranch + "</option>";
						}else{
							viewBranch += "<option value='" + row.idBranch + "'>" + row.nameBranch + "</option>";
						}                        
                    })
                    $("#branchEditClub").append(viewBranch);
				}else{
					
				}
			}
		});
	});
	$("#saveChangeClub").click(function(){
		$("#errorEditClub").empty();
		var id = $("#idEditClub").val();
		var name = $("#nameEditClub").val();
		var idMember = $("#memberEditClub").val();
		var idBranch = $("#branchEditClub").val();
		$.ajax({
			url:"/Club-IVS/api/saveChangeClub",
			type:"POST",
			data:{
				"idClub":id,
				"nameClub":name,
				"member.idMember":idMember,
				"branch.idBranch":idBranch
			},
			success:function(data){
				if(data.status==200){					
					location.reload();
				}else{
					$("#errorEditClub").append("Xẫy ra lỗi khi lưu!");
				}
				
			}
		});		
	});
	$(".deleteClub").click(function(){
		var id = $(this).attr('data-id');
		var r = confirm("Bạn thật sự muốn xoá?");
		if(r){
			$.ajax({
				url:"/Club-IVS/api/deleteClub",
				type:"POST",
				data:{
					"idClub":id,				
				},
				success:function(data){
					if(data.status==200){					
						location.reload();
					}else{
						
					}
					
				}
			});		
		}		
	})//end club
	
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
				alert("tao hk biet");
				$( "#tick" ).removeAttr( "onclick" );
				$( "#tick" ).attr( "onclick",  "myFunction("+idMember+","+idTrain+","+attendance+")");
			}else{
				
			}
			
		}
	});		
	}