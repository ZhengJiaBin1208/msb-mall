package com.zjb.mall.order.fegin;

import com.zjb.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName ProductService
 * @Description TODO
 * @Author zhengjiabin
 * @Date 2022/6/21 17:35
 * @Version 1.0
 **/

/**
 * @FeignClient 指明要从注册中心中发现的服务名称
 */
@FeignClient(name = "mall-product")
public interface ProductService {

    @GetMapping("/product/brand/all")
    public R queryAllBrand();
}
