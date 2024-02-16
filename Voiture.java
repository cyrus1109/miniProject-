import java.io.Serializable;

public class Voiture  implements Serializable
{
    private String marque ; 
    private String modele;
    private int année ;
    public Voiture(String marque, String modele , int année)
    {
        this.année=année;
        this.modele= modele;
        this.marque= marque;
    }
    public String getMarque()
    {
        return marque;
    }
    
    public String getModele() 
    {
        return modele;
    }
    public int getAnnée() 
    {
        return année;
    }
    public void setMarque(String marque)
    {
        this.marque= marque;

    }
    public void setModele(String modele) 
    {
        this.modele = modele;
    }
    public void setAnnée(int année) 
    {
        this.année = année;
    }
    public void Démarrer()
    {
        System.out.println("la voiture de marque : "+marque +"  modele : "+modele +"  de  l'année : "+année+"  démarre 0");

    }
    public void affiche()
    {
        System.out.println("marque: "+marque);
        System.out.println("modele : "+modele);
        System.out.println("Année :"+  année);

    }  
    public static void main(String[] args) 
    {
        Voiture maVoiture = new Voiture("BMW", "x5", 2010);
        maVoiture.affiche();
        maVoiture.Démarrer();
        
    }


    
}
