package com.dongdong.exception;

/**
 * @author Mona
 * @date 2020/6/10 9:12
 */
public enum EnumTest {

    MONDAY("Monday",1),
    TUESDAY("Tuesday",2),
    WEDNSDAY("Wednsday",3);

    EnumTest(String week,int number) {
        this.week = week;
        this.numer = number;
    }

    private String week;
    private int numer;

    public String getWeek() {
        return week;
    }

    public int getNum() {
        return numer;
    }
}
