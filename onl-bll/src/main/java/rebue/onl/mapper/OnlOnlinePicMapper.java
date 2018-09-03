package rebue.onl.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import rebue.onl.mo.OnlOnlinePicMo;
import rebue.robotech.mapper.MybatisBaseMapper;

@Mapper
public interface OnlOnlinePicMapper extends MybatisBaseMapper<OnlOnlinePicMo, Long> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ONL_ONLINE_PIC
     *
     * @mbg.generated 2018-08-31 10:09:16
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ONL_ONLINE_PIC
     *
     * @mbg.generated 2018-08-31 10:09:16
     */
    int insert(OnlOnlinePicMo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ONL_ONLINE_PIC
     *
     * @mbg.generated 2018-08-31 10:09:16
     */
    int insertSelective(OnlOnlinePicMo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ONL_ONLINE_PIC
     *
     * @mbg.generated 2018-08-31 10:09:16
     */
    OnlOnlinePicMo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ONL_ONLINE_PIC
     *
     * @mbg.generated 2018-08-31 10:09:16
     */
    int updateByPrimaryKeySelective(OnlOnlinePicMo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ONL_ONLINE_PIC
     *
     * @mbg.generated 2018-08-31 10:09:16
     */
    int updateByPrimaryKey(OnlOnlinePicMo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ONL_ONLINE_PIC
     *
     * @mbg.generated 2018-08-31 10:09:16
     */
    List<OnlOnlinePicMo> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ONL_ONLINE_PIC
     *
     * @mbg.generated 2018-08-31 10:09:16
     */
    List<OnlOnlinePicMo> selectSelective(OnlOnlinePicMo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ONL_ONLINE_PIC
     *
     * @mbg.generated 2018-08-31 10:09:16
     */
    boolean existByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ONL_ONLINE_PIC
     *
     * @mbg.generated 2018-08-31 10:09:16
     */
    boolean existSelective(OnlOnlinePicMo record);
}