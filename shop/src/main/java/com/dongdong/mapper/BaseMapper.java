package com.dongdong.mapper;

import com.dongdong.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface BaseMapper {

//    String selectTest(String param);

    //查询所有
    List<Employee> query();

    Employee queriById(int id);

    //增加一个用户（注意传进去的是什么）
    int addUser(Employee employee);

    //更新
    int update(Employee employee);

    //删除
    int deleteById(int id);

}
