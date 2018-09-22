package rebue.onl.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import rebue.onl.mo.OnlOnlineLogMo;
import rebue.robotech.mapper.MybatisBaseMapper;

@Mapper
public interface OnlOnlineLogMapper extends MybatisBaseMapper<OnlOnlineLogMo, Long> {
    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int deleteByPrimaryKey(Long id);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insert(OnlOnlineLogMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insertSelective(OnlOnlineLogMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    OnlOnlineLogMo selectByPrimaryKey(Long id);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKeySelective(OnlOnlineLogMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKey(OnlOnlineLogMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<OnlOnlineLogMo> selectAll();

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<OnlOnlineLogMo> selectSelective(OnlOnlineLogMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existByPrimaryKey(Long id);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existSelective(OnlOnlineLogMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int countSelective(OnlOnlineLogMo record);
}