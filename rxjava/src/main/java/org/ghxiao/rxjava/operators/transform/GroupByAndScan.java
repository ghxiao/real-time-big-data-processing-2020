package org.ghxiao.rxjava.operators.transform;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.GroupedObservable;

import java.util.concurrent.TimeUnit;

public class GroupByAndScan {
    public static void main(String[] args) throws InterruptedException {
        Observable.interval(1, TimeUnit.SECONDS)
                .groupBy(x -> x % 3)
                .subscribe(
                        ((GroupedObservable<Long, Long> go) ->
                                go.scan((x, y) -> x + y)
                                        .subscribe((Long v) -> System.out.println(
                                                "key: " + go.getKey() + " value: " + v)))
                );

        Thread.sleep(10000);
    }
}
