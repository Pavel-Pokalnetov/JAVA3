package ru.gb.java3.homework5;

public class Road extends Stage {
    public Road(int length) {
        this.length = length;
        this.description = "дорога " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            System.out.println(Stopwatch.getState() + ": " + c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(Stopwatch.getState() + ": " + c.getName() + " закончил этап: " + description);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
