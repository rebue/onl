package rebue.onl.svr.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import rebue.onl.mo.OnlSearchCategoryOnlineMo;
import rebue.robotech.ro.Ro;
import rebue.sbs.feign.FeignConfig;

@FeignClient(name = "onl-svr", configuration = FeignConfig.class, contextId = "onl-svr-search-category-online")
public interface OnlSearchCategoryOnlineSvc {

    @PostMapping("/onl/searchcategoryonline")
    Ro add(@RequestBody OnlSearchCategoryOnlineMo mo);

    @GetMapping("/onl/searchcategoryonline/get-by-onlineid")
    OnlSearchCategoryOnlineMo getByOnlineId(@RequestBody OnlSearchCategoryOnlineMo mo);

    @PutMapping("/onl/searchcategoryonline")
    Ro modify(@RequestBody OnlSearchCategoryOnlineMo mo);

}
