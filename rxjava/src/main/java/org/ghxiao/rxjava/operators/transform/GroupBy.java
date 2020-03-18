package org.ghxiao.rxjava.operators.transform;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.GroupedObservable;

import java.util.concurrent.TimeUnit;

public class GroupBy {
    public static void main(String[] args) throws InterruptedException {
        Observable.interval(1, TimeUnit.SECONDS)
                .groupBy(i -> i % 3)
                .subscribe(
                        (GroupedObservable<Long, Long> go) -> {
                            go.subscribe((Long v) ->
                                    System.out.println("key: " + go.getKey()
                                            + " value: " + v));
                        },
                        err -> System.out.println("ERROR " + err),
                        () -> System.out.println("DONE"));
        Thread.sleep(10000);
    }
}
