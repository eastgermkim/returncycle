/**
 * deliver list에서 폼 자동 기입
 */

$(".list").each(function(){
		$(this).click(function(){
			/*var uid = $("input[name='a_uid']").val();*/
			var uid = $(this).attr("id");
			$.ajax({
				//받아온 var contextPath를 여기서 사용한다. AJAX는절대경로로 사용한다.
				url:contextPath + "/apply/ApplyGetDetailOk.ap?a_uid="+uid,
				dataType:"json",
				contentType : "application/json; charset:UTF-8",
				type:"get",
				success:function(data){
					if(data != null){
						/*console.log(data);
						console.log(data["a_id"]);
						console.log(uid);
						console.log("됨");*/
						$("#r_uid").val(data["a_uid"]);
						$("#r_wdate").val(data["a_wdate"]);
						$("#r_wtime").val(data["a_wtime"]);
						$("#r_id").val(data["a_id"]);
						$("#r_name").val(data["a_name"]);
						$("#r_phone").val(data["a_phone"]);
						$("#r_address").val(data["a_zipcode"]+" "+data["a_address"]+" "+data["a_address_detail"]);
						$("#r_request").val(data["a_request"]);
						$("#r_plastic").val(data["a_plastic"]);
						$("#r_vinyl").val(data["a_vinyl"]);
						$("#r_can").val(data["a_can"]);
						$("#r_glass").val(data["a_glass"]);
						$("#r_paper").val(data["a_paper"]);
						$("#r_point").val(data["a_point"]);
					}else{
						$("#r_id").val("정보 없음")
					}
				},
				error:function(request, error){
					console.log("오류");
					  alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				}
			});
		});
});


	/*var applyBean = {};
applyBean.a_id = a_id;
	
	var a_id = ${applyBean.getA_id()};
	$("#applyList").on('click',function deliverListDetail(a_uid){
	var uid = $("input[name='a_uid']").val();
	$.ajax({
		//받아온 var contextPath를 여기서 사용한다. AJAX는절대경로로 사용한다.
		url:contextPath + "/apply/ApplyGetDetailOk.ap?a_uid="+uid,
		type:"get",
		dataType:"text",
		//통신에 성공했을시 ApplyGetDetail에서 뿌린 "not ok"나 "ok"가 result자리로 대신 들어간다.
		success:function(result){
			var applyBean = $(requestScope.applyBean);
			if(result.trim() == "ok"){
				$("#r_id").val($("#a_id").val());
			}else{
				$("#r_id").val("정보 없음")
			}
		},
		error:function(){
			console.log("오류");
		}
	});
});*/