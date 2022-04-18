package com.koreait.app.review.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.koreait.app.review.vo.ReviewReplyVO;
import com.koreait.app.review.vo.ReviewVO;
import com.koreait.mybatis.config.SqlMapConfig;

public class ReviewDAO {
	
	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession;
	
	public ReviewDAO() {
		sqlsession = sessionf.openSession(true);
	}
	
	//페이지별 리뷰 목록
	public List<ReviewVO> getReviewList(int startRow, int endRow) {
		HashMap<String, Integer> pageMap=new HashMap<>();
		
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);
		
		return sqlsession.selectList("Review.listAll",pageMap);
	}
	
	//***게시글 번호로 해당 게시글 가져오기
	public ReviewVO getDetail(int review_idx) {
		return sqlsession.selectOne("Review.getDetail", review_idx);
	}
	
	//리뷰글 전체 개수
	public int getReviewCnt() {
		return sqlsession.selectOne("Review.getReviewCnt");
	}
	
	//유저 아이디로 결과 review_id 개수 가져오기
	public int getMyCount(String u_id) {
		return sqlsession.selectOne("Review.getMyCount", u_id);
	}
	
/*	//조회수
	public void updateReadeCount(int review_idx) {
		sqlsession.update("Review.updateReviewCount", review_idx);
	}*/
	
	//리뷰글 번호
	public int getReviewSeq() {
		return sqlsession.selectOne("Review.getSeq");
	}
	
	//리뷰글 추가
	public boolean insertReview(ReviewVO review) {
		return sqlsession.insert("Review.insertReview", review) == 1;
	}
	
	//리뷰글 삭제
	public void deleteReview(int review_idx) {
		sqlsession.delete("Review.deleteReview", review_idx);
	}
	
	//게시판 수정(게시글번호(기존), 게시글 제목(수정), 게시글 내용(수정))
	public void updateReview(ReviewVO r_vo) {
		sqlsession.update("Review.updateReview", r_vo);
	}
	
	/* 댓글 */
	
	//댓글 전체 목록
	public List<ReviewReplyVO> getReviewReplyList(int review_idx){
		return sqlsession.selectList("Review.getReviewReplyList", review_idx);
	}
	
	//댓글 추가
	public boolean insertReviewReply(ReviewReplyVO rr_vo) {
		return sqlsession.insert("Review.insertReviewReply", rr_vo) == 1;
	}
	
	//댓글 삭제
	public void deleteReviewReply(int review_reply_num) {
		sqlsession.delete("Review.deleteReviewReply", review_reply_num);
	}
	
	//댓글 수정
	public void updateReviewReply(ReviewReplyVO rr_vo) {
		sqlsession.update("Review.updateReviewReply", rr_vo);
		
	}
	
	//댓글 전체삭제
	public void deleteReplyAll(int review_idx) {
		sqlsession.delete("Review.deleteReviewReplyAll", review_idx);
	}
	
}
