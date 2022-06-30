package com.zjb.mall.product.controller;

import com.zjb.common.utils.PageUtils;
import com.zjb.common.utils.R;
import com.zjb.mall.product.entity.BrandEntity;
import com.zjb.mall.product.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * 品牌
 *
 * @author zjb
 * @email 757511020@qq.com
 * @date 2022-06-20 15:03:32
 */
@RestController
@RequestMapping("product/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;


    @GetMapping("/all")
    public R queryAllBrand(){
        BrandEntity entity = new BrandEntity();
        entity.setName("华为");
        return R.ok().put("brands",entity);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = brandService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{brandId}")
    public R info(@PathVariable("brandId") Long brandId){
		BrandEntity brand = brandService.getById(brandId);

        return R.ok().put("brand", brand);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@Valid @RequestBody BrandEntity brand, BindingResult result){
        System.out.println("brand" + brand);
        System.out.println("result" + result);
		if (result.hasErrors()){
		    // 提交的数据经过SR303校验后有非法的字段
            Map<String,String> map = new HashMap<>();
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                // 获取非法数据的 field
                String field = fieldError.getField();
                // 获取非法的field的提示信息
                String defaultMessage = fieldError.getDefaultMessage();
                map.put(field,defaultMessage);
            }
            return R.error(400,"提交的品牌表单数据不合法").put("data",map);
        }

        brandService.save(brand);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody BrandEntity brand){
		brandService.updateById(brand);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] brandIds){
		brandService.removeByIds(Arrays.asList(brandIds));

        return R.ok();
    }

}
