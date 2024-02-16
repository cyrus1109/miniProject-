import java.util.Scanner;
// this exercice use for detecting negative variables and checking ArithmeticException; 
class  NegativeNumberException extends Exception
{
    public NegativeNumberException(String s)
    {
        super(s); 

    }
}




public class Exercice{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); 
        int nb1 =0; 
        System.out.println("please enter the value of nb2 ");
        int nb2 = sc.nextInt();
        
        sc.close();

        try
        { 
            nb1  = 10/nb2 ; 
            if(nb1 <0 || nb2 <0 )
                throw new NegativeNumberException("try positive variable ");
                System.out.println(nb1 );
        }
        catch(NegativeNumberException e )
        
        {
            System.out.println( "negatives variables");
            e.printStackTrace();
        }
        catch(ArithmeticException e )
        {
            System.out.println("cannot devide by zero "+ e);
            nb1= 10 ; 
            System.out.println("that's the default value  for nb1 "+nb1);
        }
        
    }
    

} 

