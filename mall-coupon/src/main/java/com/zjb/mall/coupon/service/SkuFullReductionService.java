package com.zjb.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zjb.common.utils.PageUtils;
import com.zjb.mall.coupon.entity.SkuFullReductionEntity;

import java.util.Map;

/**
 * 商品满减信息
 *
 * @author zjb
 * @email 757511020@qq.com
 * @date 2022-06-21 10:30:56
 */
public interface SkuFullReductionService extends IService<SkuFullReductionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

