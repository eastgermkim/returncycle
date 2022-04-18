package com.koreait.app.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.member.dao.MemberDAO;
import com.koreait.app.member.vo.MemberVO;

public class MemberFindIdAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		ActionForward forward =null;
		MemberDAO m_dao = new MemberDAO();
		MemberVO m_vo = new MemberVO();
		
		m_vo.setU_last_name(req.getParameter("u_last_name"));
		m_vo.setU_first_name(req.getParameter("u_first_name"));
		m_vo.setU_email(req.getParameter("u_email"));
		m_vo.setU_phone(req.getParameter("u_phone"));
		
		String u_name = req.getParameter("u_first_name");
		
		if(m_dao.findId(m_vo) == null) {
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html;charset=UTF-8");
			out.println("<script>");
			out.println("alert('가입하신 아이디가 없습니다.')");
			out.println("window.location='/returncycle1230_deliver/member/MemberFindIdForm.me'");
			//returncycle1230_deliver << 자기 프로젝트 이름으로 변경
			out.println("</script>");
			out.close();
		}else {
			req.setAttribute("u_name", u_name);
			req.setAttribute("find_id",m_dao.findId(m_vo));
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/member/FindId_result.me");
		}
		return forward;
	}
	
	/*//비밀번호 찾기
		//임시비밀번호를 해당 회원의 핸드폰 번호로 전송
		//전송하고 나서 DB 접근 후 임시비밀번호로 수정
		public void findPw(String id, String phone_number) {
			//랜덤한 문자의 조합으로 임시비밀번호를 만든다.
			
			try {
				conn = DBConnector.getConnection();
				String query ="SELECT USER_NUMBER FROM TBL_USER WHERE ID = ? AND PHONE_NUMBER = ?";
				pstm = conn.prepareStatement(query);
				
				pstm.setString(1, id);
				pstm.setString(2, phone_number);
				
				rs = pstm.executeQuery();
				
				if(rs.next()) {
					//검색된 회원이 있다면 임시 비밀번호를 발급한다.
					Random r = new Random();
					String temp = "0123456789abcdefghijklmnopqrstuvwxyz~!@#$%^&*()_+-=[]{};:/?";
					String temp_pw = "";
					final int TEMP_PW_LENGTH = 6;
					
					//임의의 문자의 조합으로 6자리 임시 비밀번호를 발급한다.
					for (int i = 0; i < TEMP_PW_LENGTH; i++) {
						temp_pw += temp.charAt(r.nextInt(temp.length()));
					}
					
					changePw(rs.getInt(1), temp_pw);
					
					//외부API(문자발송)
					//coolsms 사이트에 로그인 한 후
					//본인의 API KEY값을 참고하여 작성한다.
					String api_key = "";
					String api_secret = "";
					Message coolsms = new Message(api_key, api_secret);

					// 4 params(to, from, type, text) are mandatory. must be filled
					HashMap<String, String> params = new HashMap<String, String>();
					//누구에게 전송할 지
					params.put("to", "");
					//등록한 발신 번호 작성
					params.put("from", "");
					//SMS 그대로 유지
					params.put("type", "SMS");
					//전송할 메세지
					params.put("text", "[테스트]\n임시 비밀번호: " + temp_pw + "\n노출될 수 있으니 반드시 비밀번호를 변경해 주세요.");
					//사용하고 있는 API 버전
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
				
			} catch (SQLException e) {
			}
			
		}
		
	}*/
}
