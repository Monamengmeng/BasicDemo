package com.dongdong.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 *
 //@AllArgsConstructor  包含所有参数的构造函数---lombok

 //@NoArgsConstructor   无参构造方法----lombok
 *
 *
 * @author Mona
 * @date 2020/4/30 18:43
 */
@Data
@Builder    //创建构造器
@AllArgsConstructor
public class Employee implements Serializable {//redis保存对象的时候要求对象是序列化的
    private int id;
    private String last_name;
    private String gender;
    private String email;

    public Employee() { //可以将它私有化，外界不可以改变

    }

    //被@AllArgsConstructor注解代替
//    public Employee(int id, String last_name, String gender, String email) {
//        this.id = id;
//        this.last_name = last_name;
//        this.gender = gender;
//        this.email = email;
//    }

    /**
     * toString方法：方法返回一个字符串，是该Java对象的内存地址经过哈希算法得出的int类型的值在转换成十六进制
     *
     * @return
     */
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", last_name='" + last_name + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
