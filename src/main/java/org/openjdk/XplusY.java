package org.openjdk;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(value = 1, jvmArgsAppend = "-XX:CompileCommand=blackhole,org/openjdk/jmh/infra/Blackhole.consume")
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
public class XplusY {

    int x, y;

    @Benchmark
    public void test(Blackhole bh) {
        bh.consume(x + y);
        bh.consume(x + y);
    }

}
