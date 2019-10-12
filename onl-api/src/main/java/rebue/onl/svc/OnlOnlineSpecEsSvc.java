package rebue.onl.svc;

import java.util.List;

import rebue.onl.mo.OnlOnlineSpecMo;
import rebue.onl.so.OnlOnlineSpecSo;
import rebue.robotech.svc.EsBaseSvc;

/**
 * 上线规格
 *
 */
public interface OnlOnlineSpecEsSvc extends EsBaseSvc<OnlOnlineSpecSo> {
    public List<OnlOnlineSpecMo> selectByName(String name);
}
