package rebue.onl.svr.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import rebue.onl.mo.OnlSearchCategoryMo;
import rebue.onl.ro.OnlSearchCategoryTreeRo;
import rebue.sbs.feign.FeignConfig;

@FeignClient(name = "onl-svr", configuration = FeignConfig.class, contextId = "onl-svr-search-category")
public interface OnlSearchCategorySvc {

    /**
     * 根据店铺id获取搜索分类树
     * 
     * @param shopId
     * @return
     */
    @GetMapping("/onl/searchcategory/tree")
    List<OnlSearchCategoryTreeRo> searchCategoryTreeList(@RequestParam("shopId") Long shopId);
    
    
    @PostMapping("/onl/addSearchCategory")
    int addSearchCategory(@RequestBody OnlSearchCategoryMo mo);
}
