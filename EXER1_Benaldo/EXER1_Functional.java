import java.util.Arrays;

public class EXER1_Functional {    
    public static void main(String[] args) {     
        int[] numbers = {10, 20, 30, 70, 50}; 

        int squaredSum = Arrays.stream(numbers) 
                               .map(n -> n * n) 
                               .reduce(0, Integer::sum); 

        System.out.println("Functional Squared Sum = " + squaredSum); 
    } 
}

 
 