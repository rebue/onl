package rebue.onl.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import rebue.onl.mo.OnlSearchCategoryMo;
import rebue.robotech.mapper.MybatisBaseMapper;

@Mapper
public interface OnlSearchCategoryMapper extends MybatisBaseMapper<OnlSearchCategoryMo, Long> {

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int deleteByPrimaryKey(Long id);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insert(OnlSearchCategoryMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insertSelective(OnlSearchCategoryMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    OnlSearchCategoryMo selectByPrimaryKey(Long id);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKeySelective(OnlSearchCategoryMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKey(OnlSearchCategoryMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<OnlSearchCategoryMo> selectAll();

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<OnlSearchCategoryMo> selectSelective(OnlSearchCategoryMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existByPrimaryKey(Long id);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existSelective(OnlSearchCategoryMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int countSelective(OnlSearchCategoryMo record);
}
