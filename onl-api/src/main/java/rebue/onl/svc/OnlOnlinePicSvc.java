package rebue.onl.svc;

import rebue.robotech.svc.MybatisBaseSvc;
import rebue.onl.mo.OnlOnlinePicMo;
import java.util.List;

public interface OnlOnlinePicSvc extends MybatisBaseSvc<OnlOnlinePicMo, java.lang.Long> {

	/**
	 * 获取已上线商品轮播图 2018年4月1日14:51:33
	 */
	List<OnlOnlinePicMo> list(OnlOnlinePicMo mo);

}