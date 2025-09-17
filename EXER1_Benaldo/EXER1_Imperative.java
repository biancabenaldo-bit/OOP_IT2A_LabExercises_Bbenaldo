public class EXER1_Imperative {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 70, 50};
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        System.out.println("Imperative Sum = " + sum);
    }
}
