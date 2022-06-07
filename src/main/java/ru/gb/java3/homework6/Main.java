package ru.gb.java3.homework6;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.testng.annotations.Test;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    private int[] remakeArray(int[] array) {
        boolean flag = false;
        int i;
        for (i = array.length - 1; i >= 0; i--) {
            if (array[i] == 4) {
                flag = true;
                i++;
                break;
            }
        }
        if (i == array.length || !flag) {
            throw new RuntimeException();
        }
        return Arrays.copyOfRange(array, i , array.length);
    }

    private boolean checkArray(int[] array) {
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




    @ParameterizedTest
    @MethodSource("dataForRemakeArray")
    public void m1_Test(int[] array, int[] result){
        Assertions.assertArrayEquals(result,remakeArray(array));
    }
    public static Stream<Arguments> dataForRemakeArray(){
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{1,3,2,1,5,4,7,9,5},new int[]{7,9,5}));
        out.add(Arguments.arguments(new int[]{4,7,1,4,3,2,8,4,7,5,3,7},new int[]{7,5,3,7}));
        out.add(Arguments.arguments(new int[]{2,8,6,7,7,1,3,4,8,8,1,1,1},new int[]{8,8,1,1,1}));
        return out.stream();
    }

    @Test
    public void m2_Test(){
        Assertions.assertTrue(checkArray(new int[]{1,1,1,4,4,1,4,4}));
        Assertions.assertFalse(checkArray(new int[]{1,1,1,1,1,1}));
        Assertions.assertFalse(checkArray(new int[]{4,4,4,4}));
        Assertions.assertTrue(checkArray(new int[]{1,4,4,1,1,4,3}));
    }
}
