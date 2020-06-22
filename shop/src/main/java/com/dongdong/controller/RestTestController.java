package com.dongdong.controller;

import com.dongdong.entity.Article;
import com.dongdong.entity.Employee;
import com.dongdong.exception.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author Mona
 * @date 2020/6/8 18:36
 */
@Slf4j
@RestController
public class RestTestController {

    //由@Slf4j注解替换
//    private static final Logger log = (Logger) LoggerFactory.getLogger(TestMapperController.class);

    /**
     * lombok注解的测试
     *
     * @return
     */
    @RequestMapping("/lombok")
    public Employee testLombok() {

        Employee employee = new Employee(19,"dd","ddd","ioo");//测试@AllArgsConstructor注解
        employee.setEmail("dddddddd");//测试@Data注解
        Employee build = Employee.builder().email("aaa@qq.com").gender("1").id(1).build();

        log.info("测试一下" + build);

        return build;
    }

    /**
     * GET   PUT  POST   DELETE同等类比下面的POST方法
     *
     */
    //@RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json")等价于
    @PostMapping("/save")
    public AjaxResponse saveInfo(@RequestBody Article article) {
        log.info("saveInfo:{}",article);
        return AjaxResponse.success(article);
    }


    /**
     * put方式
     *
     * @PathVariable  用路径方式传id
     *
     * @param id
     * @param article
     * @return
     */
    @PutMapping("/article/{id}")
    public AjaxResponse updateArticle(@PathVariable Long id, @RequestBody Article article) {
        article.setId(id);
        log.info("updateArticle:{}",article);
        return AjaxResponse.success(article);
    }

    /**
     * 删除----@DeleteMapping
     *
     * @param id
     * @return
     */
    @DeleteMapping("/article/{id}")
    public AjaxResponse deleteArticle(@PathVariable Long id) {
        log.info("deleteArticle:{}",id);
        return AjaxResponse.success(id);
    }


}
