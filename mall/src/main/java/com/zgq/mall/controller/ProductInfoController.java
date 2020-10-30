package com.zgq.mall.controller;

import com.zgq.mall.common.api.CommonResult;
import com.zgq.mall.model.PmsBrand;
import com.zgq.mall.service.ProductInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * TODO
 *
 * @author zgq
 * @date 2020/10/28
 */

@RestController
public class ProductInfoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductInfoController.class);

    @Autowired
    private ProductInfoService productInfoService;

    @RequestMapping(value = "/brand/listAll",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsBrand>> getBrandList(){
        return CommonResult.success(productInfoService.listAllBrand());
    }

}
