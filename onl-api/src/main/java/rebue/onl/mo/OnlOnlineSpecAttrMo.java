package rebue.onl.mo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;

/**
 * 上线规格属性
 *
 * 数据库表: ONL_ONLINE_SPEC_ATTR
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
@JsonInclude(Include.NON_NULL)
public class OnlOnlineSpecAttrMo implements Serializable {

    /**
     *    上线规格属性ID
     *
     *    数据库字段: ONL_ONLINE_SPEC_ATTR.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long id;

    /**
     *    上线规格ID
     *
     *    数据库字段: ONL_ONLINE_SPEC_ATTR.ONLINE_SPEC_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long onlineSpecId;

    /**
     *    属性名称
     *
     *    数据库字段: ONL_ONLINE_SPEC_ATTR.ATTR_NAME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String attrName;

    /**
     *    属性值
     *
     *    数据库字段: ONL_ONLINE_SPEC_ATTR.ATTR_VALUE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String attrValue;

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private static final long serialVersionUID = 1L;

    /**
     *    上线规格属性ID
     *
     *    数据库字段: ONL_ONLINE_SPEC_ATTR.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getId() {
        return id;
    }

    /**
     *    上线规格属性ID
     *
     *    数据库字段: ONL_ONLINE_SPEC_ATTR.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *    上线规格ID
     *
     *    数据库字段: ONL_ONLINE_SPEC_ATTR.ONLINE_SPEC_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getOnlineSpecId() {
        return onlineSpecId;
    }

    /**
     *    上线规格ID
     *
     *    数据库字段: ONL_ONLINE_SPEC_ATTR.ONLINE_SPEC_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setOnlineSpecId(Long onlineSpecId) {
        this.onlineSpecId = onlineSpecId;
    }

    /**
     *    属性名称
     *
     *    数据库字段: ONL_ONLINE_SPEC_ATTR.ATTR_NAME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getAttrName() {
        return attrName;
    }

    /**
     *    属性名称
     *
     *    数据库字段: ONL_ONLINE_SPEC_ATTR.ATTR_NAME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    /**
     *    属性值
     *
     *    数据库字段: ONL_ONLINE_SPEC_ATTR.ATTR_VALUE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getAttrValue() {
        return attrValue;
    }

    /**
     *    属性值
     *
     *    数据库字段: ONL_ONLINE_SPEC_ATTR.ATTR_VALUE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue;
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
        sb.append(", onlineSpecId=").append(onlineSpecId);
        sb.append(", attrName=").append(attrName);
        sb.append(", attrValue=").append(attrValue);
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
        OnlOnlineSpecAttrMo other = (OnlOnlineSpecAttrMo) that;
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
