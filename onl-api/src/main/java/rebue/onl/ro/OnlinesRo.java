package rebue.onl.ro;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import rebue.onl.mo.OnlOnlinePicMo;
import rebue.onl.mo.OnlOnlineSpecMo;

public class OnlinesRo {
	private Long id;

	private String onlineTitle;

	private String onlineDetail;

	private Byte onlineState;

	private Long opId;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date onlineTime;

	private Long productId;

	private Byte subjectType;

	/**
	 * 规格信息
	 */
	private List<OnlOnlineSpecMo> onlineSpecList;

	/**
	 * 图片信息
	 */
	private List<OnlOnlinePicMo> onlinePicList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOnlineTitle() {
		return onlineTitle;
	}

	public void setOnlineTitle(String onlineTitle) {
		this.onlineTitle = onlineTitle;
	}

	public String getOnlineDetail() {
		return onlineDetail;
	}

	public void setOnlineDetail(String onlineDetail) {
		this.onlineDetail = onlineDetail;
	}

	public Byte getOnlineState() {
		return onlineState;
	}

	public void setOnlineState(Byte onlineState) {
		this.onlineState = onlineState;
	}

	public Long getOpId() {
		return opId;
	}

	public void setOpId(Long opId) {
		this.opId = opId;
	}

	public Date getOnlineTime() {
		return onlineTime;
	}

	public void setOnlineTime(Date onlineTime) {
		this.onlineTime = onlineTime;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Byte getSubjectType() {
		return subjectType;
	}

	public void setSubjectType(Byte subjectType) {
		this.subjectType = subjectType;
	}

	public List<OnlOnlineSpecMo> getOnlineSpecList() {
		return onlineSpecList;
	}

	public void setOnlineSpecList(List<OnlOnlineSpecMo> onlineSpecList) {
		this.onlineSpecList = onlineSpecList;
	}

	public List<OnlOnlinePicMo> getOnlinePicList() {
		return onlinePicList;
	}

	public void setOnlinePicList(List<OnlOnlinePicMo> onlinePicList) {
		this.onlinePicList = onlinePicList;
	}

	@Override
	public String toString() {
		return "OnlOnlineRo [id=" + id + ", onlineTitle=" + onlineTitle + ", onlineDetail=" + onlineDetail
				+ ", onlineState=" + onlineState + ", opId=" + opId + ", onlineTime=" + onlineTime + ", productId="
				+ productId + ", subjectType=" + subjectType + ", onlineSpecList=" + onlineSpecList + ", onlinePicList="
				+ onlinePicList + "]";
	}

}
