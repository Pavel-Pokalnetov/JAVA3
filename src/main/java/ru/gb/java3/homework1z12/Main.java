package ru.gb.java3.homework1z12;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //перестановка элементов
        //проверка с числами
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        new ArrayTools<Integer>(arr).print();
        arr = new ArrayTools<Integer>(arr).revers(1, 6);
        new ArrayTools<Integer>(arr).print();

        //проверка состроками
        String[] arrString = new String[]{"one", "two", "three", "four", "five", "six", "seven", "eight",};
        new ArrayTools<String>(arrString).print();
        arrString = new ArrayTools<String>(arrString).revers(1, 5);
        new ArrayTools<String>(arrString).print();

        //делаем ArrayList из массива строк
        System.out.println();
        ArrayList<String> arrList = new ArrayTools<String>(arrString).getArrayList();
        System.out.println(arrList);
        System.out.println(arrList.size());
        System.out.println(arrList.getClass());
        System.out.println(arrList.get(0).getClass());


        //тоже самое, только из числового(Float) массива
        Float[] arrF = new Float[]{2.3f, 12.4f, 6.0f, 1f, 0f, 0f, 12.4f};
        new ArrayTools<Float>(arrF).print();
        ArrayList<Float> arayListF = new ArrayTools<Float>(arrF).getArrayList();
        System.out.println(arayListF);
        System.out.println(arayListF.size());
        System.out.println(arayListF.getClass());
        System.out.println(arayListF.get(0).getClass());
    }

}

