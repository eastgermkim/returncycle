/**
 * 개빡친당
 */

/*$("#submit").mouseover(function(){*/
$(document).ready(function(){
			var id = $("#a_id").val();
			$.ajax({
				//받아온 var contextPath를 여기서 사용한다. AJAX는절대경로로 사용한다.
				url:contextPath + "/apply/ApplyCheckOkAction.ap?a_id="+id,
				type:"get",
				dataType:"text",
				success:function(result){
					if(result.trim() == "not-ok"){
						check = true;
						alert("신청내역이 있습니다. 신청하기 페이지로 이동합니다 :)");
						/*window.history.back();*/
						$(location).attr("href", contextPath + "/member/myApplyAction.me?a_id="+id);
					}
				},
				error:function(request, error){
					console.log("오류");
					  alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				}
			});
		});
