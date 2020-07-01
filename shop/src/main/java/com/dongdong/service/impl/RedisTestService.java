package com.dongdong.service.impl;

import com.dongdong.entity.Employee;
import com.dongdong.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Mona
 * @date 2020/6/30 12:13
 */
@Service
public class RedisTestService {
    @Autowired
    private BaseMapper baseMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    //查询所有
    public List<Employee> query() {
        return baseMapper.query();
    }

    /**
     * 获取用户策略：先从缓存中获取用户，没有则取数据表中 数据，再将数据写入缓存
     */
    public Employee findUserById(int id) {
        String key = "employee_" + id;

        ValueOperations<String, Employee> operations = redisTemplate.opsForValue();
                            //判断是否有key所对应的值
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            long start = System.currentTimeMillis();//为了计算性能
            Employee employee = operations.get(key);
            System.out.println("==========从缓存中获得数据=========");
            System.out.println(employee.getLast_name());
            System.out.println("==============================");

            long end = System.currentTimeMillis();
            System.out.println("查询redis花费的时间是:" + (end - start)+"s");
            return employee;
        } else {
            long start = System.currentTimeMillis();
            Employee employee = baseMapper.queriById(id);
            System.out.println("==========从数据表中获得数据=========");
            System.out.println(employee.getLast_name());
            System.out.println("==============================");

            // 写入缓存
            operations.set(key, employee, 5, TimeUnit.HOURS);
            long end = System.currentTimeMillis();
            System.out.println("查询mysql花费的时间是:" + (end - start)+"s");
            return employee;
        }
    }

    /**
     * 更新用户策略：先更新数据表，成功之后，删除原来的缓存，再更新缓存
     */
    public int updateEmployee(Employee employee) {
        ValueOperations<String, Employee> operations = redisTemplate.opsForValue();
        int result = baseMapper.update(employee);
        if (result != 0) {
            String key = "employee_" + employee.getId();
            boolean haskey = redisTemplate.hasKey(key);
            if (haskey) {
                redisTemplate.delete(key);
                System.out.println("删除缓存中的key=========>" + key);
            }
            // 再将更新后的数据加入缓存
            Employee emplooeeNew = baseMapper.queriById(employee.getId());
            if (emplooeeNew != null) {
                operations.set(key, emplooeeNew, 3, TimeUnit.HOURS);
            }
        }
        return result;
    }

    /**
     * 删除用户策略：删除数据表中数据，然后删除缓存
     */
    public int deleteEmployeeById(int id) {
        int result = baseMapper.deleteById(id);
        String key = "employee_" + id;
        if (result != 0) {
            boolean hasKey = redisTemplate.hasKey(key);
            if (hasKey) {
                redisTemplate.delete(key);
                System.out.println("删除了缓存中的key:" + key);
            }
        }
        return result;
    }

}
