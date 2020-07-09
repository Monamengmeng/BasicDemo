package com.dongdong.shop.threadtest;

/**
 * 两个人AB通过一个账户A在柜台取钱和B在ATM机取钱
 *
 * 运行结果：
 * ATM取钱200.0元，还剩800.0元！
 * 柜台取钱100.0元，还剩700.0元！
 * 柜台取钱100.0元，还剩600.0元！
 * ATM取钱200.0元，还剩400.0元！
 * ATM取钱200.0元，还剩200.0元！
 * 柜台取钱100.0元，还剩100.0元！
 * 柜台取钱100.0元，还剩0.0元！
 *
 * @author Mona
 * @date 2020/7/2 11:34
 */
public class BankMain {
    public static void main(String[] args) {

        Bank bank = new Bank();
        // 实例化两个人，传入同一个银行的对象
        PersonA a = new PersonA(bank,"counter");
        PersonB b = new PersonB(bank,"ATM");
        a.start();
        b.start();
    }
}
