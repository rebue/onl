package rebue.onl.svc;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import rebue.onl.mo.OnlOnlineSpecMo;
import rebue.onl.ro.ModifyOnlineSpecInfoRo;
import rebue.onl.ro.OnlOnlineSpecInfoRo;
import rebue.robotech.svc.MybatisBaseSvc;

/**
 * 上线规格
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
public interface OnlOnlineSpecSvc extends MybatisBaseSvc<OnlOnlineSpecMo, java.lang.Long> {

    /**
     *  根据商品规格编号查询商品规格信息 Title: selectByPrimaryKey Description:
     *
     *  @param id
     *  @return
     *  @date 2018年3月29日 下午2:15:17
     */
    OnlOnlineSpecMo selectByPrimaryKey(Long id);

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
     *  @param mo
     *  @return
     *  @date 2018年4月10日 下午2:21:42
     */
    int updateSelective(OnlOnlineSpecMo mo);

    /**
     *  删除购物车和修改上线数量 Title: deleteCartAndModifyInventory Description:
     *
     *  @param ro
     *  @return
     *  @throws IOException
     *  @throws JsonMappingException
     *  @throws JsonParseException
     *  @date 2018年4月11日 下午5:25:52
     */
    Map<String, Object> deleteCartAndModifyInventory(String cartAndSpecInfo) throws JsonParseException, JsonMappingException, IOException;

    /**
     *  修改上线规格信息 Title: resultMap Description:
     *
     *  @param mo
     *  @return
     *  @date 2018年4月23日 下午5:46:50
     */
    ModifyOnlineSpecInfoRo modifyOnlineSpecInfo(List<Map<String, Object>> specList);
}
