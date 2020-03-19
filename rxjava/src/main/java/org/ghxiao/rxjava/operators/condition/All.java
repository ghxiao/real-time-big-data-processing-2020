package org.ghxiao.rxjava.operators.condition;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

import java.util.concurrent.TimeUnit;

public class All {
    public static void main(String[] args) throws InterruptedException {
        final Single<Boolean> contains = Observable
                .interval(1, TimeUnit.SECONDS)
                //.take(5)
                .all(x -> x >= 0);

        contains.subscribe((b, throwable) -> {
            System.out.println(b);
        });
        Thread.sleep(10000);
    }
}
