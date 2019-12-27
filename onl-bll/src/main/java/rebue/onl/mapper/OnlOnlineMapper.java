package rebue.onl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import rebue.onl.mo.OnlOnlineMo;
import rebue.onl.ro.OnlOnlineGoodsInfoRo;
import rebue.onl.ro.SupplierGoodsRo;
import rebue.onl.so.OnlOnlineSpecSo;
import rebue.onl.to.OnlineGoodsListTo;
import rebue.onl.to.SelectOnlineTo;
import rebue.onl.to.SupplierGoodsTo;
import rebue.robotech.mapper.MybatisBaseMapper;

@Mapper
public interface OnlOnlineMapper extends MybatisBaseMapper<OnlOnlineMo, Long> {

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    int deleteByPrimaryKey(Long id);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    int insert(OnlOnlineMo record);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    int insertSelective(OnlOnlineMo record);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    OnlOnlineMo selectByPrimaryKey(Long id);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    int updateByPrimaryKeySelective(OnlOnlineMo record);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    int updateByPrimaryKey(OnlOnlineMo record);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    List<OnlOnlineMo> selectAll();

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    List<OnlOnlineMo> selectSelective(OnlOnlineMo record);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    boolean existByPrimaryKey(Long id);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    boolean existSelective(OnlOnlineMo record);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    int countSelective(OnlOnlineMo record);

    /**
     * 获取上线商品列表
     */
    List<OnlOnlineGoodsInfoRo> selectOnlineGoodsList(OnlineGoodsListTo to);

    /**
     * 判断产品是否已上线
     */
    boolean existOnlineByProduceId(OnlOnlineMo record);

    /**
     * 自动下线上线数量<=销售数量的上线记录
     */
    @//
    Update(//
    "UPDATE ONL_ONLINE AS a" + //
            "        INNER JOIN" + //
            "    (SELECT " + //
            "        COUNT(*) AS INVENTORY_COUNT" + //
            "    FROM" + //
            "        ONL_ONLINE_SPEC c" + //
            "    WHERE" + "        c.ONLINE_ID = #{onlineId}"
            + "            AND c.CURRENT_ONLINE_COUNT > c.SALE_COUNT) AS b " + "SET " + "    a.ONLINE_STATE = 0 "
            + "WHERE" + "    a.ID = #{onlineId}" + "        AND a.ONLINE_STATE = 1"
            + "        AND b.INVENTORY_COUNT = 0;")
    int autoOffline(@Param("onlineId") Long onlineId);

    /**
     * 供应商查询商品信息
     * 
     * @param record
     * @return
     */
    List<SupplierGoodsRo> selectSupplierGoods(SupplierGoodsTo record);

    /**
     * 查询上线信息
     * 
     * @param to
     * @return
     */
    List<OnlOnlineMo> selectOnlineInfo(SelectOnlineTo to);

    OnlOnlineMo selectOne(OnlOnlineMo mo);

    /**
     * 判断是否为称重商品
     * 
     * @param onlineId
     * @return
     */
    @Select("SELECT IS_WEIGH_GOODS FROM onl.ONL_ONLINE where id =#{onlineId};")
    boolean existWeighGoods(@Param("onlineId") Long onlineId);

    @Select("select  A.PRODUCT_ID , A.IS_WEIGH_GOODS, B.* from onl.ONL_ONLINE A , onl.ONL_ONLINE_SPEC B where A.ID = B.ONLINE_ID and A.OP_ID = 123456 ")
    List<OnlOnlineSpecSo> getOnlineInfo();

    @Select("select * from onl.ONL_ONLINE where ONLINE_TITLE=#{onlineTitle} and OP_ID=1234567 order by id desc limit 1")
    OnlOnlineMo getOneByName(@Param("onlineTitle") String onlineTitle);
}
