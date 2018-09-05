package rebue.onl.svc;

import java.util.List;
import rebue.onl.mo.OnlOnlinePicMo;
import rebue.robotech.svc.MybatisBaseSvc;

public interface OnlOnlinePicSvc extends MybatisBaseSvc<OnlOnlinePicMo, java.lang.Long> {

    /**
     *  获取已上线商品轮播图 2018年4月1日14:51:33
     */
    List<OnlOnlinePicMo> list(OnlOnlinePicMo mo);
}
