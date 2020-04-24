package org.ghxiao.flink.basic;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class Map {
    public static void main(String[] args) throws Exception {
        final StreamExecutionEnvironment env =
                StreamExecutionEnvironment.getExecutionEnvironment();
        // configure event time
        env.setStreamTimeCharacteristic(TimeCharacteristic.ProcessingTime);

        DataStream<Integer> integers = env.fromElements(1, 2, 3, 4);
// Regular Map - Takes one element and produces one element
        DataStream<Integer> doubleIntegers =
                integers.map(new MapFunction<Integer, Integer>() {
                    @Override
                    public Integer map(Integer value) {
                        return value * 2;
                    }
                });
        doubleIntegers.print();
        env.execute("Map Example");
    }
}
