package com.zjb.mall.member.dao;

import com.zjb.mall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author zjb
 * @email 757511020@qq.com
 * @date 2022-06-21 10:34:58
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
