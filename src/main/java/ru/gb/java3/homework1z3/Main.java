package ru.gb.java3.homework1z3;

public class Main {
    public static void main(String[] args) {
        Box boxGreen = new Box();
        Box boxRed = new Box();
        Box boxBlue = new Box();

        boxBlue.addFruit(new Apple(), 30);
        boxGreen.addFruit(new Orange(), 20);
        printBoxes(boxGreen, boxRed, boxBlue);

        boxGreen.push(boxRed, 15);
        printBoxes(boxGreen, boxRed, boxBlue);

        boxBlue.push(boxRed, 1);
        printBoxes(boxGreen, boxRed, boxBlue);

        boxGreen.addFruit(new Orange());
        boxGreen.addFruit(new Apple());
        printBoxes(boxGreen, boxRed, boxBlue);

        boxRed.push(boxGreen);
        printBoxes(boxGreen, boxRed, boxBlue);

        boxBlue.push(boxRed, 5);
        printBoxes(boxGreen, boxRed, boxBlue);
    }

    private static void printBoxes(Box boxGreen, Box boxRed, Box boxBlue) {
        System.out.println("Green box: " + boxGreen.getWeight() + " " + boxGreen.getBoxType());
        System.out.println("  Red box: " + boxRed.getWeight() + " " + boxRed.getBoxType());
        System.out.println(" Blue box: " + boxBlue.getWeight() + " " + boxBlue.getBoxType() + "\n");
    }
}
/*
вывод консоли

Green box: 30.0 Orange
  Red box: 0.0
 Blue box: 30.0 Apple

Green box: 7.5 Orange
  Red box: 22.5 Orange
 Blue box: 30.0 Apple

this is a box for other fruits
Green box: 7.5 Orange
  Red box: 22.5 Orange
 Blue box: 30.0 Apple

box is not for this fruit
Green box: 9.0 Orange
  Red box: 22.5 Orange
 Blue box: 30.0 Apple

Green box: 31.5 Orange
  Red box: 0.0
 Blue box: 30.0 Apple

Green box: 31.5 Orange
  Red box: 5.0 Apple
 Blue box: 25.0 Apple

 */