package lang.practice;

import java.util.Random;

public class ThreadPractice {


    public void printA() throws InterruptedException {
        synchronized (ThreadPractice.class) {

            System.out.println(Thread.currentThread().getName() + " - a");
            Thread.sleep(1000);


        }

    }

    public void printB() throws InterruptedException {
        synchronized (this) {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " - b");
                Thread.sleep(1000);
            }

        }
    }

    public static void main(String[] args) {
        ThreadPractice threadPractice = new ThreadPractice();
        Random random = new Random();

        Runnable runnable = () -> {
            try {
                if (random.nextInt() % 2 == 0) {
                    while (true) {
                        threadPractice.printA();
                    }
                } else {
                    while (true) {
                        threadPractice.printB();
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread A = new Thread(runnable, "A");
        Thread B = new Thread(runnable, "B");
        A.start();
        B.start();


    }


}
