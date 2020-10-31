package assignment_001;

public class NthPower {
    public static void main(String[] args) {
        String formula = "";
        double n =3;
        for (int i = 0; i < 10; i++) {
            formula=Math.pow(n,i)+(i==9?"":"+");

        }
        String [] formulaArray = formula.split("/+");
        double sum=0;
        for (String number:formulaArray
             ) {
            sum += Double.parseDouble(number);
        }
        System.out.println(sum);
    }
}
