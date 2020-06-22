package com.dongdong.shop;

import com.dongdong.entity.ReflectEntity;

import java.lang.reflect.Constructor;

/**
 *
 *
 * @author Mona
 * @date 2020/6/11 16:29
 */
public class ReflectConstructorTest {
    public static void main(String[] args) throws Exception{
        /**
         * 2 获取构造方法们
         *      Constructor<?>[] getConstructors()
         *      Constructor<T> getConstructor()（类<?>...parameterTypes）
         *
         *      Constructor<T> getDeclaredConstructor()（类<?>...parameterTypes）
         *      Constructor<?>[] getDeclaredConstructors()
         */
        //0 获取ReflectEntity对象
        Class reflectEntityClass = ReflectEntity.class;
        //获取构造器
        Constructor constructor = reflectEntityClass.getConstructor(String.class, int.class);
        System.out.println(constructor);
        //创建对象
        Object ins = constructor.newInstance("校花", 22);
        System.out.println(ins);
        System.out.println("=================");

        //无参构造----可以直接使用newInstance。不需要向上面那么麻烦(也可以像上面方法一样写)
        Object newInstance = reflectEntityClass.newInstance();
        System.out.println(newInstance);

    }
}
