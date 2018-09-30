package rebue.onl.mo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;

/**
 * 上线图片日志
 *
 * 数据库表: ONL_ONLINE_PIC_LOG
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
@JsonInclude(Include.NON_NULL)
public class OnlOnlinePicLogMo implements Serializable {

    /**
     *    上线图片日志ID
     *
     *    数据库字段: ONL_ONLINE_PIC_LOG.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long id;

    /**
     *    上线日志ID
     *
     *    数据库字段: ONL_ONLINE_PIC_LOG.ONLINE_LOG_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long onlineLogId;

    /**
     *    上线ID
     *
     *    数据库字段: ONL_ONLINE_PIC_LOG.ONLINE_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long onlineId;

    /**
     *    上线图片ID
     *
     *    数据库字段: ONL_ONLINE_PIC_LOG.ONLINE_PIC_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long onlinePicId;

    /**
     *    图片类型
     *
     *    数据库字段: ONL_ONLINE_PIC_LOG.PIC_TYPE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Byte picType;

    /**
     *    图片路径
     *
     *    数据库字段: ONL_ONLINE_PIC_LOG.PIC_PATH
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String picPath;

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private static final long serialVersionUID = 1L;

    /**
     *    上线图片日志ID
     *
     *    数据库字段: ONL_ONLINE_PIC_LOG.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getId() {
        return id;
    }

    /**
     *    上线图片日志ID
     *
     *    数据库字段: ONL_ONLINE_PIC_LOG.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *    上线日志ID
     *
     *    数据库字段: ONL_ONLINE_PIC_LOG.ONLINE_LOG_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getOnlineLogId() {
        return onlineLogId;
    }

    /**
     *    上线日志ID
     *
     *    数据库字段: ONL_ONLINE_PIC_LOG.ONLINE_LOG_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setOnlineLogId(Long onlineLogId) {
        this.onlineLogId = onlineLogId;
    }

    /**
     *    上线ID
     *
     *    数据库字段: ONL_ONLINE_PIC_LOG.ONLINE_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getOnlineId() {
        return onlineId;
    }

    /**
     *    上线ID
     *
     *    数据库字段: ONL_ONLINE_PIC_LOG.ONLINE_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setOnlineId(Long onlineId) {
        this.onlineId = onlineId;
    }

    /**
     *    上线图片ID
     *
     *    数据库字段: ONL_ONLINE_PIC_LOG.ONLINE_PIC_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getOnlinePicId() {
        return onlinePicId;
    }

    /**
     *    上线图片ID
     *
     *    数据库字段: ONL_ONLINE_PIC_LOG.ONLINE_PIC_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setOnlinePicId(Long onlinePicId) {
        this.onlinePicId = onlinePicId;
    }

    /**
     *    图片类型
     *
     *    数据库字段: ONL_ONLINE_PIC_LOG.PIC_TYPE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Byte getPicType() {
        return picType;
    }

    /**
     *    图片类型
     *
     *    数据库字段: ONL_ONLINE_PIC_LOG.PIC_TYPE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setPicType(Byte picType) {
        this.picType = picType;
    }

    /**
     *    图片路径
     *
     *    数据库字段: ONL_ONLINE_PIC_LOG.PIC_PATH
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getPicPath() {
        return picPath;
    }

    /**
     *    图片路径
     *
     *    数据库字段: ONL_ONLINE_PIC_LOG.PIC_PATH
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", onlineLogId=").append(onlineLogId);
        sb.append(", onlineId=").append(onlineId);
        sb.append(", onlinePicId=").append(onlinePicId);
        sb.append(", picType=").append(picType);
        sb.append(", picPath=").append(picPath);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
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
        OnlOnlinePicLogMo other = (OnlOnlinePicLogMo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()));
    }

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }
}
