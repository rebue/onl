package rebue.onl.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import rebue.onl.mo.OnlOnlinePromotionMo;
import rebue.robotech.mapper.MybatisBaseMapper;

@Mapper
public interface OnlOnlinePromotionMapper extends MybatisBaseMapper<OnlOnlinePromotionMo, Long> {

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    int deleteByPrimaryKey(Long id);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    int insert(OnlOnlinePromotionMo record);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    int insertSelective(OnlOnlinePromotionMo record);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    OnlOnlinePromotionMo selectByPrimaryKey(Long id);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    int updateByPrimaryKeySelective(OnlOnlinePromotionMo record);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    int updateByPrimaryKey(OnlOnlinePromotionMo record);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    List<OnlOnlinePromotionMo> selectAll();

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    List<OnlOnlinePromotionMo> selectSelective(OnlOnlinePromotionMo record);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    boolean existByPrimaryKey(Long id);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    boolean existSelective(OnlOnlinePromotionMo record);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    int countSelective(OnlOnlinePromotionMo record);

    /**
     * 获取上线的推广活动列表
     */
    List<Map<String, Object>> listOnlinePromotion(@Param("promotionType") Byte promotionType);
}
