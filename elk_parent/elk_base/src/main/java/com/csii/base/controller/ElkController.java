package com.csii.base.controller;

import com.csii.base.pojo.MyLogger;
import com.csii.base.service.ElkService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.elasticsearch.search.aggregations.bucket.terms.StringTerms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@Api("日志服务接口")
@RestController
@CrossOrigin
@RequestMapping("/logger")
public class ElkController {

    @Autowired
    private ElkService elkService;

    //创建索引、配置映射
    @PutMapping
    @ApiOperation(value = "创建索引", notes = "创建索引")
    public Result createIndex() {
        elkService.createIndex();
        return new Result(true, StatusCode.OK, "索引/映射创建成功");
    }

    //删除索引
    @DeleteMapping
    @ApiOperation(value = "删除索引", notes = "删除索引")
    public Result deleteIndex() {
        elkService.deleteIndex();
        return new Result(true, StatusCode.OK, "删除索引成功");
    }

    //新增
    @PostMapping("/alone")
    @ApiOperation(value = "新增一条数据", notes = "新增数据")
    public Result index() {
        elkService.index();
        return new Result(true, StatusCode.OK, "新增数据成功");
    }

    //批量新增1
    @PostMapping("/multi")
    @ApiOperation(value = "批量新增数据1", notes = "批量新增")
    public Result indexList() {
        elkService.indexList();
        return new Result(true, StatusCode.OK, "批量新增数据成功");
    }

    //批量新增2
    @ApiOperation(value = "批量新增数据2", notes = "批量新增")
    @PostMapping("/multiAll")
    public Result indexListAll() {
        elkService.indexListAll();
        return new Result(true, StatusCode.OK, "批量新增所有数据成功");
    }

    //通过ID查询
    @GetMapping("/search/{id}")
    @ApiOperation(value = "通过ID查询", notes = "通过ID查询")
    @ApiImplicitParam(name = "id", required = true, value = "日志的唯一记录_ID")
    public Result testQuery(@PathVariable String id) {
        return new Result(true, StatusCode.OK, "查询成功", elkService.testQuery(id));
    }

    // 查询全部，并按照行号降序排序
    @GetMapping("/search/all")
    @ApiOperation(value = "查询全部，并按照行号降序排序", notes = "查询全部")
    public Result testFind() {
        return new Result(true, StatusCode.OK, "查询成功", elkService.testFind());
    }

    //高级基本查询
    @GetMapping("/search")
    @ApiOperation(value = "高级基本查询", notes = "高级基本查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "field", value = "字段",
                    defaultValue = "loglevel", type = "String"),
            @ApiImplicitParam(name = "terms", value = "词条",
                    defaultValue = "warn", type = "String")
    })
    public Result testFullQuery(
            @RequestParam(defaultValue = "loglevel") String field,
            @RequestParam(defaultValue = "warn") String terms) {
        return new Result(true, StatusCode.OK, "查询成功", elkService.testFullQuery(field, terms));
    }

    //自定义查询
    @GetMapping("/search/{field}/{terms}")
    @ApiIgnore
    public Result testDiyNativeQuery(@PathVariable String field, @PathVariable String terms) {
        Page<MyLogger> pageList = elkService.testDiyNativeQuery(field, terms);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult<MyLogger>(pageList.getTotalElements(), pageList.getContent()));
    }

    //分页查询
    @GetMapping("/search/native/{field}/{terms}")
    @ApiIgnore
    public Result testNativeQuery(@PathVariable String field, @PathVariable String terms, @RequestParam int page, @RequestParam int size) {
        Page<MyLogger> pageList = elkService.testNativeQuery(field, terms, page, size);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult<MyLogger>(pageList.getTotalElements(), pageList.getContent()));
    }

    //排序查询
    @PostMapping("/search/{loglevel}")
    @ApiIgnore
    public Result testSort(@PathVariable String loglevel) {
        Page<MyLogger> pageList = elkService.testSort(loglevel);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult<MyLogger>(pageList.getTotalElements(), pageList.getContent()));
    }

    //聚合为桶
    @GetMapping("/search/aggs")
    @ApiIgnore
    public Result testAgg() {
        List<StringTerms.Bucket> buckets = elkService.testAgg();
        StringTerms.Bucket bucket = buckets.get(0);
        return new Result(true, StatusCode.OK, "查询成功", bucket);
    }

    //嵌套聚合,求平均值
    @GetMapping("/search/avg}")
    public Result testSubAgg() {
        List<StringTerms.Bucket> buckets = elkService.testSubAgg();
        return new Result(true, StatusCode.OK, "查询成功", buckets);
    }


}
