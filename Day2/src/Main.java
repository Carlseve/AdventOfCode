import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] test = {5, 4, 3, 2, 1};
        int[] test2 = {2, 3, 4, 6, 9};


        System.out.println(main.makeArrayFromFile());

    }

    public int makeArrayFromFile() {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] numbers = line.split(" ");
                int[] intNumbers = new int[numbers.length];

                for (int i = 0; i < numbers.length; i++) {
                    intNumbers[i] = Integer.parseInt(numbers[i]);
                }
                if (isListSafe(intNumbers) == true) {
                    count++;
                } else if (safeWithOneFault(intNumbers) == true) {
                    count++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    public boolean safeWithOneFault(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= array.length - 1; i++) {
            list.add(array[i]);
        }
        for (int j = 0; j < list.size(); j++) {
            List<Integer> tempList = new ArrayList<>(list);
            tempList.remove(j);
            if (isListSafe(tempList)) {
                return true;
            }
        }
        return false;
    }

    public boolean isListSafe(List<Integer> list) {
        int count = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            int positiveDiff = list.get(i) - list.get(i + 1);

            if (positiveDiff >= 1 && positiveDiff <= 3) {
                count++;
            }
            if (positiveDiff <= -1 && positiveDiff >= -3) {
                count--;
            }

        }
        if (count == list.size() - 1 || count == -list.size() + 1) {
            return true;
        }
        return false;
    }


    public boolean isListSafe(int[] array) {
        List<Integer> list = new ArrayList<>();
        int count = 0;
        boolean failSafe = true;
        for (int i = 0; i <= array.length - 1; i++) {
            list.add(array[i]);
        }

        for (int i = 0; i < list.size() - 1; i++) {
            int positiveDiff = list.get(i) - list.get(i + 1);

            if (positiveDiff >= 1 && positiveDiff <= 3) {
                count++;
            }
            if (positiveDiff <= -1 && positiveDiff >= -3) {
                count--;
            }

        }
        if (count == list.size() - 1 || count == -list.size() + 1) {
            return true;
        }

        return false;
    }
}



