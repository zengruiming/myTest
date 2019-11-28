package com.ruiming.manage_cms.dao;


import com.ruiming.framework.domain.cms.CmsTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CmsTemplateRepository extends MongoRepository<CmsTemplate,String> {
}
