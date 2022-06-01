package ru.gb.java3.homework6;

import java.util.Arrays;

public class Main {
    public static Integer[] remakeArray(Integer[] array){
        boolean flag = false;
        int i;
        for (i = array.length-1; i =0; i--) {
             if (array[i]==4){
                 flag=true;
                 break;
             }
        }
        if (!flag){
            throw new RuntimeException();
        }
        return Arrays.copyOfRange(array,i,array.length-1);

    }

    public static void main(String[] args) {

    }
}
