import java.util.Random;

public class Assignments_001 {
    public static void main(String[] args) {
        int temp = 0;
        int[] unorderedIntegers = new int[7];
        for (int i = 0; i < unorderedIntegers.length; i++) {
            unorderedIntegers[i] = (int) (Math.random() * 1000);
            System.out.println(unorderedIntegers[i]);
        }
        System.out.println("**********************");
        for (int i = 0; i < unorderedIntegers.length/2; i++) {
            temp = unorderedIntegers[i];
            unorderedIntegers[i] = unorderedIntegers[unorderedIntegers.length - i - 1];
            unorderedIntegers[unorderedIntegers.length - i - 1] = temp;
        }

        for (int i = 0; i < unorderedIntegers.length; i++) {
            System.out.println(unorderedIntegers[i]);
        }
    }
}
