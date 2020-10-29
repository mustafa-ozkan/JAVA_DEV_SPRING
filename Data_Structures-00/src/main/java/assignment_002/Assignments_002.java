package assignment_002;

public class Assignments_002 {


    public static void main(String[] args) {
        int[][] squareArray = createMatrix(31, 31);
        printoutAnArray(squareArray);
        squareArray = rotateMatrixInPlace(squareArray);
        printoutAnArray(squareArray);
    }

    public static int[][] createMatrix(int row, int column) {
        int[][] uoi = new int[row][column];
        for (int i = 0; i < uoi.length; i++) {
            for (int j = 0; j < uoi[i].length; j++) {
                uoi[i][j] = (int) (Math.random() * 100);
            }
        }
        return uoi;
    }

    public static int[][] rotateMatrixInPlace(int[][] uoi) {
        System.out.println("**********************");
        int temp = 0;
        for (int i = 0; i < (uoi.length - i - 1); i++) {
            for (int j = i; j < (uoi.length - i - 1); j++) {
                temp = uoi[j][uoi.length - i - 1];
                uoi[j][uoi.length - i - 1] = uoi[i][j];
                uoi[i][j] = uoi[uoi.length - j - 1][i];
                uoi[uoi.length - j - 1][i] = uoi[uoi.length - i - 1][uoi.length - j - 1];
                uoi[uoi.length - i - 1][uoi.length - j - 1] = temp;
            }
        }
        return uoi;
    }


    public static void printoutAnArray(int[][] uoi) {
        System.out.println("Printout Array");

        for (int i = 0; i < uoi.length; i++) {
            for (int j = 0; j < uoi[i].length; j++) {
                System.out.print(uoi[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
