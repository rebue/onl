package rebue.onl.svc;

import java.util.List;
import rebue.onl.mo.OnlOnlineMo;
import rebue.onl.ro.AddOnlineRo;
import rebue.onl.ro.OnlOnlineGoodsInfoRo;
import rebue.onl.to.AddOnlineTo;
import rebue.onl.to.OnlineGoodsListTo;
import rebue.robotech.svc.MybatisBaseSvc;

public interface OnlOnlineSvc extends MybatisBaseSvc<OnlOnlineMo, java.lang.Long> {

    /**
     *  获取上线商品列表 Title: selectOnlineGoodsList Description:
     *
     *  @return
     *  @date 2018年3月29日 下午5:40:42
     */
    List<OnlOnlineGoodsInfoRo> selectOnlineGoodsList(OnlineGoodsListTo to);

    /**
     *  添加上线信息
     *
     *  @param to
     *  @return
     */
    AddOnlineRo addOnline(AddOnlineTo to);

    /**
     *  根据id查询上线信息
     *
     *  @param id
     *  @return
     */
    OnlOnlineMo listByPrimaryKey(Long id);
}
