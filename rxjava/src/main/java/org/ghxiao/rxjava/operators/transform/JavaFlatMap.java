package org.ghxiao.rxjava.operators.transform;

import io.reactivex.rxjava3.core.Observable;
import org.w3c.dom.ls.LSOutput;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class JavaFlatMap {
    public static void main(String[] args) throws InterruptedException {

        Optional<String> message = getMessage();

        Optional<String> optionalS = message
                .flatMap(
                        //x -> Optional.of(x + "!")
                        x -> Optional.empty()
                ).flatMap(
                        x -> Optional.of("> " + x)
                );

        optionalS.ifPresent(
                x -> System.out.println(x)
        );

//        String y;
//        if (message.isPresent()){
//            y = message.get() + "!";
//            //System.out.println(message.get());
//        } else {
//            // do nothing!
//        }

    }

    public static Optional<String> getMessage() {
        //Optional<String> s = Optional.of("Great!");
        Optional<String> s = Optional.empty();
        return s;
    }
}
