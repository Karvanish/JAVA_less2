package org.example;

import static org.example.OtherFunctions.inputNumber;
import static org.example.UserMenu.makeMenu;


public class Main {
    public static void main(String[] args) {
        run();
    }

    public static void run(){
        makeMenu();
        boolean key = true;
        UserMenu.showMenu();
        while (key){
            try {
                int numberMenu = inputNumber("Введите номер команды: ");
                UserMenu.perform(numberMenu);
            } catch (Exception e){
                System.out.println("Программа завершена");
                key = false;
            }
        }
    }
}