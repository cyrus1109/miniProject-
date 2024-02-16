public class Rectangle
{
   private double longueur ;
   private double largeur  ;

   public Rectangle(double longueur, double largeur)
   {
        this.largeur= largeur;
        this.longueur=longueur;

   }
   public double getLongueur()
   {
        return longueur;
   }
   public void setLongueur(double longueur)
   {
        this.longueur=longueur;

   }
   public double getLargeur()
   {
        return largeur;

   }
   public void setLargeur(double largeur)
   {
        this.largeur=largeur;
   } 
   public double périmètre()
   {
        return (largeur+longueur)*2;

   } 
   public double superficie()
   {
        return largeur*largeur;
   }
   public static void main(String[] args) {
    Rectangle A = new Rectangle(15, 12);
    A.périmètre();
    A.superficie();
    System.out.println("périmètre du rectangle : " +A.périmètre() );
    System.out.println("superficie du rectangle : " + A.superficie());
    
      
   }



}