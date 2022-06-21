package com.zjb.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zjb.common.utils.PageUtils;
import com.zjb.mall.member.entity.MemberEntity;

import java.util.Map;

/**
 * 会员
 *
 * @author zjb
 * @email 757511020@qq.com
 * @date 2022-06-21 10:34:58
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

