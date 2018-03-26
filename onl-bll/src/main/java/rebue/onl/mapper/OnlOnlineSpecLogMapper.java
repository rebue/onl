package rebue.onl.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import rebue.onl.mo.OnlOnlineSpecLogMo;
import rebue.robotech.mapper.MybatisBaseMapper;

@Mapper
public interface OnlOnlineSpecLogMapper extends MybatisBaseMapper<OnlOnlineSpecLogMo, Long> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ONL_ONLINE_SPEC_LOG
     *
     * @mbg.generated 2018-03-26 15:41:47
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ONL_ONLINE_SPEC_LOG
     *
     * @mbg.generated 2018-03-26 15:41:47
     */
    int insert(OnlOnlineSpecLogMo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ONL_ONLINE_SPEC_LOG
     *
     * @mbg.generated 2018-03-26 15:41:47
     */
    int insertSelective(OnlOnlineSpecLogMo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ONL_ONLINE_SPEC_LOG
     *
     * @mbg.generated 2018-03-26 15:41:47
     */
    OnlOnlineSpecLogMo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ONL_ONLINE_SPEC_LOG
     *
     * @mbg.generated 2018-03-26 15:41:47
     */
    int updateByPrimaryKeySelective(OnlOnlineSpecLogMo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ONL_ONLINE_SPEC_LOG
     *
     * @mbg.generated 2018-03-26 15:41:47
     */
    int updateByPrimaryKey(OnlOnlineSpecLogMo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ONL_ONLINE_SPEC_LOG
     *
     * @mbg.generated 2018-03-26 15:41:47
     */
    List<OnlOnlineSpecLogMo> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ONL_ONLINE_SPEC_LOG
     *
     * @mbg.generated 2018-03-26 15:41:47
     */
    List<OnlOnlineSpecLogMo> selectSelective(OnlOnlineSpecLogMo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ONL_ONLINE_SPEC_LOG
     *
     * @mbg.generated 2018-03-26 15:41:47
     */
    boolean existByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ONL_ONLINE_SPEC_LOG
     *
     * @mbg.generated 2018-03-26 15:41:47
     */
    boolean existSelective(OnlOnlineSpecLogMo record);
}