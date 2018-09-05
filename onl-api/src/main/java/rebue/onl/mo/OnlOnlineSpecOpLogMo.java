package rebue.onl.mo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
上线规格操作日志信息
记录上线规格份数的调整情况（日志）

数据库表: ONL_ONLINE_SPEC_OP_LOG

@mbg.generated 自动生成的注释，如需修改本注释，请删除本行
*/
@JsonInclude(Include.NON_NULL)
public class OnlOnlineSpecOpLogMo implements Serializable {
    /**
    操作日志id
    
    数据库字段: ONL_ONLINE_SPEC_OP_LOG.ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    private Long id;

    /**
    上线ID
    
    数据库字段: ONL_ONLINE_SPEC_OP_LOG.ONLINE_ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    private Long onlineId;

    /**
    上线规格ID
    
    数据库字段: ONL_ONLINE_SPEC_OP_LOG.ONLINE_SPEC_ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    private Long onlineSpecId;

    /**
    操作人id
    
    数据库字段: ONL_ONLINE_SPEC_OP_LOG.OP_ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    private Long opId;

    /**
    操作内容
    
    数据库字段: ONL_ONLINE_SPEC_OP_LOG.OP_CONTENT
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    private String opContent;

    /**
    操作时间
    
    数据库字段: ONL_ONLINE_SPEC_OP_LOG.OP_TIME
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date opTime;

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private static final long serialVersionUID = 1L;

    /**
    操作日志id
    
    数据库字段: ONL_ONLINE_SPEC_OP_LOG.ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public Long getId() {
        return id;
    }

    /**
    操作日志id
    
    数据库字段: ONL_ONLINE_SPEC_OP_LOG.ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public void setId(Long id) {
        this.id = id;
    }

    /**
    上线ID
    
    数据库字段: ONL_ONLINE_SPEC_OP_LOG.ONLINE_ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public Long getOnlineId() {
        return onlineId;
    }

    /**
    上线ID
    
    数据库字段: ONL_ONLINE_SPEC_OP_LOG.ONLINE_ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public void setOnlineId(Long onlineId) {
        this.onlineId = onlineId;
    }

    /**
    上线规格ID
    
    数据库字段: ONL_ONLINE_SPEC_OP_LOG.ONLINE_SPEC_ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public Long getOnlineSpecId() {
        return onlineSpecId;
    }

    /**
    上线规格ID
    
    数据库字段: ONL_ONLINE_SPEC_OP_LOG.ONLINE_SPEC_ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public void setOnlineSpecId(Long onlineSpecId) {
        this.onlineSpecId = onlineSpecId;
    }

    /**
    操作人id
    
    数据库字段: ONL_ONLINE_SPEC_OP_LOG.OP_ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public Long getOpId() {
        return opId;
    }

    /**
    操作人id
    
    数据库字段: ONL_ONLINE_SPEC_OP_LOG.OP_ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public void setOpId(Long opId) {
        this.opId = opId;
    }

    /**
    操作内容
    
    数据库字段: ONL_ONLINE_SPEC_OP_LOG.OP_CONTENT
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public String getOpContent() {
        return opContent;
    }

    /**
    操作内容
    
    数据库字段: ONL_ONLINE_SPEC_OP_LOG.OP_CONTENT
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public void setOpContent(String opContent) {
        this.opContent = opContent;
    }

    /**
    操作时间
    
    数据库字段: ONL_ONLINE_SPEC_OP_LOG.OP_TIME
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public Date getOpTime() {
        return opTime;
    }

    /**
    操作时间
    
    数据库字段: ONL_ONLINE_SPEC_OP_LOG.OP_TIME
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public void setOpTime(Date opTime) {
        this.opTime = opTime;
    }

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", onlineId=").append(onlineId);
        sb.append(", onlineSpecId=").append(onlineSpecId);
        sb.append(", opId=").append(opId);
        sb.append(", opContent=").append(opContent);
        sb.append(", opTime=").append(opTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
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
        OnlOnlineSpecOpLogMo other = (OnlOnlineSpecOpLogMo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        ;
    }

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }
}