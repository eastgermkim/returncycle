package com.koreait.app.code.dao;

import java.util.HashMap;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


import com.koreait.app.member.dao.MemberDAO;
import com.koreait.mybatis.config.SqlMapConfig;


public class CodeDAO {
	
	//세션 팩토리로 세션을 열어주고 모든 쿼리문을 auto커밋으로 설정
	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession sql_session;
	
	public CodeDAO() {
		sql_session = sessionf.openSession(true);
	}
	
	MemberDAO m_dao = new MemberDAO();
	
	//번호와 code를 db에 넣어준다
	public boolean insertCode(String c_phone, String tempCode) {
		HashMap<String, String> code = new HashMap<>();
		
		code.put("c_phone", c_phone);
		code.put("tempCode", tempCode);
		
		return sql_session.insert("Code.insertCode", code)==1;
	}
	//번호를 입력하면 db에 있는 코드 가져오기
	public boolean CheckCode(String tempcode) {
		return (Integer)sql_session.selectOne("Code.CheckCode", tempcode)==1;
	}
	
	public boolean deleteCode(String tempcode) {
		return sql_session.delete("Code.deleteCode", tempcode)==1;
	}
	
/*	public String takeCode(String c_phone) {
	      //랜덤한 문자의 조합으로 임시비밀번호를 만든다.
	      
	      try {
	            Random r = new Random();
	            String ramdom = "0123456789abcdefghijklmnopqrstuvwxyz~!@#$%^&*()_+-=[]{};:/?";
	            String code = "";
	            final int TEMP_PW_LENGTH = 6;
	            
	            //임이의 문자의 조합으로 6자리 임시 비밀번호를 발급한다.
	            for (int i = 0; i < TEMP_PW_LENGTH; i++) {
	            	code += ramdom.charAt(r.nextInt(ramdom.length()));
	            }
	            
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
	             Finally
	      }
	
	public class CertificationKeyGenerator {
		public static CertificationKeyGenerator newInstance(){
			return new CertificationKeyGenerator();
		}
		
		private CertificationKeyGenerator(){}
		
		*//**
		 * 인증키 생성 유틸
		 * 인증키는 아래와 같이 시간을 전번 뒤에 섞고 끝에서 6자리를 서브스트링한다.
		 * @param Number
		 * @return
		 *//*
		public String tempKeyGenarator(String Number){
			String lastNumberString = null;
			String numberArray[] = Number.split("-");
			if(numberArray[2].charAt(0) == '0'){
				lastNumberString = "1"+numberArray[2].substring(1, numberArray[2].length());
			}else{
				lastNumberString = numberArray[2];
			}
			String last = Long.toString((Integer.parseInt(lastNumberString) * System.currentTimeMillis()));
			return last.substring(last.length()-6, last.length());
		}
		
		*//**
		 * 인증키를 디비에서 지우고 새로운 인증키를 생성하여 디비에 삽입한다.
		 * @param thamesMemberDAO
		 * @param phone
		 *//*
		public void tempKeyGenerator(CodeDAO codeDAO ,String c_phone) throws Exception{
			//인증키 생성
			String tempKey = tempKeyGenarator(c_phone);
			System.out.println("암호화키 : "+tempKey);

			//이전 인증키 삭제
			certifiDAO.deleteTempKey(phone);
			
			//인증키및 전화번호 파라미터화
			HashMap<Object, Object> param = new HashMap<Object, Object> ();
			param.put("tempKey", tempKey);
			param.put("phone", phone);
			
			//SMS를 보내기위해 작업
			SMSFactory smsFactory = new SMSFactory(tempKey, phone);
			if(smsFactory.Send()){
				//sms로 발송한 신규 인증키를 db에 삽입
				System.out.println("sms 전송 완료");
				certifiDAO.insertCertificationKey(param);			
			}
		}
		
		*//**
		 * 인풋키와 임시키를 비교하여 일치하는지 반환함
		 * @param thamesMemberDAO
		 * @param phone
		 * @param input
		 * @return
		 *//*
		public boolean isCorrectCertifiKey(CertifiDAO certifiDAO, String phone , String inputKey){
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