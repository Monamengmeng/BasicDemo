package com.dongdong.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author Mona
 * @date 2020/6/8 19:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Article {
    @JsonIgnore
    private Long id;

    @JsonProperty("a")//取别名
    private String author;
    private String title;

    @JsonInclude(JsonInclude.Include.NON_NULL)//不为空的时候反序列化==对比postman的返回值
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")  //在application中做了替换
    private Date createTime;
    private List<Reader> reader; //有嵌套
}
