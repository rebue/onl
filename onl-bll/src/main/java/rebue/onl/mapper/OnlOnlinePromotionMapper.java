package rebue.onl.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import rebue.onl.mo.OnlOnlinePromotionMo;
import rebue.robotech.mapper.MybatisBaseMapper;
import java.util.Map;

@Mapper
public interface OnlOnlinePromotionMapper
		extends
			MybatisBaseMapper<OnlOnlinePromotionMo, Long> {
	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table ONL_ONLINE_PROMOTION
	 *
	 * @mbg.generated 2018-04-08 11:13:12
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table ONL_ONLINE_PROMOTION
	 *
	 * @mbg.generated 2018-04-08 11:13:12
	 */
	int insert(OnlOnlinePromotionMo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table ONL_ONLINE_PROMOTION
	 *
	 * @mbg.generated 2018-04-08 11:13:12
	 */
	int insertSelective(OnlOnlinePromotionMo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table ONL_ONLINE_PROMOTION
	 *
	 * @mbg.generated 2018-04-08 11:13:12
	 */
	OnlOnlinePromotionMo selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table ONL_ONLINE_PROMOTION
	 *
	 * @mbg.generated 2018-04-08 11:13:12
	 */
	int updateByPrimaryKeySelective(OnlOnlinePromotionMo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table ONL_ONLINE_PROMOTION
	 *
	 * @mbg.generated 2018-04-08 11:13:12
	 */
	int updateByPrimaryKey(OnlOnlinePromotionMo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table ONL_ONLINE_PROMOTION
	 *
	 * @mbg.generated 2018-04-08 11:13:12
	 */
	List<OnlOnlinePromotionMo> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table ONL_ONLINE_PROMOTION
	 *
	 * @mbg.generated 2018-04-08 11:13:12
	 */
	List<OnlOnlinePromotionMo> selectSelective(OnlOnlinePromotionMo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table ONL_ONLINE_PROMOTION
	 *
	 * @mbg.generated 2018-04-08 11:13:12
	 */
	boolean existByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table ONL_ONLINE_PROMOTION
	 *
	 * @mbg.generated 2018-04-08 11:13:12
	 */
	boolean existSelective(OnlOnlinePromotionMo record);

	/**
	 * 获取推广上线数据信息 Title: promotionOnlineGoodsList Description:
	 * 
	 * @return
	 * @date 2018年3月29日 上午11:38:51
	 */
	List<Map<String, Object>> promotionOnlineGoodsList();
}