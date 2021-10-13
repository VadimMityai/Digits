package main.java.com.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Check {

    public static void checkEquals (List<String> values, String s) {
        ArrayList<String> upValues = new ArrayList<>();
        for (String word: values) {
            upValues.add(word.toLowerCase(Locale.ROOT).replaceAll("\\s+",""));
        }
        String upS;
        upS = s.toLowerCase(Locale.ROOT).replaceAll("\\s+","");
        for (int i = 0; i < upValues.size(); i++) {
            if (upValues.get(i).equals(upS)) {
                values.set(i, values.get(i) + " Верно");
            } else {
                values.set(i, values.get(i) + " Неверно");
            }
        }
    }

    public static boolean checkInputNumber (String s) {
        return true;
    }
}
