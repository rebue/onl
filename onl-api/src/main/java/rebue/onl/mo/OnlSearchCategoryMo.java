package rebue.onl.mo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;

/**
 * 搜索分类
 *
 * 数据库表: ONL_SEARCH_CATEGORY
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
@JsonInclude(Include.NON_NULL)
public class OnlSearchCategoryMo implements Serializable {

    /**
     *    分类ID
     *
     *    数据库字段: ONL_SEARCH_CATEGORY.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long id;

    /**
     *    卖家ID
     *
     *    数据库字段: ONL_SEARCH_CATEGORY.SELLER_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long sellerId;

    /**
     *    店铺ID
     *
     *    数据库字段: ONL_SEARCH_CATEGORY.SHOP_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long shopId;

    /**
     *    分类名称
     *
     *    数据库字段: ONL_SEARCH_CATEGORY.NAME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String name;

    /**
     *    分类编码
     *
     *    数据库字段: ONL_SEARCH_CATEGORY.CODE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String code;

    /**
     *    分类备注
     *
     *    数据库字段: ONL_SEARCH_CATEGORY.REMARK
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String remark;

    /**
     *    是否启用
     *
     *    数据库字段: ONL_SEARCH_CATEGORY.IS_ENABLED
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Boolean isEnabled;

    /**
     *    分类图片
     *
     *    数据库字段: ONL_SEARCH_CATEGORY.IMAGE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String image;

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private static final long serialVersionUID = 1L;

    /**
     *    分类ID
     *
     *    数据库字段: ONL_SEARCH_CATEGORY.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getId() {
        return id;
    }

    /**
     *    分类ID
     *
     *    数据库字段: ONL_SEARCH_CATEGORY.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *    卖家ID
     *
     *    数据库字段: ONL_SEARCH_CATEGORY.SELLER_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getSellerId() {
        return sellerId;
    }

    /**
     *    卖家ID
     *
     *    数据库字段: ONL_SEARCH_CATEGORY.SELLER_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    /**
     *    店铺ID
     *
     *    数据库字段: ONL_SEARCH_CATEGORY.SHOP_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getShopId() {
        return shopId;
    }

    /**
     *    店铺ID
     *
     *    数据库字段: ONL_SEARCH_CATEGORY.SHOP_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    /**
     *    分类名称
     *
     *    数据库字段: ONL_SEARCH_CATEGORY.NAME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getName() {
        return name;
    }

    /**
     *    分类名称
     *
     *    数据库字段: ONL_SEARCH_CATEGORY.NAME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *    分类编码
     *
     *    数据库字段: ONL_SEARCH_CATEGORY.CODE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getCode() {
        return code;
    }

    /**
     *    分类编码
     *
     *    数据库字段: ONL_SEARCH_CATEGORY.CODE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     *    分类备注
     *
     *    数据库字段: ONL_SEARCH_CATEGORY.REMARK
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getRemark() {
        return remark;
    }

    /**
     *    分类备注
     *
     *    数据库字段: ONL_SEARCH_CATEGORY.REMARK
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     *    是否启用
     *
     *    数据库字段: ONL_SEARCH_CATEGORY.IS_ENABLED
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Boolean getIsEnabled() {
        return isEnabled;
    }

    /**
     *    是否启用
     *
     *    数据库字段: ONL_SEARCH_CATEGORY.IS_ENABLED
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    /**
     *    分类图片
     *
     *    数据库字段: ONL_SEARCH_CATEGORY.IMAGE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getImage() {
        return image;
    }

    /**
     *    分类图片
     *
     *    数据库字段: ONL_SEARCH_CATEGORY.IMAGE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setImage(String image) {
        this.image = image;
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
        sb.append(", sellerId=").append(sellerId);
        sb.append(", shopId=").append(shopId);
        sb.append(", name=").append(name);
        sb.append(", code=").append(code);
        sb.append(", remark=").append(remark);
        sb.append(", isEnabled=").append(isEnabled);
        sb.append(", image=").append(image);
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
        OnlSearchCategoryMo other = (OnlSearchCategoryMo) that;
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
