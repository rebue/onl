package rebue.onl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import rebue.onl.dic.OnlineGoodsPromotionDic;
import rebue.onl.to.AddOnlineTo;
import rebue.onl.to.OnlOnlineSpecTo;
import rebue.onl.to.UpdateOnlineAfterOrderTo;
import rebue.onl.to.UpdateOnlineSpecAfterOrderTo;
import rebue.robotech.dic.ResultDic;
import rebue.robotech.ro.Ro;
import rebue.wheel.OkhttpUtils;

/**
 * 创建时间：2018年3月27日 下午2:19:01 项目名称：onl-svr
 * 
 * @author daniel
 * @version 1.0
 * @since JDK 1.8 文件名称：OnlOnlineTest.java
 *        类说明：商品上线、推广测试
 */
public class OnlOnlineTests {
    private final static Logger _log          = LoggerFactory.getLogger(OnlOnlineTests.class);

    private final String        hostUrl       = "http://localhost:9101/";

    private final ObjectMapper  _objectMapper = new ObjectMapper();

    /**
     * 发布商品
     */
//    @Test
    public void onlineTest() throws JsonParseException, JsonMappingException, IOException {
        final String url = hostUrl + "/onl/online";
        final Map<String, Object> slideshowMap = new HashMap<>();
        slideshowMap.put("slideshow", "slideshow=/damaiSlideshow/2018/11/08/16/06/84D0945253F8493AB2106C13F19EE92C.png");
        final List<Map<String, Object>> slideshowList = new ArrayList<>();
        slideshowList.add(slideshowMap);

        final List<OnlOnlineSpecTo> onlineSpecList = new ArrayList<>();
        final OnlOnlineSpecTo onlineSpecTo = new OnlOnlineSpecTo();
        onlineSpecTo.setOnlineSpec("啊飒飒122");
        onlineSpecTo.setSalePrice(new BigDecimal(123));
        onlineSpecTo.setCostPrice(new BigDecimal(212));
        // 返现金（板块类型为普通返现时需要加）
//		onlineSpecTo.setCashbackAmount(new BigDecimal("121"));
        onlineSpecTo.setSaleUnit("个");
        onlineSpecTo.setCurrentOnlineCount(122);
        onlineSpecList.add(onlineSpecTo);

        final AddOnlineTo onlineTo = new AddOnlineTo();
        onlineTo.setProductId(0L);
        onlineTo.setOnlineName("阿萨飒飒啊实打实大声道21");
        // 全返商品
        onlineTo.setSubjectType((byte) 1);
        // 普通返现
//		onlineTo.setSubjectType((byte) 0);
        onlineTo.setGoodsQsmm("/damaiQsmm/2018/11/08/16/05/AF7569B9D64B444782860951C64E67B5.png");
        onlineTo.setOnlineDetail("<p>阿斯蒂芬噶水电费刚好是大法官好</p>");
        onlineTo.setOpId(520469568947224576L);
        onlineTo.setSupplierId(532812733012377601L);
        onlineTo.setDeliverOrgId(532812849798578179L);
        onlineTo.setOnlineSpecs(onlineSpecList);
        onlineTo.setSlideshow(slideshowList);

        final String result = OkhttpUtils.postByJsonParams(url, onlineTo);
        System.out.println(result);
    }

    /**
     * 获取上线商品
     */
//    @Test
    public void selectOnlineTest() throws IOException {
        final String url = hostUrl + "/onl/online?pageNum=" + 2 + "&pageSize=" + 1;
        final String list = OkhttpUtils.get(url);
        System.out.println(list);
    }

    /**
     * 根据条件查询上线商品规格信息
     */
//    @Test
    public void selectOnlineSpecTest() throws IOException {
        final String url = hostUrl + "/onl/onlinespec?pageNum=" + 1 + "&pageSize=" + 5 + "&onlineId=" + "454092105233596416";
        final String list = OkhttpUtils.get(url);
        System.out.println(list);
    }

    /**
     * 商品下线
     */
//    @Test
    public void updateOnlineTest() throws IOException {
        final Map<String, Object> map = new HashMap<>();
        map.put("id", "454092105233596416");
        map.put("onlineState", 0);
        final String url = hostUrl + "/onl/online";
        final String result = OkhttpUtils.putByFormParams(url, map);
        System.out.println(result);
    }

    /**
     * 上线商品推广
     */
//    @Test
    public void onlineGoodsPromoteTest() throws IOException {
        final String url = hostUrl + "/onl/onlinepromotion";
        final Map<String, Object> map = new HashMap<>();
        final OnlineGoodsPromotionDic item = OnlineGoodsPromotionDic.getItem(2);
        map.put("promotionType", item.getCode());
        map.put("onlineId", "454097686082224128");
        System.out.println(map);
        final String result = OkhttpUtils.postByFormParams(url, map);
        System.out.println(result);
    }

    /**
     * 判断上线商品是否已推广
     */
//    @Test
    public void selectOnlineGoodsPromoteExist() throws IOException {
        final String url = hostUrl + "/onl/onlinepromotion/exist";
        final Map<String, Object> map = new HashMap<>();
        map.put("onlineId", "454092105233596416");
        final String result = OkhttpUtils.get(url, map);
        System.out.println(result);
    }

    /**
     * 取消上线商品推广
     */
//    @Test
    public void deleteOnlineGoodsPromote() throws IOException {
        final String url = hostUrl + "/onl/onlinepromotion/";
        final String result = OkhttpUtils.delete(url + "454092105233596416");
        System.out.println(result);
    }

    /**
     * 获取上线商品推广列表
     */
//    @Test
    public void selectPromotionOnlineGoodsList() throws IOException {
        final String url = hostUrl + "/onl/onlinepromotion/list";
        final String result = OkhttpUtils.get(url);
        System.out.println(result);
    }

    /**
     * 获取上线商品列表
     */
//    @Test
    public void selectOnlineGoodsListTest() throws IOException {
        final Map<String, Object> map = new HashMap<>();
        map.put("sortname", "oo.ID");
        map.put("sortOrder", "DESC");
        map.put("start", "0");
        map.put("size", "10");
        final String result = OkhttpUtils.get(hostUrl + "/onl/online/list", map);
        System.out.println(result);
    }

    /**
     * 根据上线编号获取上线详情信息
     */

//    @Test
    public void selectOnlineGoodsDetails() throws IOException {
        final String result = OkhttpUtils.get(hostUrl + "/onl/online/details?id=" + "454098678299361291");
        System.out.println(result);
    }

//    @Test
    public void selectOnlineSpecInfoByOnlineId() throws IOException {
        final String result = OkhttpUtils.get(hostUrl + "/onl/onlinespec/details?id=" + "454098678299361291");
        System.out.println(result);
    }

    /**
     * 测试下单后更新上线信息
     */
    @Test
    public void test01() throws IOException {
        UpdateOnlineAfterOrderTo to = new UpdateOnlineAfterOrderTo();
        List<UpdateOnlineSpecAfterOrderTo> specList = new ArrayList<>();
        UpdateOnlineSpecAfterOrderTo specTo = new UpdateOnlineSpecAfterOrderTo();
        specTo.setOnlineId(522013913085116443L);
        specTo.setOnlineSpecId(522009343650955288L);
        specTo.setBuyCount(2);
        specTo.setCartId(533540461516816387L);
        specList.add(specTo);
        to.setSpecList(specList);
        Ro ro = updateOnlineAfterOrder(to);
        _log.info("返回值: {}", ro);
        Assert.assertEquals(ResultDic.PARAM_ERROR, ro.getResult());
        Assert.assertEquals("参数错误", ro.getMsg());

        to = new UpdateOnlineAfterOrderTo();
        to.setUserId(524919076280205312L);
        specTo.setOnlineId(522013913085116443L);
        specTo.setOnlineSpecId(522009343650955288L);
        specTo.setBuyCount(2);
        specTo.setCartId(533540461516816387L);
        specList.add(specTo);
        to.setSpecList(specList);
        ro = updateOnlineAfterOrder(to);
        _log.info("返回值: {}", ro);
        Assert.assertEquals(ResultDic.FAIL, ro.getResult());
        Assert.assertEquals("商品已下线", ro.getMsg());

        to = new UpdateOnlineAfterOrderTo();
        to.setUserId(524919076280205312L);
        specTo.setOnlineId(522009343600623638L);
        specTo.setOnlineSpecId(1L);
        specTo.setBuyCount(2);
        specTo.setCartId(533540461516816387L);
        specList.add(specTo);
        to.setSpecList(specList);
        ro = updateOnlineAfterOrder(to);
        _log.info("返回值: {}", ro);
        Assert.assertEquals(ResultDic.FAIL, ro.getResult());
        Assert.assertEquals("没有找到上线的规格信息", ro.getMsg());

        to = new UpdateOnlineAfterOrderTo();
        to.setUserId(524919076280205312L);
        specList = new ArrayList<>();
        specTo = new UpdateOnlineSpecAfterOrderTo();
        specTo.setOnlineId(522009343600623638L);
        specTo.setOnlineSpecId(522009343650955288L);
        specTo.setBuyCount(Integer.MAX_VALUE);
        specTo.setCartId(533540461516816387L);
        specList.add(specTo);
        to.setSpecList(specList);
        ro = updateOnlineAfterOrder(to);
        _log.info("返回值: {}", ro);
        Assert.assertEquals(ResultDic.FAIL, ro.getResult());
        Assert.assertEquals("商品库存不足", ro.getMsg());

        to = new UpdateOnlineAfterOrderTo();
        to.setUserId(524919076280205312L);
        specList = new ArrayList<>();
        specTo = new UpdateOnlineSpecAfterOrderTo();
        specTo.setOnlineId(522009343600623638L);
        specTo.setOnlineSpecId(522009343650955288L);
        specTo.setBuyCount(3);
        specTo.setCartId(533540461516816387L);
        specList.add(specTo);
        to.setSpecList(specList);
        ro = updateOnlineAfterOrder(to);
        _log.info("返回值: {}", ro);
        Assert.assertEquals(ResultDic.SUCCESS, ro.getResult());
    }

    /**
     * 请求下单后更新上线信息
     */
    private Ro updateOnlineAfterOrder(final UpdateOnlineAfterOrderTo to) throws IOException {
        _log.info("下单后更新上线信息的参数为：{}", to);
        final Ro ro = _objectMapper.readValue(OkhttpUtils.putByJsonParams(hostUrl + "/onl/online/updateonlineafterorder", to), Ro.class);
        _log.info("获取到返回值: {}", ro);
        return ro;
    }
}
