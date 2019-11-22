package com.csii.base.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "mylogger",type = "docs", shards = 1, replicas = 0)
public class MyLogger {

    @Id
    @JsonIgnore
    private String _id;

    @Field(type = FieldType.Keyword)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;

    @Field(type = FieldType.Keyword)
    private String loglevel;

    @Field(type = FieldType.Text)
    private String namespace;

    @Field(type = FieldType.Keyword)
    private String method;

    @Field(index = false, type = FieldType.Keyword)
    private Integer line;

    @Field(type = FieldType.Text)
    private String msg;

    public MyLogger(Date time, String loglevel, String namespace, String method, Integer line, String msg) {
        this.time = time;
        this.loglevel = loglevel;
        this.namespace = namespace;
        this.method = method;
        this.line = line;
        this.msg = msg;
    }
}
