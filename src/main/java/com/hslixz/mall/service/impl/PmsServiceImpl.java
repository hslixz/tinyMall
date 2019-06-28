package com.hslixz.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.hslixz.mall.mbg.mapper.PmsBrandMapper;
import com.hslixz.mall.mbg.model.PmsBrand;
import com.hslixz.mall.mbg.model.PmsBrandExample;
import com.hslixz.mall.service.IPmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author l
 * @description
 * @time 2019/6/26 10:31
 */
@Service
public class PmsServiceImpl implements IPmsBrandService {
    @Autowired
    private PmsBrandMapper pmsBrandMapper;

    @Override
    public List<PmsBrand> listAll() {
        return pmsBrandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public int create(PmsBrand brand) {
        return pmsBrandMapper.insert(brand);
    }

    @Override
    public int update(Long id, PmsBrand brand) {
        brand.setId(id);
        return pmsBrandMapper.updateByPrimaryKey(brand);
    }

    @Override
    public int delete(Long id) {
        return pmsBrandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<PmsBrand> listBrand(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return pmsBrandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public PmsBrand get(Long id) {
        return pmsBrandMapper.selectByPrimaryKey(id);
    }
}
