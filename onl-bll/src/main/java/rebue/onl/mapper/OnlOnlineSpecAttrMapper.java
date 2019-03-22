package rebue.onl.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import rebue.onl.mo.OnlOnlineSpecAttrMo;
import rebue.robotech.mapper.MybatisBaseMapper;

@Mapper
public interface OnlOnlineSpecAttrMapper extends MybatisBaseMapper<OnlOnlineSpecAttrMo, Long> {
    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int deleteByPrimaryKey(Long id);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insert(OnlOnlineSpecAttrMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insertSelective(OnlOnlineSpecAttrMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    OnlOnlineSpecAttrMo selectByPrimaryKey(Long id);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKeySelective(OnlOnlineSpecAttrMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKey(OnlOnlineSpecAttrMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<OnlOnlineSpecAttrMo> selectAll();

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<OnlOnlineSpecAttrMo> selectSelective(OnlOnlineSpecAttrMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existByPrimaryKey(Long id);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existSelective(OnlOnlineSpecAttrMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int countSelective(OnlOnlineSpecAttrMo record);
}