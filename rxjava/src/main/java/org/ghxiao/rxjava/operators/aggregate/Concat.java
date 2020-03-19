package org.ghxiao.rxjava.operators.aggregate;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class Concat {
    public static void main(String[] args) throws InterruptedException {
        final Observable<String> s1 = Observable
                .interval(1,1, TimeUnit.SECONDS)
                .take(5)
                .map(x -> "a" + x);
        s1.subscribe(x -> System.out.println("s1 " + x));
        final Observable<String> s2 = Observable
                .interval(0,1, TimeUnit.SECONDS)
                .map(x -> "b" + x);
        s2.subscribe(x -> System.out.println("s2 " + x));
        Observable.concat(s1, s2).subscribe(x -> System.out.println("concat " + x));
        Thread.sleep(10000);
    }
}
