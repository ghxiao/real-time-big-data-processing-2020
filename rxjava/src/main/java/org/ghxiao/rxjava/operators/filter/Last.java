package org.ghxiao.rxjava.operators.filter;

import io.reactivex.rxjava3.core.Observable;

public class Last {
    public static void main(String[] args) {
        Observable.fromArray()
                .last(100)
                .subscribe(
                        System.out::println,
                        err -> System.out.println("ERROR " + err)
                );
    }
}
