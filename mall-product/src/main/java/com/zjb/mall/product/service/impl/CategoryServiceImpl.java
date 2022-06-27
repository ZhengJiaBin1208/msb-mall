package com.zjb.mall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjb.common.utils.PageUtils;
import com.zjb.common.utils.Query;
import com.zjb.mall.product.dao.CategoryDao;
import com.zjb.mall.product.entity.CategoryEntity;
import com.zjb.mall.product.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * @author zhengjiabin
     * @description 查询所有的类别数据，然后将数据封装为树形结构，便于前端使用
     * @date 2022/6/23 10:46
     * @param params
     * @return List<CategoryEntity>
     **/
    @Override
    public List<CategoryEntity> queryPageWithTree(Map<String, Object> params) {
        // 1.查询所有商品分类信息
        List<CategoryEntity> categoryEntities = baseMapper.selectList(null);
        // 2.将商品分类差结尾树形结构【父子关系】
        // 第一部遍历出所有的大类 parent_cid = 0
        List<CategoryEntity> list = categoryEntities.stream().filter(categoryEntity -> categoryEntity.getParentCid() == 0)
                .map(categoryEntity -> {
                    // 根据大类找到所有的小类 地柜方式实现
                    categoryEntity.setChildrens(getCategoryChildrens(categoryEntity,categoryEntities));
                    return categoryEntity;
                }).sorted((entity1, entity2) -> {
                    return (entity1.getSort() == null ? 0 : entity1.getSort()) - (entity2.getSort() == null ? 0 : entity2.getSort());
                }).collect(Collectors.toList());
        // 第二步根据大类找到对应的所有小类
        return list;
    }


    /**
     * @author zhengjiabin
     * @description 查找该大类下的所有的小类 递归查找
     * @date 2022/6/23 11:19 
     * @param categoryEntity 某个大类
     * @param categoryEntities 所有的类别数据
     * @return java.util.List<com.zjb.mall.product.entity.CategoryEntity>
     **/
    private List<CategoryEntity> getCategoryChildrens(CategoryEntity categoryEntity, List<CategoryEntity> categoryEntities) {
        List<CategoryEntity> collect = categoryEntities.stream().filter(entity -> {
            // 根据大类找到他的直属小类
            return entity.getParentCid().equals(categoryEntity.getCatId());
        }).map(entity -> {
            // 根据这个小类递归找到对应的小小类
            entity.setChildrens(getCategoryChildrens(entity, categoryEntities));
            return entity;
        }).sorted((entity1, entity2) -> {
            return (entity1.getSort() == null ? 0 : entity1.getSort()) - (entity2.getSort() == null ? 0 : entity2.getSort());
        }).collect(Collectors.toList());
        return collect;
    }



    /**
     * @author zhengjiabin
     * @description 逻辑批量删除
     * @date 2022/6/27 11:03
     * @param ids
     * @return void
     **/
    @Override
    public void removeCateggoryByIds(List<Long> ids) {
        // TODO 1.检查类别数据是否在其他业务中使用

        // 2.批量逻辑删除操作
        baseMapper.deleteBatchIds(ids);
    }

}