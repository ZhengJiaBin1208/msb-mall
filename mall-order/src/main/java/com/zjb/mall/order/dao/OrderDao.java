package com.zjb.mall.order.dao;

import com.zjb.mall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author zjb
 * @email 757511020@qq.com
 * @date 2022-06-21 10:32:25
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
