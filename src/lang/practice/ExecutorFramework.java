package lang.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Stream;

public class ExecutorFramework {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<?>> list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            list.add(executorService.submit(() -> {
                System.out.println(Math.random());
                synchronized (ExecutorFramework.class) {
                    ExecutorFramework.class.notifyAll();
                }

            }));

        }

        for (int i = 0; i < 100; i++) {
            list.add(executorService.submit(() -> {
                synchronized (ExecutorFramework.class) {
                    ExecutorFramework.class.notifyAll();
                }
                return Math.random();
            }));

        }

        list.forEach(f -> {
            while (!f.isDone()) {
                synchronized (ExecutorFramework.class) {
                    try {
                        System.out.println("Waiting -" + f.get());
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                    try {
                        ExecutorFramework.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });


        executorService.shutdown();


    }
}
