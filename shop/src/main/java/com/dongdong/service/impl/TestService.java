package com.dongdong.service.impl;

import com.dongdong.entity.Employee;
import com.dongdong.exception.CustomException;
import com.dongdong.exception.ExceptionType;
import com.dongdong.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * TestInterface是另外一个模块的
 */
@Service("testInterface")
//public class TestService implements TestInterface {
public class TestService {
//    @Override
//    public String test(String param) {
//
//        return param;
//    }

    @Autowired
    private BaseMapper baseMapper;

//    @PostConstruct
//    public void test() {
//        String str = baseMapper.selectTest("1");
//        System.out.println(str);
//    }

    //查询所有
    public List<Employee> query() {
        return baseMapper.query();
    }

    //查询一条信息
    public Employee queryById(int id) {
        return baseMapper.queriById(id);
    }


    /**
     * //提交事务----增上改查需要提交事务
     *
     * //插入===实体类中有构造器
     */
    @Transactional(rollbackFor = Exception.class)   //事务注解
    public int addUser() {
        int addUser = baseMapper.addUser(new Employee(16, "wei", "1", "wei@qq.com"));

       //增加一个测试，捕获一个异常并抛出====测试事务是否生效
        try {
            int a = 10;
            int b = a/0;
        }catch (Exception e) {
            throw new CustomException(ExceptionType.SYSTEM_ERROR);  //抛异常才会影响到事务--否则没有影响
        }

        //try-catch-----------逻辑

//        try{
//            //controller
//            {
//                //service
//                {
//                    try{
//                        //jdk{}
//                        try{
//                            1/0
//                        }catch (ArithmeticException ex){
//                            throw  ex;
//                        }
//
//                    }catch (Exception ex){
//                        throw CustomException
//                    }
//                }
//            }
//        }catch (CustomException e){
//
//        }catch (ArithmeticException e){
//
//        }catch (Exception e){
//
//        }

//        return baseMapper.addUser(employee);
        return addUser;
    }

    //更新数据
    public int update() {
        int updateMessage = baseMapper.update(new Employee(15, "zeng", "1", "zeng@qq.com"));
        return updateMessage;
    }

    //删除数据
    public int delete(int id) {
        return baseMapper.deleteById(id);
    }



}
