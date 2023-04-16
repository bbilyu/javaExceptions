package homeWork.hwThree;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        App.start();
    }
}

class App {
    // Класс App представляет приложение.
    // Он содержит метод start() для запуска программы и метод program(), в котором реализуется основная логика приложения.
    public static void start() {
        while (true) {
            try {
                program();
                break;
            } catch (DateException e) {
                System.out.println(e.getMessage());
            } catch (ParseException e) {
                System.out.println("Ошибка! Неверный формат даты. Должно быть  dd.mm.yyyy");
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Неверный формат номера телефона. Должно быть целое число без знака");
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка! Неверное значение пола. Допустимые значения: f или m");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void program() throws DateException, ParseException, IllegalArgumentException, IOException {
        // Считываем данные от пользователя
        Scanner input = new Scanner(System.in);
        System.out.println("Введите данные разделяя пробелом (строка должна содержать Ф.И.О, дату рождения - dd.mm.yyyy, номер телефона - цифры, пол - f/m ): ");
        String userData = input.nextLine();
        String[] dataArray = userData.split(" ");
        // Проверяем, совпадает ли количество введенных данных с требуемым
        checkData(dataArray);
        // Записываем данные в переменные с соответствующими типами данных
        String lastName = dataArray[0];
        String firstName = dataArray[1];
        String patronymicName = dataArray[2];
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Date birthDate = format.parse(dataArray[3]);
        String birthDateString = format.format(birthDate);
        Long phoneNumber = 0L;
        char gender = ' ';
        phoneNumber = Long.parseLong(dataArray[4]);
        gender = dataArray[5].charAt(0);
        // Проверяем,вверно ли был введен пол
        checkGender(gender);
        // Формируем строку для записи в файл
        String dataString = lastName + " " + firstName + " " + patronymicName + " " + birthDateString + " " + phoneNumber + " " + gender;
        File file = new File(lastName + ".txt");
        if (file.exists()) {
            FileWriter fileWriter = new FileWriter(lastName + ".txt", true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.newLine();
            writer.write(dataString);
            writer.close();
        } else {
            FileWriter fileWriter = new FileWriter(lastName + ".txt");
            fileWriter.write(dataString);
            fileWriter.close();
        }
        System.out.println("Данные успешно записаны в файл: " + lastName + ".txt");
    }


    public static void checkData(String[] dataArr) throws DateException {
        // Метод checkData принимает массив строк, состоящих из 6 параметров, и выбрасывает исключение DateException,если было передано неверное количество параметров.
        if (dataArr.length != 6) {
            throw new DateException("Ошибка! Вы ввели неверное количество данных \n" +
                    "Должно быть 6 параметров разделенных пробелом");
        }
    }

    public static void checkGender(char gen) throws IllegalArgumentException {
        // Метод checkGender принимает параметр типа char и выбрасывает исключение IllegalArgumentException,если переданное значение пола не f или m.
        if (gen != 'f' && gen != 'm') {
            throw new IllegalArgumentException("Неверное значение пола");
        }
    }
}

class DateException extends Exception {
    public DateException(String message) {
        super(message);
    }
}