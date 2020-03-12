package org.ghxiao.rxjava.intro;

import io.reactivex.rxjava3.core.Flowable;

import java.util.concurrent.TimeUnit;

public class RxBasicDemo {
    public static void main(String[] args) {
        Flowable.interval(1,1, TimeUnit.SECONDS)
                .subscribe(
                        d -> System.out.println(d),
                        error -> System.out.println("Error " + error),
                        () -> System.out.println("Done")
                );

        sleep(10_000);
    }

    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
