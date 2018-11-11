package com.lzr.pojo;

import java.util.List;

public class Page<T> {

	private Integer total;
	private Integer page;
	private Integer size;
	private List<T> rows;
	private Integer allPage;

	public Page() {
	}

	public Page(Integer total, Integer page, Integer size, List<T> rows, Integer allPage) {
		this.total = total;
		this.page = page;
		this.size = size;
		this.rows = rows;
		this.allPage = allPage;
	}

	public Integer getAllPage() {
		return allPage;
	}

	public void setAllPage(Integer allPage) {
		this.allPage = allPage;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "Page [total=" + total + ", page=" + page + ", size=" + size + ", rows=" + rows + ", allPage=" + allPage
				+ "]";
	}

}
