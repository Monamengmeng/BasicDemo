package com.dongdong.shop.threadtest;

import java.util.Objects;

/**
 * 两个人AB通过一个账户 A在柜台取钱和 B在ATM机取钱！
 * 程序分析：
 *         钱的数量要设置成一个静态的变量，两个人要取的同一个对象值。
 *
 * @author Mona
 * @date 2020/7/2 10:45
 */
public class Bank {
    //账户中的资金：设置为1000 (static类型；全局访问
    static double money = 1000;

    //柜台counter取钱方法
    private void counter(double money) {
        Bank.money -= money;
        System.out.println("柜台取钱" + money + "元，还剩" + Bank.money + "元！");
    }

    //从ATM取钱的方法
    private void ATM(double money) {
        Bank.money -= money;
        System.out.println("ATM取钱" + money + "元，还剩" + Bank.money + "元！");
    }

    // 提供一个对外取款途径，防止直接调取方法同时取款时，并发余额显示错误
    public synchronized void outMoney(double money, String mode) throws Exception{
        if (money > Bank.money) {
            throw new Exception("取款金额" + money + "，余额只剩" + Bank.money + ",取款失败");
        }
        if (Objects.equals(mode, "ATM")) {
            ATM(money);
        } else {
            counter(money);
        }

    }

}
