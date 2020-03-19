package org.ghxiao.rxjava.operators.aggregate;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class SumByCollect {
    public static void main(String[] args) throws InterruptedException {
        final var s1 = Observable.interval(1, 1, TimeUnit.SECONDS).take(5);
        s1.collect(() -> new AtomicLong(0),
                AtomicLong::addAndGet)
                .subscribe(System.out::println);
        Thread.sleep(10000);
    }
}
