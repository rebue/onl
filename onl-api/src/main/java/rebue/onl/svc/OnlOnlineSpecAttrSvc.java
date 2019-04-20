package rebue.onl.svc;

import rebue.onl.mo.OnlOnlineSpecAttrMo;
import rebue.robotech.svc.MybatisBaseSvc;

/**
 * 上线规格属性
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
public interface OnlOnlineSpecAttrSvc extends MybatisBaseSvc<OnlOnlineSpecAttrMo, java.lang.Long> {
    int deleteByOnlineSpecId(Long onlineSpecId);

}
