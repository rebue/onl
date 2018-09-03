package rebue.onl.svc;

import rebue.robotech.svc.MybatisBaseSvc;
import rebue.onl.mo.OnlCartMo;
import java.util.List;
import java.util.Map;
import rebue.onl.ro.AddCartRo;
import rebue.onl.ro.OnlCartRo;

public interface OnlCartSvc extends MybatisBaseSvc<OnlCartMo, java.lang.Long> {

	/**
	 * 根据用户编号和购物车编号删除购物车 Title: deleteByUserIdAndCartId Description:
	 * 
	 * @param record
	 * @return
	 * @date 2018年3月29日 下午3:03:11
	 */
	int deleteByUserIdAndCartId(OnlCartMo record);

	/**
	 * 批量删除购物车 Title: deleteByUserIdAndCartIds Description:
	 * 
	 * @param map
	 * @return
	 * @date 2018年4月3日 下午3:26:23
	 */
	int deleteByUserIdAndCartIds(Map<String, Object> map);

	/**
	 * 加入购物车 Title: addEx Description:
	 * 
	 * @param mo
	 * @return
	 * @date 2018年3月30日 上午10:03:22
	 */
	AddCartRo addCart(OnlCartMo mo);

	/**
	 * 获取购物车数量 Title: selectCartCount Description:
	 * 
	 * @param mo
	 * @return
	 * @date 2018年3月30日 上午10:49:11
	 */
	int selectCartCount(OnlCartMo mo);

	/**
	 * 获取购物车列表 Title: selectCartList Description:
	 * 
	 * @param mo
	 * @return
	 * @date 2018年3月30日 下午1:54:27
	 */
	List<OnlCartRo> selectCartList(OnlCartMo mo);

}