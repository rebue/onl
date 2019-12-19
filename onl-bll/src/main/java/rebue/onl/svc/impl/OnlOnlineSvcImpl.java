package rebue.onl.svc.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.dozermapper.core.Mapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import damai.pnt.util.PntPointsAlgorithmUtils;
import rebue.onl.dic.AddOnlineDic;
import rebue.onl.dic.OnlineStateDic;
import rebue.onl.dic.ReOnlineDic;
import rebue.onl.mapper.OnlOnlineMapper;
import rebue.onl.mo.OnlOnlineLogMo;
import rebue.onl.mo.OnlOnlineMo;
import rebue.onl.mo.OnlOnlinePicLogMo;
import rebue.onl.mo.OnlOnlinePicMo;
import rebue.onl.mo.OnlOnlinePromotionMo;
import rebue.onl.mo.OnlOnlineSpecAttrMo;
import rebue.onl.mo.OnlOnlineSpecLogMo;
import rebue.onl.mo.OnlOnlineSpecMo;
import rebue.onl.mo.OnlSearchCategoryMo;
import rebue.onl.mo.OnlSearchCategoryOnlineMo;
import rebue.onl.ro.AddOnlineRo;
import rebue.onl.ro.OnlOnlineGoodsInfoRo;
import rebue.onl.ro.OnlOnlineListRo;
import rebue.onl.ro.OnlOnlineTreeRo;
import rebue.onl.ro.ReOnlineRo;
import rebue.onl.ro.SupplierGoodsRo;
import rebue.onl.so.OnlOnlineSpecSo;
import rebue.onl.svc.OnlCartSvc;
import rebue.onl.svc.OnlOnlineLogSvc;
import rebue.onl.svc.OnlOnlinePicLogSvc;
import rebue.onl.svc.OnlOnlinePicSvc;
import rebue.onl.svc.OnlOnlinePromotionSvc;
import rebue.onl.svc.OnlOnlineSpecAttrSvc;
import rebue.onl.svc.OnlOnlineSpecEsSvc;
import rebue.onl.svc.OnlOnlineSpecLogSvc;
import rebue.onl.svc.OnlOnlineSpecSvc;
import rebue.onl.svc.OnlOnlineSvc;
import rebue.onl.svc.OnlSearchCategoryOnlineSvc;
import rebue.onl.svc.OnlSearchCategorySvc;
import rebue.onl.to.AddOnlineTo;
import rebue.onl.to.OnlOnlineSpecTo;
import rebue.onl.to.OnlineGoodsListTo;
import rebue.onl.to.SelectOnlineTo;
import rebue.onl.to.SupplierGoodsTo;
import rebue.onl.to.UpdateOnlineAfterOrderTo;
import rebue.onl.to.UpdateOnlineSpecAfterOrderTo;
import rebue.ord.svr.feign.OrdOrderDetailSvc;
import rebue.robotech.dic.ResultDic;
import rebue.robotech.ro.Ro;
import rebue.robotech.svc.impl.MybatisBaseSvcImpl;
import rebue.slr.mo.SlrShopMo;
import rebue.slr.svr.feign.SlrShopSvc;
import rebue.suc.ro.SucOrgRo;
import rebue.suc.svr.feign.SucOrgSvc;

/**
 * 上线信息
 *
 * 在单独使用不带任何参数的 @Transactional 注释时， propagation(传播模式)=REQUIRED，readOnly=false，
 * isolation(事务隔离级别)=READ_COMMITTED， 而且事务不会针对受控异常（checked exception）回滚。
 *
 * 注意： 一般是查询的数据库操作，默认设置readOnly=true, propagation=Propagation.SUPPORTS
 * 而涉及到增删改的数据库操作的方法，要设置 readOnly=false, propagation=Propagation.REQUIRED
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
@Service
public class OnlOnlineSvcImpl extends MybatisBaseSvcImpl<OnlOnlineMo, java.lang.Long, OnlOnlineMapper>
        implements OnlOnlineSvc {

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public int add(OnlOnlineMo mo) {
        _log.info("添加上线信息-{}", mo);
        // 如果id为空那么自动生成分布式id
        if (mo.getId() == null || mo.getId() == 0) {
            mo.setId(_idWorker.getId());
        }
        return super.add(mo);
    }

    /**
     */
    private static final Logger _log = LoggerFactory.getLogger(OnlOnlineSvcImpl.class);

    /**
     */
    @Resource
    private OnlOnlineSpecSvc onlOnlineSpecSvc;

    /**
     */
    @Resource
    private OnlOnlinePicSvc onlOnlinePicSvc;

    @Resource
    private OnlSearchCategoryOnlineSvc onlSearchCategoryOnlineSvc;

    /**
     */
    @Resource
    private OnlOnlineSvc thisSvc;

    @Resource
    private OnlOnlineLogSvc onlOnlineLogSvc;

    @Resource
    private OnlOnlineSpecLogSvc oOnlOnlineSpecLogSvc;

    @Resource
    private OnlOnlinePicLogSvc onlOnlinePicLogSvc;

    @Resource
    private OnlCartSvc cartSvc;

    @Resource
    private Mapper dozerMapper;

    @Resource
    private SucOrgSvc sucOrgSvc;

    @Resource
    private OnlOnlinePromotionSvc onlOnlinePromotionSvc;

    @Resource
    private OrdOrderDetailSvc ordOrderDetailSvc;

    @Resource
    private OnlOnlineSpecAttrSvc onlOnlineSpecAttrSvc;

    @Resource
    private OnlSearchCategorySvc onlSearchCategorySvc;

    @Resource
    private SlrShopSvc slrShopSvc;

    @Resource
    private OnlOnlineSpecEsSvc onlOnlineSpecEsSvc;

    /**
     * 添加上线信息
     *
     * @param to
     * @return
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public AddOnlineRo addOnline(final AddOnlineTo to) {
        _log.info("添加上线信息的参数为：{}", to);
        final AddOnlineRo ro = new AddOnlineRo();
        if (to.getOnlineName() == null || to.getOnlineName().equals("") || to.getGoodsQsmm() == null
                || to.getGoodsQsmm().equals("") || to.getOnlineSpecs().size() == 0 || to.getSlideshow().size() == 0
                || to.getSupplierId() == null || to.getDeliverOrgId() == null) {
            ro.setResult(AddOnlineDic.PARAMETER_ERROR);
            ro.setMsg("参数错误");
            return ro;
        }
        final Long onlineId  = _idWorker.getId();
        Long       productId = to.getProductId();
        productId = productId == 0 ? onlineId : productId;
        final Date onlineTime   = new Date();
        Long       deliverOrgId = to.getDeliverOrgId();
        deliverOrgId = deliverOrgId == 0 ? to.getOnlineOrgId() : deliverOrgId;
        // 是否线下
        Boolean isBelow = to.getIsBelowOnline() == 0 ? false : true;
        // 是否线上
        Boolean isOnline = to.getIsBelowOnline() == 0 ? true : false;
        if (to.getIsBelowOnline() == 2) {
            isBelow  = true;
            isOnline = true;
        }
        // 是否上线到平台
        Boolean isOnlinePlatform = to.getIsOnlinePlatform() == 0 ? false : true;
        // 添加上线信息开始
        final OnlOnlineMo onlineMo = new OnlOnlineMo();
        onlineMo.setId(onlineId);
        onlineMo.setOnlineTitle(to.getOnlineName());
        onlineMo.setSupplierId(to.getSupplierId());
        onlineMo.setOnlineDetail(to.getOnlineDetail());
        onlineMo.setOpId(to.getOpId());
        onlineMo.setOnlineOrgId(to.getOnlineOrgId());
        onlineMo.setDeliverOrgId(deliverOrgId);
        onlineMo.setOnlineState((byte) 1);
        onlineMo.setOnlineTime(onlineTime);
        onlineMo.setProductId(productId);
        onlineMo.setSubjectType((byte) to.getSubjectType());
        onlineMo.setIsBelow(isBelow);
        onlineMo.setIsOnline(isOnline);
        onlineMo.setIsOnlinePlatform(isOnlinePlatform);
        onlineMo.setIsWeighGoods(to.getIsWeighGoods());
        _log.info("添加上线信息的参数为：{}", onlineMo);
        final int addResult = add(onlineMo);
        _log.info("添加上线信息的返回值为：{}", addResult);
        if (addResult != 1) {
            _log.error("添加上线信息出错，用户id为：{}", to.getOpId());
            ro.setResult(AddOnlineDic.ADD_GOODS_ONLINE_ERROR);
            ro.setMsg("添加上线信息出错");
            return ro;
        }
        // 添加上线信息结束
        // 添加上线日志信息开始
        final Long           onlineLogId = _idWorker.getId();
        final OnlOnlineLogMo onlineLogMo = new OnlOnlineLogMo();
        onlineLogMo.setId(onlineLogId);
        onlineLogMo.setSupplierId(to.getSupplierId());
        onlineLogMo.setOnlineId(onlineId);
        onlineLogMo.setOpId(to.getOpId());
        onlineLogMo.setOnlineOrgId(to.getOnlineOrgId());
        onlineLogMo.setDeliverOrgId(deliverOrgId);
        onlineLogMo.setOpTime(onlineTime);
        onlineLogMo.setSubjectType((byte) to.getSubjectType());
        onlineLogMo.setOnlineTitle(to.getOnlineName());
        onlineLogMo.setOnlineDetail(to.getOnlineDetail());
        onlineLogMo.setProductId(productId);
        onlineLogMo.setIsBelow(isBelow);
        onlineLogMo.setIsOnline(isOnline);
        onlineLogMo.setIsOnlinePlatform(isOnlinePlatform);
        _log.info("添加上线信息添加上线日志信息的参数为：{}", onlineLogMo);
        final int addOnlineLogResult = onlOnlineLogSvc.add(onlineLogMo);
        _log.info("添加上线信息添加上线日志信息的返回值为：{}", addOnlineLogResult);
        if (addOnlineLogResult != 1) {
            _log.error("添加上线信息添加上线日志出错，操作人id为：{}", to.getOpId());
            throw new RuntimeException("添加上线日志出错");
        }
        // 添加上线日志信息结束
        for (int i = 0; i < to.getOnlineSpecs().size(); i++) {
            // 添加上线规格信息开始
            final OnlOnlineSpecMo onlineSpecMo = new OnlOnlineSpecMo();
            // 上线规格名称
            String onlineSpecName = "";
            if (to.getOnlineSpecs().get(i).getOnlineSpec() != ""
                    && to.getOnlineSpecs().get(i).getOnlineSpec() != null) {
                onlineSpecName = to.getOnlineSpecs().get(i).getOnlineSpec();
            }
            if (to.getAttrNames() != null) {
                String[] oldOnlineSpec = onlineSpecName.split("/");
                onlineSpecName = oldOnlineSpec[0];
                String[] attrvalues = to.getAttrValues()[i];
                for (int j = 0; j < attrvalues.length; j++) {
                    if (onlineSpecName != "") {
                        onlineSpecName += "/";
                    }
                    onlineSpecName += attrvalues[j];
                }
            }

            _log.info("添加上线信息查询上线规格名称是否存在的参数为：{}", onlineSpecName);
            final boolean existSelectiveResult = onlOnlineSpecSvc.existOnlineSpec(onlineSpecName, onlineId);
            _log.info("添加上线信息查询上线规格名称是否存在的返回值为：{}", existSelectiveResult);
            if (existSelectiveResult) {
                _log.error("添加上线信息查询上线规格名称是否存在时发现该商品名称已存在，商品名称为：{}", onlineSpecName);
                throw new RuntimeException("规格名称为：" + onlineSpecName + "已存在");
            }
            // 上线规格ID
            Long onlineSpecId = _idWorker.getId();
            // 销售价格
            BigDecimal salePrice = to.getOnlineSpecs().get(i).getSalePrice();
            // 成本价格
            BigDecimal costPrice = to.getOnlineSpecs().get(i).getCostPrice();
            _log.info("添加上线计算积分的参数为：销售价格={}，成本价格={}", salePrice, costPrice);
            BigDecimal point = PntPointsAlgorithmUtils.commissionPoints(salePrice, costPrice);
            _log.info("添加上线计算积分的返回值为：{}", point);
            _log.info("添加上线计算首单积分的参数为：销售价格={}", salePrice);
            BigDecimal firstOrderPoint = PntPointsAlgorithmUtils.firstOrderPoints(salePrice);
            _log.info("添加上线计算首单积分的返回值为：{}", firstOrderPoint);
            onlineSpecMo.setId(onlineSpecId);
            onlineSpecMo.setOnlineId(onlineId);
            final BigDecimal amount = new BigDecimal("0");
            // 返现金额（如果版块类型为普通商品（0）则为输入的返现金额，否则为0）
            final BigDecimal cashbackAmount = to.getSubjectType() == 0 ? to.getOnlineSpecs().get(i).getCashbackAmount()
                    : amount;
            onlineSpecMo.setCashbackAmount(cashbackAmount);
            onlineSpecMo.setSalePrice(to.getOnlineSpecs().get(i).getSalePrice());
            // 返佣金额（如果版块类型为普通商品（0）则返佣金额为0，否则等于销售金额）
            final BigDecimal commissionAmount = to.getSubjectType() == 0 ? amount : salePrice;
            onlineSpecMo.setCommissionAmount(commissionAmount);
            onlineSpecMo.setOnlineSpec(onlineSpecName);
            onlineSpecMo.setSaleUnit(to.getOnlineSpecs().get(i).getSaleUnit());
            onlineSpecMo.setSaleCount(BigDecimal.ZERO);
            onlineSpecMo.setLimitCount(to.getOnlineSpecs().get(i).getLimitCount());
            onlineSpecMo.setCostPrice(costPrice);
            onlineSpecMo.setBuyPoint(point);
            onlineSpecMo.setFirstBuyPoint(firstOrderPoint);
            onlineSpecMo.setSeqNo(i);
            onlineSpecMo.setCurrentOnlineCount(to.getOnlineSpecs().get(i).getCurrentOnlineCount());
            onlineSpecMo.setProductSpecId(to.getOnlineSpecs().get(i).getProductSpecId());// 添加产品规格id
            // 如果版块类型为返积分商品（2）则购买积分为原返现金额*10,不再返现
            if (to.getSubjectType() == 2) {
                onlineSpecMo.setCommissionAmount(amount);
                onlineSpecMo.setCashbackAmount(amount);
                BigDecimal returnPoint = to.getOnlineSpecs().get(i).getCashbackAmount().multiply(BigDecimal.TEN);
                _log.info("版块类型为返积分商品,返还的积分为:{}", returnPoint);
                // 版块类型为返积分商品（2)商品只有设定的返还积分
                onlineSpecMo.setBuyPoint(returnPoint);
                onlineSpecMo.setFirstBuyPoint(returnPoint);
            }
            if (onlineSpecMo.getLimitCount() == null) {
                onlineSpecMo.setLimitCount(amount);
            }
            _log.info("添加上线信息添加上线规格信息的参数为：{}", onlineSpecMo);
            final int addOnlineSpecResult = onlOnlineSpecSvc.add(onlineSpecMo);
            _log.info("添加上线信息添加上线规格信息的返回值为：{}", addOnlineSpecResult);
            if (addOnlineSpecResult != 1) {
                _log.error("添加上线信息添加上线规格信息时出错，用户id为：{}", to.getOpId());
                throw new RuntimeException("添加商品规格出错");
            } else {

                // 添加到搜索引擎
                if (to.getIsPos() == 1) {
                    _log.info("开始添加到搜索引擎onlineSpecMo-{}", onlineSpecMo);
                    OnlOnlineSpecSo so = dozerMapper.map(onlineSpecMo, OnlOnlineSpecSo.class);
                    so.setProducId(to.getProductId());

                    // 店铺id
                    Set<Long> shopIds = new HashSet<Long>();
                    for (Long classificationId : to.getClassificationId()) {
                        OnlSearchCategoryMo searchCategoryMo = onlSearchCategorySvc.getById(classificationId);
                        shopIds.add(searchCategoryMo.getShopId());
                    }
                    so.setShopId(new ArrayList<>(shopIds));
                    so.setIsWeighGoods(to.getIsWeighGoods() == null ? false : to.getIsWeighGoods());
                    so.setProducSpecId(to.getOnlineSpecs().get(i).getProductSpecId().toString());
                    _log.info("添加搜索引擎参数-{}", so);
                    onlOnlineSpecEsSvc.add(so);
                    _log.info("添加搜索引擎结束");
                }
            }
            // 添加上线规格信息结束
            if (to.getAttrNames() != null) {
                // 添加上线规格属性开始
                for (int j = 0; j < to.getAttrValues()[i].length; j++) {
                    final OnlOnlineSpecAttrMo onlineSpecAttrMo = new OnlOnlineSpecAttrMo();
                    // 上线规格属性ID
                    final Long specAttrId = _idWorker.getId();
                    // 上线规格属性名
                    final String attrName = to.getAttrNames()[j];
                    // 上线规格属性值
                    final String attrValue = to.getAttrValues()[i][j];
                    onlineSpecAttrMo.setId(specAttrId);
                    onlineSpecAttrMo.setOnlineSpecId(onlineSpecId);
                    onlineSpecAttrMo.setAttrName(attrName);
                    onlineSpecAttrMo.setAttrValue(attrValue);
                    _log.info("添加上线规格属性的参数为：{}", onlineSpecAttrMo);
                    final int addOnlineSpecAttrResult = onlOnlineSpecAttrSvc.add(onlineSpecAttrMo);
                    _log.info("添加上线规格属性的返回值为：{}", addOnlineSpecAttrResult);
                    if (addOnlineSpecAttrResult != 1) {
                        _log.error("添加上线规格属性时出错，操作人id为：{}", to.getOpId());
                        throw new RuntimeException("添加上线规格属性出错");
                    }
                    // 添加上线规格属性结束
                }
            }
            // 添加上线规格日志信息开始
            final OnlOnlineSpecLogMo onlineSpecLogMo = new OnlOnlineSpecLogMo();
            onlineSpecLogMo.setOnlineLogId(onlineLogId);
            onlineSpecLogMo.setOnlineId(onlineId);
            onlineSpecLogMo.setOnlineSpec(onlineSpecName);
            onlineSpecLogMo.setSalePrice(salePrice);
            onlineSpecLogMo.setCostPrice(costPrice);
            onlineSpecLogMo.setBuyPoint(point);
            onlineSpecLogMo.setFirstBuyPoint(firstOrderPoint);
            onlineSpecLogMo.setCashbackAmount(cashbackAmount);
            onlineSpecLogMo.setCommissionAmount(commissionAmount);
            onlineSpecLogMo.setCurrentOnlineCount(to.getOnlineSpecs().get(i).getCurrentOnlineCount());
            onlineSpecLogMo.setLimitCount(to.getOnlineSpecs().get(i).getLimitCount());
            onlineSpecLogMo.setSaleUnit(to.getOnlineSpecs().get(i).getSaleUnit());
            onlineSpecLogMo.setSeqNo(i);
            _log.info("添加上线信息添加上线规格日志信息的参数为：{}", onlineSpecLogMo);
            int addOnlineSpecLogResult = 0;
            try {
                addOnlineSpecLogResult = oOnlOnlineSpecLogSvc.add(onlineSpecLogMo);
            } catch (final Exception e) {
                e.printStackTrace();
            }
            _log.info("添加上线信息添加上线规格日志信息的返回值为：{}", addOnlineSpecLogResult);
            if (addOnlineSpecLogResult != 1) {
                _log.error("添加上线信息添加上线规格日志信息出错：操作人id为：{}", to.getOpId());
                throw new RuntimeException("添加上线规格日志出错");
            }
            // 添加上线规格日志信息结束
        }
        // 添加搜索分类上线开始
        // 搜索分类上线id
        List<Long> classificationIds = to.getClassificationId();
        for (Long classificationId : classificationIds) {
            // 搜索分类上线id
            final Long                      searchCategoryOnlineId    = _idWorker.getId();
            final OnlSearchCategoryOnlineMo onlSearchCategoryOnlineMo = new OnlSearchCategoryOnlineMo();
            onlSearchCategoryOnlineMo.setId(searchCategoryOnlineId);
            onlSearchCategoryOnlineMo.setOnlineId(onlineId);
            onlSearchCategoryOnlineMo.setSearchCategoryId(classificationId);
            _log.info("添加搜索分类上线的参数为：{}", onlSearchCategoryOnlineMo);
            final int searchCategoryOnlineResult = onlSearchCategoryOnlineSvc.add(onlSearchCategoryOnlineMo);
            _log.info("添加搜索分类上线的返回值为：{}", searchCategoryOnlineResult);
            if (searchCategoryOnlineResult == 0) {
                _log.error("添加搜索分类上线时出错，用户id为：{}", to.getOpId());
                throw new RuntimeException("添加搜索分类上线出错");
            }
        }
        // 添加搜索分类上线结束

        // 添加商品主图开始
        // 上线图片id
        final Long           onlinePicId = _idWorker.getId();
        final OnlOnlinePicMo qsmmPicMo   = new OnlOnlinePicMo();
        qsmmPicMo.setId(onlinePicId);
        qsmmPicMo.setOnlineId(onlineId);
        qsmmPicMo.setPicPath(to.getGoodsQsmm());
        qsmmPicMo.setPicType((byte) 1);
        _log.info("添加上线信息添加商品主图的参数为：{}", qsmmPicMo);
        final int addQsmmResult = onlOnlinePicSvc.add(qsmmPicMo);
        _log.info("添加上线信息添加商品主图的返回值为：{}", addQsmmResult);
        if (addQsmmResult != 1) {
            _log.error("添加上线信息添加商品主图时出错，用户id为：{}", to.getOpId());
            throw new RuntimeException("添加商品主图出错");
        }
        // 添加商品主图结束
        // 添加上线图片日志开始
        OnlOnlinePicLogMo onlinePicLogMo = new OnlOnlinePicLogMo();
        onlinePicLogMo.setOnlineLogId(onlineLogId);
        onlinePicLogMo.setOnlineId(onlineId);
        onlinePicLogMo.setPicType((byte) 1);
        onlinePicLogMo.setPicPath(to.getGoodsQsmm());
        _log.info("添加上线信息添加上线主图日志的参数为：{}", onlinePicLogMo);
        final int addOnlineQsmmLogResult = onlOnlinePicLogSvc.add(onlinePicLogMo);
        _log.info("添加上线信息添加上线主图日志的返回值为：{}", addOnlineQsmmLogResult);
        if (addOnlineQsmmLogResult != 1) {
            _log.error("添加上线信息添加上线主图日志出错，操作人id为：{}", to.getOpId());
            throw new RuntimeException("添加上线主图日志出错");
        }
        for (int j = 0; j < to.getSlideshow().size(); j++) {
            // 轮播图id
            final Long picId = _idWorker.getId();
            // 添加商品轮播图开始
            final OnlOnlinePicMo picMo = new OnlOnlinePicMo();
            picMo.setId(picId);
            picMo.setOnlineId(onlineId);
            picMo.setPicPath(String.valueOf(to.getSlideshow().get(j).get("slideshow")));
            picMo.setPicType((byte) 0);
            _log.info("添加上线信息添加商品轮播图的参数为：{}", picMo);
            final int addPicResult = onlOnlinePicSvc.add(picMo);
            _log.info("添加上线信息添加商品轮播图的返回值为：{}", addPicResult);
            if (addPicResult != 1) {
                _log.error("添加上线商信息添加商品轮播图出错，用户id为：{}", to.getOpId());
                throw new RuntimeException("添加商品轮播图出错");
            }
            // 添加商品轮播图结束
            // 添加上线图片日志开始
            onlinePicLogMo = new OnlOnlinePicLogMo();
            onlinePicLogMo.setOnlineLogId(onlineLogId);
            onlinePicLogMo.setOnlineId(onlineId);
            onlinePicLogMo.setPicType((byte) 0);
            onlinePicLogMo.setPicPath(String.valueOf(to.getSlideshow().get(j).get("slideshow")));
            _log.info("添加上线信息添加上线轮播图日志的参数为：{}", onlinePicLogMo);
            final int addOnlinePicLogResult = onlOnlinePicLogSvc.add(onlinePicLogMo);
            _log.info("添加上线信息添加上线轮播图日志的返回值为：{}", addOnlinePicLogResult);
            if (addOnlinePicLogResult != 1) {
                _log.error("添加上线信息添加上线轮播图日志出错，操作人id为：{}", to.getOpId());
                throw new RuntimeException("添加上线轮播图日志出错");
            }
            // 添加上线图片日志结束
        }
        _log.info("发布商品成功，用户id为：{}", to.getOpId());
        ro.setResult(AddOnlineDic.SUCCESS);
        ro.setMsg("发布成功");
        return ro;
    }

    /**
     * 商品下线
     *
     * @param mo
     * @return
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Ro offline(OnlOnlineMo mo) {
        _log.info("商品下线的参数为:{}", mo);
        Ro ro = new Ro();
        if (mo.getId() == null || mo.getOnlineState() == null) {
            _log.error("商品下线出现参数错误,请求的参数为: {}", mo);
            ro.setResult(ResultDic.PARAM_ERROR);
            ro.setMsg("参数错误");
            return ro;
        }
        OnlOnlinePromotionMo onlinePromotionMo = new OnlOnlinePromotionMo();
        onlinePromotionMo.setOnlineId(mo.getId());
        _log.info("商品下线判断该商品是否已推广的参数为:{}", onlinePromotionMo);
        OnlOnlinePromotionMo onlOnlinePromotionMo = onlOnlinePromotionSvc.getOne(onlinePromotionMo);
        _log.info("商品下线判断该商品是否已推广的返回值为:{}", onlOnlinePromotionMo);
        if (onlOnlinePromotionMo != null) {
            _log.info("商品下线判断该商品是否已推广时发现该商品已推广, 上线id为:{}", mo.getId());
            _log.info("商品下线删除商品推广的参数为:{}", mo.getId());
            int delPromotionResult = onlOnlinePromotionSvc.del(mo.getId());
            _log.info("商品下线删除商品推广的返回值为:{}", delPromotionResult);
            if (delPromotionResult != 1) {
                _log.error("商品下线删除商品推广时出现错误,上线id为:{}", mo.getId());
                ro.setResult(ResultDic.FAIL);
                ro.setMsg("删除商品推广失败");
                return ro;
            }
        }
        _log.info("商品下线的请求参数为:{}", mo);
        int updateByPrimaryKeyResullt = _mapper.updateByPrimaryKeySelective(mo);
        _log.info("商品下线的返回值为:{}", updateByPrimaryKeyResullt);
        if (updateByPrimaryKeyResullt != 1) {
            _log.error("商品下线出现错误,请求的参数为:{}", mo);
            throw new RuntimeException("下线失败");
        } else {
            // 将下线的上线规格从elasticSearch中移除
            onlOnlineSpecSvc.deleteEsByOnlineId(mo.getId());
        }
        _log.info("商品下线成功,请求参数为:{}", mo);
        ro.setResult(ResultDic.SUCCESS);
        ro.setMsg("下线成功");
        return ro;
    }

    /**
     * 获取上线商品列表 2018年3月29日17:41:26
     */
    @Override
    public List<OnlOnlineGoodsInfoRo> selectOnlineGoodsList(final OnlineGoodsListTo to) {
        _log.info("==================================================================================================");
        _log.info("最新版本获取上线列表的参数为：", to);
        _log.info("==================================================================================================");
        return _mapper.selectOnlineGoodsList(to);
    }

    /**
     * 根据id查询上线信息
     *
     * @param id
     * @return
     */
    @Override
    public OnlOnlineMo listByPrimaryKey(final Long id) {
        return _mapper.selectByPrimaryKey(id);
    }

    /**
     * 重新上线
     *
     * @param to
     * @return
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public ReOnlineRo reOnline(final AddOnlineTo to) {
        _log.info("重新上线的请求参数为：{}", to);
        final ReOnlineRo ro = new ReOnlineRo();
        if (to.getOnlineId() == null || to.getOnlineName() == null || to.getOnlineName().equals("")
                || to.getGoodsQsmm() == null || to.getGoodsQsmm().equals("") || to.getOnlineSpecs().size() == 0
                || to.getSlideshow().size() == 0 || to.getSupplierId() == null) {
            ro.setResult(ReOnlineDic.PARAMETER_ERROR);
            ro.setMsg("参数错误");
            return ro;
        }
        // 根据上线id修改该商品的订单供应商和发货组织IsEditSupplier：0：否，1：是，2，是且修改没有结算的订单详情供应商和发货组织。
        if (to.getIsEditSupplier() != null && to.getIsEditSupplier() == 2) {
            _log.info("需要修改该商品订单详情的供应商和发货组织，IsEditSupplier-{}", to.getIsEditSupplier());
            try {
                _log.info("根据上线id修改订单详情供应商和发货组织参数为：getSupplierId()-{},deliverOrgId()-{},getOnlineId()-{}",
                        to.getSupplierId(), to.getDeliverOrgId(), to.getOnlineId());
                int result = ordOrderDetailSvc.modifyDeliverAndSupplierByOnlineid(to.getSupplierId(),
                        to.getDeliverOrgId(), to.getOnlineId());
                _log.info("根据上线id修改订单详情供应商和发货组织结果为 result:{} ：", result);
            } catch (final RuntimeException e) {
                _log.error("重新上线修改上线信息出现错误，上线id为：{}", to.getOnlineId());
                ro.setResult(ReOnlineDic.ERROR);
                ro.setMsg("修改商品供应商发发货组织出错");
                return ro;
            }
        } else {
            _log.info("不需要修改该商品订单详情的供应商和发货组织，IsEditSupplier-{}", to.getIsEditSupplier());
        }
        Long deliverOrgId = to.getDeliverOrgId();
        deliverOrgId = deliverOrgId == 0 ? to.getOnlineOrgId() : deliverOrgId;
        // 上线时间
        final Date onlineTime = new Date();
        // 是否线下
        Boolean isBelow = to.getIsBelowOnline() == 0 ? false : true;
        // 是否线上
        Boolean isOnline = to.getIsBelowOnline() == 0 ? true : false;
        if (to.getIsBelowOnline() == 2) {
            isBelow  = true;
            isOnline = true;
        }
        // 是否上线到平台
        Boolean isOnlinePlatform = to.getIsOnlinePlatform() == 0 ? false : true;
        // 修改上线信息开始
        final OnlOnlineMo onlineMo = new OnlOnlineMo();
        onlineMo.setId(to.getOnlineId());
        onlineMo.setSupplierId(to.getSupplierId());
        onlineMo.setSubjectType(to.getSubjectType());
        onlineMo.setOnlineTitle(to.getOnlineName());
        onlineMo.setOnlineDetail(to.getOnlineDetail());
        onlineMo.setOpId(to.getOpId());
        onlineMo.setOnlineOrgId(to.getOnlineOrgId());
        onlineMo.setDeliverOrgId(deliverOrgId);
        onlineMo.setOnlineState((byte) 1);
        onlineMo.setOnlineTime(onlineTime);
        onlineMo.setProductId(to.getProductId());
        onlineMo.setIsBelow(isBelow);
        onlineMo.setIsOnline(isOnline);
        onlineMo.setIsOnlinePlatform(isOnlinePlatform);
        onlineMo.setIsWeighGoods(to.getIsWeighGoods());
        _log.info("修改上线信息的参数为：{}", onlineMo);
        final int updateByPrimaryKeyResult = _mapper.updateByPrimaryKey(onlineMo);
        _log.info("修改上线信息的返回值为：{}", updateByPrimaryKeyResult);
        if (updateByPrimaryKeyResult != 1) {
            _log.error("重新上线修改上线信息出现错误，上线id为：{}", to.getOnlineId());
            ro.setResult(ReOnlineDic.MODIFY_ONLINE_ERROR);
            ro.setMsg("修改上线信息出错");
            return ro;
        }
        // 修改上线信息结束
        // 上线日志id
        final Long onlineLogId = _idWorker.getId();
        // 添加上线日志信息开始
        final OnlOnlineLogMo onlineLogMo = new OnlOnlineLogMo();
        onlineLogMo.setId(onlineLogId);
        onlineLogMo.setSupplierId(to.getSupplierId());
        onlineLogMo.setOnlineId(to.getOnlineId());
        onlineLogMo.setOpId(to.getOpId());
        onlineLogMo.setOnlineOrgId(to.getOnlineOrgId());
        onlineLogMo.setDeliverOrgId(deliverOrgId);
        onlineLogMo.setOpTime(onlineTime);
        onlineLogMo.setSubjectType(to.getSubjectType());
        onlineLogMo.setOnlineTitle(to.getOnlineName());
        onlineLogMo.setOnlineDetail(to.getOnlineDetail());
        onlineLogMo.setProductId(to.getProductId());
        onlineLogMo.setIsBelow(isBelow);
        onlineLogMo.setIsOnline(isOnline);
        onlineLogMo.setIsOnlinePlatform(isOnlinePlatform);
        _log.info("重新上线添加上线日志信息的参数为：{}", onlineLogMo);
        final int addOnlineLogResult = onlOnlineLogSvc.add(onlineLogMo);
        _log.info("重新上线添加上线日志信息的返回值为：{}", addOnlineLogResult);
        if (addOnlineLogResult != 1) {
            _log.error("重新上线添加上线日志信息出错，上线id为：{}", to.getOnlineId());
            throw new RuntimeException("添加上线日志信息出错");
        }
        // 添加上线日志信息结束

        // 开始删除旧的搜索分类上线
        final OnlSearchCategoryOnlineMo deleteSearchCategoryOnlineMo = new OnlSearchCategoryOnlineMo();
        deleteSearchCategoryOnlineMo.setOnlineId(to.getOnlineId());
        _log.info("删除搜索分类上线的参数为：{}", deleteSearchCategoryOnlineMo);
        final int deleteSearchCategoryOnlineResult = onlSearchCategoryOnlineSvc
                .deleteByOnlineId(deleteSearchCategoryOnlineMo);
        _log.info("删除搜索分类上线的返回值为：{}", deleteSearchCategoryOnlineResult);
        // 删除旧的搜索分类上线结束

        // 修改搜索分类上线开始
        List<Long> classificationIds = to.getClassificationId();
        for (Long classificationId : classificationIds) {
            // 搜索分类上线id
            final Long                      searchCategoryOnlineId    = _idWorker.getId();
            final OnlSearchCategoryOnlineMo onlSearchCategoryOnlineMo = new OnlSearchCategoryOnlineMo();
            onlSearchCategoryOnlineMo.setId(searchCategoryOnlineId);
            onlSearchCategoryOnlineMo.setOnlineId(to.getOnlineId());
            onlSearchCategoryOnlineMo.setSearchCategoryId(classificationId);
            _log.info("添加搜索分类上线的参数为：{}", onlSearchCategoryOnlineMo);
            final int searchCategoryOnlineResult = onlSearchCategoryOnlineSvc.add(onlSearchCategoryOnlineMo);
            _log.info("添加搜索分类上线的返回值为：{}", searchCategoryOnlineResult);
            if (searchCategoryOnlineResult == 0) {
                _log.error("添加搜索分类上线时出错，用户id为：{}", to.getOpId());
                throw new RuntimeException("添加搜索分类上线出错");
            }
        }
        // 修改搜索分类上线结束
        // 用于存放未删除的规格id
        final StringBuilder onlineSpecIds = new StringBuilder();
        for (int i = 0; i < to.getOnlineSpecs().size(); i++) {
            final BigDecimal amount = new BigDecimal("0");
            // 销售价格
            BigDecimal salePrice = to.getOnlineSpecs().get(i).getSalePrice();
            // 成本价格
            BigDecimal costPrice = to.getOnlineSpecs().get(i).getCostPrice();
            // 购买积分
            _log.info("重新上线计算积分的参数为：销售价格={}，成本价格={}", salePrice, costPrice);
            BigDecimal commissionPoints = PntPointsAlgorithmUtils.commissionPoints(salePrice, costPrice);
            _log.info("重新上线计算积分的返回值为：{}", commissionPoints);
            _log.info("添加上线计算首单积分的参数为：销售价格={}", salePrice);
            BigDecimal firstOrderPoint = PntPointsAlgorithmUtils.firstOrderPoints(salePrice);
            _log.info("添加上线计算首单积分的返回值为：{}", firstOrderPoint);
            // 返佣金额： 如果版块类型为普通商品则返佣金额为0，否则返佣金额等于销售金额
            final BigDecimal commissionAmount = to.getSubjectType() == 0 ? amount : salePrice;
            // 返现金额： 如果版块类型为全返商品则等于输入的数量， 否则等于0
            final BigDecimal cashbackAmount = to.getSubjectType() == 0 ? to.getOnlineSpecs().get(i).getCashbackAmount()
                    : amount;
            // 上线规格名称
            String onlineSpecName = "";
            if (to.getOnlineSpecs().get(i).getOnlineSpec() != ""
                    && to.getOnlineSpecs().get(i).getOnlineSpec() != null) {
                onlineSpecName = to.getOnlineSpecs().get(i).getOnlineSpec();
            }
            if (to.getAttrNames() != null) {
                String[] oldOnlineSpec = onlineSpecName.split("/");
                onlineSpecName = oldOnlineSpec[0];
                String[] attrvalues = to.getAttrValues()[i];
                for (int j = 0; j < attrvalues.length; j++) {
                    if (onlineSpecName != "") {
                        onlineSpecName += "/";
                    }
                    onlineSpecName += attrvalues[j];
                }
            }
            // 修改或添加上线规格开始
            final OnlOnlineSpecTo onlineSpecTo = new OnlOnlineSpecTo();
            onlineSpecTo.setOnlineId(to.getOnlineId());
            onlineSpecTo.setOnlineSpec(onlineSpecName);
            onlineSpecTo.setSalePrice(salePrice);
            onlineSpecTo.setCostPrice(costPrice);
            onlineSpecTo.setCommissionAmount(commissionAmount);
            onlineSpecTo.setSaleUnit(to.getOnlineSpecs().get(i).getSaleUnit());
            onlineSpecTo.setSeqNo(i);
            onlineSpecTo.setSaleCount(BigDecimal.ZERO);
            onlineSpecTo.setLimitCount(to.getOnlineSpecs().get(i).getLimitCount());
            onlineSpecTo.setCurrentOnlineCount(to.getOnlineSpecs().get(i).getCurrentOnlineCount());
            onlineSpecTo.setBuyPoint(commissionPoints);
            onlineSpecTo.setFirstBuyPoint(firstOrderPoint);
            onlineSpecTo.setCashbackAmount(cashbackAmount);
            Long onlineSpecId = _idWorker.getId();

            // 如果版块类型为返积分商品（2）则购买积分为原返现金额*10,不再返现
            if (to.getSubjectType() == 2) {
                onlineSpecTo.setCommissionAmount(amount);
                onlineSpecTo.setCashbackAmount(amount);
                BigDecimal returnPoint = to.getOnlineSpecs().get(i).getCashbackAmount().multiply(BigDecimal.TEN);
                _log.info("版块类型为返积分商品,返还的积分为:{}", returnPoint);
                // 版块类型为返积分商品（2)商品只有设定的返还积分
                onlineSpecTo.setBuyPoint(returnPoint);
                onlineSpecTo.setFirstBuyPoint(returnPoint);
            }

            if (onlineSpecTo.getLimitCount() == null) {
                onlineSpecTo.setLimitCount(amount);
            }
            // 如果规格id的长度大于13位的话说明该规格属于已上线的规格
            if (to.getOnlineSpecs().get(i).getId().toString().length() > 13) {
                onlineSpecId = to.getOnlineSpecs().get(i).getId();
                onlineSpecTo.setId(onlineSpecId);
                onlineSpecTo.setAlreadyOnlineTotal(to.getOnlineSpecs().get(i).getOnlineTotal());
                onlineSpecTo.setProductSpecId(to.getOnlineSpecs().get(i).getProductSpecId());
                _log.info("重新上线修改上线规格信息的参数为：{}", onlineSpecTo);
                final int updateOnlineSpecResult = onlOnlineSpecSvc.updateOnlineSpec(onlineSpecTo);
                _log.info("重新上线修改上线规格信息的返回值为：{}", updateOnlineSpecResult);
                if (updateOnlineSpecResult != 1) {
                    _log.error("重新上线修改上线规格信息出错，上线id为：{}", to.getOnlineId());
                    throw new RuntimeException("修改上线规格出错");
                } else {
                    // 添加到搜索引擎
                    if (onlineSpecTo.getProductSpecId() != null) {
                        OnlOnlineSpecSo so = dozerMapper.map(onlineSpecTo, OnlOnlineSpecSo.class);
                        so.setProducId(to.getProductId());
                        so.setIsWeighGoods(to.getIsWeighGoods() == null ? false : to.getIsWeighGoods());

                        so.setProducSpecId(to.getOnlineSpecs().get(i).getProductSpecId().toString());
                        onlOnlineSpecEsSvc.add(so);
                    }
                }
            } else {
                _log.info("添加上线信息查询上线规格名称是否存在的参数为：{}", onlineSpecName);
                final boolean existSelectiveResult = onlOnlineSpecSvc.existOnlineSpec(onlineSpecName, to.getOnlineId());
                _log.info("添加上线信息查询上线规格名称是否存在的返回值为：{}", existSelectiveResult);
                if (existSelectiveResult) {
                    _log.error("添加上线信息查询上线规格名称是否存在时发现该商品名称已存在，商品名称为：{}", onlineSpecName);
                    throw new RuntimeException("规格名称为：" + onlineSpecName + "已存在");
                }
                onlineSpecTo.setId(onlineSpecId);
                final OnlOnlineSpecMo onlineSpecMo = dozerMapper.map(onlineSpecTo, OnlOnlineSpecMo.class);
                _log.info("重新上线添加上线规格信息的参数为：{}", onlineSpecMo);
                final int addOnlineSpecResult = onlOnlineSpecSvc.add(onlineSpecMo);
                _log.info("重新上线添加上线规格信息的返回值为：{}", addOnlineSpecResult);
                if (addOnlineSpecResult != 1) {
                    _log.error("重新上线添加上线规格信息出错，上线id为：{}", addOnlineSpecResult);
                    throw new RuntimeException("添加上线规格出错");
                }
            }
            onlineSpecIds.append(onlineSpecId + ",");
            // 修改或添加上线规格结束
            // 添加上线规格日志开始
            final OnlOnlineSpecLogMo onlineSpecLogMo = dozerMapper.map(onlineSpecTo, OnlOnlineSpecLogMo.class);
            onlineSpecLogMo.setId(_idWorker.getId());
            onlineSpecLogMo.setOnlineLogId(onlineLogId);
            onlineSpecLogMo.setCurrentOnlineCount(to.getOnlineSpecs().get(i).getCurrentOnlineCount());
            _log.info("重新上线添加上线规格日志信息的参数为：{}", onlineSpecLogMo);
            final int addOnlineSpecLogResult = oOnlOnlineSpecLogSvc.add(onlineSpecLogMo);
            _log.info("重新上线添加上线规格日志信息的返回值为：{}", addOnlineSpecLogResult);
            if (addOnlineSpecLogResult != 1) {
                _log.error("重新上线添加上线规格日志信息出错，上线id为：{}", to.getOnlineId());
                throw new RuntimeException("添加上线规格日志出错");
            }
            _log.info("删除上线规格属性的参数为：{}", onlineSpecId);
            final int deleteByOnlineSpecIdResult = onlOnlineSpecAttrSvc.deleteByOnlineSpecId(onlineSpecId);
            _log.info("删除上线规格属性的返回值为：{}", deleteByOnlineSpecIdResult);
            // 添加上线规格日志结束
            if (to.getAttrNames() != null) {
                // 添加上线规格属性开始
                // 根据上线规格id删除上线规格属性
                for (int j = 0; j < to.getAttrValues()[i].length; j++) {
                    final OnlOnlineSpecAttrMo onlineSpecAttrMo = new OnlOnlineSpecAttrMo();
                    // 上线规格属性名
                    final String attrName = to.getAttrNames()[j];
                    // 上线规格属性值
                    final String attrValue = to.getAttrValues()[i][j];

                    onlineSpecAttrMo.setId(_idWorker.getId());
                    onlineSpecAttrMo.setOnlineSpecId(onlineSpecId);
                    onlineSpecAttrMo.setAttrName(attrName);
                    onlineSpecAttrMo.setAttrValue(attrValue);
                    _log.info("添加上线规格属性的参数为：{}", onlineSpecAttrMo);
                    final int addOnlineSpecAttrResult = onlOnlineSpecAttrSvc.add(onlineSpecAttrMo);
                    _log.info("添加上线规格属性的返回值为：{}", addOnlineSpecAttrResult);
                    if (addOnlineSpecAttrResult != 1) {
                        _log.error("添加上线规格属性时出错，操作人id为：{}", to.getOpId());
                        throw new RuntimeException("添加上线规格属性出错");
                    }
                }
                // 添加上线规格属性结束
            }
        }
        // 删除上线规格开始
        if (onlineSpecIds.length() != 0) {
            _log.info("重新商品删除规格信息的参数为：{}", onlineSpecIds);
            onlOnlineSpecSvc.batchDeleteByIds(
                    onlineSpecIds.toString().substring(0, onlineSpecIds.toString().length() - 1), to.getOnlineId());
        }
        // 删除上线规格结束

        // 根据上线id删除上线图片开始
        _log.info("重新上线删除上线图片的参数为：{}", to.getOnlineId());
        int deleteByOnlineIdResult = 0;
        try {
            deleteByOnlineIdResult = onlOnlinePicSvc.deleteByOnlineId(to.getOnlineId());
        } catch (final Exception e) {
            e.printStackTrace();
        }
        _log.info("重新上线删除上线图片的返回值为：{}", deleteByOnlineIdResult);
        if (deleteByOnlineIdResult < 1) {
            _log.error("重新上线删除上线图片出错，上线id为：{}", to.getOnlineId());
            throw new RuntimeException("删除上线图片失败");
        }
        // 根据上线id删除上线图片结束
        // 上线图片id
        final Long onlinePicId = _idWorker.getId();
        // 添加上线主图开始
        final OnlOnlinePicMo onlinePicMo = new OnlOnlinePicMo();
        onlinePicMo.setId(onlinePicId);
        onlinePicMo.setOnlineId(to.getOnlineId());
        onlinePicMo.setPicType((byte) 1);
        onlinePicMo.setPicPath(to.getGoodsQsmm());
        _log.info("重新上线 添加上线主图的参数为：{}", onlinePicMo);
        final int addOnlinePicResult = onlOnlinePicSvc.add(onlinePicMo);
        _log.info("重新上线添加上线主图的返回值为：{}", addOnlinePicResult);
        if (addOnlinePicResult != 1) {
            _log.error("重新上线添加上线主图出错，上线id为：{}", to.getOnlineId());
            throw new RuntimeException("添加上线主图出错");
        }
        // 添加上线主图结束
        // 添加上线主图日志开始
        OnlOnlinePicLogMo onlinePicLogMo = new OnlOnlinePicLogMo();
        onlinePicLogMo.setOnlineLogId(onlineLogId);
        onlinePicLogMo.setOnlineId(to.getOnlineId());
        onlinePicLogMo.setPicType((byte) 1);
        onlinePicLogMo.setPicPath(to.getGoodsQsmm());
        _log.info("重新上线添加上线图片日志的参数为：{}", onlinePicLogMo);
        final int addOnlinePicLogResult = onlOnlinePicLogSvc.add(onlinePicLogMo);
        if (addOnlinePicLogResult != 1) {
            _log.error("重新上线添加上线图片日志出错，上线id为：{}", to.getOnlineId());
            throw new RuntimeException("添加上线主图日志出错");
        }
        for (int j = 0; j < to.getSlideshow().size(); j++) {
            // 轮播图id
            final Long picId = _idWorker.getId();
            // 添加商品轮播图开始
            final OnlOnlinePicMo picMo = new OnlOnlinePicMo();
            picMo.setId(picId);
            picMo.setOnlineId(to.getOnlineId());
            picMo.setPicPath(String.valueOf(to.getSlideshow().get(j).get("slideshow")));
            picMo.setPicType((byte) 0);
            _log.info("添加上线信息添加商品轮播图的参数为：{}", picMo);
            final int addPicResult = onlOnlinePicSvc.add(picMo);
            _log.info("添加上线信息添加商品轮播图的返回值为：{}", addPicResult);
            if (addPicResult != 1) {
                _log.error("添加上线商信息添加商品轮播图出错，上线id为：{}", to.getOnlineId());
                throw new RuntimeException("添加商品轮播图出错");
            }
            // 添加商品轮播图结束
            // 添加上线图片日志开始
            onlinePicLogMo = new OnlOnlinePicLogMo();
            onlinePicLogMo.setOnlineLogId(onlineLogId);
            onlinePicLogMo.setOnlineId(to.getOnlineId());
            onlinePicLogMo.setPicType((byte) 0);
            onlinePicLogMo.setPicPath(String.valueOf(to.getSlideshow().get(j).get("slideshow")));
            _log.info("添加上线信息添加上线轮播图日志的参数为：{}", onlinePicLogMo);
            final int addPicLogResult = onlOnlinePicLogSvc.add(onlinePicLogMo);
            _log.info("添加上线信息添加上线轮播图日志的返回值为：{}", addPicLogResult);
            if (addPicLogResult != 1) {
                _log.error("添加上线信息添加上线轮播图日志出错，上线id为：{}", to.getOnlineId());
                throw new RuntimeException("添加上线轮播图日志出错");
            }
            // 添加上线图片日志结束
        }
        _log.info("重新上线成功，上线id为：{}", to.getOnlineId());
        ro.setResult(ReOnlineDic.SUCCESS);
        ro.setMsg("重新上线成功");
        return ro;
    }

    /**
     * 重写查询上线信息
     *
     * @param ro
     * @param pageNum
     * @param pageSize
     * @param orderBy
     * @return
     */
    @Override
    @SuppressWarnings("unchecked")
    public PageInfo<OnlOnlineListRo> listEx(final OnlOnlineListRo ro, final int pageNum, final int pageSize,
            final String orderBy) {
        PageInfo<OnlOnlineListRo>   pageInfo = new PageInfo<>();
        final List<OnlOnlineListRo> listEx   = new ArrayList<>();

        // 根据thisOrgId和店铺名字查询当前卖家的所有店铺
        SlrShopMo ListslrShopMo = new SlrShopMo();
        ListslrShopMo.setShopName(ro.getShopName());
        ListslrShopMo.setSellerId(ro.getThisOrgId());
        _log.info("根据当前组织id获取该组织下的所有店铺的信息参数为：{}", ListslrShopMo);
        List<SlrShopMo> slrShopMoList = slrShopSvc.list(ListslrShopMo);
        _log.info("根据当前组织id获取该组织下的所有店铺的信息结果为：slrShopMoList-{}", slrShopMoList);
        if (slrShopMoList.size() == 0) {
            return pageInfo;
        }

        // 根据店铺id获取所有搜索分类
        // 拼接的店铺shopIds
        String shopIds = "";
        for (int i = 0; i < slrShopMoList.size(); i++) {
            if (i != 0 && i < slrShopMoList.size()) {
                shopIds += ",'" + slrShopMoList.get(i).getId() + "'";
            } else {
                shopIds += "'" + slrShopMoList.get(i).getId() + "'";
            }
        }
        _log.info("根据店铺id集合获取所有搜索分类的参数为: shopIds-{}", shopIds);
        List<OnlSearchCategoryMo> onlSearchCategoryList = onlSearchCategorySvc.searchCategoryByshopIds(shopIds);
        _log.info("根据店铺id集合获取所有搜索分类的结果为: shopIds-{}", onlSearchCategoryList);
        if (onlSearchCategoryList.size() == 0) {
            return pageInfo;
        }

        // 根据分类id集合获取所有上线id
        // 拼接的searchCategoryIds
        String searchCategoryIds = "";
        for (int i = 0; i < onlSearchCategoryList.size(); i++) {
            if (i != 0 && i < onlSearchCategoryList.size()) {
                searchCategoryIds += ",'" + onlSearchCategoryList.get(i).getId() + "'";
            } else {
                searchCategoryIds += "'" + onlSearchCategoryList.get(i).getId() + "'";
            }
        }
        _log.info("根据搜索分类id集合获取搜索上线信息参数为: searchCategoryId-{}", searchCategoryIds);
        List<OnlSearchCategoryOnlineMo> SearchCategoryOnlineList = onlSearchCategoryOnlineSvc
                .selectBysearchCategoryIds(searchCategoryIds);
        _log.info("根据搜索分类id集合获取搜索上线结果为: SearchCategoryOnlineList-{}", SearchCategoryOnlineList);
        if (SearchCategoryOnlineList.size() == 0) {
            return pageInfo;
        }

        // 根据上线id集合获取所有的上线信息。
        // 拼接的onlinerIds
        String onlineIds = "";
        for (int i = 0; i < SearchCategoryOnlineList.size(); i++) {
            if (i != 0 && i < SearchCategoryOnlineList.size()) {
                onlineIds += ",'" + SearchCategoryOnlineList.get(i).getOnlineId() + "'";
            } else {
                onlineIds += "'" + SearchCategoryOnlineList.get(i).getOnlineId() + "'";
            }
        }
        _log.info("拼接后的上线id集合 onlinerIds-{} ", onlineIds);
        SelectOnlineTo SelectOnlineTo = new SelectOnlineTo();
        SelectOnlineTo.setOnlineIds(onlineIds);
        SelectOnlineTo.setOnlineState(ro.getOnlineState());
        SelectOnlineTo.setOnlineTitle(ro.getOnlineTitle());
        _log.info("查询上线信息的参数为 SelectOnlineTo-{} ", SelectOnlineTo);
        final PageInfo<OnlOnlineMo> onlinePageInfo = PageHelper.startPage(pageNum, pageSize, orderBy)
                .doSelectPageInfo(() -> _mapper.selectOnlineInfo(SelectOnlineTo));
        _log.info("查询上线信息的结果为 onlinePageInfo.getList()-{} ", onlinePageInfo.getList());

        for (final OnlOnlineMo onlOnlineMo : onlinePageInfo.getList()) {
            final OnlOnlineListRo onlineListRo = dozerMapper.map(onlOnlineMo, OnlOnlineListRo.class);
            if (onlOnlineMo.getSupplierId() != null) {
                _log.info("获取供应商名称参数为：{}", onlOnlineMo.getSupplierId());
                final SucOrgRo sucOrgRo = sucOrgSvc.getById(onlOnlineMo.getSupplierId());
                _log.info("获取供应商名称的返回值为：{}", sucOrgRo);
                if (sucOrgRo.getRecord() != null && sucOrgRo.getRecord().getName() != null) {
                    onlineListRo.setSupplierName(sucOrgRo.getRecord().getName());
                }
            }
            if (onlOnlineMo.getDeliverOrgId() != null) {
                _log.info("获取发货组织名称的参数为：{}", onlOnlineMo.getDeliverOrgId());
                final SucOrgRo sucOrgRo = sucOrgSvc.getById(onlOnlineMo.getDeliverOrgId());
                _log.info("获取发货组织名称的返回值为：{}", sucOrgRo);
                if (sucOrgRo.getRecord() != null && sucOrgRo.getRecord().getName() != null) {
                    onlineListRo.setDeliverOrgName(sucOrgRo.getRecord().getName());
                }
            }
            OnlOnlinePromotionMo onlinePromotionMo = new OnlOnlinePromotionMo();
            onlinePromotionMo.setOnlineId(onlOnlineMo.getId());
            _log.info("重写查询上线信息查询推广信息的参数为:{}", onlinePromotionMo);
            OnlOnlinePromotionMo onlOnlinePromotionMo = onlOnlinePromotionSvc.getOne(onlinePromotionMo);
            _log.info("重写查询上线信息查询推广信息的返回值为:{}", onlOnlinePromotionMo);
            if (onlOnlinePromotionMo != null) {
                onlineListRo.setOnlineId(onlOnlinePromotionMo.getOnlineId());
            }
            listEx.add(onlineListRo);
        }
        pageInfo = dozerMapper.map(onlinePageInfo, PageInfo.class);
        pageInfo.setList(listEx);
        _log.info("重写查询上线信息的返回值为：{}", pageInfo);
        return pageInfo;
    }

    /**
     * 更新上线信息(下单后) 1. 如果上线数量-销售数量<购买数量，返回库存不足 2. 更新上线规格商品的销售数量=原销售数量+购买数量 3.
     * 删除用户的购物车 4. 如果上线的所有规格的上线数量都<=销售数量都，那么此上线记录自动下线
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Ro updateOnlineAfterOrder(final UpdateOnlineAfterOrderTo to) {
        _log.info("下单后更新上线信息的参数为：{}", to);
        final Ro ro = new Ro();
        _log.debug("检查参数的正确性");
        if (to.getUserId() == null) {
            final String msg = "参数错误";
            _log.error("{}:{}", msg, "没有传入下单人的用户ID");
            ro.setResult(ResultDic.PARAM_ERROR);
            ro.setMsg(msg);
            return ro;
        }
        _log.debug("参数正确");
        for (final UpdateOnlineSpecAfterOrderTo specTo : to.getSpecList()) {
            _log.debug("检查商品是否已下线");
            final OnlOnlineMo conditions1 = new OnlOnlineMo();
            conditions1.setId(specTo.getOnlineId());
            conditions1.setOnlineState((byte) OnlineStateDic.ONLINE.getCode());
            final boolean isOnline = thisSvc.existSelective(conditions1);
            _log.info("查询商品是否已上线的返回值为：{}", isOnline);
            if (!isOnline) {
                final String msg = "商品已下线";
                _log.error("{}: specTo-{}", msg, specTo);
                throw new RuntimeException(msg);
            }
            _log.info("获取上线规格信息");
            final OnlOnlineSpecMo onlineSpecMo = onlOnlineSpecSvc.getById(specTo.getOnlineSpecId());
            if (onlineSpecMo == null) {
                final String msg = "没有找到上线的规格信息";
                _log.error(msg + ": " + specTo);
                throw new RuntimeException(msg);
            }
            _log.info("获取上线规格的信息为：{}", onlineSpecMo);
            _log.info("检查购买数量是否超过库存数量");
            // XXX 检查购买数量是否超过库存数量：判断上线数量-销售数量是否小于购买数量-2
            if (onlineSpecMo.getCurrentOnlineCount().subtract(onlineSpecMo.getSaleCount())
                    .compareTo(specTo.getBuyCount()) == -1) {
                final String msg = "商品库存不足";
                _log.error("{}: onlineSpecMo-{}, 购买数量-{}", msg, onlineSpecMo, specTo.getBuyCount());
                throw new RuntimeException(msg);
            }
            _log.info("更新上线规格商品的销售数量=原销售数量+购买数量：specTo-{}, 原销售数量-{}", specTo, onlineSpecMo.getSaleCount());
            final int rowCount = onlOnlineSpecSvc.updateSaleCount(specTo.getBuyCount(), specTo.getOnlineSpecId(),
                    onlineSpecMo.getSaleCount());
            _log.info("更新销售数量的影响行数为{}", rowCount);
            if (rowCount != 1) {
                final String msg = "更新销售数量失败，出现并发问题";
                _log.error("{}: specTo-{}, onlineSpecMo-{}", msg, specTo, onlineSpecMo);
                throw new RuntimeException(msg);
            }
            _log.debug("删除购物车");
            if (specTo.getCartId() != null) {
                try {
                    cartSvc.del(specTo.getCartId());
                } catch (final RuntimeException e) {
                    // 这里捕获运行时，不让其抛出，避免事务回滚
                    _log.error("删除购物车出现运行时异常", e);
                }
            }
            if (onlineSpecMo.getCurrentOnlineCount()
                    .compareTo(onlineSpecMo.getSaleCount().add(specTo.getBuyCount())) < 1) {
                _log.debug("如果上线的所有规格的上线数量都<=销售数量，那么此上线记录自动下线");
                try {
                    _mapper.autoOffline(specTo.getOnlineId());
                } catch (final RuntimeException e) {
                    // 这里捕获运行时，不让其抛出，避免事务回滚
                    _log.error("自动下线出现运行时异常", e);
                }
                // 上线数量都<=销售数量,删除elasticSearch中相应的上线规格
                onlOnlineSpecEsSvc.del(onlineSpecMo.getId().toString());
            }
        }
        ro.setResult(ResultDic.SUCCESS);
        ro.setMsg("更新上线信息(下单后)成功");
        return ro;
    }

    @Override
    public PageInfo<SupplierGoodsRo> supplierGoods(SupplierGoodsTo to, int pageNum, int pageSize) {
        _log.info("供应商查询商品的参数为：SupplierGoodsTo：{}", to);
        final PageInfo<SupplierGoodsRo> supplierGoodsRo = PageHelper.startPage(pageNum, pageSize)
                .doSelectPageInfo(() -> _mapper.selectSupplierGoods(to));
        _log.info("供应商查询商品的结果为：：supplierGoodsRo：{}", supplierGoodsRo.getList());
        return supplierGoodsRo;
    }

    /**
     * 获取上线商品树
     * 
     * @param onlineId
     * @return
     */
    @Override
    public OnlOnlineTreeRo onlineTree(Long onlineId) {
        _log.info("获取上线商品树的参数为：onlineId-{}", onlineId);
        OnlOnlineTreeRo ro = new OnlOnlineTreeRo();
        if (onlineId == null) {
            _log.info("上线id为null");
            return ro;
        }

        _log.info("根据上线id查询上线信息的参数为：onlineId-{}", onlineId);
        OnlOnlineMo onlOnlineMo = thisSvc.getById(onlineId);
        _log.info("根据上线id查询上线信息的返回值为：{}", onlOnlineMo);

        if (onlOnlineMo != null && onlOnlineMo.getOnlineState() == 1) {
            ro = dozerMapper.map(onlOnlineMo, OnlOnlineTreeRo.class);
            OnlOnlineSpecMo specMo = new OnlOnlineSpecMo();
            specMo.setOnlineId(onlineId);
            _log.info("根据上线id查询上线规格信息的参数为：specMo-{}", specMo);
            List<OnlOnlineSpecMo> list = onlOnlineSpecSvc.list(specMo);
            _log.info("根据上线id查询上线规格信息的返回值为：{}", list);
            ro.setGoodsList(list);

            OnlOnlinePicMo onlOnlinePicMo = new OnlOnlinePicMo();
            onlOnlinePicMo.setOnlineId(onlineId);
            onlOnlinePicMo.setPicType((byte) 1);
            _log.info("根据上线id和图片类型获取获取商品主图的参数是：onlOnlinePicMo-{}", onlOnlinePicMo);
            List<OnlOnlinePicMo> picList = onlOnlinePicSvc.list(onlOnlinePicMo);
            _log.info("根据上线id获取获取商品主图的结果是：pigList-{}", picList);
            if (picList != null && picList.size() > 0) {
                ro.setPicPath(picList.get(0).getPicPath());
            }
        }
        _log.info("根据上线id获取上线商品树的返回值为：{}", ro);
        return ro;
    }

    /**
     * 判断是否为称重商品
     */
    @Override
    public boolean existWeighGoods(Long onlineId) {
        _log.info("判断是否为称重商品的参数:onlineId-{}", onlineId);
        return _mapper.existWeighGoods(onlineId);
    }

    @Override
    public void addGoodsToEs() {
        List<OnlOnlineSpecSo> soResult = _mapper.getOnlineInfo();
        _log.info("获取到的上线与上线规格信息为-{}", soResult);
        for (OnlOnlineSpecSo item : soResult) {
            onlOnlineSpecEsSvc.add(item);
        }
    }
}
