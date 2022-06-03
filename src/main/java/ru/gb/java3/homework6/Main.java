package ru.gb.java3.homework6;

import java.util.Arrays;

public class Main {
    private Integer[] remakeArray(Integer[] array) {
        boolean flag = false;
        int i;
        for (i = array.length - 1; i >= 0; i--) {
            if (array[i] == 4) {
                flag = true;
                break;
            }
        }
        if (i == array.length - 1 || !flag) {
            throw new RuntimeException();
        }
        return Arrays.copyOfRange(array, i + 1, array.length - 1);

    }

    private boolean checkArray(Integer[] array) {
        boolean n1 = false, n4 = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                n1 = n1 | true;
            } else if (array[i] == 4) {
                n4 = n4 | true;
            }
            if (n1 & n4) return true;
        }
        return false;
    }

    public static void main(String[] args) {


    }
}
