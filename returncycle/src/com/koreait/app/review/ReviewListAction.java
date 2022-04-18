package com.koreait.app.review;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.review.dao.ReviewDAO;
import com.koreait.app.review.dao.ReviewFilesDAO;
import com.koreait.app.review.vo.ReviewFilesVO;
import com.koreait.app.review.vo.ReviewVO;

public class ReviewListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();
		ReviewDAO r_dao = new ReviewDAO();
		ReviewFilesDAO rf_dao = new ReviewFilesDAO();
		
		//페이징 처리
		String temp = req.getParameter("page");
		
		//요청한 페이지가 없다면 default로 1페이지를 응답해주고,
		//요청한 페이지가 있다면 해당 페이지로 응답해준다.
		int page = temp == null ? 1 : Integer.parseInt(temp);
		
		//한페이지당 20개의 게시글이 보이도록 설정
		int pageSize = 20;
		
		//한페이지에서 가장 마지막행 번호
		int endRow = page*pageSize;
		
		//한페이지에서 가장 첫번째 행 번호
		int startRow = endRow-(pageSize-1);
		
		int totalCnt = r_dao.getReviewCnt();
		
		//10의배수로 
		int startPage = ((page-1)/pageSize)*pageSize+1;
		int endPage = startPage+9;
		
		int realEndPage = (totalCnt-1)/pageSize+1;
		
		//실제 마지막 페이지와 연산으로 구한 마지막 페이지를 비교하여 일치하도록 해준다.
		endPage = endPage > realEndPage ? realEndPage: endPage;
		
		//r_dao에 있는 게시글번호를 사용하여 파일이 있는지 검사한후 파일 이름을 가져오고 없으면 null을 붙혀서 
		//어레이 형식으로 저장후 넘겨준다.
		
		//게시글 전체 목록
		List<ReviewVO> r_vos = r_dao.getReviewList(startRow, endRow);
		int size = r_vos.size();
		ArrayList<String> filenames = new ArrayList<String>();
		for(int i=0; i<size; i++) {
			int r_idx = r_vos.get(i).getReview_idx();
			ReviewFilesVO rf_vo = rf_dao.getDetail(r_idx);
			//첨부파일이 없을 때
			if(rf_vo == null) {
				//게시글 내용이 10글자 이상일 때
				if(r_vos.get(i).getReview_content().length() > 10) {
					//게스글 내용을 10글자로 자른 후 뒤에 ... 붙여주기
					r_vos.get(i).setReview_content(r_vos.get(i).getReview_content().substring(0, 10) + "...");
				}
				filenames.add(null);
			}else {
				String filename = rf_vo.getR_file_name();
				filenames.add("s_"+filename);
			}
		}
		req.setAttribute("totalCnt", totalCnt);
		req.setAttribute("realEndPage", realEndPage);
		req.setAttribute("nowPage", page);
		req.setAttribute("startPage", startPage);
		req.setAttribute("endPage", endPage);
		req.setAttribute("filenames", filenames);
		req.setAttribute("reviewList", r_vos);
		
		
		forward.setRedirect(false);
		forward.setPath("/app/review/reviewList.jsp");
		
		return forward;
	}

}
