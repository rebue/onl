package rebue.onl.mo;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

/**
 * Database Table Remarks:
 *   上线图片
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table ONL_ONLINE_PIC
 *
 * @mbg.generated do_not_delete_during_merge 2018-04-08 11:13:11
 */
@ApiModel(value = "OnlOnlinePicMo", description = "上线图片")
@JsonInclude(Include.NON_NULL)
public class OnlOnlinePicMo implements Serializable {
    /**
     * Database Column Remarks:
     *   上线图片ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ONL_ONLINE_PIC.ID
     *
     * @mbg.generated 2018-04-08 11:13:11
     */
    @ApiModelProperty(value = "上线图片ID")
    private Long id;

    /**
     * Database Column Remarks:
     *   上线ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ONL_ONLINE_PIC.ONLINE_ID
     *
     * @mbg.generated 2018-04-08 11:13:11
     */
    @ApiModelProperty(value = "上线ID")
    private Long onlineId;

    /**
     * Database Column Remarks:
     *   图片类型
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ONL_ONLINE_PIC.PIC_TYPE
     *
     * @mbg.generated 2018-04-08 11:13:11
     */
    @ApiModelProperty(value = "图片类型")
    private Byte picType;

    /**
     * Database Column Remarks:
     *   图片路径
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ONL_ONLINE_PIC.PIC_PATH
     *
     * @mbg.generated 2018-04-08 11:13:11
     */
    @ApiModelProperty(value = "图片路径")
    private String picPath;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ONL_ONLINE_PIC
     *
     * @mbg.generated 2018-04-08 11:13:11
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ONL_ONLINE_PIC.ID
     *
     * @return the value of ONL_ONLINE_PIC.ID
     *
     * @mbg.generated 2018-04-08 11:13:11
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ONL_ONLINE_PIC.ID
     *
     * @param id the value for ONL_ONLINE_PIC.ID
     *
     * @mbg.generated 2018-04-08 11:13:11
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ONL_ONLINE_PIC.ONLINE_ID
     *
     * @return the value of ONL_ONLINE_PIC.ONLINE_ID
     *
     * @mbg.generated 2018-04-08 11:13:11
     */
    public Long getOnlineId() {
        return onlineId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ONL_ONLINE_PIC.ONLINE_ID
     *
     * @param onlineId the value for ONL_ONLINE_PIC.ONLINE_ID
     *
     * @mbg.generated 2018-04-08 11:13:11
     */
    public void setOnlineId(Long onlineId) {
        this.onlineId = onlineId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ONL_ONLINE_PIC.PIC_TYPE
     *
     * @return the value of ONL_ONLINE_PIC.PIC_TYPE
     *
     * @mbg.generated 2018-04-08 11:13:11
     */
    public Byte getPicType() {
        return picType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ONL_ONLINE_PIC.PIC_TYPE
     *
     * @param picType the value for ONL_ONLINE_PIC.PIC_TYPE
     *
     * @mbg.generated 2018-04-08 11:13:11
     */
    public void setPicType(Byte picType) {
        this.picType = picType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ONL_ONLINE_PIC.PIC_PATH
     *
     * @return the value of ONL_ONLINE_PIC.PIC_PATH
     *
     * @mbg.generated 2018-04-08 11:13:11
     */
    public String getPicPath() {
        return picPath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ONL_ONLINE_PIC.PIC_PATH
     *
     * @param picPath the value for ONL_ONLINE_PIC.PIC_PATH
     *
     * @mbg.generated 2018-04-08 11:13:11
     */
    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ONL_ONLINE_PIC
     *
     * @mbg.generated 2018-04-08 11:13:11
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", onlineId=").append(onlineId);
        sb.append(", picType=").append(picType);
        sb.append(", picPath=").append(picPath);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ONL_ONLINE_PIC
     *
     * @mbg.generated 2018-04-08 11:13:11
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
        OnlOnlinePicMo other = (OnlOnlinePicMo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        ;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ONL_ONLINE_PIC
     *
     * @mbg.generated 2018-04-08 11:13:11
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }
}