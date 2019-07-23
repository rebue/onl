package rebue.onl.svc;

import java.math.BigDecimal;
import java.util.List;

import rebue.onl.mo.OnlOnlineSpecMo;
import rebue.onl.ro.OnlOnlineSpecInfoRo;
import rebue.onl.to.ModifySaleCountByIdTo;
import rebue.onl.to.OnlOnlineSpecTo;
import rebue.robotech.ro.Ro;
import rebue.robotech.svc.MybatisBaseSvc;

/**
 * 上线规格
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
public interface OnlOnlineSpecSvc extends MybatisBaseSvc<OnlOnlineSpecMo, java.lang.Long> {

    /**
     * 根据商品规格编号查询商品规格信息
     */
    OnlOnlineSpecMo selectByPrimaryKey(Long id);

    /**
     * 获取上线规格信息
     */
    List<OnlOnlineSpecInfoRo> selectOnlineSpecInfo(OnlOnlineSpecMo record);

    /**
     * 修改上线规格信息
     */
    int updateSelective(OnlOnlineSpecMo mo);

    /**
     * 修改上线规格信息
     */
    int updateOnlineSpec(OnlOnlineSpecTo to);

    /**
     * 根据规格id批量删除规格信息
     */
    int batchDeleteByIds(String ids, Long onlineId);

    /**
     * 判断商品规格是否存在
     */
    Boolean existOnlineSpec(String onlineSpec, Long onlineId);

    /**
     * 更新销售数量(购买后)
     * 新销售数量 = 原销售数量 + 购买数量
     *
     * @param buyCount
     *                     购买数量
     * @param onlineSpecId
     *                     上线规格ID
     * @param saleCount
     *                     原销售数量
     * @return 更新影响的行数，为0表示出现并发问题
     */
    int updateSaleCount(BigDecimal buyCount, Long onlineSpecId, BigDecimal saleCount);

    /**
     * 根据上线规格id修改销售数量(减)
     */
    Ro modifySaleCountById(ModifySaleCountByIdTo to);

    /**
     * 根据上线规格id修改是否已有首单
     * 
     * @param id
     * @param isHaveFirstOrder
     * @return
     */
    Ro modifyIsHaveFirstOrderById(Long id, Boolean isHaveFirstOrder);
}
