package rebue.onl.svc;

import rebue.robotech.svc.MybatisBaseSvc;

import java.util.Map;

import rebue.onl.mo.OnlOnlineMo;
import rebue.onl.to.OnlineGoodsBaseTo;

public interface OnlOnlineSvc extends MybatisBaseSvc<OnlOnlineMo, java.lang.Long>{

	Map<String, Object> addEx(OnlineGoodsBaseTo to);

}