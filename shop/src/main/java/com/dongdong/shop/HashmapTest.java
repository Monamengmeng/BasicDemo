package com.dongdong.shop;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mona
 * @date 2020/6/12 18:29
 */
public class HashmapTest {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("mona","你好呀");
        map.put("tony","在这里");
        map.put("body","等我啊");
        map.put("ketty","回来吧");
        System.out.println(map.get("mona"));

    }
}
