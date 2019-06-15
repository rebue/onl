package rebue.onl.svc;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import rebue.onl.mo.OnlSearchCategoryOnlineMo;
import rebue.onl.ro.OnlOnlineTreeRo;
import rebue.robotech.svc.MybatisBaseSvc;

/**
 * 搜索分类上线
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
public interface OnlSearchCategoryOnlineSvc extends MybatisBaseSvc<OnlSearchCategoryOnlineMo, java.lang.Long> {

	/**
     * 根据搜索分类id获取上线商品树
     * @param searchCategoryId
     * @return
     */
	List<OnlOnlineTreeRo> onlineTreeList(Long searchCategoryId);
	
	/**
	 * 根据上线id和搜索分类id删除数据
	 * @param record
	 * @return
	 */
    int deleteByOnlineId(OnlSearchCategoryOnlineMo searchCategoryOnlineMo);
    
    /**
     * 根据搜索分类id集合查询符合条件搜索上线信息
     * @param searchCategoryIds
     * @return
     */
    List<OnlSearchCategoryOnlineMo>  selectBysearchCategoryIds(String searchCategoryIds);
}
