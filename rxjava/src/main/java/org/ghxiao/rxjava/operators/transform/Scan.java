package org.ghxiao.rxjava.operators.transform;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class Scan {
    public static void main(String[] args) throws InterruptedException {
        Observable.interval(1, TimeUnit.SECONDS)
                .scan((x,y) -> x + y)
                .subscribe(
                        System.out::println,
                        err -> System.out.println("ERROR " + err),
                        () -> System.out.println("DONE"));
        Thread.sleep(5000);
    }
}
