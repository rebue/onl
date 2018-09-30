package rebue.onl.svc;

import java.util.List;
import rebue.onl.mo.OnlOnlinePicMo;
import rebue.robotech.svc.MybatisBaseSvc;

/**
 * 上线图片
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
public interface OnlOnlinePicSvc extends MybatisBaseSvc<OnlOnlinePicMo, java.lang.Long> {

    /**
     *  获取已上线商品轮播图 2018年4月1日14:51:33
     */
    List<OnlOnlinePicMo> list(OnlOnlinePicMo mo);

    /**
     *  根据上线id删除上线图片
     *
     *  @param onlineId
     *  @return
     */
    int deleteByOnlineId(Long onlineId);
}
