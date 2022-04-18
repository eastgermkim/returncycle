package com.koreait.app.Deliver.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import org.apache.ibatis.session.SqlSessionFactory;

import com.koreait.app.Deliver.vo.DeliverVO;
import com.koreait.mybatis.config.SqlMapConfig;

public class DeliverDAO {
	
	//세션 팩토리로 세션을 열어주고 모든 쿼리문을 auto커밋으로 설정
	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession sql_session;
	
	public DeliverDAO() {
		sql_session = sessionf.openSession(true);
	}
	
	//기사가 사용자 정보를 입력한걸 db에 넣어준다.
	public boolean deliver(DeliverVO deliver) {
		return sql_session.insert("deliver.save", deliver)==1;
	}
	
	//수거하기 완료시 유저 포인트 적립
	public void pointPlus(Map map) {
		sql_session.update("deliver.pointPlus",map);
	}
	
	//유저 아이디로 결과 r_id 개수 가져오기
	public int getMyCount(String u_id) {
		return sql_session.selectOne("deliver.getMyCount", u_id);
	}
	
	/*${pageContext.request.contextPath}/deliver/DeliverGo.de?id=${session_id}*/
}
