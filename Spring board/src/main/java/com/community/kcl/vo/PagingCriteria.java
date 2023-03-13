package com.community.kcl.vo;

public class PagingCriteria {
	

	private int pageNum=1;	//페이지 번호
	private int amount=5;	//페이지당 데이터 갯수

	private int startNo = 1;
	private int endNo = 10;

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
		resetPageSet();
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
		resetPageSet();
	}

	@Override
	public String toString() {
		return "PagingCriteria [pageNum=" + pageNum + ", amount=" + amount + "]";
	}


	public int getStartNo() {
		return startNo;
	}

	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}

	public int getEndNo() {
		return endNo;
	}

	public void setEndNo(int endNo) {
		this.endNo = endNo;
	}
	
	public int getLastPage() {
		return Math.round(pageNum / amount + 1) * amount;
	}
	
	public int getStartPage() {
		return Math.round(pageNum / amount) * amount + 1;
	}

	private void resetPageSet() {
		// TODO Auto-generated method stub
		startNo = (pageNum - 1) * amount + 1; // (1,10) -> 0
		endNo = pageNum * amount; // (1,10) -> 10
	}
}
