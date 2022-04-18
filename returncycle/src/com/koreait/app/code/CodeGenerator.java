package com.koreait.app.code;

import java.util.HashMap;
import java.util.Random;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class CodeGenerator {
	
	public CodeGenerator() {
		// TODO Auto-generated constructor stub
	}
	
	public String CreateCode() {
	Random r = new Random();
    String ramdom = "0123456789abcdefghijklmnopqrstuvwxyz~!@#$%^&*()_+-=[]{};:/?";
    String code = "";
    int TEMP_CODE_LENGTH = 6;
    
    //임이의 문자의 조합으로 6자리 임시 비밀번호를 발급한다.
    for (int i = 0; i < TEMP_CODE_LENGTH; i++) {
    	code += ramdom.charAt(r.nextInt(ramdom.length()));
    }
	return code;
}
	/**
	 * 인증키를 디비에서 지우고 새로운 인증키를 생성하여 디비에 삽입한다.
	 * @param thamesMemberDAO
	 * @param phone
	 */
	public void goMessage(String c_phone, String code) throws Exception{
		//인증키 생성
		//외부API(문자발송)
        //coolsms 사이트에 로그인 한 후
        //본인의 API KEY값을 참고하여 작성한다.
        String api_key = "NCS4AIEACADMW6JA";
        String api_secret = "YE3Q2PGGYKNXVNGTJ6IDXNBFSLMB9KJA";
        Message coolsms = new Message(api_key, api_secret);

        // 4 params(to, from, type, text) are mandatory. must be filled
        HashMap<String, String> params = new HashMap<String, String>();
        //누구에게 전송할지
        params.put("to", c_phone);
        //coolsms에 등록한 발신 번호 작성
        params.put("from", "01088315815");
        //sms 그대로 유지
        params.put("type", "SMS");
        //전송할 메세지 (지정된 임시비밀번호 전송)
        params.put("text", "[테스트]\n인증 번호 : " + code + "\n인증번로흘 입력해주세요.");
        //사용하고 있는 API 버전 작성
        params.put("app_version", "JAVA SDK v2.2"); // application name and version

        try {
       	 //전송된 데이터를 JSON으로 변환하여 콘솔에 출력
           JSONObject obj = (JSONObject) coolsms.send(params);
           System.out.println(obj.toString());
         } catch (CoolsmsException e) {
           System.out.println(e.getMessage());
           System.out.println(e.getCode());
         }
	}
	
	/**
	 * 인풋키와 임시키를 비교하여 일치하는지 반환함
	 * @param thamesMemberDAO
	 * @param phone
	 * @param input
	 * @return
	 */
/*	public boolean isCorrectCertifiKey(CertifiDAO certifiDAO, String phone , String inputKey){
		//db에서 dbKey를 가져와 저장할 임시변수
		String dbKey = "";
		//암호화된 전화번호로 임시키 가져옴
		dbKey = certifiDAO.getTempKey(phone);
		//임시키와 인풋키 공백제거
		dbKey = dbKey.trim();
		inputKey = inputKey.trim();
		//디비에 누적된 임시키 삭제
		certifiDAO.deleteTempKey(phone);
		
		//인풋키와 임시키 비교
		if(inputKey.equals(dbKey)){
			return true;
		}
		else{
			return false;
		}
	}
}*/
}
