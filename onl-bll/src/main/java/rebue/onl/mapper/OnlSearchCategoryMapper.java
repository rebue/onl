package rebue.onl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import rebue.onl.mo.OnlSearchCategoryMo;
import rebue.robotech.mapper.MybatisBaseMapper;

@Mapper
public interface OnlSearchCategoryMapper extends MybatisBaseMapper<OnlSearchCategoryMo, Long> {

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    int deleteByPrimaryKey(Long id);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    int insert(OnlSearchCategoryMo record);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    int insertSelective(OnlSearchCategoryMo record);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    OnlSearchCategoryMo selectByPrimaryKey(Long id);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    int updateByPrimaryKeySelective(OnlSearchCategoryMo record);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    int updateByPrimaryKey(OnlSearchCategoryMo record);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    List<OnlSearchCategoryMo> selectAll();

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    List<OnlSearchCategoryMo> selectSelective(OnlSearchCategoryMo record);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    boolean existByPrimaryKey(Long id);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    boolean existSelective(OnlSearchCategoryMo record);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    int countSelective(OnlSearchCategoryMo record);

    /**
     * 根据卖家、店铺和分类编码查询分类数量
     * 
     * @param sellerId 卖家id
     * @param shopId   店铺id
     * @param code     分类编码
     * @return
     */
    @Select("select count(*) from ONL_SEARCH_CATEGORY where SELLER_ID = #{sellerId,jdbcType=BIGINT} and SHOP_ID = #{shopId,jdbcType=BIGINT} and CODE like '${code}__'")
    int countBySellerAndShopAndCode(@Param("sellerId") Long sellerId, @Param("shopId") Long shopId,
            @Param("code") String code);

    /**
     * 禁用/启用店铺搜索分类 注：该方法会禁用/启用该分类和该分类下的所有子类
     * 
     * @return
     */
    @Update("update ONL_SEARCH_CATEGORY set IS_ENABLED=#{isEnabled,jdbcType=TINYINT} where SELLER_ID = #{sellerId,jdbcType=BIGINT} and SHOP_ID = #{shopId,jdbcType=BIGINT} and CODE like '${code}%'")
    int enable(@Param("sellerId") Long sellerId, @Param("shopId") Long shopId, @Param("code") String code,
            @Param("isEnabled") Boolean isEnabled);

    /**
     * 根据卖家id和店铺id禁用所有的店铺分类
     * 
     * @param sellerId
     * @param shopId
     * @return
     */
    @Update("update ONL_SEARCH_CATEGORY set IS_ENABLED=false where SELLER_ID = #{sellerId,jdbcType=BIGINT} and SHOP_ID = #{shopId,jdbcType=BIGINT}")
    int disable(@Param("sellerId") Long sellerId, @Param("shopId") Long shopId);

    /**
     * 根据店铺id查询顶级搜索分类
     * 
     * @param shopId
     * @return
     */
    @Select("SELECT * FROM ONL_SEARCH_CATEGORY where SHOP_ID = #{shopId,jdbcType=BIGINT} and code like '__' or code like '___' ;")
    List<OnlSearchCategoryMo> selectShopTopSearchCategory(@Param("shopId") Long shopId);

    /**
     * 根据店铺id和分类编码查询子级搜索分类
     * 
     * @param shopId
     * @return
     */
    @Select("SELECT * FROM ONL_SEARCH_CATEGORY where SHOP_ID = #{shopId,jdbcType=BIGINT} and code like '${code}__';")
    List<OnlSearchCategoryMo> selectShopSonSearchCategory(@Param("shopId") Long shopId, @Param("code") String code);

    /**
     * 根据店铺集合获取搜索分类id
     * 
     * @param shopIds
     * @return
     */
    @Select("SELECT * FROM ONL_SEARCH_CATEGORY where SHOP_ID in (${shopIds}) ")
    List<OnlSearchCategoryMo> searchCategoryByshopIds(@Param("shopIds") String shopIds);

    /**
     * 根据店铺id和上线id判断该分类是否存在
     * 
     * @param shopId
     * @param onlineId
     * @return
     */
    @Select("SELECT       count(*) FROM     ONL_SEARCH_CATEGORY WHERE     shop_id = #{shopId,jdbcType=BIGINT}     AND id in (SELECT          SEARCH_CATEGORY_ID       FROM            onl.ONL_SEARCH_CATEGORY_ONLINE      WHERE        online_id = #{onlineId,jdbcType=BIGINT})")
    int countSelectiveByShopId(@Param("shopId") Long shopId, @Param("onlineId") Long onlineId);
}
