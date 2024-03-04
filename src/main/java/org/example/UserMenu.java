package org.example;

import java.util.*;

import static org.example.MethodToysQueue.*;
import static org.example.MethodsFile.deletedFile;
import static org.example.MethodsFile.printFile;
import static org.example.OtherFunctions.inputNumber;


/**
 * Методы взаимодействия с пользователем
 */
public class UserMenu {

    /**
     * Список главного меню
     */
    private static final ArrayList <String> userMenu = new ArrayList<>();

    protected static void makeMenu() {
        userMenu.add(0, "Старт");
        userMenu.add(1, "Показать список доступных призов ");
        userMenu.add(2, "Добавить 1 приз");
        userMenu.add(3, "Изменить % выпадения приза");
        userMenu.add(4, "Разыграть приз");
        userMenu.add(5, "Вывод файла с выданными призами");
        userMenu.add(6, "Удаление файла с данными о выданных призах");
        userMenu.add(7, "Выход из программы");
        userMenu.add(8, "Печать меню");
    }


    /**
     * Отображение главного меню
     */
    protected static void showMenu() {
        System.out.println("\n  Главное меню \nдля выбора команды введите её номер ");
        for (int i = 0; i < userMenu.size(); i++) {
            System.out.printf("%d: %s\n", i + 1, userMenu.get(i));
        }
        System.out.println();
    }

    public static void perform(int command){
        switch (command) {
            case 1:
                String message = "Введите стартовое количество призов: ";
                int number = inputNumber(message);
                makeToys(number);
                break;
            case 2:
                showToys();
                break;
            case 3:
                makeToys(1);
                break;
            case 4:
                changeToys();
                break;
            case 5:
                winToy();
                break;
            case 6:
                printFile();
                break;
            case 7:
                deletedFile();
                break;
            case 8:
                throw new RuntimeException("Вы решили прервать программу ");
            case 9:
                showMenu();
                break;
            default:
                System.out.println("Нет команды с таким номером. " +
                        "Пожалуйста, повторите ввод ");
        }
    }
}
