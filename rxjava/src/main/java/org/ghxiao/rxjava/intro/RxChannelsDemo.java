package org.ghxiao.rxjava.intro;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableEmitter;

import javax.management.BadAttributeValueExpException;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class RxChannelsDemo {
    public static void main(String[] args) {
        Flowable
                .create(RxChannelsDemo::emit, BackpressureStrategy.BUFFER)
                //.interval(1, 1, TimeUnit.SECONDS)
                .subscribe(
                        d -> System.out.println(d),
                        error -> System.out.println("Error " + error),
                        () -> System.out.println("Done")
                );

        sleep(10_000);
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
                            + Thread.currentThread().getName() + " value: " + count) ;

            if(count == 5){
            //    throw new RuntimeException("Boom!");
                emitter.onError(new RuntimeException("Boom!"));
            }

            emitter.onNext(count);
            sleep(500);
        }
        emitter.onComplete();
    }

}
