package com.zjb.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zjb.common.utils.PageUtils;
import com.zjb.mall.member.entity.MemberLevelEntity;

import java.util.Map;

/**
 * 会员等级
 *
 * @author zjb
 * @email 757511020@qq.com
 * @date 2022-06-21 10:34:58
 */
public interface MemberLevelService extends IService<MemberLevelEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

