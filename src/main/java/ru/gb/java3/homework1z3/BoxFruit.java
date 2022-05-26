package ru.gb.java3.homework1z3;

import java.util.ArrayList;

/*
Класс коробки  с Generics, но в Box все работало и без них
 */
public class BoxFruit<F extends Fruit> {
    private ArrayList<F> storage;

    BoxFruit() {
        ArrayList<F> storage = new ArrayList<>();
    }

    BoxFruit(F fruit) {
        this.addFruit(fruit);
    }

    BoxFruit(F fruit, int count) {
        for (int i = 0; i < count; i++) {
            this.addFruit(fruit);
        }
    }

    public float getWeight() {
        //вес ящика
        if (getFruitCounter() == 0) return 0;
        return getFruitCounter() * storage.get(0).getWeight();
    }

    public String getBoxType() {
        //какой тип ящика
        if (getFruitCounter() == 0) return "";
        return this.storage.get(0).getClass().getSimpleName();
    }

    public int getFruitCounter() {
        //сколько в ящике фруктов
        return storage.size();
    }

    public void addFruit(F fruit) {
        if (getFruitCounter() != 0) {
            if (!getBoxType().equals(fruit.getClass().getSimpleName())) {
                System.out.println("box is not for this fruit");
                return;
            }
        }
        storage.add(fruit);
    }

    public void addFruit(F fruit, int count) {
        //добавление нескольких фруктов
        for (int i = 0; i < count; i++) {
            addFruit(fruit);
        }
    }

    public boolean compare(BoxFruit<F> box) {
        //сравнение типов ящиков
        return (box.getWeight() == this.getWeight());
    }

    public void push(BoxFruit<F> box, int counter) {
        //пересыпать несколько
        //только если ящик пуст или такой же
        if (!((box.getBoxType().equals(this.getBoxType())) | box.getFruitCounter() == 0)) {
            System.out.println("this is a box for other fruits");
            return;
        }
        if (counter == 0) return;//если ничего нет в ящике, то ничего не делаем
        if (counter > getFruitCounter()) counter = getFruitCounter();//можем пересыпать не больше чем осталось
        for (int i = 0; i < counter; i++) {
            box.addFruit(storage.get(0));
            storage.remove(0);
        }
    }

    public void push(BoxFruit<F> box) {
        //пересыпать все
        push(box, getFruitCounter());
    }
}
