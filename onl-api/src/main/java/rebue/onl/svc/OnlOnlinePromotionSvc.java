package rebue.onl.svc;

import java.util.List;
import java.util.Map;
import rebue.onl.dic.PromotionTypeDic;
import rebue.onl.mo.OnlOnlinePromotionMo;
import rebue.robotech.svc.MybatisBaseSvc;

/**
 * 上线推广
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
public interface OnlOnlinePromotionSvc extends MybatisBaseSvc<OnlOnlinePromotionMo, java.lang.Long> {

    /**
     * 获取上线的推广活动列表
     *
     * @param promotionType
     *            {@link PromotionTypeDic}
     *            推广类型（1-每日热门）
     */
    List<Map<String, Object>> listOnlinePromotion(PromotionTypeDic promotionType);
}
