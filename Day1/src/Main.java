import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();

        FixList.getNumbersFromFile(leftList, rightList);

        FixList.sort(leftList);
        FixList.sort(rightList);

        System.out.println(FixList.sumList(FixList.getProduct(leftList, FixList.similarityChecker(rightList))));
    }
}