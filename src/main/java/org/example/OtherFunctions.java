package org.example;

import java.util.Scanner;

/**
 * Класс, где собраны разные функции
 */
public class OtherFunctions {

    /**
     * Метод ввода числа из консоли
     */
    public static Integer inputNumber(String message){
        int number = 0;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println(message);
            String string = scanner.nextLine();
            if (string.isEmpty()) System.out.println("  Ну, что же так? \nВы ввели пустую строку");
            else if (isParsable(string)) {
                number = Integer.parseInt(string);
            } else System.out.println("Не корректные данные. Принято значение по умолчанию ");
        } catch (Exception e) {
            System.out.println("Ввод числа не удался");
            throw new RuntimeException(e);
        }
        return number;
    }

    /**
     * Метод ввода строки из консоли
     */
    public static String inputString(String message){
        String string;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println(message);
            string = scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Ввод строки не удался");
            throw new RuntimeException(e);
        }
        return string;
    }

    /**
     * Метод проверки возможности преобразования строки в число
     */
    public static boolean isParsable(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (final NumberFormatException e) {
            return false;
        }
    }
}
