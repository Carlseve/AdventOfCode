import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FixList {
    public static void getNumbersFromFile(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {
        try(BufferedReader file = new BufferedReader(new FileReader("input.txt"))){
            String line;
            while((line = file.readLine()) != null) {
                String[] numbers = line.split("   ");
                int left = Integer.parseInt(numbers[0]);
                int right = Integer.parseInt(numbers[1]);

                leftList.add(left);
                rightList.add(right);

            }

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static int compareTo(int x, int y){
        if (x > y){
            return 1;
        }
        else if (x < y){
            return -1;
        }
        return 0;
    }

    public static void sort(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int temp = list.get(i);
            int copyOfCurrentSmallestInt = list.get(i);
            int indexForSmallest = i;

            for (int j = i + 1; j < list.size(); j++) {
                if (compareTo(copyOfCurrentSmallestInt, list.get(j)) == 1) {
                    copyOfCurrentSmallestInt = list.get(j);
                    indexForSmallest = j;
                }
            }
            list.set(i, copyOfCurrentSmallestInt);
            list.set(indexForSmallest, temp);
        }
    }

    public static List<Integer> getDifference(List<Integer> a, List<Integer> b) {
        List<Integer> difference = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i)>b.get(i)) {
                difference.add(a.get(i) - b.get(i));
            }
            if (a.get(i)<b.get(i)) {
                difference.add(b.get(i)-a.get(i));
            }
        }
        return difference;
    }

    public static int sumList(List<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }
    public static HashMap<Integer, Integer> similarityChecker(List<Integer> a) {
        HashMap<Integer, Integer> occurencesOf = new HashMap<>();
        for (int i = 0; i < a.size(); i++) {
            if (!occurencesOf.containsKey(a.get(i))) {
                occurencesOf.put(a.get(i), 1);
            }
            else{
                occurencesOf.put(a.get(i), occurencesOf.get(a.get(i)) + 1);
            }
        }
        return occurencesOf;
    }

    public static List<Integer> getProduct(List<Integer> a, HashMap<Integer, Integer> b) {
        List<Integer> newList = new ArrayList<>();
        for (Integer num : a) {
            if (b.containsKey(num)) {
                newList.add(num * b.get(num));
            }
        }
        return newList;
    }
}