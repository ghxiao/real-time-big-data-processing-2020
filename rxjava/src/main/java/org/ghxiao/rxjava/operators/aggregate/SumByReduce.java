package org.ghxiao.rxjava.operators.aggregate;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class SumByReduce {
    public static void main(String[] args) throws InterruptedException {
        final var s1 = Observable
                .interval(1, 1, TimeUnit.SECONDS).take(5);
        s1.reduce(0L, (x,y) -> x + y)
                .subscribe(System.out::println);
        Thread.sleep(10000);
    }
}
