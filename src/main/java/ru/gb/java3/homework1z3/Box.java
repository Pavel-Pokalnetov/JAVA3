package ru.gb.java3.homework1z3;

import java.util.ArrayList;

/*
Класс коробки без использования Generic
так коробка не привязывается к какому-либо фрукту
пока в нее ничего не положили.
Коробка начинает принимает в себя только тот тип фруктов, которые
были положены в нее в начале.
Когда из коробки извлекли все фрукты, она считается пустой и может принять уже другой тип фруктов.

 */
public class Box {
    private final ArrayList<Fruit> storageFruit = new ArrayList<>();

    Box() {
    }

    Box(Fruit fruit) {
        storageFruit.add(fruit);
    }

    Box(Fruit fruit, int counter) {
        for (int i = 0; i < counter; i++) {
            storageFruit.add(fruit);
        }
    }

    public float getWeight() {
        //вес ящика
        if (getFruitCounter() == 0) return 0;
        return getFruitCounter() * storageFruit.get(0).getWeight();
    }

    public String getBoxType() {
        //какой тип ящика
        if (getFruitCounter() == 0) return "";
        return storageFruit.get(0).getClass().getSimpleName();
    }

    public int getFruitCounter() {
        //сколько в ящике фруктов
        return storageFruit.size();
    }

    public void addFruit(Fruit fruit) {
        if (getFruitCounter() != 0) {
            if (!getBoxType().equals(fruit.getClass().getSimpleName())) {
                System.out.println("box is not for this fruit");
                return;
            }
        }
        storageFruit.add(fruit);
    }

    public void addFruit(Fruit fruit, int count) {
        //добавление нескольких фруктов
        for (int i = 0; i < count; i++) {
            addFruit(fruit);
        }
    }

    public boolean compare(Box box) {
        //сравнение типов ящиков
        return (box.getWeight() == this.getWeight());
    }

    public void push(Box box, int counter) {
        //пересыпать несколько
        //только если ящик пуст или такой же
        if (!((box.getBoxType().equals(this.getBoxType())) | box.getFruitCounter() == 0)) {
            System.out.println("this is a box for other fruits");
            return;
        }
        if (counter == 0) return;//если ничего нет в ящике, то ничего не делаем
        if (counter > getFruitCounter()) counter = getFruitCounter();
        for (int i = 0; i < counter; i++) {
            box.addFruit(storageFruit.get(0));
            storageFruit.remove(0);
        }
    }

    public void push(Box box) {
        //пересыпать все
        push(box, getFruitCounter());
    }
}
