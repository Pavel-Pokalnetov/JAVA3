package ru.gb.java3.homework5;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    public static final Semaphore tnCapacity = new Semaphore(MainRace.CARS_COUNT / 2);//вместимость тоннеля

    public Tunnel() {
        this.length = 100;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(Stopwatch.getState() + ": " + c.getName() + " готовится к этапу(ждет): " +
                        description);
                tnCapacity.acquire();
                System.out.println(Stopwatch.getState() + ": " + c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                tnCapacity.release();
                System.out.println(Stopwatch.getState() + ": " + c.getName() + " закончил этап: " +
                        description);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
