package com.zjb.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zjb.common.utils.PageUtils;
import com.zjb.mall.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author zjb
 * @email 757511020@qq.com
 * @date 2022-06-20 15:03:32
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CategoryEntity> queryPageWithTree(Map<String, Object> params);

    void removeCateggoryByIds(List<Long> ids);

}

