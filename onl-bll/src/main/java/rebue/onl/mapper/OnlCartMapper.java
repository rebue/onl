package rebue.onl.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import rebue.onl.mo.OnlCartMo;
import rebue.onl.ro.OnlCartRo;
import rebue.robotech.mapper.MybatisBaseMapper;

@Mapper
public interface OnlCartMapper extends MybatisBaseMapper<OnlCartMo, Long> {

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int deleteByPrimaryKey(Long id);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insert(OnlCartMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insertSelective(OnlCartMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    OnlCartMo selectByPrimaryKey(Long id);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKeySelective(OnlCartMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKey(OnlCartMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<OnlCartMo> selectAll();

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<OnlCartMo> selectSelective(OnlCartMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existByPrimaryKey(Long id);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existSelective(OnlCartMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int countSelective(OnlCartMo record);

    /**
     *  根据用户编号和购物车编号删除购物车 Title: deleteByUserIdAndCartId Description:
     *
     *  @param record
     *  @return
     *  @date 2018年3月29日 下午3:03:11
     */
    int deleteByUserIdAndCartId(OnlCartMo record);

    /**
     *  批量删除购物车 Title: deleteByUserIdAndCartIds Description:
     *
     *  @param map
     *  @return
     *  @date 2018年4月3日 下午3:25:38
     */
    int deleteByUserIdAndCartIds(Map<String, Object> map);

    /**
     *  根据用户编号、上线编号、规格编号修改购物车数量 Title: updateByCondition Description:
     *
     *  @param record
     *  @return
     *  @date 2018年3月30日 上午10:31:26
     */
    int updateByCondition(OnlCartMo record);

    /**
     *  根据用户编号查询购物车数量 Title: selectCartCountByUserId Description:
     *
     *  @param record
     *  @return
     *  @date 2018年3月30日 上午10:40:14
     */
    int selectCartCountByUserId(OnlCartMo record);

    /**
     *  获取购物车列表 Title: selectCartList Description:
     *
     *  @param record
     *  @return
     *  @date 2018年3月30日 下午1:52:14
     */
    List<OnlCartRo> selectCartList(OnlCartMo record);
}
