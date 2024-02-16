import java.util.Objects;

public class Contact {
    String nom;
    String Email;
    int  numéro ;
    public Contact(String nom,String Email, int numéro){
        this.numéro= numéro;
        this.Email= Email;
        this.nom= nom ;

    }
    @Override
    public String toString() {
        return " [nom=" + nom + ", Email=" + Email + ", numéro=" + numéro + "]";
    }
   @Override
public boolean equals(Object obj)
{
    if(this == obj)
    {
        return true;
    }
    if(obj == null || getClass() != obj.getClass())
    {
        return false;
    }
    Contact contact = (Contact) obj;
    return Objects.equals(nom, contact.nom) && Objects.equals(Email, contact.Email) && Objects.equals(numéro, contact.numéro);
}


    
}
