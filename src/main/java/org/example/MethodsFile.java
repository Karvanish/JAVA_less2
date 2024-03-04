package org.example;

import java.io.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;


/**
 * Создание файла, чтение/запись/удаление данных
 */
public class MethodsFile {


    /**
     * Печать данных из файла в консоль
     */
    public static void printFile(){
        String fileName = "GivingOutToys.txt";
        try(FileReader reader = new FileReader(fileName)) {
            int c;
            while((c=reader.read())!=-1){   // читаем посимвольно
                System.out.print((char)c);
            }
        } catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Удаление данных из файла
     */
    public static void deletedFile(){
        String fileName = "GivingOutToys.txt";
        File file = new File(fileName);
        if (file.exists()) {
            boolean deleted = file.delete();
            if (deleted) System.out.println("Файл с данными успешно удалён");
        }else{
            System.out.println("Не получается удалить файл. Возможно, его итак нет");
        }
    }

    /**
     * Запись в файл
     */
    public static void writeFile(String winner, Toys toy) throws IOException {
        String fileName = "GivingOutToys.txt";
        try {
            File myFile = new File(fileName);
            if(myFile.exists())
                System.out.println("Происходит запись данных в текущий файл ");
            else{
               // System.out.println("File not found");
                try  {
                    boolean created = myFile.createNewFile();
                    if (created) {
                        System.out.println("Данные сохранены в новый файл ");
                    }
                } catch(IOException ex){
                    System.out.println(ex.getMessage());
                }
            }
        } catch (Exception e){
            throw new RemoteException();
        }
        try(FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(STR."\{winner} - \{toy.toString()}");
            // дозапись по символам
            writer.append('\n');
            writer.flush();
        } catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
