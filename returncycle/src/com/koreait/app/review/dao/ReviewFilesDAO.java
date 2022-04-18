package com.koreait.app.review.dao;

import java.util.Enumeration;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.koreait.app.review.vo.ReviewFilesVO;
import com.koreait.mybatis.config.SqlMapConfig;
import com.oreilly.servlet.MultipartRequest;

public class ReviewFilesDAO {
	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession;
	
	public ReviewFilesDAO(){
		sqlsession = sessionf.openSession(true);
	}
	
	//첨부파일 목록
	public ReviewFilesVO getDetail(int review_idx){
		return sqlsession.selectOne("ReviewFiles.getDetail", review_idx);
	}
	
	//첨부파일 등록
	public boolean insertReviewFiles(int review_idx, MultipartRequest multi) {
		Enumeration<String> files = multi.getFileNames();
		boolean check = true;
		
		ReviewFilesVO file = new ReviewFilesVO();
		file.setReview_idx(review_idx);
		
		while(files.hasMoreElements()) {
			//사용자가 업로드한 파일명
			String data = files.nextElement();
			//사용자가 업로드한 파일명을 통해서 중복이없는 시스템 파일명을 가져온다.
			String systemName = multi.getFilesystemName(data);
			
			//슬롯 별로 검사하여 null이 아닐때에만 DB에 INSERT한다.
			if(systemName == null) {continue;}
			file.setR_file_name(systemName);
			
			if(sqlsession.insert("ReviewFiles.insertFile", file)!=1){
				//추가 실패시 check에 false대입.
				check = false;
				break;
			}
			
		}
		return check;
	}
	//첨부파일 삭제
	public void deleteReviewFiles(int review_idx) {
		sqlsession.delete("ReviewFiles.deleteReviewFiles", review_idx);
	}

}
