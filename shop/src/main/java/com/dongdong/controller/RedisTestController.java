package com.dongdong.controller;

import com.dongdong.entity.Employee;
import com.dongdong.mapper.BaseMapper;
import com.dongdong.service.impl.RedisTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Mona
 * @date 2020/6/30 14:12
 */
@RestController
@Slf4j
public class RedisTestController {

    @Autowired
    private RedisTestService redisTestService;

    @ResponseBody
    @RequestMapping("/queryAll")
    public List<Employee> queryAll() {
        List<Employee> lists = redisTestService.query();
        return lists;
    }

    @ResponseBody
    @RequestMapping("/findEmploeeById")
    public Map<String,Object> findEmploeeById(@RequestParam int id) {
        Employee userById = redisTestService.findUserById(id);
        Map<String,Object> result = new HashMap<>();
        result.put("id",userById.getId());
        result.put("name",userById.getLast_name());
        result.put("gender",userById.getGender());
        result.put("email",userById.getEmail());
        return result;
    }

    @ResponseBody
    @RequestMapping("/updateEmployee")
    public String updateEmployee() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setLast_name("cat");
        employee.setGender("1");
        employee.setEmail("cat@qq.com");

        int result = redisTestService.updateEmployee(employee);
        if (result != 0) {
            return "update employee success";
        }

        return "fail";
    }

    @ResponseBody
    @RequestMapping("/deleteEmployeeById")
    public String deleteEmployeeById(@RequestParam int id) {
        int result = redisTestService.deleteEmployeeById(id);
        if (result != 0) {
            return "delete success";
        }
        return "delete fail";
    }


}
