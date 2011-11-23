package com.song7749.web.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * 목록 여러 페이지로 나누기.
 * 
 * @author song7749
 */

public class Pagination {

	/**
	 * pagingType 페이징 타입 ( 0: Total 카운트가 있는 일반페이징, 1: 댓글형 역순 페이징, 2: 카운트 없는 일반
	 * 페이징)
	 */
	private int pagingType;

	/**
	 * 총 카운트
	 */
	private int totalRows = 0;

	/**
	 * 게시물 row 수
	 */
	private int listRows = 0;

	/**
	 * 현재 페이지
	 */
	private int currentPage = 1;

	/**
	 * 페이지 사이즈
	 */
	private int pageSize = 0;

	/**
	 * 페이지 블럭 사이즈
	 */
	private int blockSize = 0;

	/**
	 * 총 페이지수
	 */
	private int totalPages;

	/**
	 * 총 페이지 블럭수
	 */
	private int totalBlocks;

	/**
	 * 첫페이지
	 */
	private int startPageNum;

	/**
	 * 마지막 페이지
	 */
	private int endPageNum;

	/**
	 * 현재 페이지 블럭
	 */
	private int currentBlock;

	/**
	 * 첫번째,이전,다음,마지막 이미지
	 */
	private Map buttonImage = new HashMap();

	/**
	 * 페이징 리스트 기본 스타일
	 */
	private String pageListlinkCssStyle = "";

	/**
	 * 페이징 리스트 기본 스타일 클래스 이름
	 */
	private String pageListlinkCssClass = "";

	/**
	 * 페이징 리스트 ON 기본 스타일
	 */
	private String pageListOnlinkCssStyle = "";

	/**
	 * 페이징 리스트 ON 기본 스타일 클래스 이름
	 */
	private String pageListOnlinkCssClass = "";

	/**
	 * 페이지 버튼 (이전, 다음) 스타일
	 */
	private String pageButtonlinkCssStyle = "";

	/**
	 * 페이지 버튼 (이전, 다음) 스타일 클래스 이름
	 */
	private String pageButtonlinkCssClass = "";

	/**
	 * 쿼리 스트링
	 */
	private String queryString = "";
	private String linkSrc = "";
	private String amp = "";

	/**
	 * 페이지 파라미터 이름
	 */
	private String pageParamName = "page";

	public StringBuffer pageString = new StringBuffer();

	/*
	 * 생성자
	 * 
	 * @param pagingType
	 */
	public Pagination(int pagingType) {
		this.pagingType = pagingType;

		this.buttonImage.put("Start", "<<");
		this.buttonImage.put("Prev", "<");
		this.buttonImage.put("Next", ">");
		this.buttonImage.put("End", ">>");
		this.buttonImage.put("Space", "");
	}

	public Pagination(int pagingType, String pageParamName) {
		this.pagingType = pagingType;

		this.buttonImage.put("Start", "<<");
		this.buttonImage.put("Prev", "<");
		this.buttonImage.put("Next", ">");
		this.buttonImage.put("End", ">>");
		this.buttonImage.put("Space", "");

		this.pageParamName = pageParamName;
	}

	/**
	 * @return the listRows
	 */
	public int getListRows() {
		return listRows;
	}

	/**
	 * @param listRows
	 *            the listRows to set
	 */
	public void setListRows(int listRows) {
		this.listRows = listRows;
	}

	/**
	 * @return the pageListlinkCssStyle
	 */
	public String getPageListlinkCssStyle() {
		return pageListlinkCssStyle;
	}

	/**
	 * @param pageListlinkCssStyle
	 *            the pageListlinkCssStyle to set
	 */
	public void setPageListlinkCssStyle(String pageListlinkCssStyle) {
		this.pageListlinkCssStyle = pageListlinkCssStyle;
	}

	/**
	 * @return the pageListlinkCssClass
	 */
	public String getPageListlinkCssClass() {
		return pageListlinkCssClass;
	}

	/**
	 * @param pageListlinkCssClass
	 *            the pageListlinkCssClass to set
	 */
	public void setPageListlinkCssClass(String pageListlinkCssClass) {
		this.pageListlinkCssClass = pageListlinkCssClass;
	}

	/**
	 * @return the pageListOnlinkCssStyle
	 */
	public String getPageListOnlinkCssStyle() {
		return pageListOnlinkCssStyle;
	}

	/**
	 * @param pageListOnlinkCssStyle
	 *            the pageListOnlinkCssStyle to set
	 */
	public void setPageListOnlinkCssStyle(String pageListOnlinkCssStyle) {
		this.pageListOnlinkCssStyle = pageListOnlinkCssStyle;
	}

	/**
	 * @return the pageListOnlinkCssClass
	 */
	public String getPageListOnlinkCssClass() {
		return pageListOnlinkCssClass;
	}

	/**
	 * @param pageListOnlinkCssClass
	 *            the pageListOnlinkCssClass to set
	 */
	public void setPageListOnlinkCssClass(String pageListOnlinkCssClass) {
		this.pageListOnlinkCssClass = pageListOnlinkCssClass;
	}

	/**
	 * @return the pageButtonlinkCssStyle
	 */
	public String getPageButtonlinkCssStyle() {
		return pageButtonlinkCssStyle;
	}

	/**
	 * @param pageButtonlinkCssStyle
	 *            the pageButtonlinkCssStyle to set
	 */
	public void setPageButtonlinkCssStyle(String pageButtonlinkCssStyle) {
		this.pageButtonlinkCssStyle = pageButtonlinkCssStyle;
	}

	/**
	 * @return the pageButtonlinkCssClass
	 */
	public String getPageButtonlinkCssClass() {
		return pageButtonlinkCssClass;
	}

	/**
	 * @param pageButtonlinkCssClass
	 *            the pageButtonlinkCssClass to set
	 */
	public void setPageButtonlinkCssClass(String pageButtonlinkCssClass) {
		this.pageButtonlinkCssClass = pageButtonlinkCssClass;
	}

	/**
	 * @param buttonImage
	 *            the buttonImage to set
	 */
	public void setButtonImage(Map buttonImage) {
		this.buttonImage = buttonImage;
	}

	/**
	 * 페이징 초기화
	 * 
	 * @param totalRows
	 * @param currentPage
	 * @param queryString
	 * @param pageSize
	 * @param blockSize
	 * @param linkSrc
	 */
	public void initialize(int totalRows, int currentPage,
			HttpServletRequest request, int pageSize, int blockSize,
			String linkSrc) {
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		if (this.pagingType == 2) {
			this.totalRows = totalRows;
			if (this.totalRows >= this.pageSize) {
				this.totalPages = this.pageSize * currentPage;
			} else {
				if (this.currentPage == 1) {
					this.totalPages = 1;
				} else {
					this.totalPages = this.pageSize;
				}
			}
		} else {
			this.totalRows = totalRows;
			this.totalPages = (int) Math.ceil((double) this.totalRows
					/ this.pageSize);
		}
		this.blockSize = blockSize;
		this.totalBlocks = (int) Math.ceil((double) this.totalPages
				/ this.blockSize);
		this.currentBlock = (int) Math
				.ceil((double) ((this.currentPage - 1) / this.blockSize)) + 1;
		this.startPageNum = ((this.currentBlock - 1) * this.pageSize) + 1;
		this.endPageNum = this.startPageNum + this.pageSize;
		this.setQueryString(request);
		this.linkSrc = linkSrc;
	}

	/**
	 * listRows가 있는 페이징 초기화
	 * 
	 * @param totalRows
	 * @param currentPage
	 * @param queryString
	 * @param pageSize
	 * @param blockSize
	 * @param linkSrc
	 */
	public void initialize(int totalRows, int listRows, int currentPage,
			HttpServletRequest request, int pageSize, int blockSize,
			String linkSrc) {
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.listRows = listRows;
		this.totalRows = totalRows;
		this.blockSize = blockSize;
		this.currentBlock = (int) Math
				.ceil((double) ((this.currentPage - 1) / this.blockSize)) + 1;
		this.startPageNum = ((this.currentBlock - 1) * this.pageSize) + 1;
		this.endPageNum = this.startPageNum + this.pageSize;

		if (this.pagingType == 2) {
			if (this.totalRows < this.listRows) {
				this.totalPages = this.currentPage;
				this.totalRows = (this.listRows * (this.currentPage - 1))
						+ this.totalRows;
				this.totalBlocks = (int) Math.ceil((double) this.totalPages
						/ this.blockSize);
				this.endPageNum = this.totalPages + 1;
			} else {
				this.totalPages = this.pageSize;
				this.totalRows = this.listRows * this.pageSize;
				this.totalBlocks = this.currentBlock + 1;
			}
		} else {
			this.totalPages = (int) Math.ceil((double) this.totalRows
					/ this.listRows);
			this.totalBlocks = (int) Math.ceil((double) this.totalPages
					/ this.blockSize);
		}

		this.setQueryString(request);
		this.linkSrc = linkSrc;
	}

	/**
	 * 이전 버튼 출력
	 */
	public void prePrint() {
		// set first block link
		if (this.currentBlock > 1)
			if (this.queryString != null) {
				pageString.append("<a href=\"" + this.linkSrc + "?"
						+ this.queryString + this.amp + this.pageParamName
						+ "=1\" style=\"" + this.getPageButtonlinkCssStyle()
						+ "\" class=\"" + this.getPageButtonlinkCssClass()
						+ "\">" + this.buttonImage.get("Start") + "</a>");
			} else {
				pageString.append("<a href=\"" + this.linkSrc + "?"
						+ this.pageParamName + "=1\" style=\""
						+ this.getPageButtonlinkCssStyle() + "\" class=\""
						+ this.getPageButtonlinkCssClass() + "\">"
						+ this.buttonImage.get("Start") + "</a>");
			}
		else
			pageString.append("");

		// set prev page link
		if (this.currentPage > this.pageSize)
			if (this.queryString != null) {
				pageString.append("<a href=\"" + this.linkSrc + "?"
						+ this.queryString + this.amp + this.pageParamName
						+ "=" + ((this.currentBlock - 2) * this.pageSize + 1)
						+ "\" style=\"" + this.getPageButtonlinkCssStyle()
						+ "\" class=\"" + this.getPageButtonlinkCssClass()
						+ "\">" + this.buttonImage.get("Prev") + "</a>");
			} else {
				pageString.append("<a href=\"" + this.linkSrc + "?"
						+ this.pageParamName + "="
						+ ((this.currentBlock - 2) * this.pageSize + 1)
						+ "\" style=\"" + this.getPageButtonlinkCssStyle()
						+ "\" class=\"" + this.getPageButtonlinkCssClass()
						+ "\">" + this.buttonImage.get("Prev") + "</a>");
			}
		else
			pageString.append("");
	}

	/**
	 * 다음 버튼 출력
	 */
	public void nextPrint() {
		// set next page link
		if (this.pagingType == 2) {
			if (this.currentBlock < this.totalBlocks) {
				if (this.queryString != null) {
					pageString.append("<a href=\"" + this.linkSrc + "?"
							+ this.queryString + this.amp + this.pageParamName
							+ "=" + ((this.currentBlock * this.pageSize) + 1)
							+ "\" style=\"" + this.getPageButtonlinkCssStyle()
							+ "\" class=\"" + this.getPageButtonlinkCssClass()
							+ "\">" + this.buttonImage.get("Next") + "</a>");
				} else {
					pageString.append("<a href=\"" + this.linkSrc + "?"
							+ this.pageParamName + "="
							+ ((this.currentBlock * this.pageSize) + 1)
							+ "\" style=\"" + this.getPageButtonlinkCssStyle()
							+ "\" class=\"" + this.getPageButtonlinkCssClass()
							+ "\">" + this.buttonImage.get("Next") + "</a>");
				}
			} else {
				pageString.append("");
			}
		} else {
			if (this.currentBlock < this.totalBlocks)
				if (this.queryString != null) {
					pageString.append("<a href=\"" + this.linkSrc + "?"
							+ this.queryString + this.amp + this.pageParamName
							+ "=" + ((this.currentBlock * this.pageSize) + 1)
							+ "\" style=\"" + this.getPageButtonlinkCssStyle()
							+ "\" class=\"" + this.getPageButtonlinkCssClass()
							+ "\">" + this.buttonImage.get("Next") + "</a>");
					pageString.append("<a href=\"" + this.linkSrc + "?"
							+ this.queryString + this.amp + this.pageParamName
							+ "=" + this.totalPages + "\" style=\""
							+ this.getPageButtonlinkCssStyle() + "\" class=\""
							+ this.getPageButtonlinkCssClass() + "\">"
							+ this.buttonImage.get("End") + "</a>");
				} else {
					pageString.append("<a href=\"" + this.linkSrc + "?"
							+ this.pageParamName + "="
							+ ((this.currentBlock * this.pageSize) + 1)
							+ "\" style=\"" + this.getPageButtonlinkCssStyle()
							+ "\" class=\"" + this.getPageButtonlinkCssClass()
							+ "\">" + this.buttonImage.get("Next") + "</a>");
					pageString.append("<a href=\"" + this.linkSrc + "?"
							+ this.pageParamName + "=" + this.totalPages
							+ "\" style=\"" + this.getPageButtonlinkCssStyle()
							+ "\" class=\"" + this.getPageButtonlinkCssClass()
							+ "\">" + this.buttonImage.get("End") + "</a>");
				}
			else
				pageString.append("");
		}
	}

	/**
	 * 페이징 리스트 출력
	 */
	public void printList() {
		for (int i = startPageNum; i <= endPageNum; i++) {
			if (this.pagingType == 2) {
				if (i == endPageNum)
					break;
				else if (i > startPageNum)
					pageString.append(this.buttonImage.get("Space"));
			} else {
				if (i > this.totalPages || i == endPageNum)
					break;
				else if (i > startPageNum)
					pageString.append(this.buttonImage.get("Space"));
			}

			if (i == this.currentPage)
				if (this.queryString != null) {
					pageString.append("<a href=\"" + this.linkSrc + "?"
							+ this.queryString + this.amp + this.pageParamName
							+ "=" + i + "\" style=\""
							+ this.getPageListOnlinkCssStyle() + "\" class=\""
							+ this.getPageListOnlinkCssClass() + "\">" + i
							+ "</a>");
				} else {
					pageString.append("<a href=\"" + this.linkSrc + "?"
							+ this.pageParamName + "=" + i + "\" style=\""
							+ this.getPageListOnlinkCssStyle() + "\" class=\""
							+ this.getPageListOnlinkCssClass() + "\">" + i
							+ "</a>");
				}
			else if (this.queryString != null) {
				pageString.append("<a href=\"" + this.linkSrc + "?"
						+ this.queryString + this.amp + this.pageParamName
						+ "=" + i + "\" style=\""
						+ this.getPageListlinkCssStyle() + "\" class=\""
						+ this.getPageListlinkCssClass() + "\">" + i + "</a>");
			} else {
				pageString.append("<a href=\"" + this.linkSrc + "?"
						+ this.pageParamName + "=" + i + "\" style=\""
						+ this.getPageListlinkCssStyle() + "\" class=\""
						+ this.getPageListlinkCssClass() + "\">" + i + "</a>");
			}
		}

	}

	/**
	 * 쿼리 스트링 저장
	 * 
	 * @param queryString
	 */
	public void setQueryString(HttpServletRequest request) {
		if (request.getParameterNames().hasMoreElements()) {
			this.queryString = WebUtil.getQueryString(request,
					this.pageParamName);
		} else {
			this.queryString = "";
		}
	}

	/**
	 * 페이징 관련 전체 출력
	 * 
	 * @return
	 */
	public String print() {
		if (this.queryString != "")
			this.amp = "&";

		if (this.totalPages > 1) {
			this.prePrint();
			this.printList();
			this.nextPrint();
		}

		return (pageString.toString());
	}
}