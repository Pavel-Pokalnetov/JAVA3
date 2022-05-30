package ru.gb.java3.homework4;

public class Main {
    private final Object monitor = new Object();
    private volatile int symbol = 1;

    public void printA() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (symbol != 1) {
                        monitor.wait();
                    }
                    System.out.print("A");
                    symbol = 2;
                    monitor.notifyAll();

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printB() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (symbol != 2) {
                        monitor.wait();
                    }
                    System.out.print("B");
                    symbol = 3;
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printC() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (symbol != 3) {
                        monitor.wait();
                    }
                    System.out.print("C");
                    symbol = 1;
                    monitor.notifyAll();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        Main mg = new Main();
        Thread threadA = new Thread(mg::printA);
        Thread threadB = new Thread(mg::printB);
        Thread threadC = new Thread(mg::printC);

        threadA.start();
        threadB.start();
        threadC.start();
    }
}
