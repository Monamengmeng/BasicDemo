package com.dongdong.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Mona
 * @date 2020/6/11 15:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReflectEntity {

    private String name;
    private int a;

    public ReflectEntity(String name, int a) {
        this.name = name;
        this.a = a;
    }

    public String b;
    protected String c;
    String d;

    //成员方法
    public void eat() {
        System.out.println("eat...");
    }

    public void eat(String food) {
        System.out.println("eat..." + food);
    }
}
