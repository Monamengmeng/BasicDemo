package com.dongdong.shop;

import com.dongdong.entity.ReflectEntity;

import java.lang.reflect.Method;

/**
 * @author Mona
 * @date 2020/6/11 16:53
 */
public class ReflectMethodTest {
    public static void main(String[] args) throws Exception{
        /**
         * 3 获取成员方法们
         *      Method<?>[] getMethods()
         *      Methdd<T> getMethod()（String name,类<?>...parameterTypes）
         *
         *      Method<?>[] getDeclaredMethods()
         *      Method<T> getDeclaredMethod()（String name,类<?>...parameterTypes）
         *
         */
        //0 获取ReflectEntity对象
        Class reflectEntityClass = ReflectEntity.class;

        //获取指定名称的方法
        Method eatMethod1 = reflectEntityClass.getMethod("eat");//没有参数，直接传方法名(Stinrg 类型)
        ReflectEntity reflectEntity = new ReflectEntity();
        eatMethod1.invoke(reflectEntity);

        //有参方法
        Method eatMethod2 = reflectEntityClass.getMethod("eat", String.class);//类名，参数
        eatMethod2.invoke(reflectEntity,"鱼香肉丝");//对象  传参

        System.out.println("==================");
        //获取所有public修饰的方法（包含隐藏的方法）
        Method[] methods = reflectEntityClass.getMethods();
        for(Method method:methods) {
            System.out.println(method);
            System.out.println(method.getName());//获取方法名
        }

        //获取类名
        String name = reflectEntityClass.getName();
        System.out.println(name);//结果：com.dongdong.entity.ReflectEntity

    }
}
