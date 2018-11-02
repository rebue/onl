package rebue.onl.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import rebue.onl.mo.OnlOnlineSpecMo;
import rebue.onl.ro.OnlOnlineSpecInfoRo;
import rebue.onl.to.AppendOnlineSpecCountTo;
import rebue.onl.to.DeleteCartAndModifyInventoryTo;
import rebue.onl.to.OnlOnlineSpecTo;
import rebue.robotech.mapper.MybatisBaseMapper;

@Mapper
public interface OnlOnlineSpecMapper extends MybatisBaseMapper<OnlOnlineSpecMo, Long> {

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int deleteByPrimaryKey(Long id);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insert(OnlOnlineSpecMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insertSelective(OnlOnlineSpecMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    OnlOnlineSpecMo selectByPrimaryKey(Long id);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKeySelective(OnlOnlineSpecMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKey(OnlOnlineSpecMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<OnlOnlineSpecMo> selectAll();

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<OnlOnlineSpecMo> selectSelective(OnlOnlineSpecMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existByPrimaryKey(Long id);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existSelective(OnlOnlineSpecMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int countSelective(OnlOnlineSpecMo record);

    /**
     *  获取上线规格信息 Title: selectOnlineSpecInfoByOnlineId Description:
     *
     *  @param record
     *  @return
     *  @date 2018年4月1日 下午4:29:31
     */
    List<OnlOnlineSpecInfoRo> selectOnlineSpecInfo(OnlOnlineSpecMo record);

    /**
     *  修改上线规格信息 Title: updateSelective Description:
     *
     *  @param record
     *  @return
     *  @date 2018年4月10日 下午2:17:23
     */
    int updateSelective(OnlOnlineSpecMo record);

    /**
     *  查询商品规格是否已上线 Title: selectSpecExistOnline Description:
     *
     *  @param record
     *  @return
     *  @date 2018年4月11日 下午5:02:30
     */
    boolean selectSpecExistOnline(DeleteCartAndModifyInventoryTo record);

    /**
     *  追加上线数量
     *
     *  @return
     */
    int appendOnlineCount(AppendOnlineSpecCountTo record);

    /**
     *  修改销售数量
     *	新销售数量 = 原销售数量 + 购买数量
     *  @param to
     *  @return
     */
    @Update("update ONL_ONLINE_SPEC set SALE_COUNT=SALE_COUNT + ${buyCount} where ONLINE_ID=#{onlineId,jdbcType=BIGINT} and ONLINE_SPEC=#{onlineSpec,jdbcType=VARCHAR} and SALE_COUNT=#{saleCount,jdbcType=INTEGER}")
    int updateSaleCount(@Param("buyCount") Integer buyCount, @Param("onlineId") Long onlineId, @Param("onlineSpec") String onlineSpec, @Param("saleCount") Integer saleCount);

    /**
     * 取消订单修改上线销量
     * @return
     */
    @Update("update ONL_ONLINE_SPEC set SALE_COUNT=SALE_COUNT - ${buyCount} where ONLINE_ID=#{onlineId,jdbcType=BIGINT} and ONLINE_SPEC=#{onlineSpec,jdbcType=VARCHAR} and SALE_COUNT=#{saleCount,jdbcType=INTEGER}")
    int cancelUpdateCount(@Param("onlineId") Long onlineId, @Param("onlineSpec") String onlineSpec, @Param("saleCount") Integer saleCount, @Param("buyCount") Integer buyCount);

    /**
     *  修改上线规格信息
     *
     *  @param to
     *  @return
     */
    int updateOnlineSpec(OnlOnlineSpecTo to);

    /**
     *  根据规格id批量删除规格信息
     *
     *  @param ids
     *  @return
     */
    @Delete("delete from ONL_ONLINE_SPEC where ID not in(${ids}) and ONLINE_ID=${onlineId}")
    int batchDeleteByIds(@Param("ids") String ids, @Param("onlineId") Long onlineId);
}
