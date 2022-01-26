package me.leiferksn;

public class Capitalizor {

    private char ch = 'a';

    public int getIntCh() {
        return (int)ch;
    }

    public static char getFromInt(int a) {
        return (char)a;
    }

    public void setCh(final char ach) {
        ch = ach;
    }
}
