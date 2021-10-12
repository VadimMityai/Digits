package main.java.com.example;

import main.java.com.utils.ToWords;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Ввод массива пар чисел и их строковых представлений

       TreeMap<String, String> values = new TreeMap<>();
        boolean b = true;
        Scanner scanner = new Scanner(System.in);
        while (b) {
            System.out.println("Введите число");
            String num = scanner.nextLine();
            /*
            try {
                num = Long.parseLong(n);
            } catch (Exception e) {
                System.out.println("неверные данные");
                continue;
            }*/
            System.out.println("Введите словесное описание");
            String s = scanner.nextLine();
            values.put(num, s);
            System.out.println("Продолжить? (да/нет)");
            String sc = scanner.nextLine();
            if (sc.equals("нет")) {
                b = false;
            }
        }

        TreeMap<String, String> result = new TreeMap<>();
        ToWords make = new ToWords();

        for (Map.Entry<String, String> entry : values.entrySet()) {
            String value = entry.getValue();
            String updateValue = value.toLowerCase(Locale.ROOT).replaceAll("\\s+","");
            String key = entry.getKey();
            String transformNumber = make.makeNum(key);
            if (transformNumber.equals(updateValue)) {
                result.put(key, value + " Верно");
            } else {
                result.put(key, value + " Неверно");
            }
        }

        System.out.println(result);
    }
}
