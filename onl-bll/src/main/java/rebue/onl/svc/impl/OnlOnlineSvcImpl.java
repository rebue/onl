package rebue.onl.svc.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import rebue.onl.dic.AddOnlineDic;
import rebue.onl.mapper.OnlOnlineMapper;
import rebue.onl.mo.OnlOnlineMo;
import rebue.onl.mo.OnlOnlinePicMo;
import rebue.onl.mo.OnlOnlineSpecMo;
import rebue.onl.ro.AddOnlineRo;
import rebue.onl.ro.OnlOnlineGoodsInfoRo;
import rebue.onl.svc.OnlOnlinePicSvc;
import rebue.onl.svc.OnlOnlineSpecSvc;
import rebue.onl.svc.OnlOnlineSvc;
import rebue.onl.to.AddOnlineTo;
import rebue.onl.to.OnlineGoodsListTo;
import rebue.robotech.svc.impl.MybatisBaseSvcImpl;

/**
 * 上线信息
 *
 * 在单独使用不带任何参数的 @Transactional 注释时，
 * propagation(传播模式)=REQUIRED，readOnly=false，
 * isolation(事务隔离级别)=READ_COMMITTED，
 * 而且事务不会针对受控异常（checked exception）回滚。
 *
 * 注意：
 * 一般是查询的数据库操作，默认设置readOnly=true, propagation=Propagation.SUPPORTS
 * 而涉及到增删改的数据库操作的方法，要设置 readOnly=false, propagation=Propagation.REQUIRED
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
@Service
public class OnlOnlineSvcImpl extends MybatisBaseSvcImpl<OnlOnlineMo, java.lang.Long, OnlOnlineMapper> implements OnlOnlineSvc {

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public int add(OnlOnlineMo mo) {
        _log.info("添加上线信息");
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
    private OnlOnlineSpecSvc    onlOnlineSpecSvc;

    /**
     */
    @Resource
    private OnlOnlinePicSvc     onlOnlinePicSvc;

    /**
     */
    @Resource
    private OnlOnlineSvc        onlOnlineSvc;

    /**
     * 添加上线信息
     *
     * @param to
     * @return
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public AddOnlineRo addOnline(AddOnlineTo to) {
        _log.info("添加上线信息的参数为：{}", to);
        AddOnlineRo ro = new AddOnlineRo();
        if (to.getOnlineName() == null || to.getOnlineName().equals("") || to.getGoodsQsmm() == null || to.getGoodsQsmm().equals("") || to.getOnlineSpecs().size() == 0
                || to.getSlideshow().size() == 0) {
            ro.setResult(AddOnlineDic.PARAMETER_ERROR);
            ro.setMsg("参数错误");
            return ro;
        }
        Long onlineId = _idWorker.getId();
        Long productId = to.getProductId();
        productId = productId == null ? onlineId : productId;
        Date onlineTime = new Date();
        // 添加上线信息开始
        OnlOnlineMo onlineMo = new OnlOnlineMo();
        onlineMo.setId(onlineId);
        onlineMo.setOnlineTitle(to.getOnlineName());
        onlineMo.setOnlineDetail(to.getOnlineDetail());
        onlineMo.setOpId(to.getOpId());
        onlineMo.setOnlineState((byte) 1);
        onlineMo.setOnlineTime(onlineTime);
        onlineMo.setProductId(productId);
        onlineMo.setSubjectType((byte) to.getSubjectType());
        _log.info("添加上线信息的参数为：{}", onlineMo);
        int addResult = add(onlineMo);
        _log.info("添加上线信息的返回值为：{}", addResult);
        if (addResult != 1) {
            _log.error("添加上线信息出错，用户id为：{}", to.getOpId());
            ro.setResult(AddOnlineDic.ADD_GOODS_ONLINE_ERROR);
            ro.setMsg("添加上线信息出错");
            return ro;
        }
        // 添加上线规格信息开始
        for (int i = 0; i < to.getOnlineSpecs().size(); i++) {
            OnlOnlineSpecMo onlineSpecMo = new OnlOnlineSpecMo();
            onlineSpecMo.setId(_idWorker.getId());
            onlineSpecMo.setOnlineId(onlineId);
            onlineSpecMo.setOnlineSpec(to.getOnlineSpecs().get(i).getOnlineSpec());
            BigDecimal cashbackAmount = new BigDecimal("0");
            if (to.getSubjectType() == 0) {
                cashbackAmount = to.getOnlineSpecs().get(i).getCashbackAmount();
            }
            onlineSpecMo.setCashbackAmount(cashbackAmount);
            onlineSpecMo.setSalePrice(to.getOnlineSpecs().get(i).getSalePrice());
            if (to.getOnlineSpecs().get(i).getCommissionAmount() != null) {
                onlineSpecMo.setCommissionAmount(to.getOnlineSpecs().get(i).getCommissionAmount());
            }
            onlineSpecMo.setSaleUnit(to.getOnlineSpecs().get(i).getSaleUnit());
            onlineSpecMo.setSaleCount(to.getOnlineSpecs().get(i).getSaleCount());
            onlineSpecMo.setOnlineTotal(to.getOnlineSpecs().get(i).getSaleCount());
            onlineSpecMo.setSeqNo(i);
            _log.info("添加上线信息添加上线规格信息的参数为：{}", onlineSpecMo);
            int addOnlineSpecResult = onlOnlineSpecSvc.add(onlineSpecMo);
            _log.info("添加上线信息添加上线规格信息的返回值为：{}", addOnlineSpecResult);
            if (addOnlineSpecResult != 1) {
                _log.error("添加上线信息添加上线规格信息时出错，用户id为：{}", to.getOpId());
                throw new RuntimeException("添加商品规格出错");
            }
        }
        // 添加上线规格信息结束
        // 添加商品主图开始
        OnlOnlinePicMo qsmmPicMo = new OnlOnlinePicMo();
        qsmmPicMo.setId(_idWorker.getId());
        qsmmPicMo.setOnlineId(onlineId);
        qsmmPicMo.setPicPath(to.getGoodsQsmm());
        qsmmPicMo.setPicType((byte) 1);
        _log.info("添加上线信息添加商品主图的参数为：{}", qsmmPicMo);
        int addQsmmResult = onlOnlinePicSvc.add(qsmmPicMo);
        _log.info("添加上线信息添加商品主图的返回值为：{}", addQsmmResult);
        if (addQsmmResult != 1) {
            _log.error("添加上线信息添加商品主图时出错，用户id为：{}", to.getOpId());
            throw new RuntimeException("添加商品主图出错");
        }
        // 添加商品轮播图开始
        for (int j = 0; j < to.getSlideshow().size(); j++) {
            OnlOnlinePicMo picMo = new OnlOnlinePicMo();
            picMo.setId(_idWorker.getId());
            picMo.setOnlineId(onlineId);
            picMo.setPicPath(String.valueOf(to.getSlideshow().get(j).get("slideshow")));
            picMo.setPicType((byte) 0);
            _log.info("添加上线信息添加商品轮播图的参数为：{}", picMo);
            int addPicResult = onlOnlinePicSvc.add(picMo);
            _log.info("添加上线信息添加商品轮播图的返回值为：{}", addPicResult);
            if (addPicResult != 1) {
                _log.error("添加上线商信息添加商品轮播图出错，用户id为：{}", to.getOpId());
                throw new RuntimeException("添加商品轮播图出错");
            }
        }
        // 添加商品轮播图结束
        _log.info("发布商品成功，用户id为：{}", to.getOpId());
        ro.setResult(AddOnlineDic.SUCCESS);
        ro.setMsg("发布成功");
        return ro;
    }

    /**
     * 获取上线商品列表 2018年3月29日17:41:26
     */
    @Override
    public List<OnlOnlineGoodsInfoRo> selectOnlineGoodsList(OnlineGoodsListTo to) {
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
    public OnlOnlineMo listByPrimaryKey(Long id) {
        return _mapper.selectByPrimaryKey(id);
    }
}
