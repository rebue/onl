package rebue.onl.svc;

import rebue.robotech.svc.MybatisBaseSvc;

import java.util.List;

import rebue.onl.mo.OnlOnlineSpecMo;
import rebue.onl.ro.OnlOnlineSpecInfoRo;

public interface OnlOnlineSpecSvc extends MybatisBaseSvc<OnlOnlineSpecMo, java.lang.Long>{

	/**
	 * 根据商品规格编号查询商品规格信息
	 * Title: selectByPrimaryKey
	 * Description: 
	 * @param id
	 * @return
	 * @date 2018年3月29日 下午2:15:17
	 */
	OnlOnlineSpecMo selectByPrimaryKey(Long id);
	
	/**
     * 获取上线规格信息
     * Title: selectOnlineSpecInfoByOnlineId
     * Description: 
     * @param record
     * @return
     * @date 2018年4月1日 下午4:29:31
     */
    List<OnlOnlineSpecInfoRo> selectOnlineSpecInfo(OnlOnlineSpecMo record);
}