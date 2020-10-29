package assignment_002;

public class MichaelsSolution {

    public static void main(String[] args) {
        int[][] intArr = {{1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18},
                {19, 20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29, 30},
                {31, 32, 33, 34, 35, 36,}};
        //Normal
        for (int row = 0; row < intArr.length; row++) { //ascending rows
            for (int col = 0; col < intArr[row].length; col++) { //ascending columns
                System.out.print(intArr[row][col] + "\t"); //normal row and column
            }
            System.out.println();
        }
        System.out.println();
        //Rotate 90 degrees clockwise
        for (int row = 0; row < intArr.length; row++) { //ascending rows
            for (int col = intArr[row].length - 1; col >= 0; col--) { //descending columns
                System.out.print(intArr[col][row] + "\t"); //backwards row and column
            }
            System.out.println();
        }
        System.out.println();
        //Rotate 90 degrees counter clockwise
        for (int row = intArr.length - 1; row >= 0; row--) { //descending rows
            for (int col = 0; col < intArr[row].length; col++) { //ascending columns
                System.out.print(intArr[col][row] + "\t"); //backwards row and column
            }
            System.out.println();
        }
        System.out.println();
        //rotate 180 degrees
        for (int row = intArr.length - 1; row >= 0; row--) { //descending rows
            for (int col = intArr[row].length - 1; col >= 0; col--) { //descending columns
                System.out.print(intArr[row][col] + "\t"); //normal row and column
            }
            System.out.println();
        }
    }

}
