package org.example;
import java.util.PriorityQueue;

import static org.example.MethodsFile.*;
import static org.example.OtherFunctions.*;

/**
 * Создание игрушек и их коллекции в виде очереди приоритетов
 */
public class MethodToysQueue{

    private static final PriorityQueue<Toys> toysPriorityQueue = new PriorityQueue<>();
    /**
     * Метод создания коллекции игрушек PriorityQueue
     */
    public static void makeToys(int quantity){
        for (int i = 0; i < quantity; i++) {
            Toys toy=makeOnlyToy();
            System.out.println(toy);
            toysPriorityQueue.add(toy);
        }
    }

    /**
     * Метод создания игрушки
     */
    public static Toys makeOnlyToy() {
        String nameMessage = "Введите название игрушки: ";
        String name = inputString(nameMessage);
        String numberMessage = "Введите % вероятности выигрыша игрушки (от 1 до 100): ";
        Integer percentageOfLoss = inputNumber(numberMessage);
        if (percentageOfLoss<1 || percentageOfLoss>100) System.out.println("Введён " +
                STR."сказочный показатель вероятности \{percentageOfLoss} ).\n" +
                "Пусть будет так. Посмотрим, что получится");
        return new Toys(name, percentageOfLoss);
    }


    /**
     * Проверка очереди игрушек на пустоту
     */
    public static boolean checkToysPriorityQueue(){
        if (!toysPriorityQueue.isEmpty()){
            return true;
        }
        System.out.println("Призы закончились :( ");
        return false;
    }

    /**
     * Изменение вероятности % выпадения приза
     */
    public static void changeToys(){
        System.out.println(toysPriorityQueue.peek());
        int k = inputNumber("Введите новую вероятность выигрыша приза (от 1 до 100) ");
        if (k<1 || k>100) System.out.println(STR."Введён сказочный показатель вероятности \{k} ).\n" +
                "Пусть будет так. Посмотрим, что получится");
        if (checkToysPriorityQueue()) {
            assert toysPriorityQueue.peek() != null;
            toysPriorityQueue.peek().setPercentageOfLoss(k);
            System.out.println(toysPriorityQueue.peek());
        }
    }

    /**
     * Розыгрыш приза:
     * Розыгрывается первый приз очереди.
     * В случае выигрыша идёт запись выигрывшего и приза в файл.
     * В случае проигрыша, приз переходит в хвост очереди.
     */
    public static void winToy() {
        Toys toy;
        if (checkToysPriorityQueue()) {
            int random = (int) (Math.random() * 100);
            System.out.println(STR."Выиграло число \{random}");
            toy = toysPriorityQueue.poll();
            if (toy!= null){
                System.out.println(STR."Вероятность выигрыша ближайшего приза \{toy.getPercentageOfLoss()}");
                if (random <= toy.getPercentageOfLoss()) {
                    extradition(toy);
                } else {
                    toysPriorityQueue.add(toy);
                    System.out.println("Упс... \n Удача обязательно улыбнётся, в другой раз ");
                }
            } else {
                System.out.println("К сожалению, не нашлось приза для розыгрыша, попросите пополнить коллекцию призов ");
            }
        }
    }


    /**
     * Выдача победителю с фиксацией данных в файл
     */
    public static void extradition(Toys toy){
        String winner = inputString("Введите имя обладателя приза ");
        try {
            writeFile(winner, toy);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }


    /**
     * Печать списка призов
     */
    public static void showToys(){
        if (toysPriorityQueue.isEmpty()){
            System.out.println("Список призов пуст ");
        } else {
            for (Toys elem : toysPriorityQueue){
                System.out.println(elem);
            }
        }
    }
}
