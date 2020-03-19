package org.ghxiao.rxjava.operators.combine;

import io.reactivex.rxjava3.core.Observable;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Zip {
    public static void main(String[] args) throws InterruptedException {
        final Observable<Long> units = Observable.interval(1, TimeUnit.SECONDS);
        final Observable<Long> o1 = units.filter(x -> x % 2 == 0);
        final Observable<Long> o2 = units.filter(x -> x % 3 == 0);
        final Observable<List<Long>> zipped = o1.zipWith(o2, List::of);
        o1.subscribe(x -> System.out.println("S1: " + x));
        o2.subscribe(x -> System.out.println("S2: " + x));
        zipped.subscribe(x -> System.out.println("JD: " + x));
        Thread.sleep(20000);

    }
}
