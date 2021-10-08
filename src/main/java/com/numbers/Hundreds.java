package main.java.com.numbers;

import java.util.TreeMap;

public class Hundreds extends Num {

    private TreeMap<Long, String> hundred;

    public Hundreds() {
        this.hundred = new TreeMap<>();
        init("src/resources/HundredsNumbers.txt", this.hundred);
    }

    @Override
    public String transform(String s) {
        long i = Long.parseLong(s);
        return this.hundred.get(i);
    }
}
