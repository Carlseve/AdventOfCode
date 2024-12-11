import java.io.*;
import java.util.Set;


public class Main {
    public static void main(String[] args) {

        Main main = new Main();

        System.out.println(main.matrixChecker(createMatrix("input.txt")));
        System.out.println(main.matrixCheckerPartTwo(createMatrix("input.txt")));
    }

    public static int countRows(String filename) {
        int rows = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                rows++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return rows;
    }

    public static int countColumns(String filename) {
        int columns = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String firstLine = br.readLine();
            for (int i = 0; i < firstLine.length(); i++) {
                columns++;
            }
        }
        catch (IOException e) {
            throw new RuntimeException("File not found", e);
        }
        return columns;
    }

    public static String[][] createMatrix(String filename) {
        int currentRow = 0;
        int columns = countColumns(filename);
        int rows = countRows(filename);
        String[][] matrix = new String[rows][columns];
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("");
                for (int i = 0; i < tokens.length; i++) {
                    matrix[currentRow][i] = tokens[i];
                }
                currentRow++;
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        return matrix;
    }

    public int matrixChecker(String[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("X")) {
                    if(checkOver(matrix, i, j)){
                        count++;
                    }
                    if(checkUnder(matrix, i, j)){
                        count++;
                    }
                    if(checkLeft(matrix, i, j)){
                        count++;
                    }
                    if(checkRight(matrix, i, j)){
                        count++;
                    }
                    if (checkUpLeft(matrix, i, j)){
                        count++;
                    }
                    if (checkUpRight(matrix, i, j)){
                        count++;
                    }
                    if (checkDownLeft(matrix, i, j)){
                        count++;
                    }
                    if (checkDownRight(matrix, i, j)){
                        count++;
                    }

                }
            }
        }
        return count;
    }

    public int matrixCheckerPartTwo(String[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("A")) {
                    if (checkTheX(matrix, i, j)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public boolean checkOver(String[][] matrix, int row, int col) {
        if (row >= 3) {
            if ("M".equals(matrix[row - 1][col]) &&
                    "A".equals(matrix[row - 2][col]) &&
                    "S".equals(matrix[row - 3][col])) {
                return true;
            }
        }
        return false;
    }

    public boolean checkUnder(String[][] matrix, int row, int col) {
        if (row <= matrix.length - 4) {
            if ("M".equals(matrix[row + 1][col]) &&
                    "A".equals(matrix[row + 2][col]) &&
                    "S".equals(matrix[row + 3][col])) {
                return true;
            }
        }
        return false;
    }

    public boolean checkLeft(String[][] matrix, int row, int col) {
        if (col >= 3) {
            if ("M".equals(matrix[row][col - 1]) &&
                    "A".equals(matrix[row][col - 2]) &&
                    "S".equals(matrix[row][col - 3])) {
                return true;
            }
        }
        return false;
    }

    public boolean checkRight(String[][] matrix, int row, int col) {
        if (col <= matrix[0].length - 4) {
            if ("M".equals(matrix[row][col + 1]) &&
                    "A".equals(matrix[row][col + 2]) &&
                    "S".equals(matrix[row][col + 3])) {
                return true;
            }
        }
        return false;
    }

    public boolean checkUpLeft(String[][] matrix, int row, int col) {
        if (row >= 3 && col >= 3) {
            if ("M".equals(matrix[row - 1][col - 1]) &&
                    "A".equals(matrix[row - 2][col - 2]) &&
                    "S".equals(matrix[row - 3][col - 3])) {
                return true;
            }
        }
        return false;
    }

    public boolean checkUpRight(String[][] matrix, int row, int col) {
        if (row >= 3 && col <= matrix[0].length - 4) {
            if ("M".equals(matrix[row - 1][col + 1]) &&
                    "A".equals(matrix[row - 2][col + 2]) &&
                    "S".equals(matrix[row - 3][col + 3])) {
                return true;
            }
        }
        return false;
    }

    public boolean checkDownLeft(String[][] matrix, int row, int col) {
        if (row <= matrix.length - 4 && col >= 3) {
            if ("M".equals(matrix[row + 1][col - 1]) &&
                    "A".equals(matrix[row + 2][col - 2]) &&
                    "S".equals(matrix[row + 3][col - 3])) {
                return true;
            }
        }
        return false;
    }

    public boolean checkDownRight(String[][] matrix, int row, int col) {
        if (row <= matrix.length - 4 && col <= matrix[0].length - 4) {
            if ("M".equals(matrix[row + 1][col + 1]) &&
                    "A".equals(matrix[row + 2][col + 2]) &&
                    "S".equals(matrix[row + 3][col + 3])) {
                return true;
            }
        }
        return false;
    }



    public boolean checkTheX(String[][] matrix, int row, int col) {
        if (row > 0 && row < matrix.length-1 && col > 0 && col < matrix[0].length-1) {
            if (matrix[row-1][col-1].equals("M")&&matrix[row-1][col+1].equals("M")&&matrix[row+1][col-1].equals("S")&&matrix[row+1][col+1].equals("S")) {
                return true;
            }
            if (matrix[row-1][col-1].equals("S")&&matrix[row-1][col+1].equals("S")&&matrix[row+1][col-1].equals("M")&&matrix[row+1][col+1].equals("M")) {
                return true;
            }
            if (matrix[row-1][col-1].equals("S")&&matrix[row-1][col+1].equals("M")&&matrix[row+1][col-1].equals("S")&&matrix[row+1][col+1].equals("M")) {
                return true;
            }
            if (matrix[row-1][col-1].equals("M")&&matrix[row-1][col+1].equals("S")&&matrix[row+1][col-1].equals("M")&&matrix[row+1][col+1].equals("S")) {
                return true;
            }
        }
        return false;
    }
}