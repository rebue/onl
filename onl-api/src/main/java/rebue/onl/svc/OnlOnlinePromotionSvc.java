package rebue.onl.svc;

import java.util.List;
import java.util.Map;
import rebue.onl.mo.OnlOnlinePromotionMo;
import rebue.robotech.svc.MybatisBaseSvc;

/**
 * 上线推广
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
public interface OnlOnlinePromotionSvc extends MybatisBaseSvc<OnlOnlinePromotionMo, java.lang.Long> {

    /**
     *  获取推广上线数据信息 Title: promotionOnlineGoodsList Description:
     *
     *  @return
     *  @date 2018年3月29日 上午11:38:23
     */
    List<Map<String, Object>> promotionOnlineGoodsList();
}
