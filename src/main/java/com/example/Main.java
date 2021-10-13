package main.java.com.example;

import main.java.com.utils.Check;
import main.java.com.utils.ToWords;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Ввод массива пар чисел и их строковых представлений

       TreeMap<String, ArrayList<String>> values = new TreeMap<>();
        boolean b = true;
        Scanner scanner = new Scanner(System.in);
        while (b) {
            System.out.println("Введите число");
            String num = scanner.nextLine();
            ArrayList<String> words = new ArrayList<>();
            boolean c = true;
            while (c) {
                System.out.println("Введите словесное описание");
                String s = scanner.nextLine();
                words.add(s);
                System.out.println("Еще вариант?");
                String sc = scanner.nextLine();
                if (sc.equals("нет")) {
                    c = false;
                }
            }
            values.put(num, words);
            System.out.println("Продолжить? (да/нет)");
            String sc = scanner.nextLine();
            if (sc.equals("нет")) {
                b = false;
            }
        }

        ToWords make = new ToWords();
        ArrayList<String> result = new ArrayList<>();
        for (Map.Entry<String, ArrayList<String>> entry : values.entrySet()) {
            String key = entry.getKey();
            String transformNumber = make.makeNum(key).replaceAll("[\\s]{2,}", " ");
            result.add(transformNumber.trim());
            }
        int i = 0;
        for (Map.Entry<String, ArrayList<String>> entry : values.entrySet()) {
            ArrayList<String> value = entry.getValue();
            String s = result.get(i);
            Check.checkEquals(value, s);
        }

        System.out.println("Преобразованные числа: " + result);
        System.out.println("******************");
        System.out.println("Сравнение" + values);
    }
}
