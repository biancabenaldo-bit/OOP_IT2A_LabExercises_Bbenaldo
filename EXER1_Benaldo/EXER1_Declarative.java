import java.util.Arrays;

public class EXER1_Declarative {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 70, 50};

        int sum = Arrays.stream(numbers).sum();

        System.out.println("Declarative Sum = " + sum);
    }
}
