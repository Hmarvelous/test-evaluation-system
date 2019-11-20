package online.shixun.project.pojo;

import java.util.Arrays;
import java.util.List;

/**
 * 分页实体类
 * @ClassName: PageInfo.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: am
 * @date: 2019年10月21日 下午7:52:37
 */
public class PageInfo<T> {

	// 当前页码
	private Integer pageNow;
	
	// 每页显示数量
	private Integer pageSize;
	
	// 总记录数
	private Long total;
	
	// 总页码
	private Integer totalPage;
	
	// 当前页码数据集合
	private List<T> dataList;
	
	// 页码数长度
	private Integer pagesLength;
	
	// 当前显示页码数组
	private Integer[] pages; 
	
	// 是否有上一页
	private Boolean hasPreviousPage;
	
	// 上一页页码
	private Integer previousPage;
	
	// 是否有下一页
	private Boolean hasNextPage;
	
	// 下一页页码
	private Integer nextPage;
	
	// 是否为第一页
	private Boolean frist;
	
	// 是否为最后一页
	private Boolean last;
	
	// 首页页码
	private Integer fristPage;
	
	// 尾页页码
	private Integer lastPage;

	
	/**
	 * 构造函数
	 * @param pageNow  当前页码
	 * @param pageSize 每页显示数量
	 * @param total    总记录数
	 * @param dataList 数据集合
	 */
	public PageInfo(Integer pageNow, Integer pageSize, Long total, List<T> dataList) {
		this.pageNow = pageNow;
		this.pageSize = pageSize;
		this.total = total;
		this.dataList = dataList;
		
		calculation();
	}
	
	
	/**
	 * 构造函数
	 * @param pageNow     当前页码
	 * @param pageSize    每页显示数量
	 * @param total       总记录数
	 * @param dataList    数据集合
	 * @param pagesLength 页码集合长度
	 */
	public PageInfo(Integer pageNow, Integer pageSize, Long total, List<T> dataList, Integer pagesLength) {
		this.pageNow = pageNow;
		this.pageSize = pageSize;
		this.total = total;
		this.dataList = dataList;
		this.pagesLength = pagesLength;
		
		calculation();
	}


	/**
	 * 计算其他数据
	 */
	private void calculation() {
		// 计算总页码
		int totalPageInt = (int)(total/pageSize);
		double totalPageDouble = (double)total/pageSize;
		totalPage = totalPageInt == totalPageDouble ? totalPageInt : totalPageInt+1;
		
		
		// 计算的当前显示分页数组
		if (pagesLength == null) {
			pagesLength = 11;
		}
		if (pagesLength > totalPage) {
			pagesLength = totalPage;
		}
		pages = new Integer[pagesLength];
		// 页码小于指定长度
		int page = 1;
		if (totalPage == pagesLength) {
			for (int i=0; i<pagesLength; i++) {
				pages[i] = page++;
			}
		} else {
			// 计算起始页
			if (pageNow > pagesLength/2) {
				page = pageNow - pagesLength/2;
			}
			if (pageNow > totalPage-(pagesLength/2)) {
				page = totalPage-((int)(pagesLength/2)*2);
			}
			for (int i=0; i<pagesLength; i++) {
				pages[i] = page++;
			}
		}
		
		// 上一页
		hasPreviousPage = false;
		if (pageNow-1 > 0) {
			hasPreviousPage = true;
			previousPage = pageNow-1;
		}
		
		// 下一页
		hasNextPage = false;
		if (pageNow+1 <= totalPage) {
			hasNextPage = true;
			nextPage = pageNow+1;
		}
		
		
		// 首页
		frist = false;
		if (totalPage > 1) {
			frist = true;
			fristPage = 1;
		}
		
		// 尾页
		last = false;
		if (totalPage > 1) {
			last = true;
			lastPage = totalPage;
		}
	}


	public Integer getPageNow() {
		return pageNow;
	}

	public void setPageNow(Integer pageNow) {
		this.pageNow = pageNow;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

	public Integer getPagesLength() {
		return pagesLength;
	}

	public void setPagesLength(Integer pagesLength) {
		this.pagesLength = pagesLength;
	}

	public Integer[] getPages() {
		return pages;
	}

	public void setPages(Integer[] pages) {
		this.pages = pages;
	}

	public Boolean getHasPreviousPage() {
		return hasPreviousPage;
	}

	public void setHasPreviousPage(Boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}

	public Integer getPreviousPage() {
		return previousPage;
	}

	public void setPreviousPage(Integer previousPage) {
		this.previousPage = previousPage;
	}

	public Boolean getHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(Boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	public Integer getNextPage() {
		return nextPage;
	}

	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}

	public Boolean getFrist() {
		return frist;
	}

	public void setFrist(Boolean frist) {
		this.frist = frist;
	}

	public Boolean getLast() {
		return last;
	}

	public void setLast(Boolean last) {
		this.last = last;
	}

	public Integer getFristPage() {
		return fristPage;
	}

	public void setFristPage(Integer fristPage) {
		this.fristPage = fristPage;
	}

	public Integer getLastPage() {
		return lastPage;
	}

	public void setLastPage(Integer lastPage) {
		this.lastPage = lastPage;
	}


	@Override
	public String toString() {
		return "PageInfo [pageNow=" + pageNow + ", pageSize=" + pageSize + ", total=" + total + ", totalPage="
				+ totalPage + ", dataList=" + dataList + ", pagesLength=" + pagesLength + ", pages="
				+ Arrays.toString(pages) + ", hasPreviousPage=" + hasPreviousPage + ", previousPage=" + previousPage
				+ ", hasNextPage=" + hasNextPage + ", nextPage=" + nextPage + ", frist=" + frist + ", last=" + last
				+ ", fristPage=" + fristPage + ", lastPage=" + lastPage + "]";
	}

}
