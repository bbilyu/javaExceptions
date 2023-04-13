package homeWork.hwTwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
    }


    /**
     * Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение.
     * Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.
     */

    static void task1() {
        while (true) {
            try {
                float num = getFloatFromUser();
                System.out.println(num);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Ошибка! Повторите попытку!");
            }
        }
    }

    public static float getFloatFromUser() throws InputMismatchException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите дробное число: ");
        return scan.nextFloat();
    }

    /**
     * Если необходимо, исправьте данный код (задание 2 <a href="https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit">...</a>)
     */

    static void task2() {
        try {
            int[] intArray = {1,2,3,4,5,6,7,8,9};
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }

    }
    /**
     * Дан следующий код, исправьте его там, где требуется (задание 3 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)
     */

    static void task3() {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2};
            abc[3] = 9;
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }

    }
    public static void printSum(Integer a, Integer b){
        System.out.println(a + b);
    }

    /**
     Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку. Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
     */

    static void task4() {

        try {
            program();
        }
        catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
        }

    }
    public static void program() throws RuntimeException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите любой текст кроме пустой строки");
        String result = reader.readLine();
        if(result.equals("")) throw new RuntimeException("Пустую строку вводить нельзя");
        System.out.println(result);
    }

}

