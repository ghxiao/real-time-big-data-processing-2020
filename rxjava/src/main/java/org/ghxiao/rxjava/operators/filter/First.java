package org.ghxiao.rxjava.operators.filter;

import io.reactivex.rxjava3.core.Observable;

public class First {
    public static void main(String[] args) {
        Observable.fromArray()
                .first(100)
                .subscribe(
                        System.out::println,
                        err -> System.out.println("ERROR " + err)
                );
    }
}
