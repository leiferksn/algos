package me.leiferksn;

import me.leiferksn.fibo.FastFibo;
import me.leiferksn.fibo.Fibo;
import me.leiferksn.fibo.SlowFibo;

import java.math.BigInteger;

public class Algos {

    public static final int[] NUMS =
            { -2, -1, 0, 2, 3, 4, 5, 6, 9, 10, 12, 14, 15, 19, 20, 21, 23, 45, 56, 57, 58, 59, 60 };

    public static void capitalize() {
        final var capitalizor = new Capitalizor();
        capitalizor.setCh('A');
        final int acapint = capitalizor.getIntCh();
        capitalizor.setCh('a');
        final int aint = capitalizor.getIntCh();
        final int diff = aint - acapint;
        System.out.println("From int: " + capitalizor.getFromInt(122));
        System.out.println("Ch: " + capitalizor.getIntCh());
        System.out.println("Diff: " + diff);
    }

    public static void findInArray(final int[] nums, int target) {
        final var sortedArrayFinder = new SortedArrayFinder();
        System.out.println("Solution: " + sortedArrayFinder.search(nums, target));

    }

    public static BigInteger letsGoFibo(final long nth, boolean faster) {
        Fibo fibo = new SlowFibo();
        if (faster) {
            fibo = new FastFibo();
        }

        return fibo.fibo(nth);
    }

    public static void main(String[] args) {

        capitalize();

        findInArray(NUMS, 60);
        final var start = System.currentTimeMillis();

        final var result = letsGoFibo(7500, true);

        final var elapsed = String.valueOf((double) (System.currentTimeMillis() - start) / 1000);

        /*
            fib 50 takes around 40 secs without memoization
            with memoization it takes around 0.005 sec
         */

        System.out.println("Calculated nth fibo: " + result + " in " + elapsed + " secs.");
    }
}
