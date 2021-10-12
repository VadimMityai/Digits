package main.java.com.numbers;

import java.util.TreeMap;

public class Tens extends Num {

    private TreeMap<String, String> ten;

    public Tens() {
        this.ten = new TreeMap<>();
        init("src/resources/TensNumbers.txt", this.ten);
    }

    @Override
    public String transform(String s) {
        return this.ten.get(s);
    }
}
