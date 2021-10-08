package main.java.com.numbers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public abstract class Num {

    static void init(String fileName, TreeMap<Long, String> numbers) {
        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                String[] strings = line.split(" ");
                numbers.put(Long.parseLong(strings[0]), strings[1]);
                line = reader.readLine();
            }
            reader.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract String transform(String s);
}
