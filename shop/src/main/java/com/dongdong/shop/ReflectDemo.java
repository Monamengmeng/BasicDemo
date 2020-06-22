package com.dongdong.shop;

import com.dongdong.entity.Employee;

/**
 * 反射
 *
 * 获取Class对象的方式：
 *  1 Class.forName("全类名")  将字节码文件加载进内存，返回Class对象
 *  2 类名.class  通过类名的属性class获取
 *  3 对象.getClass()  getClass()方法在Object类中定义着
 *
 * @author Mona
 * @date 2020/6/11 14:35
 */
public class ReflectDemo {
    public static void main(String[] args) throws Exception {
        /**
         * 结果：
         * class com.dongdong.entity.Employee
         * class com.dongdong.entity.Employee
         * class com.dongdong.entity.Employee
         */
        //1 Class.forName("全类名")
        Class cls1 = Class.forName("com.dongdong.entity.Employee");
        System.out.println(cls1);
        //2 类名.class
        Class cls2 = Employee.class;
        System.out.println(cls2);
        //3 对象.getClass()
        Employee employee = new Employee();
        Class cls3 = employee.getClass();
        System.out.println(cls3);

        //结论：同一个字节码文件（*.class)在一次程序运行过程中，只会被加载一次，不论通过哪一种方式获取的class对象都是同一个。
        System.out.println(cls1 == cls2);//true
        System.out.println(cls1 == cls3);//true

    }
}
