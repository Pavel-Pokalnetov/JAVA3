package ru.gb.java3.homework5;

import java.util.concurrent.CountDownLatch;

public class Car implements Runnable {

    private static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;
    public static CountDownLatch raceStart;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        raceStart = new CountDownLatch(CARS_COUNT);
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            raceStart.countDown();
            System.out.println(this.name + " готов");
            raceStart.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (!race.isStarted) {
            race.isStarted = true;
            Stopwatch.init();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        MainRace.raceResult.add(new MainRace.Raceresult(this.name, Stopwatch.getState()));
    }
}
