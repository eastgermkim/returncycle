package com.koreait.app.apply.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.koreait.app.apply.vo.ApplyVO;
import com.koreait.mybatis.config.SqlMapConfig;

public class ApplyDAO {
	
	private static final int KEY = 3;
	
	//세션 팩토리로 세션을 열어주고 모든 쿼리문을 auto커밋으로 설정
	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession sql_session;
	
	public ApplyDAO() {
		sql_session = sessionf.openSession(true);
	}
	
	//신청하기
	public boolean Apply(ApplyVO apply) {
		return sql_session.insert("Apply.form", apply)==1;
	}
	
	//페이지 별 게시글 목록
	public List<ApplyVO> getApplyList(int a_startRow, int a_endRow) {
		HashMap<String, Integer> pageMap = new HashMap<>();
		
		pageMap.put("a_startRow", a_startRow);
		pageMap.put("a_endRow", a_endRow);
		
		return sql_session.selectList("Apply.listAll", pageMap);
	}
	
	//***a_uid로 해당 신청폼 가져오기
	public ApplyVO getDetail(String a_uid) {
		return sql_session.selectOne("Apply.getDetail", a_uid);
	}
	
	//***a_id로 해당 신청폼 가져오기
	public ApplyVO getInfo(String a_id) {
		return sql_session.selectOne("Apply.getInfo", a_id);
	}
	
	//신청된 전체 개수
	public int getApplyCnt() {
		return sql_session.selectOne("Apply.getApplyCnt");
	}
	
	//신청폼 a_uid
	public String getA_uid() {
		return sql_session.selectOne("Apply.getA_uid");
	}
	
	//신청하기 한번만하도록
	public boolean checkApply(String a_id) {
		return (Integer)sql_session.selectOne("Apply.findApplyId", a_id)==1;
	}
	
	//수거신청 삭제
	public void deleteApply(String a_uid) {
		sql_session.delete("Apply.deleteApply", a_uid);
	}
	
	//내 수거신청 수정(a_uid(기존) 나머지 수정 가능)
	public void updateApply(ApplyVO a_vo) {
		sql_session.update("Apply.updateApply", a_vo);
	}
}
