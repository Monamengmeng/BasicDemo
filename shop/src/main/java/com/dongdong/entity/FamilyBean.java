package com.dongdong.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Mona
 * @date 2020/6/15 20:01
 */
@Data
@Component
@ConfigurationProperties(prefix = "family")
public class FamilyBean {
    private String familyName;

    //添加一些返回值类型为自己创建的，比如“Mother”


}
