package org.ghxiao.rxjava.operators.filter;

import io.reactivex.rxjava3.core.Observable;

public class Distinct {
    public static void main(String[] args) {
        Observable.fromArray(1, 4, 2, 3, 4, 3, 2, 1)
                .distinct()
                .subscribe(
                        System.out::println,
                        err -> System.out.println("ERROR " + err),
                        () -> System.out.println("DONE"));
    }
}
