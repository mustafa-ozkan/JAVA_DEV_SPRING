public class Assignments_002 {
    public static void main(String[] args) {
        int temp = 0;
        int[][] uoi = new int[7][7];
        for (int i = 0; i < uoi.length; i++) {
            for (int j = 0; j < uoi[i].length; j++) {
                uoi[i][j] = (int) (Math.random() * 100);
                System.out.print(uoi[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("**********************");
        for (int i = 0; i <=Math.ceil(uoi.length/2); i++) {
            for (int j = 0; j <Math.ceil(uoi.length); j++) {
                temp = uoi[j][uoi.length-i-1];
                uoi[j][uoi.length-i-1]=uoi[i][j];
                uoi[i][j]=uoi[uoi.length-j-1][i];
                uoi[uoi.length-j-1][i]=uoi[uoi.length-i-1][uoi.length-j-1];
                uoi[uoi.length-i-1][uoi.length-j-1]=temp;


            }

        }

        System.out.println("Printout new Array");

        for (int i = 0; i < uoi.length; i++) {
            for (int j = 0; j < uoi[i].length; j++) {
                System.out.print(uoi[i][j] + "\t");
            }
            System.out.println();
        }


    }
}
