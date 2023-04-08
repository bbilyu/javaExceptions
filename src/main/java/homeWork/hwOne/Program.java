package homeWork.hwOne;

import java.util.Random;
import java.util.Scanner;

public class Program {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        task1();
        task2();
    }


    /**
     * Домашнее задание:
     * Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
     * и возвращающий новый массив, каждый элемент которого равен разности элементов двух
     * входящих массивов в той же ячейке. Если длины массивов не равны,
     * необходимо как-то оповестить пользователя.
     */

    static void task1() {
        try {
            int[] res = getSubstractArrays(new int[]{1, -2, 9, 1, 6}, new int[]{5, 2, 0, 1, 8});
            for (int e : res) {
                System.out.printf("%d\t", e);
            }
            System.out.println();
        } catch (CustomArraySizeException e) {
            System.out.println(e.getMessage());
            System.out.printf("Длина первого массива: %d\nДлина второго массива: %d\n", e.getLength1(), e.getLength2());
        }
    }

    public static int[] getSubstractArrays(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null)
            throw new NullPointerException("Оба массива должны существовать.");

        if (arr1.length != arr2.length) {
            throw new CustomArraySizeException("Кол-во элементов массива должно быть одинаково.", arr1.length, arr2.length);
        }
        // инициализируем и заполняем новый массив разницей элементов двух исходных
        int[] res = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            res[i] = arr1[i] - arr2[i];
        }
        return res;
    }

    /**
     * Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
     * и возвращающий новый массив, каждый элемент которого равен частному элементов двух
     * входящих массивов в той же ячейке. Если длины массивов не равны,
     * необходимо как-то оповестить пользователя. Важно: При выполнении метода единственное исключение,
     * которое пользователь может увидеть - RuntimeException, т.е. ваше.
     */
    static void task2() {
        try {
            int[] res = getSumArray(new int[]{1, -2, 9, 1, 6}, new int[]{5, 2, 0, 1, 8});
            for (int e : res) {
                System.out.printf("%d\t", e);
            }
            System.out.println();
        } catch (CustomArraySizeException e) {
            System.out.println(e.getMessage());
            System.out.printf("Длина первого массива: %d\nДлина второго массива: %d\n", e.getLength1(), e.getLength2());
        }
    }

    static int[] getSumArray(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null)
            throw new NullPointerException("Оба массива должны существовать.");

        if (arr1.length != arr2.length)
            throw new CustomArraySizeException("Кол-во элементов массива должно быть одинаково.", arr1.length, arr2.length);
        int[] res = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            res[i] = arr1[i] + arr2[i];
        }
        return res;
    }


}

class CustomArraySizeException extends RuntimeException {

    int length1;
    int length2;

    public int getLength1() {
        return length1;
    }

    public int getLength2() {
        return length2;
    }

    public CustomArraySizeException(String message, int length1, int length2) {
        super(message);
        this.length1 = length1;
        this.length2 = length2;
    }

}
