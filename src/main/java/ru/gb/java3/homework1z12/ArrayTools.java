package ru.gb.java3.homework1z12;

import java.util.ArrayList;

public class ArrayTools<A> {
    public A[] array;

    public ArrayTools(A[] array) {
        this.array = array;
    }

    public A[] revers(int first, int second) {
        //перестановка элементов массива
        if (first < 1 || second < 1 || first > array.length || second > array.length)
            throw new RuntimeException("Error of Array index");
        //перевод из человеческой нумерации элементов(1.2.3...) в машинную(0.1.2...)
        first--;
        second--;
        A item = array[first];
        array[first] = array[second];
        array[second] = item;
        return array;
    }

    public void print() {
        //печать элементов массива, "шоб красива))"
        System.out.print("[");
        for (int i = 0; i < array.length; i++) System.out.print(array[i] + (i + 1 < array.length ? ", " : "]"));
        System.out.println();
    }

    public ArrayList<A> getArrayList() {
        //создаем ArrayList из массива
        ArrayList<A> tempArrayList = new ArrayList<A>(array.length);
        int i = 0;
        for (A item : array) {
            tempArrayList.add(i++, item);
        }
        return tempArrayList;
    }
}
