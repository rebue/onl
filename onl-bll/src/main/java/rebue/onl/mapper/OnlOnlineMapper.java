package rebue.onl.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import rebue.onl.mo.OnlOnlineMo;
import rebue.robotech.mapper.MybatisBaseMapper;
import rebue.onl.ro.OnlOnlineGoodsInfoRo;
import rebue.onl.to.OnlineGoodsListTo;

@Mapper
public interface OnlOnlineMapper extends MybatisBaseMapper<OnlOnlineMo, Long> {
	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table ONL_ONLINE
	 *
	 * @mbg.generated 2018-04-17 10:22:47
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table ONL_ONLINE
	 *
	 * @mbg.generated 2018-04-17 10:22:47
	 */
	int insert(OnlOnlineMo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table ONL_ONLINE
	 *
	 * @mbg.generated 2018-04-17 10:22:47
	 */
	int insertSelective(OnlOnlineMo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table ONL_ONLINE
	 *
	 * @mbg.generated 2018-04-17 10:22:47
	 */
	OnlOnlineMo selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table ONL_ONLINE
	 *
	 * @mbg.generated 2018-04-17 10:22:47
	 */
	int updateByPrimaryKeySelective(OnlOnlineMo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table ONL_ONLINE
	 *
	 * @mbg.generated 2018-04-17 10:22:47
	 */
	int updateByPrimaryKey(OnlOnlineMo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table ONL_ONLINE
	 *
	 * @mbg.generated 2018-04-17 10:22:47
	 */
	List<OnlOnlineMo> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table ONL_ONLINE
	 *
	 * @mbg.generated 2018-04-17 10:22:47
	 */
	List<OnlOnlineMo> selectSelective(OnlOnlineMo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table ONL_ONLINE
	 *
	 * @mbg.generated 2018-04-17 10:22:47
	 */
	boolean existByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table ONL_ONLINE
	 *
	 * @mbg.generated 2018-04-17 10:22:47
	 */
	boolean existSelective(OnlOnlineMo record);

	/**
	 * 获取上线商品列表 Title: selectOnlineGoodsList Description:
	 * 
	 * @return
	 * @date 2018年3月29日 下午5:39:41
	 */
	List<OnlOnlineGoodsInfoRo> selectOnlineGoodsList(OnlineGoodsListTo to);

	/**
	 * 判断产品是否已上线 Title: existOnlineByProduceId Description:
	 * 
	 * @param record
	 * @return
	 * @date 2018年4月12日 下午4:33:35
	 */
	boolean existOnlineByProduceId(OnlOnlineMo record);
}