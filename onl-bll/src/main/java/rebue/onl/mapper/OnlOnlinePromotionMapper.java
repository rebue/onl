package rebue.onl.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import rebue.onl.mo.OnlOnlinePromotionMo;
import rebue.robotech.mapper.MybatisBaseMapper;

@Mapper
public interface OnlOnlinePromotionMapper extends MybatisBaseMapper<OnlOnlinePromotionMo, Long> {

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int deleteByPrimaryKey(Long id);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insert(OnlOnlinePromotionMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insertSelective(OnlOnlinePromotionMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    OnlOnlinePromotionMo selectByPrimaryKey(Long id);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKeySelective(OnlOnlinePromotionMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKey(OnlOnlinePromotionMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<OnlOnlinePromotionMo> selectAll();

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<OnlOnlinePromotionMo> selectSelective(OnlOnlinePromotionMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existByPrimaryKey(Long id);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existSelective(OnlOnlinePromotionMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int countSelective(OnlOnlinePromotionMo record);

    /**
     *  获取推广上线数据信息 Title: promotionOnlineGoodsList Description:
     *
     *  @return
     *  @date 2018年3月29日 上午11:38:51
     */
    List<Map<String, Object>> promotionOnlineGoodsList();
}
