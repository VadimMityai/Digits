package main.java.com.numbers;

import java.util.TreeMap;

public class Degrees extends Num{

    private TreeMap<Long, String> listOfDegrees;

    public Degrees() {
        this.listOfDegrees = new TreeMap<>();
        init("src/resources/Degrees.txt", this.listOfDegrees);
    }

    @Override
    public String transform(String s) {
        String[] mass = new String[2];
        if (s.length() == 3) {
            mass[0] = String.valueOf(s.charAt(2));
            mass[1] = s.substring(0,2);
        } else {
            mass[0] = String.valueOf(s.charAt(1));
            mass[1] = String.valueOf(s.charAt(0));
        }
        return newEnding(mass);
    }

    private String newEnding (String[] s) {
        String value = "";
        int j = Integer.parseInt(s[0]);
        if (j != 0) {
        StringBuilder sb = new StringBuilder();
        String degree = this.listOfDegrees.get((long) j );
        sb.append(degree);
        int digitForDegree;
        try {
            if (String.valueOf(s[1].charAt(1)).equals("1")) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(s[1]);
                stringBuilder.reverse();
                s[1] = stringBuilder.toString();
                digitForDegree = Integer.parseInt(s[1]);
            } else {
                digitForDegree = Integer.parseInt(String.valueOf(s[1].charAt(0)));
            }
        } catch (Exception e) {
            digitForDegree = Integer.parseInt(s[1]);
        }
        if (degree.equals("тысяча")) {
            sb.deleteCharAt(sb.length() - 1);
            StringBuilder strB = new StringBuilder();
            value = switch (digitForDegree) {
                case 1 -> strB.append("одна").append(sb.append("а")).toString();
                case 2 -> strB.append("две").append(sb.append("и")).toString();
                case 3, 4 -> sb.append("и").toString();
                default -> sb.toString();
            };
        } else {
            value = switch (digitForDegree) {
                case 1 -> sb.toString();
                case 2, 3, 4 -> sb.append("а").toString();
                default -> sb.append("ов").toString();
            };
        }
        }
    return value;
    }
}