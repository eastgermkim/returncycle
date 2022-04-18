package com.koreait.app.review.vo;

public class ReviewReplyVO {
	private int review_reply_num;
	private int review_idx;
	private String u_id;
	private String review_reply_content;
	
	public ReviewReplyVO() {;}

	public int getReview_reply_num() {
		return review_reply_num;
	}

	public void setReview_reply_num(int review_reply_num) {
		this.review_reply_num = review_reply_num;
	}

	public int getReview_idx() {
		return review_idx;
	}

	public void setReview_idx(int review_idx) {
		this.review_idx = review_idx;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getReview_reply_content() {
		return review_reply_content;
	}

	public void setReview_reply_content(String review_reply_content) {
		this.review_reply_content = review_reply_content;
	}
	
	
}
