package com.zjb.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zjb.common.utils.PageUtils;
import com.zjb.mall.order.entity.OrderEntity;

import java.util.Map;

/**
 * 订单
 *
 * @author zjb
 * @email 757511020@qq.com
 * @date 2022-06-21 10:32:25
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

