package org.example;
import java.util.Random;

public class ThreadOne extends Thread {
    private Account account;


    public ThreadOne(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        Random rn = new Random();
        int method = rn.nextInt(2) + 1;
        if (method == 1) {

            try {
                this.account.topUpCardBalance();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(this.getName());


        } else if (method == 2) {
            try {

                this.account.withdrawBalance();
                System.out.println(this.getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }
}

