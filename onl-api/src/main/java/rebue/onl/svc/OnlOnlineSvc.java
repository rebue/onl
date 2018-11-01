package rebue.onl.svc;

import java.util.List;

import com.github.pagehelper.PageInfo;

import rebue.onl.mo.OnlOnlineMo;
import rebue.onl.ro.AddOnlineRo;
import rebue.onl.ro.OnlOnlineGoodsInfoRo;
import rebue.onl.ro.OnlOnlineListRo;
import rebue.onl.ro.ReOnlineRo;
import rebue.onl.to.AddOnlineTo;
import rebue.onl.to.OnlineGoodsListTo;
import rebue.robotech.svc.MybatisBaseSvc;

/**
 * 上线信息
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
public interface OnlOnlineSvc extends MybatisBaseSvc<OnlOnlineMo, java.lang.Long> {

    /**
     *  获取上线商品列表 Title: selectOnlineGoodsList Description:
     *
     *  @return
     *  @date 2018年3月29日 下午5:40:42
     */
    List<OnlOnlineGoodsInfoRo> selectOnlineGoodsList(OnlineGoodsListTo to);

    /**
     *  添加上线信息
     *
     *  @param to
     *  @return
     */
    AddOnlineRo addOnline(AddOnlineTo to);

    /**
     *  根据id查询上线信息
     *
     *  @param id
     *  @return
     */
    OnlOnlineMo listByPrimaryKey(Long id);

    /**
     *  重新上线
     *
     *  @param to
     *  @return
     */
    ReOnlineRo reOnline(AddOnlineTo to);

    /**
     * 重写查询上线信息
     * @param ro
     * @param pageNum
     * @param pageSize
     * @param orderBy
     * @return
     */
	PageInfo<OnlOnlineListRo> listEx(OnlOnlineListRo ro, int pageNum, int pageSize, String orderBy);
}
