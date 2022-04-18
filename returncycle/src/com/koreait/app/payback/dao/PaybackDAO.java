package com.koreait.app.payback.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;


import org.apache.ibatis.session.SqlSessionFactory;

import com.koreait.app.payback.vo.PaybackVO;
import com.koreait.mybatis.config.SqlMapConfig;

public class PaybackDAO {
	
	//세션 팩토리로 세션을 열어주고 모든 쿼리문을 auto커밋으로 설정
	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession sql_session;
	
	public PaybackDAO() {
		sql_session = sessionf.openSession(true);
	}
	
	//기사가 사용자 정보를 입력한걸 db에 넣어준다.
	public boolean Payback(PaybackVO payback) {
		return sql_session.insert("Payback.form", payback)==1;
	}
	
	//물품교환 완료시 유저 포인트 차감
	public void PointMinus(Map map) {
		sql_session.update("Payback.pointMinus",map);
	}
	
	//유저 아이디로 결과 p_id 개수 가져오기
	public int getMyCount(String u_id) {
		return sql_session.selectOne("Payback.getMyCount", u_id);
	}
	/*${pageContext.request.contextPath}/deliver/DeliverGo.de?id=${session_id}*/
}
