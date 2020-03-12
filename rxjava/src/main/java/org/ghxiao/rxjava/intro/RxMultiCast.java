package org.ghxiao.rxjava.intro;

import io.reactivex.rxjava3.core.Flowable;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class RxMultiCast {
    public static void main(String[] args) {
        final Flowable<Long> feed = Flowable.interval(1, 1, TimeUnit.SECONDS).share();;
        feed.subscribe(data -> process("S1: " + data));
        sleep(5000);
        feed.subscribe(data -> process("S2: " + data));
        sleep(10000);
    }

    public static void process(String m){
        //sleep(2000);
        System.out.println("time " + LocalDateTime.now()
                + " thread: " + Thread.currentThread().getName()
                + " processing " + m);
    }

    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
