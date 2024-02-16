

import java.util.Scanner;



public class Exercice2 
{
    
    public static void main(String[] args)
    {
        

        Scanner scanner = new Scanner(System.in);

       

        String[] numbers = new String[5];

        for (int i = 0; i <=5; i++) {
            System.out.printf("Enter the number at index %d: ", i);
            try {
                numbers[i] = String.valueOf(scanner.nextInt());
                System.out.println();
            } catch (IndexOutOfBoundsException e) {
                System.err.printf("There is no element at index %d.%n", i);
            }
        }

        for (int i = 0; i <5; i++) {
            System.out.println(numbers[i]);
        }

        scanner.close();
    }
}
