package com.zjb.mall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zjb.common.exception.group.AddGroupsInterface;
import com.zjb.common.exception.group.UpdateGroupsInterface;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * 品牌
 * 
 * @author zjb
 * @email 757511020@qq.com
 * @date 2022-06-20 15:03:32
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 品牌id
	 */
	@NotNull(message = "更新品牌信息品牌ID必须不为空",groups = {UpdateGroupsInterface.class})
	@Null(message = "添加品牌信息品牌ID必须为空",groups = {AddGroupsInterface.class})
	@TableId
	private Long brandId;
	/**
	 * 品牌名
	 */
	@NotBlank(message = "品牌的名称不能为空",groups = {AddGroupsInterface.class})
	private String name;
	/**
	 * 品牌logo地址
	 */
	@NotBlank(message = "logo不能为空",groups = {AddGroupsInterface.class})
	@URL(message = "logo必须是一个合法的URL地址",groups = {AddGroupsInterface.class,UpdateGroupsInterface.class})
	private String logo;
	/**
	 * 介绍
	 */
	private String descript;
	/**
	 * 显示状态[0-不显示；1-显示]
	 */
	private Integer showStatus;
	/**
	 * 检索首字母
	 */
	@NotBlank(message = "检索首字母不能为空",groups = {AddGroupsInterface.class})
	@Pattern(regexp ="/^[a-zA-Z]$/" ,message = "检索首字母必须是单个的字母",groups = {AddGroupsInterface.class,UpdateGroupsInterface.class})
	private String firstLetter;
	/**
	 * 排序
	 */
	@NotNull(message = "排序不能为空",groups = {AddGroupsInterface.class})
	@Min(value = 0,message = "排序不能小于0",groups = {AddGroupsInterface.class,UpdateGroupsInterface.class})
	private Integer sort;

}
