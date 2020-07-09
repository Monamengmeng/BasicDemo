package com.dongdong.shop.threadtest;

/**
 * @author Mona
 * @date 2020/7/2 10:57
 */
public class PersonB extends Thread {
    Bank bank;
    String mode;

    public PersonB(Bank bank, String mode) {
        this.mode = mode;
        this.bank = bank;
    }

    @Override
    public void run() {
        while (Bank.money >= 200) {
            try {
                bank.outMoney(200, mode);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
