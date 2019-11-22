package com.csii.base.dao;

import com.csii.base.pojo.MyLogger;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ElkRepository extends ElasticsearchRepository<MyLogger,String> {
    /**
     * 根据价格区间查询
     * @param price1
     * @param price2
     * @return
     */
//    List<MyLogger> findByPriceBetween(double price1, double price2);

}