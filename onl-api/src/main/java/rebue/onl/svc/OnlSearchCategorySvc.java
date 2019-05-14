package rebue.onl.svc;

import java.util.List;


import com.github.pagehelper.PageInfo;

import rebue.onl.mo.OnlSearchCategoryMo;
import rebue.onl.ro.OnlSearchCategoryRo;
import rebue.onl.ro.OnlSearchCategoryTreeRo;
import rebue.robotech.ro.Ro;
import rebue.robotech.svc.MybatisBaseSvc;

/**
 * 搜索分类
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
public interface OnlSearchCategorySvc extends MybatisBaseSvc<OnlSearchCategoryMo, java.lang.Long> {

	/**
	 * 添加店铺搜索分类 流程： 1、判断参数 2、判断code是否为null，如果为null说明为顶级分类，否则为子类
	 * 3、如果为顶级分类时，根据卖家和店铺查询分类的数量，如果数量小于10（不包含10）， 则前面补0
	 * 4、如果为子类时，根据传过来的code查询该子类下面的分类，如果数量小于10（不包含10）， 则前面补0 5、添加店铺搜索分类
	 * 注意：顶级分类为两位数，子类则在父类下面补两位
	 * 
	 * @param mo
	 * @return
	 */
	Ro addEx(OnlSearchCategoryMo mo);

	/**
	 * 重写查询店铺分类信息
	 * 
	 * @param ro
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	PageInfo<OnlSearchCategoryRo> listEx(OnlSearchCategoryRo ro, Integer pageNum, Integer pageSize);

	/**
	 * 禁用/启用店铺搜索分类 注：该方法会禁用/启用该分类和该分类下的所有子分类
	 * 
	 * @param sellerId 卖家id
	 * @param shopId   店铺id
	 * @param code     分类编码
	 * @return
	 */
	Ro enable(OnlSearchCategoryMo mo);

	/**
	 * 根据店铺id获取搜索分类树
	 * 
	 * @param shopId
	 * @return
	 */
	List<OnlSearchCategoryTreeRo> searchCategoryTreeList(Long shopId);
	
	/**
	 * 根据店铺id集合获取搜索分类
	 * @param shopId
	 * @return
	 */

	List<OnlSearchCategoryMo> searchCategoryByshopIds(String shopIds );
}
