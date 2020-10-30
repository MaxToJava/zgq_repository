package com.zgq.mall.service;

import com.zgq.mall.model.PmsBrand;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author zgq
 * @date 2020/10/29
 */

public interface ProductInfoService {
    public List<PmsBrand> listAllBrand();
}
