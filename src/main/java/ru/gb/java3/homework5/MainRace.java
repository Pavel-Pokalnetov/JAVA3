package ru.gb.java3.homework5;

import java.util.Vector;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class MainRace {
    static class Raceresult {
        String name;
        Long time;

        public Long getTime() {
            return time;
        }

        public String getName() {
            return name;
        }

        Raceresult(String name, Long time) {
            this.name = name;
            this.time = time;
        }
    }

    public static final int CARS_COUNT = 4;
    public static Vector<Raceresult> raceResult = new Vector<>(CARS_COUNT);

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        ThreadPoolExecutor carsThreads = (ThreadPoolExecutor) Executors.newFixedThreadPool(CARS_COUNT);
        for (int i = 0; i < cars.length; i++) {
            carsThreads.execute(new Thread(cars[i]));
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        while (carsThreads.getActiveCount() > 0) {
        }
        carsThreads.shutdown();
        System.out.println(Stopwatch.getState() + ": " + "ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!\n\n");
        System.out.println("Результаты гонки:");
        for (int i = 0; i < CARS_COUNT; i++) {
            System.out.printf("%s-е место  %s с временем: %d\n", i + 1, raceResult.get(i).name, raceResult.get(i).time);
        }
    }
}

/*  Вывод консоли:

0: ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!
0: ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!
1: Участник #1 готовится
0: Участник #4 готовится
1: Участник #2 готовится
0: Участник #3 готовится
72: Участник #2 готов
79: Участник #1 готов
84: Участник #3 готов
87: Участник #4 готов
87: Участник #1 начал этап: дорога 60 метров
87: Участник #3 начал этап: дорога 60 метров
87: Участник #2 начал этап: дорога 60 метров
87: Участник #4 начал этап: дорога 60 метров
288: Участник #2 закончил этап: дорога 60 метров
288: Участник #2 готовится к этапу(ждет): Тоннель 80 метров
288: Участник #2 начал этап: Тоннель 80 метров
289: Участник #3 закончил этап: дорога 60 метров
289: Участник #1 закончил этап: дорога 60 метров
289: Участник #4 закончил этап: дорога 60 метров
289: Участник #4 готовится к этапу(ждет): Тоннель 80 метров
289: Участник #1 готовится к этапу(ждет): Тоннель 80 метров
289: Участник #3 готовится к этапу(ждет): Тоннель 80 метров
289: Участник #4 начал этап: Тоннель 80 метров
489: Участник #1 начал этап: Тоннель 80 метров
489: Участник #2 закончил этап: Тоннель 80 метров
489: Участник #2 начал этап: дорога 40 метров
590: Участник #2 закончил этап: дорога 40 метров
590: Участник #4 закончил этап: Тоннель 80 метров
590: Участник #3 начал этап: Тоннель 80 метров
590: Участник #4 начал этап: дорога 40 метров
691: Участник #4 закончил этап: дорога 40 метров
789: Участник #1 закончил этап: Тоннель 80 метров
789: Участник #1 начал этап: дорога 40 метров
890: Участник #3 закончил этап: Тоннель 80 метров
890: Участник #3 начал этап: дорога 40 метров
890: Участник #1 закончил этап: дорога 40 метров
991: Участник #3 закончил этап: дорога 40 метров
991: ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!


Результаты гонки:
1-е место  Участник #2 с временем: 590
2-е место  Участник #4 с временем: 691
3-е место  Участник #1 с временем: 890
4-е место  Участник #3 с временем: 991

 */