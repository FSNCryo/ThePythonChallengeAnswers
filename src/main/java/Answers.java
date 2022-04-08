import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Answers {
    public static long answer0() {
        double a = 2;
        double b = 38;
        return (long) Math.pow(a, b);
    }

    public static String answer1(String input, int key) {
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                int offset = Character.isUpperCase(c) ? 'A' : 'a';
                sb.append((char) ((c - offset + key) % 26 + offset));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    public static String answer2() {
        String data = "";

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "C:\\Users\\cameronphillips\\IdeaProjects\\The Python Challenge\\src\\main\\resources\\inputText2"));
            String line = reader.readLine();
            while (line != null) {
                data += line;
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<Character, Integer> charCounts = new HashMap<>();
        for (char c : data.toCharArray()) {
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : data.toCharArray()) {
            if (charCounts.get(c) == 1) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println("0: "+answer0());
        System.out.println("1: "+answer1("map", 2));
        System.out.println("2: "+answer2());
    }

}
