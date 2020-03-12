package org.ghxiao.rxjava.intro;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableEmitter;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.time.LocalDateTime;

public class RxAsyncDemo {
    public static void main(String[] args) {
        Flowable
                .create(RxAsyncDemo::emit, BackpressureStrategy.BUFFER)
                .observeOn(Schedulers.computation(), true,2) // <-- async, non-blocking
                .subscribe(
                        d -> process(d),
                        error -> System.out.println("Error " + error),
                        () -> System.out.println("Done")
                );

        sleep(20_000);
    }

    public static long process(long n){
        sleep(2000);
        System.out.println("time " + LocalDateTime.now()
                + " thread: " + Thread.currentThread().getName()
                + " processing " + n);
        return n;
    }

    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void emit(FlowableEmitter<Integer> emitter) {
        int count = 0;
        while (count < 10) {
            count++;
            System.out.println(
                    "time " + LocalDateTime.now() + " thread: "
                            + Thread.currentThread().getName() + " emitting: " + count) ;


            emitter.onNext(count);
            sleep(1000);
        }
        emitter.onComplete();
    }

}
