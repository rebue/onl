package rebue.onl.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import rebue.onl.mo.OnlOnlineMo;
import rebue.onl.ro.OnlOnlineGoodsInfoRo;
import rebue.onl.to.OnlineGoodsListTo;
import rebue.robotech.mapper.MybatisBaseMapper;

@Mapper
public interface OnlOnlineMapper extends MybatisBaseMapper<OnlOnlineMo, Long> {

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int deleteByPrimaryKey(Long id);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insert(OnlOnlineMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insertSelective(OnlOnlineMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    OnlOnlineMo selectByPrimaryKey(Long id);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKeySelective(OnlOnlineMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKey(OnlOnlineMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<OnlOnlineMo> selectAll();

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<OnlOnlineMo> selectSelective(OnlOnlineMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existByPrimaryKey(Long id);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existSelective(OnlOnlineMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int countSelective(OnlOnlineMo record);

    /**
     *  获取上线商品列表 Title: selectOnlineGoodsList Description:
     *
     *  @return
     *  @date 2018年3月29日 下午5:39:41
     */
    List<OnlOnlineGoodsInfoRo> selectOnlineGoodsList(OnlineGoodsListTo to);

    /**
     *  判断产品是否已上线 Title: existOnlineByProduceId Description:
     *
     *  @param record
     *  @return
     *  @date 2018年4月12日 下午4:33:35
     */
    boolean existOnlineByProduceId(OnlOnlineMo record);
}
