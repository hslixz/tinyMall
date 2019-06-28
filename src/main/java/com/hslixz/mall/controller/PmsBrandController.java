package com.hslixz.mall.controller;

import com.hslixz.mall.common.api.CommonPage;
import com.hslixz.mall.common.api.CommonResult;
import com.hslixz.mall.common.api.ResultCode;
import com.hslixz.mall.mbg.model.PmsBrand;
import com.hslixz.mall.service.IPmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author l
 * 品牌管理controller
 * 2019/6/26 10:37
 */
@Api(value = "PmsBrandController", tags = "品牌管理controller")
@RestController
@RequestMapping("/brand")
public class PmsBrandController {
    @Autowired
    private IPmsBrandService pmsBrandService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);

    @ApiOperation(value = "获取指定id品牌", notes = "根据url的id来获取品牌")
    @ApiImplicitParam(name = "id", value = "品牌ID", required = true, dataType = "Long")
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public CommonResult<PmsBrand> getBrand(@PathVariable("id") Long id) {
        return CommonResult.success(pmsBrandService.get(id));
    }

    @ApiOperation(value = "获取所有品牌列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonResult<List<PmsBrand>> listAllBrand() {
        return CommonResult.success(pmsBrandService.listAll());
    }

    @ApiOperation(value = "分页获取品牌列表", notes = "根据指定页码与每页数量查询品牌")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页数量", required = true, dataType = "Integer")
    })
    @RequestMapping(value = "/list/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public CommonResult<CommonPage<PmsBrand>> listBrand(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) {
        List<PmsBrand> pmsBrands = pmsBrandService.listBrand(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(pmsBrands));
    }

    @ApiOperation(value = "删除指定id品牌", notes = "根据url的id来删除")
    @ApiImplicitParam(name = "id", value = "品牌ID", required = true, dataType = "Long")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public CommonResult deleteBrand(@PathVariable("id") Long id) {
        int count = pmsBrandService.delete(id);
        return opResult(count, 1, "deleteBrand", id);
    }

    @ApiOperation(value = "新建品牌", notes = "根据传入的PmsBrand对象来新建品牌")
    @ApiImplicitParam(name = "brand", value = "传入的品牌对象", required = true, dataType = "PmsBrand")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public CommonResult createBrand(@ModelAttribute PmsBrand brand) {
        int count = pmsBrandService.create(brand);
        return opResult(count, 1, "createBrand", brand);
    }

    @ApiOperation(value = "更新指定id的品牌", notes = "根据url中的id指定待更新的对象，并根据传入的PmsBrand对象更新信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "指定的品牌id", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "brand", value = "品牌信息实体", required = true, dataType = "PmsBrand")
    })
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public CommonResult updateBrand(@PathVariable("id") Long id, @ModelAttribute PmsBrand brand) {
        int count = pmsBrandService.update(id, brand);
        return opResult(count, 1, "updateBrand", brand);
    }

    /**
     * 判断操作是否成功并生成CommonResult
     *
     * @param count      操作返回值
     * @param exception  期望值
     * @param methodName 方法名
     * @param object     操作对象
     * @return 通用返回对象
     */
    private CommonResult opResult(int count, int exception, String methodName, Object object) {
        CommonResult result;
        if (count == exception) {
            result = CommonResult.success(null);
            LOGGER.debug(methodName + "success:{}", object);
        } else {
            result = CommonResult.failed(ResultCode.FAILED);
            LOGGER.debug(methodName + "failed:{}", object);
        }
        return result;
    }
}
