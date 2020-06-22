package com.dongdong.controller;

import com.dongdong.entity.Employee;
import com.dongdong.entity.Result;
import com.dongdong.exception.ExceptionType;
import com.dongdong.service.impl.TestService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

/**
 * @author Mona
 * @date 2020/4/30 17:39
 */
@Slf4j
@RestController
public class TestMapperController {

//    public static final String  USER_DDD = new String("df");//类比枚举类

    @Autowired
    public TestService testService;

//    @RequestMapping(value = "/query",method = RequestMethod.GET)
//    public void queryInfo() {
//        testService.test();
//    }

    //查询所有
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public List<Employee> queryInfo() {
//        ExceptionType e = new ExceptionType(1,"djjd");

        return testService.query();
    }

    //查询一条
    @RequestMapping("/queryById")
    public Employee queryById(int id) {
        return testService.queryById(id);
    }

    @RequestMapping("/add")
    public String addUser() {       //@RequestBody Employee employee
        if (testService.addUser() > 0) {
            log.info("success！");
            return "插入成功";
        }else {
            log.error("fail!",testService.addUser());
            return "插入失败";
        }
//        try {
//            testService.addUser(employee);
//            return new Result(true,"插入成功");
//        }catch (Exception e){
//            return new Result(false,"插入失败");
//        }
    }

    @RequestMapping("/update")
    public String update() {
        if (testService.update() > 0) {
            return "插入成功";
        }else {
            return "插入失败";
        }
    }

    @RequestMapping("/delete")
    public void delete(int id) {
        testService.delete(id);
    }



}
