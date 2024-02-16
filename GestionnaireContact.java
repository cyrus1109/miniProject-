import java.util.ArrayList;
import java.util.List;

public class GestionnaireContact 
{
    private List<Contact> contacts; 
    public GestionnaireContact()
    {
        contacts = new ArrayList<>();
    }
    public void ajouterContact(Contact contact)
    {
        contacts.add(contact);
    }  
    public void SuprimerContact(Contact contact)
{
    for(int i = 0; i < contacts.size(); i++)
    {
        if(contacts.get(i).equals(contact))
        {
            contacts.remove(i);
            break;
        }
    }
}
    public void AfficherContact()
    {
        System.out.println("liste des contact : ");
        for(Contact contact : contacts )
        {
            System.out.println(contact);

        }
        
    }
    public static void main(String[] args) {
        GestionnaireContact a= new GestionnaireContact();
        a.ajouterContact(new Contact("ahmed", "ahmed@gmail.com", 55442215));
        a.ajouterContact(new Contact("Khaled","Khaled@gmail.com",887745412));
        a.AfficherContact();
        a.SuprimerContact(new Contact("ahmed", "ahmed@gmail.com", 55442215));
        a.AfficherContact();

        

    }
}
