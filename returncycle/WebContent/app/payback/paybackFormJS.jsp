<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script>
//이메일 select
$('#select_email').change(function(){
	//직접입력일 경우
	$("#select_email option:selected").each(function(){if($(this).val()== '0'){
		//값 초기화
		$("#selected_email").val('');  
		//활성화
		$("#selected_email").attr("disabled",false);
		//직접입력이 아닐경우
		}else{  
		//선택값 입력
		$("#selected_email").val($(this).val());  
		//비활성화였는데 db 안넘어가서 true를 false로
		$("#selected_email").attr("disabled",false);  
		} 
	}); 	
});


$("#find_zipcode").click(function(){
	new daum.Postcode({
		oncomplete:function(data) {
			jQuery("#p_zipcode").val(data.zonecode);
			jQuery("#p_address").val(data.address);
			jQuery("#p_address_detail").focus();
		}
	}).open();
});


//서브밋 클릭
$(function(){
		//이름 없으면
		$("#submit").on('click',function(){
			if($("#p_name").val() == ""){
				alert("이름을 입력해 주세요");
				$("#p_name").focus();
				return false;
			}
		
		//이메일 아이디 없으면
			if($("#p_email").val() == ""){
				alert("이메일 아이디를 입력해 주세요");
				$("#p_email").focus();
				return false;
			}
		
		/* //이메일 뒷자리 없으면
			if($("#selected_email").val() == ""){
				alert("이메일 주소를 직접 입력 또는 선택해 주세요");
				$("selected_email").focus();
				return false;
			} */
			
		//핸드폰 번호 없으면
			if($("#p_phone").val() == ""){
				alert("핸드폰 번호를 입력해 주세요");
				$("#p_phone").focus();
				return false;
			}
			
		//주소 하나라도 없으면
			if($("#p_zipcode").val() == "" || $("#p_address").val() == "" || $("#p_address_detail").val() == ""){
				alert("주소를 입력해 주세요");
				$("#p_zipcode").focus();
				return false;
			}
		
			
		//다 만족하면 true, 결과 페이지 이동
			/* $(location).attr("href", "apply_result.jsp"); */
			return true;
		});
	});
		          
		</script>