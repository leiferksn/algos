package me.leiferksn.fibo;

import java.math.BigInteger;

public class SlowFibo implements Fibo {

    @Override
    public BigInteger fibo(final long nth) {
        if (nth == 0) {
            return BigInteger.ZERO;
        }

        if (nth > 0 && nth <= 2) {
            return new BigInteger("1");
        }

        return fibo(nth - 1).add(fibo(nth - 2));
    }
}
