package org.ghxiao.rxjava.operators.create;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class Never {
    public static void main(String[] args) {
        Observable.<Integer>never().subscribe(
                new Observer<Integer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        System.out.println("subscribed to " + d );
                    }

                    @Override
                    public void onNext(@NonNull Integer integer) {
                        System.out.println("next " + integer);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        System.out.println("Error " + e);
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Done ");
                    }
                }
        );
    }
}
