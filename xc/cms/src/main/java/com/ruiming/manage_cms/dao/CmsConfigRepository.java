package com.ruiming.manage_cms.dao;


import com.ruiming.framework.domain.cms.CmsConfig;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CmsConfigRepository extends MongoRepository<CmsConfig,String> {
}
