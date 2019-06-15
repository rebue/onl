package rebue.onl.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import rebue.onl.mo.OnlSearchCategoryMo;
import rebue.onl.mo.OnlSearchCategoryOnlineMo;
import rebue.robotech.mapper.MybatisBaseMapper;

@Mapper
public interface OnlSearchCategoryOnlineMapper extends MybatisBaseMapper<OnlSearchCategoryOnlineMo, Long> {

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int deleteByPrimaryKey(Long id);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insert(OnlSearchCategoryOnlineMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insertSelective(OnlSearchCategoryOnlineMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    OnlSearchCategoryOnlineMo selectByPrimaryKey(Long id);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKeySelective(OnlSearchCategoryOnlineMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKey(OnlSearchCategoryOnlineMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<OnlSearchCategoryOnlineMo> selectAll();

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<OnlSearchCategoryOnlineMo> selectSelective(OnlSearchCategoryOnlineMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existByPrimaryKey(Long id);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existSelective(OnlSearchCategoryOnlineMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int countSelective(OnlSearchCategoryOnlineMo record);
    
    /**
     * 根据上线id和搜索分类id删除数据
     * @param record
     * @return
     */
    int deleteByOnlineId(OnlSearchCategoryOnlineMo record);
    
    /**
     * 
     * @param searchCategoryId
     * @return
     */
	@Select("SELECT * FROM ONL_SEARCH_CATEGORY_ONLINE where SEARCH_CATEGORY_ID in (${searchCategoryIds}) ")
	List<OnlSearchCategoryOnlineMo>  selectBysearchCategoryIds(@Param("searchCategoryIds") String searchCategoryIds);

}
