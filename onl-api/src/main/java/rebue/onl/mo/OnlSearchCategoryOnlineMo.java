package rebue.onl.mo;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;

/**
搜索分类上线

数据库表: ONL_SEARCH_CATEGORY_ONLINE

@mbg.generated 自动生成的注释，如需修改本注释，请删除本行
*/
@JsonInclude(Include.NON_NULL)
public class OnlSearchCategoryOnlineMo implements Serializable {
    /**
    搜索分类上线ID
    
    数据库字段: ONL_SEARCH_CATEGORY_ONLINE.ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    private Long id;

    /**
    搜索分类ID
    
    数据库字段: ONL_SEARCH_CATEGORY_ONLINE.SEARCH_CATEGORY_ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    private Long searchCategoryId;

    /**
    上线ID
    
    数据库字段: ONL_SEARCH_CATEGORY_ONLINE.ONLINE_ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    private Long onlineId;

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private static final long serialVersionUID = 1L;

    /**
    搜索分类上线ID
    
    数据库字段: ONL_SEARCH_CATEGORY_ONLINE.ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public Long getId() {
        return id;
    }

    /**
    搜索分类上线ID
    
    数据库字段: ONL_SEARCH_CATEGORY_ONLINE.ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public void setId(Long id) {
        this.id = id;
    }

    /**
    搜索分类ID
    
    数据库字段: ONL_SEARCH_CATEGORY_ONLINE.SEARCH_CATEGORY_ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public Long getSearchCategoryId() {
        return searchCategoryId;
    }

    /**
    搜索分类ID
    
    数据库字段: ONL_SEARCH_CATEGORY_ONLINE.SEARCH_CATEGORY_ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public void setSearchCategoryId(Long searchCategoryId) {
        this.searchCategoryId = searchCategoryId;
    }

    /**
    上线ID
    
    数据库字段: ONL_SEARCH_CATEGORY_ONLINE.ONLINE_ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public Long getOnlineId() {
        return onlineId;
    }

    /**
    上线ID
    
    数据库字段: ONL_SEARCH_CATEGORY_ONLINE.ONLINE_ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public void setOnlineId(Long onlineId) {
        this.onlineId = onlineId;
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
        sb.append(", searchCategoryId=").append(searchCategoryId);
        sb.append(", onlineId=").append(onlineId);
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
        OnlSearchCategoryOnlineMo other = (OnlSearchCategoryOnlineMo) that;
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