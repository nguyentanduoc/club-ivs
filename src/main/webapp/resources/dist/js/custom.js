$(document).ready(function(){
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
			
	});
});