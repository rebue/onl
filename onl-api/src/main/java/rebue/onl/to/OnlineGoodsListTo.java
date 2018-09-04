package rebue.onl.to;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 创建时间：2018年5月24日 下午2:56:52 项目名称：onl-api
 * 
 * @author daniel
 * @version 1.0
 * @since JDK 1.8 文件名称：OnlineGoodsListTo.java 类说明： 获取上线商品列表参数
 */
@JsonInclude(Include.NON_NULL)
public class OnlineGoodsListTo {

	/** 上线ID **/
	private long id;

	/** 上线标题 **/
	private String onlineTitle;

	/** 排序字段 **/
	private String sortname;

	/** 排序规则（desc、asc） **/
	private String sortOrder;

	/** 起始条数 **/
	private int start;

	/** 每页条数 **/
	private int size;
	
	/** 板块类型 **/
	private Integer subjectType;

	/** 最低价 **/
	private Integer lowPrice;
	
	/** 最高价 **/
	private Integer hignPrice;

	public Integer getLowPrice() {
		return lowPrice;
	}

	public void setLowPrice(Integer lowPrice) {
		this.lowPrice = lowPrice;
	}

	public Integer getHignPrice() {
		return hignPrice;
	}

	public void setHignPrice(Integer hignPrice) {
		this.hignPrice = hignPrice;
	}

	public Integer getSubjectType() {
		return subjectType;
	}

	public void setSubjectType(Integer subjectType) {
		this.subjectType = subjectType;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOnlineTitle() {
		return onlineTitle;
	}

	public void setOnlineTitle(String onlineTitle) {
		this.onlineTitle = onlineTitle;
	}

	public String getSortname() {
		return sortname;
	}

	public void setSortname(String sortname) {
		this.sortname = sortname;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "OnlineGoodsListTo [id=" + id + ", onlineTitle=" + onlineTitle + ", sortname=" + sortname
				+ ", sortOrder=" + sortOrder + ", start=" + start + ", size=" + size + ", subjectType=" + subjectType
				+ ", lowPrice=" + lowPrice + ", hignPrice=" + hignPrice + "]";
	}

}
