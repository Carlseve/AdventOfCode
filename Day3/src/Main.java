import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.patternFinder();
    }

    public void patternFinder() {
        ArrayList<String> patterns = new ArrayList<>();
        int sum = 0;
        boolean enabled = true;
        String regex = "mul\\((\\d+),(\\d+)\\)|do\\(\\)|don't\\(\\)";
        Pattern pattern = Pattern.compile(regex);



        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                    Matcher matcher = pattern.matcher(line);
                    while (matcher.find()) {
                        patterns.add(matcher.group());
                    }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println(sumList(multiplyElementsInList(checkIfValidElements(removeMulFromElement(patterns)))));
    }

    public static String arrayListToString(ArrayList<String> list) {
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int i = 0; i < list.size(); i++) {
            result.append(list.get(i));
            if (i < list.size() - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }

    public List<String> removeMulFromElement(List<String>list){
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains("do")) {
                result.add(list.get(i));
            }
            if (list.get(i).startsWith("mul")) {
                String line = list.get(i).substring(4, list.get(i).length()-1);
                result.add(line);
            }
        }
        return result;
    }

    public List<String> checkIfValidElements(List<String> list){
        ArrayList<String> result = new ArrayList<>();
        boolean enabled = true;
        for (int i = 0; i < list.size(); i++) {
            String element = list.get(i);
            if (element.equals("do()")) {
                i++;
                enabled =true;
            }
            if (element.equals("don't()")) {
                enabled = false;
            }
            if (enabled) {
                result.add(list.get(i));
            }
        }
        return result;
    }

    public List<Integer> multiplyElementsInList(List<String>list){
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
           String line = list.get(i);
           String[] parts = line.split(",");
           int product = Integer.parseInt(parts[0])*Integer.parseInt(parts[1]);
            result.add(product);
        }
        return result;
    }
    public int sumList(List<Integer> list){
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }
}