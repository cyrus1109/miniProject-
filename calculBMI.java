import java.util.Scanner;

public class calculBMI
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("entrer le poids en kg  ");
        double poids= sc.nextDouble();
        System.out.println("entrer la taille en metre ");
        double taille=sc.nextDouble();
        double BMI = poids/Math.pow(taille,2);
        System.out.println(" votre BMI est : "+BMI);
        sc.close();


        
    }


}