package org.ghxiao.rxjava.operators.aggregate;

import io.reactivex.rxjava3.core.Observable;

public class Average {
    public static void main(String[] args) {
        Observable.range(1, 8)
                .reduce(new Aggregator(0L, 0L),
                        (a, i) -> new Aggregator(a.sum + i, a.count + 1))
                .map(a -> a.sum / a.count)
                .subscribe(System.out::println);
    }

    public static class Aggregator {
        final long sum;
        final long count;

        public Aggregator(long sum, long count) {
            this.sum = sum;
            this.count = count;
        }
    }
}
