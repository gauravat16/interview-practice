package leetcode.concurrancy;

import java.util.ConcurrentModificationException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

class FizzBuzz {
    private int n;
    private final Object lock;
    private int curr = 1;
    private final AtomicInteger counter;

    public FizzBuzz(int n) {
        this.n = n;
        this.counter = new AtomicInteger(1);
        this.lock = new Object();
    }

    private void updateToNext(int count) {
        if (!counter.compareAndSet(count, count + 1))
            throw new ConcurrentModificationException();
    }


    public void fizz(Runnable printFizz) throws InterruptedException {
        int count;

        while ((count = counter.get()) <= n) {
            if (count % 3 == 0 && count % 5 != 0) {
                printFizz.run();
                updateToNext(count);
            }
        }

    }

    public void buzz(Runnable printBuzz) throws InterruptedException {
        int count;
        while ((count = counter.get()) <= n) {
            if (count % 5 == 0 && count % 3 != 0) {
                printBuzz.run();
                updateToNext(count);
            }

        }
    }

    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        int count;
        while ((count = counter.get()) <= n) {
            if (count % 3 == 0 && count % 5 == 0) {
                printFizzBuzz.run();
                updateToNext(count);
            }
        }
    }

    public void number(IntConsumer printNumber) throws InterruptedException {
        int count;
        while ((count = counter.get()) <= n) {
            if (count % 3 != 0 && count % 5 != 0) {
                printNumber.accept(count);
                updateToNext(count);
            }
        }
    }

//    // printFizz.run() outputs "fizz".
//    public void fizz(Runnable printFizz) throws InterruptedException {
//        while (curr <= n) {
//            synchronized (lock) {
//                if (curr % 3 == 0 && curr % 5 != 0) {
//                    printFizz.run();
//                    curr++;
//                    lock.notifyAll();
//                } else {
//                    lock.wait();
//                }
//
//            }
//
//        }
//    }
//
//    // printBuzz.run() outputs "buzz".
//    public void buzz(Runnable printBuzz) throws InterruptedException {
//        while (curr <= n) {
//            synchronized (lock) {
//                if (curr % 5 == 0 && curr % 3 != 0) {
//                    printBuzz.run();
//                    curr++;
//                    lock.notifyAll();
//                } else {
//                    lock.wait();
//                }
//            }
//        }
//    }
//
//    // printFizzBuzz.run() outputs "fizzbuzz".
//    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
//        while (curr <= n) {
//            synchronized (lock) {
//                if (curr % 15 == 0) {
//                    printFizzBuzz.run();
//                    curr++;
//                    lock.notifyAll();
//                } else {
//                    lock.wait();
//                }
//            }
//        }
//    }
//
//    // printNumber.accept(x) outputs "x", where x is an integer.
//    public void number(IntConsumer printNumber) throws InterruptedException {
//
//        while (curr <= n) {
//            synchronized (lock) {
//                if (curr % 3 == 0 || curr % 5 == 0) {
//                    lock.wait();
//                } else {
//                    printNumber.accept(curr++);
//                    lock.notifyAll();
//                }
//            }
//        }
//    }

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(15);

        Runnable buzz = () -> {
            try {
                fizzBuzz.buzz(() -> System.out.println("buzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable fizz = () -> {
            try {
                fizzBuzz.fizz(() -> System.out.println("fizz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable fizzBuzzRun = () -> {
            try {
                fizzBuzz.fizzbuzz(() -> System.out.println("fizzbuzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable integer = () -> {
            try {
                fizzBuzz.number(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread t1 = new Thread(fizz);
        Thread t2 = new Thread(buzz);
        Thread t3 = new Thread(fizzBuzzRun);
        Thread t4 = new Thread(integer);

        t1.start();
        t2.start();
        t3.start();
        t4.start();


    }
}