package com.koreait.app.Admin.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.koreait.app.member.vo.MemberVO;
import com.koreait.mybatis.config.SqlMapConfig;

public class AdminDAO {
	
	private static final int KEY = 3;
	
	//세션 팩토리로 세션을 열어주고 모든 쿼리문을 auto커밋으로 설정
	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession sql_session;
	
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;
	
	public AdminDAO() {
		sql_session = sessionf.openSession(true);
	}
	
	//admin검사
	public boolean checkAdmin(String u_id, String admin) {
		HashMap<String, String> a = new HashMap<>();
		a.put("u_id", u_id);
		a.put("admin", admin);
		return (Integer)sql_session.selectOne("Admin.checkAdmin", u_id)==1;
	}
}
