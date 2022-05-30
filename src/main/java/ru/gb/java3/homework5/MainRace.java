package ru.gb.java3.homework5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
    public static List<Raceresult> raceResult = Collections.synchronizedList(new ArrayList<Raceresult>(CARS_COUNT));

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
        while (carsThreads.getActiveCount() > 0) ;//ждем окончания заезда
        carsThreads.shutdown();
        System.out.println(Stopwatch.getState() + ": " + "ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!\n\n");
        System.out.println("Результаты гонки:");
        for (int i = 0; i < CARS_COUNT; i++) {
            System.out.printf("%s-е место  %s с временем: %d\n", i + 1, raceResult.get(i).name, raceResult.get(i).time);
        }
    }
}

/*  Вывод консоли:

ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!
Участник #2 готовится
Участник #3 готовится
Участник #1 готовится
Участник #4 готовится
Участник #4 готов
Участник #2 готов
Участник #1 готов
Участник #3 готов
ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!
0: Участник #3 начал этап: дорога 60 метров
0: Участник #2 начал этап: дорога 60 метров
0: Участник #1 начал этап: дорога 60 метров
0: Участник #4 начал этап: дорога 60 метров
201: Участник #3 закончил этап: дорога 60 метров
201: Участник #3 готовится к этапу(ждет): Тоннель 100 метров
201: Участник #3 начал этап: Тоннель 100 метров
201: Участник #2 закончил этап: дорога 60 метров
201: Участник #4 закончил этап: дорога 60 метров
201: Участник #2 готовится к этапу(ждет): Тоннель 100 метров
201: Участник #4 готовится к этапу(ждет): Тоннель 100 метров
201: Участник #2 начал этап: Тоннель 100 метров
301: Участник #1 закончил этап: дорога 60 метров
301: Участник #1 готовится к этапу(ждет): Тоннель 100 метров
501: Участник #4 начал этап: Тоннель 100 метров
501: Участник #3 закончил этап: Тоннель 100 метров
501: Участник #3 начал этап: дорога 40 метров
602: Участник #3 закончил этап: дорога 40 метров
602: Участник #2 закончил этап: Тоннель 100 метров
602: Участник #1 начал этап: Тоннель 100 метров
602: Участник #2 начал этап: дорога 40 метров
703: Участник #2 закончил этап: дорога 40 метров
902: Участник #4 закончил этап: Тоннель 100 метров
902: Участник #4 начал этап: дорога 40 метров
1003: Участник #4 закончил этап: дорога 40 метров
1102: Участник #1 закончил этап: Тоннель 100 метров
1102: Участник #1 начал этап: дорога 40 метров
1302: Участник #1 закончил этап: дорога 40 метров
1302: ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!


Результаты гонки:
1-е место  Участник #3 с временем: 602
2-е место  Участник #2 с временем: 703
3-е место  Участник #4 с временем: 1003
4-е место  Участник #1 с временем: 1302

Process finished with exit code 0

 */