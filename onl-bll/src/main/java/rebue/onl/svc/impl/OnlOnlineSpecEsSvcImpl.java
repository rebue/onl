package rebue.onl.svc.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.ScoreSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import rebue.onl.ro.OnlOnlineSpecEsRo;
import rebue.onl.so.OnlOnlineSpecSo;
import rebue.onl.svc.OnlOnlineSpecEsSvc;
import rebue.robotech.svc.impl.EsBaseSvcImpl;

/**
 * 上线规格
 * elasticSearch服务实现类
 */
@Service
public class OnlOnlineSpecEsSvcImpl extends EsBaseSvcImpl<OnlOnlineSpecSo> implements OnlOnlineSpecEsSvc {

    private static final Logger _log = LoggerFactory.getLogger(OnlOnlineSpecEsSvcImpl.class);

    @Resource
    private RestHighLevelClient esClient;

    @Override
    public String getIndexName() {
        return "onl-online-spec";
    }

    /**
     * 根据名称查询上线信息
     */
    @Override
    public List<OnlOnlineSpecEsRo> selectByName(String name) {
        _log.info("selectByName:{}", name);
        try {
            // 模糊查询
            QueryBuilder        queryBuilder        = QueryBuilders.matchPhraseQuery("onlineSpec.pinyin", name);// 加上.keyword就是精确查找
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            // 开始位置
            searchSourceBuilder.from(0);
            // 每页数量
            searchSourceBuilder.size(12);
            searchSourceBuilder.query(queryBuilder);

            // 排序
            // Sort descending by _score (the default)
            searchSourceBuilder.sort(new ScoreSortBuilder().order(SortOrder.DESC));
            // Also sort ascending by _id field
            searchSourceBuilder.sort(new FieldSortBuilder("_id").order(SortOrder.ASC));

            // 查询指定字段 不查询指定字段
            // 该方法还接受一个由一个或多个通配符模式组成的数组，以控制以更细粒度的方式包含或排除哪些字段:
//           searchSourceBuilder.fetchSource(false);
//           String[] includeFields = new String[]{"name"};
//           String[] excludeFields = Strings.EMPTY_ARRAY;
//           searchSourceBuilder.fetchSource(includeFields, excludeFields);

            SearchRequest searchRequest = new SearchRequest();
            searchRequest.indices(getIndexName());
            searchRequest.source(searchSourceBuilder);
            SearchResponse search = esClient.search(searchRequest, RequestOptions.DEFAULT);

            _log.info("search返回值:{}", search);
            SearchHits              hits = search.getHits();
            List<OnlOnlineSpecEsRo> list = new ArrayList<OnlOnlineSpecEsRo>();
            for (SearchHit hit : hits) {
                Map<String, Object> tempSource = hit.getSourceAsMap();
                if (tempSource != null) {
                    OnlOnlineSpecEsRo mo = new OnlOnlineSpecEsRo();
                    mo.setOnlineSpec(tempSource.get("onlineSpec").toString());
                    mo.setId(Long.parseLong(tempSource.get("id").toString()));
                    mo.setOnlineId(Long.parseLong(tempSource.get("onlineId").toString()));
                    mo.setSaleUnit(tempSource.get("saleUnit").toString());
                    mo.setSalePrice(new BigDecimal(tempSource.get("salePrice").toString()));
                    mo.setBuyPoint(new BigDecimal(tempSource.get("buyPoint").toString()));
                    mo.setCashbackAmount(new BigDecimal(tempSource.get("cashbackAmount").toString()));
                    mo.setCommissionAmount(new BigDecimal(tempSource.get("commissionAmount").toString()));
                    mo.setCostPrice(new BigDecimal(tempSource.get("costPrice").toString()));
                    mo.setFirstBuyPoint(new BigDecimal(tempSource.get("firstBuyPoint").toString()));
                    mo.setLimitCount(new BigDecimal(tempSource.get("limitCount").toString()));
                    mo.setIsWeighGoods(tempSource.get("isWeighGoods").toString().equalsIgnoreCase("true"));
                    list.add(mo);
                }
            }

            _log.info("hits返回值:{}", list);
            return list;
        } catch (final IOException e) {
            final String msg = "ElasticSearch获取document失败";
            _log.error(msg, e);
            throw new RuntimeException(msg, e);
        }
    }

}
