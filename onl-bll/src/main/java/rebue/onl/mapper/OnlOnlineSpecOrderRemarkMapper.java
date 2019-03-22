package rebue.onl.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import rebue.onl.mo.OnlOnlineSpecOrderRemarkMo;
import rebue.robotech.mapper.MybatisBaseMapper;

@Mapper
public interface OnlOnlineSpecOrderRemarkMapper extends MybatisBaseMapper<OnlOnlineSpecOrderRemarkMo, Long> {
    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int deleteByPrimaryKey(Long id);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insert(OnlOnlineSpecOrderRemarkMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insertSelective(OnlOnlineSpecOrderRemarkMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    OnlOnlineSpecOrderRemarkMo selectByPrimaryKey(Long id);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKeySelective(OnlOnlineSpecOrderRemarkMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKey(OnlOnlineSpecOrderRemarkMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<OnlOnlineSpecOrderRemarkMo> selectAll();

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<OnlOnlineSpecOrderRemarkMo> selectSelective(OnlOnlineSpecOrderRemarkMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existByPrimaryKey(Long id);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existSelective(OnlOnlineSpecOrderRemarkMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int countSelective(OnlOnlineSpecOrderRemarkMo record);
}