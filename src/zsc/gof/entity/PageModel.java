package zsc.gof.entity;

import java.util.List;

public class PageModel<E> {
	private int pageIndex;// 当前页
	private int totalRecords;// 总计记录数
	private List<E> list;
	private int pageSize;// 每页记录数

	// 获取总页数
	public int getTotalPage() {
		return (totalRecords + pageSize - 1) / pageSize;
	}

	public int getFirstPage() {
		return 1;
	}

	// 获取上一页
	public int getPreviousPage() {
		return pageIndex <= 1 ? 1 : pageIndex - 1;
	}

	// 获取下一页
	public int getNextPage() {
		if (pageIndex >= getTotalPage()) {
			return getLastPage();
		}
		return pageIndex + 1;
	}

	// 最后一页
	public int getLastPage() {
		return getTotalPage() <= 0 ? 1 : getTotalPage();
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public List<E> getList() {
		return list;
	}

	public void setList(List<E> list) {
		this.list = list;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
