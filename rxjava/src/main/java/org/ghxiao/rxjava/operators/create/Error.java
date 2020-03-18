package org.ghxiao.rxjava.operators.create;

import io.reactivex.rxjava3.core.Observable;

public class Error {
    public static void main(String[] args) {
        Observable.error(new RuntimeException("error!"))
                .subscribe(
                        System.out::println,
                        err -> System.out.println("ERROR " + err),
                        () -> System.out.println("DONE"));
    }
}
