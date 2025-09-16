import java.util.Arrays; 
 
public class Main {     public static void main(String[] args) {         int[] numbers = {10, 20, 30, 70, 50}; 
 
        int squaredSum = Arrays.stream(numbers) 
                               .map(n -> n * n) 
             
          .reduce(0, Integer::sum); 
 
        System.out.println(“Functional Squared Sum = “ + squaredSum); 
    } 
} 
 
 

 
Functional Squared Sum = 8800 
 
 
 
 
 

                                                                                          
