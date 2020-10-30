package com.zgq.mall.mapper;

import com.zgq.mall.model.PmsBrand;
import com.zgq.mall.model.PmsBrandExample;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


import java.util.List;

/**
 * TODO
 *
 * @author zgq
 * @date 2020/10/28
 */
@Mapper
@Component(value = "pmsBrandMapper")
public interface PmsBrandMapper {
    List<PmsBrand> selectByExample(PmsBrandExample example);
}
