package com.hslixz.mall.service;

import com.hslixz.mall.mbg.model.PmsBrand;

import java.util.List;

/**
 * 商品品牌service接口
 * @author l
 * @version 0.1
 * @since 0.1
 */
public interface IPmsBrandService {
    /**
     * 返回所有品牌
     * @return 品牌列表
     */
    List<PmsBrand> listAll();

    /**
     * 新建一个品牌
     * @param brand 品牌实体
     * @return 成功条数
     */
    int create(PmsBrand brand);

    /**
     * 更新品牌信息
     * @param id 指定的品牌id
     * @param brand 品牌实体
     * @return 成功条数
     */
    int update(Long id, PmsBrand brand);

    /**
     * 删除指定品牌
     * @param id 品牌id
     * @return 成功条数
     */
    int delete(Long id);

    /**
     * 分页查询品牌
     * @param pageNum 页码
     * @param pageSize 页面数量
     * @return 品牌列表
     */
    List<PmsBrand> listBrand(int pageNum, int pageSize);

    /**
     * 获取指定品牌
     * @param id 品牌id
     * @return 品牌实体
     */
    PmsBrand get(Long id);
}
