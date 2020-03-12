package org.ghxiao.rxjava.intro;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Flowable;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class RxTreeCast {
    public static void main(String[] args) {
        final Flowable<Long> feed = Flowable.interval(1, 1, TimeUnit.SECONDS);

        feed.subscribe(x -> System.out.println("main stream: " + x));

        Flowable<Long> even = feed.filter(x -> x % 2 == 0);

        even.subscribe(x -> System.out.println("even stream: " + x));

        Flowable<Long> odd = feed.filter(x -> x % 2 == 1);

        odd.subscribe(x -> System.out.println("odd stream: " + x));

        sleep(10_000);
    }

    public static void process(String m){
        //sleep(2000);
        System.out.println("time " + LocalDateTime.now()
                + " thread: " + Thread.currentThread().getName()
                + " processing " + m);
    }

    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
