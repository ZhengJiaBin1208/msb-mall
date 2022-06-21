package com.zjb.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zjb.common.utils.PageUtils;
import com.zjb.mall.coupon.entity.SeckillSkuRelationEntity;

import java.util.Map;

/**
 * 秒杀活动商品关联
 *
 * @author zjb
 * @email 757511020@qq.com
 * @date 2022-06-21 10:30:56
 */
public interface SeckillSkuRelationService extends IService<SeckillSkuRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

