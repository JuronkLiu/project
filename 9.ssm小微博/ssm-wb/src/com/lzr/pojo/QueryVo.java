package com.lzr.pojo;

public class QueryVo {

	private Integer id;
	private String name;
	private Integer state;
	// 当前页
	private Integer page = 1;
	// 每页数
	private Integer size = 5;
	// 开始行
	private Integer startRow = 0;

	private String find;

	public QueryVo() {
	}

	public QueryVo(Integer id, String name, Integer page, Integer size, Integer startRow, String find, Integer state) {
		this.id = id;
		this.name = name;
		this.page = page;
		this.size = size;
		this.startRow = startRow;
		this.find = find;
		this.state = state;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFind() {
		return find;
	}

	public void setFind(String find) {
		this.find = find;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Integer getStartRow() {
		return startRow;
	}

	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}

	@Override
	public String toString() {
		return "QueryVo [id=" + id + ", name=" + name + ", state=" + state + ", page=" + page + ", size=" + size
				+ ", startRow=" + startRow + ", find=" + find + "]";
	}

}
