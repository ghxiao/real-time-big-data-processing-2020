package org.ghxiao.rxjava.intro;

import io.reactivex.rxjava3.core.Flowable;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaMultiCast {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2);

        stream.collect(Collectors.toList());

        stream.collect(Collectors.toList());
    }

}
