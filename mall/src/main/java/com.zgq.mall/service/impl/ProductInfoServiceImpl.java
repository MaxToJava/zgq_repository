package com.zgq.mall.service.impl;

import com.zgq.mall.mapper.PmsBrandMapper;
import com.zgq.mall.model.PmsBrand;
import com.zgq.mall.model.PmsBrandExample;
import com.zgq.mall.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author zgq
 * @date 2020/10/29
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private PmsBrandMapper pmsBrandMapper;

    @Override
    public List<PmsBrand> listAllBrand() {
        return pmsBrandMapper.selectByExample(new PmsBrandExample());
    }
}
