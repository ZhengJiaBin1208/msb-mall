package com.zjb.mall.product.dao;

import com.zjb.mall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author zjb
 * @email 757511020@qq.com
 * @date 2022-06-20 15:03:32
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
