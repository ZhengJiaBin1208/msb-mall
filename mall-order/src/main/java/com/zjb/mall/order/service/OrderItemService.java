package com.zjb.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zjb.common.utils.PageUtils;
import com.zjb.mall.order.entity.OrderItemEntity;

import java.util.Map;

/**
 * 订单项信息
 *
 * @author zjb
 * @email 757511020@qq.com
 * @date 2022-06-21 10:32:25
 */
public interface OrderItemService extends IService<OrderItemEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

