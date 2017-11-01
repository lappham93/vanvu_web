package com.mit.common;

public class Paging {
	private int currentPage = 1;
	private int totalRecord = 0;
	private int pageSize = 10;
	private int numDisplay = 5;

	public int getTotalPage() {
		if (pageSize == 0)
			return 0;

		int totalPages = (totalRecord - 1) / pageSize + 1;

		return totalPages;
	}

	public static int clamp(int value, int min, int max) {
		return Math.max(min, Math.min(max, value));
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currPage) {
		this.currentPage = currPage;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecords) {
		this.totalRecord = totalRecords;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getNumDisplay() {
		return numDisplay;
	}

	public void setNumDisplay(int numDisplay) {
		this.numDisplay = numDisplay;
	}

}
