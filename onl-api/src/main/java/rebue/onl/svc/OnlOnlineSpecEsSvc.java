package rebue.onl.svc;

import java.util.List;

import rebue.onl.ro.OnlOnlineSpecEsRo;
import rebue.onl.so.OnlOnlineSpecSo;
import rebue.robotech.svc.EsBaseSvc;

/**
 * 上线规格
 *
 */
public interface OnlOnlineSpecEsSvc extends EsBaseSvc<OnlOnlineSpecSo> {
    public List<OnlOnlineSpecEsRo> selectByName(String name);
}
