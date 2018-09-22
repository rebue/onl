package rebue.onl.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import rebue.onl.mo.OnlOnlineSpecMo;
import rebue.onl.ro.DeleteCartAndModifyInventoryRo;
import rebue.onl.ro.OnlOnlineSpecInfoRo;
import rebue.onl.to.AppendOnlineSpecCountTo;
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
    boolean selectSpecExistOnline(DeleteCartAndModifyInventoryRo record);

    /**
     * 追加上线数量
     * @return
     */
    int appendOnlineCount(AppendOnlineSpecCountTo record);
}
