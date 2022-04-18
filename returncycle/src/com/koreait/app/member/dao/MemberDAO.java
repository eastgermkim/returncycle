package com.koreait.app.member.dao;

import java.util.HashMap;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.koreait.app.member.vo.MemberVO;
import com.koreait.mybatis.config.SqlMapConfig;

public class MemberDAO {
	
	private static final int KEY = 3;
	
	//세션 팩토리로 세션을 열어주고 모든 쿼리문을 auto커밋으로 설정
	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession sql_session;
	
	public MemberDAO() {
		sql_session = sessionf.openSession(true);
	}
	
    

	//회원가입
	public boolean join(MemberVO member) {
		member.setU_pwd(encrypt(member.getU_pwd()));
		return sql_session.insert("Member.join", member)==1;
	}
	
	
	
	//아이디검사
	public boolean checkId(String u_id) {
		return (Integer)sql_session.selectOne("Member.checkId", u_id) == 1;
	}
	
	
/*	//생년월일 
	public Date birthToDate(MemberVO member) {
		String year=member.getBirth_yy();
		String month=member.getBirth_mm();
		String day=member.getBirth_dd();
		
		Date birthday=null;
		
		if(year!=null && month!=null && day!=null) {
			birthday=Date.valueOf(year+"-"+month+"-"+day);
		}
		return birthday;
	}*/
	
	//로그인
	public boolean login(String u_id, String u_pwd) {
		HashMap<String, String> member = new HashMap<>();
		
		member.put("u_id", u_id);
		member.put("u_pwd", encrypt(u_pwd));
		
		return (Integer)sql_session.selectOne("Member.login",member)==1;
	}
	
	//admin로그인
	public boolean loginAdmin(String u_id, String admin) {
		HashMap<String, String> member = new HashMap<>();
		
		member.put("u_id", u_id);
		member.put("admin", admin);
		return (Integer)sql_session.selectOne("Member.checkAdmin", member)==1;
	}
	
	//암호화
	public String encrypt(String pw) {
		
		String en_pw = "";
		for (int i=0;i<pw.length();i++) {
			en_pw+=(char)(pw.charAt(i)*KEY);
		}
		return en_pw;
	}
	
	//복호화
	public String decrypt(String en_pw) {
		
		String de_pw="";
		for (int i=0;i<en_pw.length();i++) {
			de_pw+=(char)(en_pw.charAt(i)/KEY);
		}
		return de_pw;
	}
		
	
	//아이디로 아이디 정보 가져오기
	public MemberVO getDetail(String u_id) {
		return sql_session.selectOne("Member.getDetail", u_id);
	}
	
	//회원삭제(회원 번호)
	public boolean remove(int num) {
		return sql_session.delete("Member.remove", num) == 1;
	}
	
	//회원아이디로 회원 정보 변경
	public void memberModify(MemberVO m_vo) {
		sql_session.update("Member.modify", m_vo);
	}
	
	//포인트 조회하기
	public String getPoint(String u_id) {
		return sql_session.selectOne("Member.getPoint", u_id);
	}
	
	//사용자 조회하기
	public int getWho(String u_id) {
		return (Integer)sql_session.selectOne("Member.getWho", u_id);
	}
	
	//사용자 번호가 있는지 조회하기
	public int Phone(String u_phone) {
		return (Integer)sql_session.selectOne("Member.Phone", u_phone);
	}
	//ID 찾기
	public String findId(MemberVO member) {
		return sql_session.selectOne("Member.findId", member);
	}

	//PW 찾기
	public String findPw(MemberVO member) {
		return sql_session.selectOne("Member.findPw", member);
	}
}
