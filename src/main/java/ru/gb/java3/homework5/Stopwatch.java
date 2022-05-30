package ru.gb.java3.homework5;

public class Stopwatch {
    public static long initTime = System.currentTimeMillis();

    public static void init() {
        initTime = System.currentTimeMillis();
    }

    public static long getState() {
        return (System.currentTimeMillis() - initTime) / 10;
    }
}
