package me.leiferksn.fibo;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class FastFibo implements Fibo {

    private static final Memoizer MEMOIZER = new Memoizer();

    @Override
    public BigInteger fibo(final long nth) {
        if (nth == 0) {
            return BigInteger.ZERO;
        }

        if (nth > 0 && nth <= 2) {
            return new BigInteger("1");
        }

        if (MEMOIZER.fiboResult(nth) != null) {
            return MEMOIZER.fiboResult(nth);
        }

        final var fiboNth = fibo(nth - 1).add(fibo(nth - 2));
        MEMOIZER.storeNewFiboResult(nth, fiboNth);
        return MEMOIZER.fiboResult(nth);
    }

    private static class Memoizer {

        private final List<FiboResult> fiboResults = new ArrayList<>();

        public BigInteger fiboResult(final long nth) {
            for (final var fiboResult : fiboResults) {
                if (fiboResult.getNth() == nth) {
                    return fiboResult.getFiboOfNth();
                }
            }
            return null;
        }

        public void storeNewFiboResult(final long nth, final BigInteger fiboOfNth) {
            final var existingResult = fiboResult(nth);
            if (existingResult == null) {
                final var newFiboResult = new FiboResult();
                newFiboResult.setNth(nth);
                newFiboResult.setFiboOfNth(fiboOfNth);
                fiboResults.add(newFiboResult);
            }
        }
    }

    private static class FiboResult {

        private long nth;
        private BigInteger fiboOfNth;

        public long getNth() {
            return nth;
        }

        public void setNth(long nth) {
            this.nth = nth;
        }

        public BigInteger getFiboOfNth() {
            return fiboOfNth;
        }

        public void setFiboOfNth(BigInteger fiboOfNth) {
            this.fiboOfNth = fiboOfNth;
        }
    }

}
