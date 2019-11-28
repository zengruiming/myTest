package com.csii.base.service;

import com.csii.base.dao.ElkRepository;
import com.csii.base.pojo.MyLogger;
import org.aspectj.weaver.ast.And;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.StringTerms;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.FetchSourceFilter;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @program: elk_parent
 * @description: elk业务逻辑
 * @author: zrm
 * @create: 2019-11-18 15:14
 **/
@Service
public class ElkService {

    @Autowired
    private ElkRepository elkRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    /**
     * @Description: 创建及映射索引
     * @Param:
     * @return:
     * @Author: zrm
     * @Date: 2019/11/18
     */
    public void createIndex() {
        // 创建索引，会根据Item类的@Document注解信息来创建
        elasticsearchTemplate.createIndex(MyLogger.class);
        // 配置映射，会根据Item类中的id、Field等字段来自动完成映射
        elasticsearchTemplate.putMapping(MyLogger.class);
    }

    /**
     * @Description: 删除索引
     * @Param:
     * @return:
     * @Author: zrm
     * @Date: 2019/11/18
     */
    public void deleteIndex() {
        elasticsearchTemplate.deleteIndex("mylogger");
    }

    /**
     * @Description: 新增数据
     * @Param:
     * @return:
     * @Author: zrm
     * @Date: 2019/11/18
     */
    public void index() {
        MyLogger MyLogger = new MyLogger(new Date(), "INFO", "org.springframework.context.support.PostProcessorRegistrationDelegate$BeanPostProcessorChecker", "postProcessAfterInitialization", 330, "Bean 'org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration' of type [org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration$$EnhancerBySpringCGLIB$$8359a75b] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)");
        elkRepository.save(MyLogger);
    }

    /**
     * @Description: 批量新增数据1
     * @Param:
     * @return:
     * @Author: zrm
     * @Date: 2019/11/18
     */
    public void indexList() {
        List<MyLogger> list = new ArrayList<>();
        list.add(new MyLogger(new Date(), "DEBUG", "org.springframework.context.support.PostProcessorRegistrationDelegate$BeanPostProcessorChecker", "postProcessAfterInitialization", 130, "Bean 'org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration' of type [org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration$$EnhancerBySpringCGLIB$$8359a75b] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)"));
        list.add(new MyLogger(new Date(), "INFO", "org.springframework.context.support.PostProcessorRegistrationDelegate$BeanPostProcessorChecker", "postProcessAfterInitialization", 30, "Bean 'org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration' of type [org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration$$EnhancerBySpringCGLIB$$8359a75b] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)"));
        // 接收对象集合，实现批量新增
        elkRepository.saveAll(list);
        System.out.println("fjjf");
    }

    /**
     * @param :
     * @Description: 批量新增数据2
     * @return: void
     * @Author: zrm
     * @Date: 2019/11/19 10:23
     */
    public void indexListAll() {
        List<MyLogger> list = new ArrayList<>();
        list.add(new MyLogger(new Date(), "INFO", "org.springframework.context.support.PostProcessorRegistrationDelegate$BeanPostProcessorChecker", "postProcessAfterInitialization", 230, "Bean 'org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration' of type [org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration$$EnhancerBySpringCGLIB$$8359a75b] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)"));
        list.add(new MyLogger(new Date(), "DEBUG", "org.springframework.context.support.PostProcessorRegistrationDelegate$BeanPostProcessorChecker", "postProcessAfterInitialization", 50, "Bean 'org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration' of type [org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration$$EnhancerBySpringCGLIB$$8359a75b] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)"));
        list.add(new MyLogger(new Date(), "DEBUG", "org.springframework.context.support.PostProcessorRegistrationDelegate$BeanPostProcessorChecker", "postProcessAfterInitialization", 70, "Bean 'org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration' of type [org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration$$EnhancerBySpringCGLIB$$8359a75b] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)"));
        list.add(new MyLogger(new Date(), "INFO", "org.springframework.context.support.PostProcessorRegistrationDelegate$BeanPostProcessorChecker", "postProcessAfterInitialization", 990, "Bean 'org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration' of type [org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration$$EnhancerBySpringCGLIB$$8359a75b] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)"));
        list.add(new MyLogger(new Date(), "INFO", "org.springframework.context.support.PostProcessorRegistrationDelegate$BeanPostProcessorChecker", "postProcessAfterInitialization", 111, "Bean 'org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration' of type [org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration$$EnhancerBySpringCGLIB$$8359a75b] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)"));
        // 接收对象集合，实现批量新增
        elkRepository.saveAll(list);
    }

    /**
     * @param id:
     * @Description: 根据id查记录
     * @return: com.csii.base.pojo.MyLogger
     * @Author: zrm
     * @Date: 2019/11/19 10:24
     */
    public MyLogger testQuery(String id) {
        Optional<MyLogger> optional = this.elkRepository.findById(id);
        return optional.get();
    }

    /**
     * @param :
     * @Description: 查询全部，并按照价格降序排序
     * @return: java.lang.Iterable<com.csii.base.pojo.MyLogger>
     * @Author: zrm
     * @Date: 2019/11/19 10:29
     */
    public Iterable<MyLogger> testFind() {
        return this.elkRepository.findAll(Sort.by(Sort.Direction.DESC, "line"));
    }

    /**
     * @param :
     * @Description: 高级基本查询
     * @return: entity.Result
     * @Author: zrm
     * @Date: 2019/11/19 10:29
     */
    public Iterable<MyLogger> testFullQuery(String field , String terms) {
        // 词条查询
        MatchQueryBuilder queryBuilder = QueryBuilders.matchQuery(field,terms);
        // 执行查询
        return this.elkRepository.search(queryBuilder);
    }

    /**
     * @Description: 自定义查询
     * @param field:
     * @param terms:
     * @return: org.springframework.data.domain.Page<com.csii.base.pojo.MyLogger>
     * @Author: zrm
     * @Date: 2019/11/19 15:37
     */
    public Page<MyLogger> testDiyNativeQuery(String field , String terms){
        // 构建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加基本的分词查询
        queryBuilder.withQuery(QueryBuilders.matchQuery(field,terms));
        // 执行搜索，获取结果
        return this.elkRepository.search(queryBuilder.build());
    }

    /**
     * @Description: 分页查询
     * @param field:
     * @param terms:
     * @param page:
     * @param size:
     * @return: org.springframework.data.domain.Page<com.csii.base.pojo.MyLogger>
     * @Author: zrm
     * @Date: 2019/11/19 15:48
     */
    public Page<MyLogger> testNativeQuery(String field,String terms,int page,int size){
        // 构建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加基本的分词查询
        queryBuilder.withQuery(QueryBuilders.termQuery(field,terms));
        // 设置分页参数
        queryBuilder.withPageable(PageRequest.of(page, size));

        // 执行搜索，获取结果
        return this.elkRepository.search(queryBuilder.build());
    }

    /**
     * @Description: 排序查询
     * @param loglevel:
     * @return: org.springframework.data.domain.Page<com.csii.base.pojo.MyLogger>
     * @Author: zrm
     * @Date: 2019/11/19 16:07
     */
    public Page<MyLogger> testSort(String loglevel){
        // 构建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加基本的分词查询
        queryBuilder.withQuery(QueryBuilders.termQuery("loglevel", loglevel));

        // 排序
        queryBuilder.withSort(SortBuilders.fieldSort("line").order(SortOrder.DESC));

        // 执行搜索，获取结果
        return this.elkRepository.search(queryBuilder.build());
    }

    /**
     * @Description: 聚合为桶
     * @param :
     * @return: java.util.List<org.elasticsearch.search.aggregations.bucket.terms.StringTerms.Bucket>
     * @Author: zrm
     * @Date: 2019/11/19 16:24
     */
    public List<StringTerms.Bucket> testAgg(){
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 不查询任何结果
        queryBuilder.withSourceFilter(new FetchSourceFilter(new String[]{""}, null));
        // 1、添加一个新的聚合，聚合类型为terms，聚合名称为brands，聚合字段为brand
        queryBuilder.addAggregation(
                AggregationBuilders.terms("INFOS").field("loglevel"));
        // 2、查询,需要把结果强转为AggregatedPage类型
        AggregatedPage<MyLogger> aggPage = (AggregatedPage<MyLogger>) this.elkRepository.search(queryBuilder.build());
        // 3、解析
        // 3.1、从结果中取出名为brands的那个聚合，
        // 因为是利用String类型字段来进行的term聚合，所以结果要强转为StringTerm类型
        StringTerms agg = (StringTerms) aggPage.getAggregation("INFOS");
        // 3.2、获取桶
        return agg.getBuckets();
    }

    /**
     * @Description: 聚合为桶嵌套聚合
     * @param :
     * @return: java.util.List<org.elasticsearch.search.aggregations.bucket.terms.StringTerms.Bucket>
     * @Author: zrm
     * @Date: 2019/11/22 9:24
     */
    public List<StringTerms.Bucket> testSubAgg(){
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 不查询任何结果
        queryBuilder.withSourceFilter(new FetchSourceFilter(new String[]{""}, null));
        // 1、添加一个新的聚合，聚合类型为terms，聚合名称为brands，聚合字段为brand
        queryBuilder.addAggregation(
                AggregationBuilders.terms("INFOS").field("loglevel")
                        .subAggregation(AggregationBuilders.avg("LINESAVG").field("line")) // 在品牌聚合桶内进行嵌套聚合，求平均值
        );
        // 2、查询,需要把结果强转为AggregatedPage类型
        AggregatedPage<MyLogger> aggPage = (AggregatedPage<MyLogger>) this.elkRepository.search(queryBuilder.build());
        // 3、解析
        // 3.1、从结果中取出名为brands的那个聚合，
        // 因为是利用String类型字段来进行的term聚合，所以结果要强转为StringTerm类型
        StringTerms agg = (StringTerms) aggPage.getAggregation("INFOS");
        // 3.2、获取桶
        return agg.getBuckets();
    }

}
