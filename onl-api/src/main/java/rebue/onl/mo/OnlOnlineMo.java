package rebue.onl.mo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Database Table Remarks:
 *   上线信息
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table ONL_ONLINE
 *
 * @mbg.generated do_not_delete_during_merge 2018-03-26 15:41:46
 */
@ApiModel(value = "OnlOnlineMo", description = "上线信息")
@JsonInclude(Include.NON_NULL)
public class OnlOnlineMo implements Serializable {
    /**
     * Database Column Remarks:
     *   上线ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ONL_ONLINE.ID
     *
     * @mbg.generated 2018-03-26 15:41:46
     */
    @ApiModelProperty(value = "上线ID")
    private Long id;

    /**
     * Database Column Remarks:
     *   上线标题
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ONL_ONLINE.ONLINE_TITLE
     *
     * @mbg.generated 2018-03-26 15:41:46
     */
    @ApiModelProperty(value = "上线标题")
    private String onlineTitle;

    /**
     * Database Column Remarks:
     *   上线描述
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ONL_ONLINE.ONLINE_DETAIL
     *
     * @mbg.generated 2018-03-26 15:41:46
     */
    @ApiModelProperty(value = "上线描述")
    private String onlineDetail;

    /**
     * Database Column Remarks:
     *   上线状态（0：下线，1：上线  ）
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ONL_ONLINE.ONLINE_STATE
     *
     * @mbg.generated 2018-03-26 15:41:46
     */
    @ApiModelProperty(value = "上线状态（0：下线，1：上线  ）")
    private Byte onlineState;

    /**
     * Database Column Remarks:
     *   上线时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ONL_ONLINE.ONLINE_TIME
     *
     * @mbg.generated 2018-03-26 15:41:46
     */
    @ApiModelProperty(value = "上线时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date onlineTime;

    /**
     * 上线编号
     */
    private String onlineId;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ONL_ONLINE
     *
     * @mbg.generated 2018-03-26 15:41:46
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ONL_ONLINE.ID
     *
     * @return the value of ONL_ONLINE.ID
     *
     * @mbg.generated 2018-03-26 15:41:46
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ONL_ONLINE.ID
     *
     * @param id the value for ONL_ONLINE.ID
     *
     * @mbg.generated 2018-03-26 15:41:46
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ONL_ONLINE.ONLINE_TITLE
     *
     * @return the value of ONL_ONLINE.ONLINE_TITLE
     *
     * @mbg.generated 2018-03-26 15:41:46
     */
    public String getOnlineTitle() {
        return onlineTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ONL_ONLINE.ONLINE_TITLE
     *
     * @param onlineTitle the value for ONL_ONLINE.ONLINE_TITLE
     *
     * @mbg.generated 2018-03-26 15:41:46
     */
    public void setOnlineTitle(String onlineTitle) {
        this.onlineTitle = onlineTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ONL_ONLINE.ONLINE_DETAIL
     *
     * @return the value of ONL_ONLINE.ONLINE_DETAIL
     *
     * @mbg.generated 2018-03-26 15:41:46
     */
    public String getOnlineDetail() {
        return onlineDetail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ONL_ONLINE.ONLINE_DETAIL
     *
     * @param onlineDetail the value for ONL_ONLINE.ONLINE_DETAIL
     *
     * @mbg.generated 2018-03-26 15:41:46
     */
    public void setOnlineDetail(String onlineDetail) {
        this.onlineDetail = onlineDetail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ONL_ONLINE.ONLINE_STATE
     *
     * @return the value of ONL_ONLINE.ONLINE_STATE
     *
     * @mbg.generated 2018-03-26 15:41:46
     */
    public Byte getOnlineState() {
        return onlineState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ONL_ONLINE.ONLINE_STATE
     *
     * @param onlineState the value for ONL_ONLINE.ONLINE_STATE
     *
     * @mbg.generated 2018-03-26 15:41:46
     */
    public void setOnlineState(Byte onlineState) {
        this.onlineState = onlineState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ONL_ONLINE.ONLINE_TIME
     *
     * @return the value of ONL_ONLINE.ONLINE_TIME
     *
     * @mbg.generated 2018-03-26 15:41:46
     */
    public Date getOnlineTime() {
        return onlineTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ONL_ONLINE.ONLINE_TIME
     *
     * @param onlineTime the value for ONL_ONLINE.ONLINE_TIME
     *
     * @mbg.generated 2018-03-26 15:41:46
     */
    public void setOnlineTime(Date onlineTime) {
        this.onlineTime = onlineTime;
    }

    public String getOnlineId() {
		return onlineId;
	}

	public void setOnlineId(String onlineId) {
		this.onlineId = onlineId;
	}

    @Override
	public String toString() {
		return "OnlOnlineMo [id=" + id + ", onlineTitle=" + onlineTitle + ", onlineDetail=" + onlineDetail
				+ ", onlineState=" + onlineState + ", onlineTime=" + onlineTime + ", onlineId=" + onlineId + "]";
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ONL_ONLINE
     *
     * @mbg.generated 2018-03-26 15:41:46
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        OnlOnlineMo other = (OnlOnlineMo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        ;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ONL_ONLINE
     *
     * @mbg.generated 2018-03-26 15:41:46
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }
}