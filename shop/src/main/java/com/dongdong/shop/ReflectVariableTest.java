package com.dongdong.shop;

import com.dongdong.entity.ReflectEntity;

import java.lang.reflect.Field;

/**
 * @author Mona
 * @date 2020/6/11 15:02
 */
public class ReflectVariableTest {
    public static void main(String[] args) throws Exception {
        /**
         * 1、获取成员变量们
         * Field[]  getFields()
         * Field  getField(String name)
         *
         * Field[] getDeclaredFields()
         * Field  getDeclaredField(String name)
         */
        //0 获取ReflectEntity对象
        Class entity = ReflectEntity.class;
        //1 获取成员变量们   ---- Field[] getFields()获取所有public修饰的成员变量
        Field[] fields = entity.getFields();
        for(Field field : fields) {
            System.out.println(field);//变量为private时没有打印任何内容
        }

        System.out.println("---------------------");
//        //   Field  getField(String name)
        Field b = entity.getField("b");
//
//        //获取成员变量
        ReflectEntity reflectEntity = new ReflectEntity();
//
//        Object value = a.get(reflectEntity);
//        System.out.println(value);

        //给成员变量设置值
        b.set(reflectEntity,"mona");
        System.out.println(reflectEntity);
        System.out.println("================");

        //Field[] getDeclaredFields()  ----获取所有的成员变量，不考虑修饰符
        Field[] declaredFields = entity.getDeclaredFields();
        for(Field declaredField:declaredFields) {
            System.out.println(declaredField);
        }

        Field d = entity.getDeclaredField("d");
        d.setAccessible(true);//暴力反射
        Object o = d.get(reflectEntity);//获取私有方法原本会提示报错，使用上面的暴力反射，则可以忽略
        System.out.println(o);

    }

}
