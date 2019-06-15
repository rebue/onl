package rebue.onl.ctrl;

import com.github.dozermapper.core.Mapper;
import com.github.pagehelper.PageInfo;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import rebue.onl.dic.AddOnlineDic;
import rebue.onl.dic.ReOnlineDic;
import rebue.onl.mo.OnlOnlineMo;
import rebue.onl.mo.OnlOnlinePicMo;
import rebue.onl.mo.OnlOnlineSpecAttrMo;
import rebue.onl.mo.OnlOnlineSpecMo;
import rebue.onl.mo.OnlSearchCategoryMo;
import rebue.onl.mo.OnlSearchCategoryOnlineMo;
import rebue.onl.ro.AddOnlineRo;
import rebue.onl.ro.GetOnlinesRo;
import rebue.onl.ro.OnlOnlineGoodsInfoRo;
import rebue.onl.ro.OnlOnlineListRo;
import rebue.onl.ro.OnlinesRo;
import rebue.onl.ro.ReOnlineRo;
import rebue.onl.ro.SupplierGoodsRo;
import rebue.onl.svc.OnlOnlinePicSvc;
import rebue.onl.svc.OnlOnlineSpecAttrSvc;
import rebue.onl.svc.OnlOnlineSpecSvc;
import rebue.onl.svc.OnlOnlineSvc;
import rebue.onl.svc.OnlSearchCategoryOnlineSvc;
import rebue.onl.svc.OnlSearchCategorySvc;
import rebue.onl.to.AddOnlineTo;
import rebue.onl.to.OnlineGoodsListTo;
import rebue.onl.to.SupplierGoodsTo;
import rebue.onl.to.UpdateOnlineAfterOrderTo;
import rebue.robotech.dic.ResultDic;
import rebue.robotech.ro.Ro;
import rebue.wheel.turing.JwtUtils;

/**
 * 上线信息
 *
 * @mbg.removeField _uniqueFilesName
 */
@RestController
public class OnlOnlineCtrl {

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private static final Logger _log = LoggerFactory.getLogger(OnlOnlineCtrl.class);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Resource
    private OnlOnlineSvc svc;

    /**
     * 删除上线信息
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @DeleteMapping("/onl/online")
    Ro del(@RequestParam("id") java.lang.Long id) {
        _log.info("del OnlOnlineMo by id: {}", id);
        int result = svc.del(id);
        Ro ro = new Ro();
        if (result == 1) {
            String msg = "删除成功";
            _log.info("{}: id-{}", msg, id);
            ro.setMsg(msg);
            ro.setResult(ResultDic.SUCCESS);
            return ro;
        } else {
            String msg = "删除失败，找不到该记录";
            _log.error("{}: id-{}", msg, id);
            ro.setMsg(msg);
            ro.setResult(ResultDic.FAIL);
            return ro;
        }
    }

    /**
     * 获取单个上线信息
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @GetMapping("/onl/online/getbyid")
    OnlOnlineMo getById(@RequestParam("id") java.lang.Long id) {
        _log.info("get OnlOnlineMo by id: " + id);
        return svc.getById(id);
    }

    @Value("${debug:false}")
    private Boolean isDebug;

    @Resource
    private OnlOnlineSpecSvc onlineSpecSvc;

    @Resource
    private OnlOnlinePicSvc onlinePicSvc;

    @Resource
    private Mapper dozerMapper;
    
    @Resource
    private OnlOnlineSpecAttrSvc onlOnlineSpecAttrSvc;

    @Resource
    private OnlSearchCategoryOnlineSvc onlSearchCategoryOnlineSvc;
    
    @Resource
    private OnlSearchCategorySvc onlSearchCategorySvc;
    /**
     *  添加上线信息
     *
     *  @mbg.overrideByMethodName
     */
    @PostMapping("/onl/online")
    AddOnlineRo add(@RequestBody final AddOnlineTo to, final HttpServletRequest req) throws Exception {
        // 获取当前登录用户id
        Long currentUserId = 520469568947224576L;
        Long orgId = 520874560590053376L;
        if (!isDebug) {
            currentUserId = JwtUtils.getJwtUserIdInCookie(req);
            orgId = (Long) JwtUtils.getJwtAdditionItemInCookie(req, "orgId");
            _log.info("从cookie中获取的组织id：{}", orgId);
            _log.info("从cookie中获取的用户：{}", currentUserId);
        }
        final AddOnlineRo ro = new AddOnlineRo();
        if (currentUserId == null) {
            ro.setResult(AddOnlineDic.OP_NOT_EXIST);
            ro.setMsg("您未登录，请登录后再试。。。");
            return ro;
        }
        if (orgId == null) {
            ro.setResult(AddOnlineDic.OP_NOT_ORG);
            ro.setMsg("您未加入任何组织无法上线商品，请加入组织后再试。。。");
            return ro;
        }
        to.setOpId(currentUserId);
        to.setOnlineOrgId(orgId);
        _log.info("添加上线信息的参数为：{}", to);
        try {
            return svc.addOnline(to);
        } catch (final RuntimeException e) {
            final String msg = e.getMessage();
            ro.setMsg(msg);
            ro.setResult(AddOnlineDic.ERROR);
            return ro;
        }
    }

    /**
     *  重写查询查询商品上线信息
     *
     *  @param ro
     *  @param pageNum
     *  @param pageSize
     *  @return
     *  @throws ParseException
     *  @throws NumberFormatException
     *  @mbg.overrideByMethodName
     */
    @GetMapping("/onl/online")
    PageInfo<OnlOnlineListRo> listEx(final OnlOnlineListRo ro, @RequestParam("pageNum") final int pageNum, @RequestParam("pageSize") final int pageSize, final HttpServletRequest req) throws NumberFormatException, ParseException {
        _log.info("list OnlOnlineListMo:" + ro + ", pageNum = " + pageNum + ", pageSize = " + pageSize);
        if (pageSize > 50) {
            final String msg = "pageSize不能大于50";
            _log.error(msg);
            throw new IllegalArgumentException(msg);
        }
        Long orgId = 581703841586741249L;
        if (!isDebug) {
            orgId = (Long) JwtUtils.getJwtAdditionItemInCookie(req, "orgId");
        }
        ro.setThisOrgId(orgId);
        final PageInfo<OnlOnlineListRo> result = svc.listEx(ro, pageNum, pageSize, "ONLINE_TIME DESC");
        _log.info("result: " + result);
        return result;
    }

    /**
     *  商品下线 Title: modify Description:
     *
     *  @param vo
     *  @return
     *  @throws Exception
     *  @date 2018年3月28日 下午3:14:23
     */
    @PutMapping("/onl/online")
    Ro offline(final OnlOnlineMo vo) throws Exception {
        _log.info("开始商品下线，商品下线的参数为：" + vo);
        try {
            return svc.offline(vo);
        } catch (Exception e) {
            _log.error("商品下线出现异常:{}", e);
            Ro ro = new Ro();
            ro.setResult(ResultDic.FAIL);
            ro.setMsg("下线出现错误");
            return ro;
        }
    }

    /**
     *  获取上线商品列表 Title: selectOnlineGoodsList Description:
     *
     *  @return
     *  @date 2018年3月29日 下午5:42:46
     */
    @SuppressWarnings("finally")
    @GetMapping("/onl/online/list")
    List<OnlOnlineGoodsInfoRo> selectOnlineGoodsList(final OnlineGoodsListTo to) {
        _log.info("获取上线商品列表的参数为：{}", to);
        List<OnlOnlineGoodsInfoRo> list = new ArrayList<>();
        try {
            list = svc.selectOnlineGoodsList(to);
        } catch (final Exception e) {
            e.printStackTrace();
        } finally {
            return list;
        }
    }

    /**
     *  查询是否已上线 Title: existSelective Description:
     *
     *  @param qo
     *  @return
     *  @date 2018年4月10日 下午4:06:26
     */
    @GetMapping(value = "/onl/online/exist")
    @ResponseBody
    Boolean existSelective(@RequestParam("id") final Long id, @RequestParam("onlineState") final Byte onlineState) {
        final OnlOnlineMo qo = new OnlOnlineMo();
        qo.setId(id);
        qo.setOnlineState(onlineState);
        _log.info("查询是否已上线的参数为：{}", qo);
        final boolean result = svc.existSelective(qo);
        _log.info("查询是否已上线的返回值为：{}", result);
        return result;
    }

	/**
	 * 根据id获取上线信息、规格信息、图片信息、搜索分类信息
	 *
	 * @param id
	 * @return
	 * @throws ParseException
	 * @throws NumberFormatException
	 */
	@GetMapping("/onl/online/getonlines")
	GetOnlinesRo getOnlines(@RequestParam("id") final Long id, final HttpServletRequest req)
			throws NumberFormatException, ParseException {
		_log.info("根据上线id获取上线信息的参数为：{}", id);
		Long orgId = 520874560590053376L;
		if (!isDebug) {
			orgId = (Long) JwtUtils.getJwtAdditionItemInCookie(req, "orgId");
		}
		final GetOnlinesRo onlinesRo = new GetOnlinesRo();
		// 获取上线信息
		final OnlinesRo onlOnlineRo = dozerMapper.map(svc.listByPrimaryKey(id), OnlinesRo.class);
		if (orgId.equals(onlOnlineRo.getDeliverOrgId()) ) {
			onlOnlineRo.setDeliveryType((byte) 0);
		} else {
			onlOnlineRo.setDeliveryType((byte) 1);
		}
		// 获取规格信息
		final OnlOnlineSpecMo onlineSpecMo = new OnlOnlineSpecMo();
		onlineSpecMo.setOnlineId(id);
		onlOnlineRo.setOnlineSpecList(onlineSpecSvc.list(onlineSpecMo));
		// 获取规格属性信息
		final List<OnlOnlineSpecAttrMo> onlineSpecAttrMoList = new ArrayList<OnlOnlineSpecAttrMo>();
		final List<OnlOnlineSpecMo> onlineSpecList = onlOnlineRo.getOnlineSpecList();
		for (OnlOnlineSpecMo onlOnlineSpecMo : onlineSpecList) {
			final OnlOnlineSpecAttrMo onlineSpecAttrMo = new OnlOnlineSpecAttrMo();
			onlineSpecAttrMo.setOnlineSpecId(onlOnlineSpecMo.getId());
			onlineSpecAttrMoList.addAll(onlOnlineSpecAttrSvc.list(onlineSpecAttrMo));
		}
		onlOnlineRo.setOnlOnlineSpecAttrList(onlineSpecAttrMoList);
		// 获取图片信息
		final OnlOnlinePicMo onlinePicMo = new OnlOnlinePicMo();
		onlinePicMo.setOnlineId(id);
		onlOnlineRo.setOnlinePicList(onlinePicSvc.list(onlinePicMo));
		//获取搜索分类上线
		final OnlSearchCategoryOnlineMo searchCategoryOnlineMo =new OnlSearchCategoryOnlineMo();
		searchCategoryOnlineMo.setOnlineId(id);
		List<OnlSearchCategoryOnlineMo> searchCategoryOnlineResult = onlSearchCategoryOnlineSvc.list(searchCategoryOnlineMo);
		//获取搜索子分类信息
		final List<OnlSearchCategoryMo> onlSearchCategoryMo  =new ArrayList<OnlSearchCategoryMo>();
		for(OnlSearchCategoryOnlineMo searchCategoryOnline:searchCategoryOnlineResult) {
		Long searchCategoryId=searchCategoryOnline.getSearchCategoryId();
		onlSearchCategoryMo.add(onlSearchCategorySvc.getById(searchCategoryId));
		}
		onlOnlineRo.setSearchCategoryMo(onlSearchCategoryMo);
		
		onlinesRo.setRecord(onlOnlineRo);
		onlinesRo.setResult((byte) 1);
		return onlinesRo;
	}

    /**
     *  重新上线
     *
     *  @param to
     *  @param req
     *  @return
     *  @throws ParseException
     *  @throws NumberFormatException
     */
    @PutMapping("/onl/online/reonline")
    ReOnlineRo reOnline(@RequestBody final AddOnlineTo to, final HttpServletRequest req) throws NumberFormatException, ParseException {
        // 获取当前登录用户id
        Long currentUserId = 520469568947224576L;
        Long orgId = 520874560590053376L;
        if (!isDebug) {
            currentUserId = JwtUtils.getJwtUserIdInCookie(req);
            orgId = (Long) JwtUtils.getJwtAdditionItemInCookie(req, "orgId");
        }
        to.setOpId(currentUserId);
        final ReOnlineRo ro = new ReOnlineRo();
        if (currentUserId == null) {
            ro.setResult(ReOnlineDic.OP_NOT_EXIST);
            ro.setMsg("您未登录，请登录后再试。。。");
            return ro;
        }
        if (orgId == null) {
            ro.setResult(ReOnlineDic.OP_NOT_ORG);
            ro.setMsg("您未加入任何组织无法上线商品，请加入组织后再试。。。");
            return ro;
        }
        to.setOnlineOrgId(orgId);
        _log.info("添加上线信息的参数为：{}", to);
        try {
            return svc.reOnline(to);
        } catch (final RuntimeException e) {
            final String msg = e.getMessage();
            ro.setMsg(msg);
            ro.setResult(ReOnlineDic.ERROR);
            return ro;
        }
    }

    /**
     *  更新上线信息(下单后)
     */
    @PutMapping(value = "/onl/online/updateonlineafterorder")
    Ro updateOnlineAfterOrder(@RequestBody final UpdateOnlineAfterOrderTo to) {
        _log.info("updateOnlineAfterOrder：{}", to);
        Ro ro = new Ro();
        try {
            ro = svc.updateOnlineAfterOrder(to);
        } catch (final RuntimeException e) {
            final String msg = e.getMessage();
            if (!StringUtils.equalsAny(msg, "商品已下线", "没有找到上线的规格信息", "商品库存不足", "更新销售数量失败，出现并发问题")) {
                _log.error("更新上线信息(下单后)出现运行时异常", e);
            }
            ro.setResult(ResultDic.FAIL);
            ro.setMsg(msg);
        }
        _log.info("返回值为：{}", ro);
        return ro;
    }

    /**
     * 		供应商获取商品
     */
    @GetMapping("/onl/online/supplierGoods")
    PageInfo<SupplierGoodsRo> listSupplierGoods(final SupplierGoodsTo to, @RequestParam("pageNum") final int pageNum, @RequestParam("pageSize") final int pageSize, final HttpServletRequest req) throws NumberFormatException, ParseException {
        _log.info("listSupplierGoods SupplierGoodsTo:" + to + ", pageNum = " + pageNum + ", pageSize = " + pageSize);
        if (pageSize > 50) {
            final String msg = "pageSize不能大于50";
            _log.error(msg);
            throw new IllegalArgumentException(msg);
        }
        final PageInfo<SupplierGoodsRo> result = svc.supplierGoods(to, pageNum, pageSize);
        return result;
    }
}
