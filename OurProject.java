
import java.io.*;
import java.util.*;



class Note
{   Double n,c ;
    String mat ;
    public Note(String mat,double n , double c )
    {
        this.mat= mat;
        this.n = n ;
        this.c = c;

    }

}

class Stage implements Serializable
{
    String date;
    int nbj;
    double evaluation;
    public Stage(String date, int nbj, double evaluation) {
        this.date = date;
        this.nbj = nbj;
        this.evaluation = evaluation;
    }

    
}

 

abstract class Etudiant
{
    String id;
    String nom;
    String Email ;
    public List<Note>notes;
    public Etudiant(String id, String nom, String Email)
    {
        this.Email= Email;
        this.notes = new ArrayList<>();
        this.nom= nom;
        this.id = id ;
    }
    public Etudiant()
    {

    }
    public double calcMoyenne () {
        if(notes.isEmpty())
            return 0;

        double totMat = 0;
        double totcoef = 0;
        for (Note note : notes) {
            totMat += note.n * note.c;
            totcoef += note.c;


        }
        if (totcoef == 0.0) {
            throw new ArithmeticException("Division by zero");
        }
        return  totMat /  totcoef;
    }
    
}


class eIng extends Etudiant implements Serializable
{
    Stage stage1;
    Stage stage2 ;


    public eIng(String id, String nom, String Email,  Stage stage1, Stage stage2) {
        super(id, nom, Email );
        this.stage1 = stage1;
        this.stage2 = stage2;
    }


    public double calMoy ()
    {
        if (notes.isEmpty()) {
            return 0.0;
        }
        double totMat = 0;
        double totcoef = 0;
        for (Note note : notes) {
            totMat += note.n * note.c;
            totcoef += note.c;
        }

       double moye =  (totcoef != 0.0) ? (totMat / totcoef) : 0.0;
       double sumStage = stage1.evaluation + stage2.evaluation;

       return (moye + sumStage)/3.0;

    }






}
class eLmd  extends Etudiant implements Serializable
{
    String certificates;

    public eLmd(String id, String nom, String Email,String certificates) 
    {
        super(id, nom, Email);
        this.certificates = certificates;
    }
    public double calMoy ()
    {
        if (notes.isEmpty()) {
            return 0.0;
        }
        double totMat = 0;
        double totcoef = 0;
        for (Note note : notes) {
            totMat += note.n * note.c;
            totcoef += note.c;
        }
        if (totcoef == 0.0) {
            throw new ArithmeticException("Division by zero");
        }
        return  totMat /  totcoef;

       

    }
    
    


}
class eTic extends eLmd
{
    List<Stage> stages;


    public eTic(String id, String nom, String Email, String certificates) {
        super(id, nom, Email,  certificates);
        this .stages= new ArrayList<>();

    }
    double calcmoy()
    {
        if (notes.isEmpty()|| stages.isEmpty()) {
            return 0.0;
        }
        double totMat = 0;
        double totcoef = 0;
        for (Note note : notes) {
            totMat += note.n * note.c;
            totcoef += note.c;
        }
        double moye = (totcoef != 0.0) ? (totMat / totcoef) : 0.0;
        double moyeStage = moyeStage();
        double moyeTot = (moye + moyeStage) / 2.0;

        return moyeTot;
    }
        
       
    private double moyeStage() {
        double moyEvaluations = 0.0;
    
        for (Stage stage : stages) {
            moyEvaluations += stage.evaluation;
            }
    
        int numStages = stages.size();
        if (numStages == 0) {
            return 0.0;
        }
        return moyEvaluations / numStages;

    }
}
class eElect extends eLmd{
    Stage stage;

    public eElect(String id, String nom, String Email , String certificates, Stage stage) {
        super(id, nom, Email, certificates);
        this.stage = stage;
    }
    double calcmoy()
    {

        if (notes.isEmpty()|| (stage== null)) {
            return 0.0;
        }
        double totMat = 0;
        double totcoef = 0;
        for (Note note : notes) {
            totMat += note.n * note.c;
            totcoef += note.c;
        }
        double moye = ( totcoef != 0.0) ? ( totMat / totcoef) : 0.0;
        double moyTot = (moye + stage.evaluation) / 2.0;

        return moyTot;

    }
}

class Groupe implements Serializable
{
    String nom;
    Map<String, Etudiant> listEtuds;
    int capacity;

    public Groupe(String nom, int capacity) {
        this.nom = nom;
        this.capacity = capacity;
        this.listEtuds = new HashMap<>();
    }

    public void listall() {
        System.out.println("Groupe: " + nom);
        System.out.println("Etudiants:");
        for (Etudiant  etudiant: listEtuds.values()) {
            System.out.println("Etudiant ID: " + etudiant.id + ", Name: " + etudiant.nom);
        }
    }

    public double moyenneGlobale()
    {
        if (listEtuds.isEmpty()) {
            return 0.0;
            
    } 

    double sumMoy = 0.0;

    for (Etudiant student : listEtuds.values()) {
        sumMoy  += student.calcMoyenne ();
    }

    return sumMoy / listEtuds.size();
}

    public void addEtudiant(Etudiant etudiant) {
        if (listEtuds.size() < capacity) {
            listEtuds.put(etudiant.id,etudiant);
            System.out.println("Student added to the group: " + etudiant.nom);
        } else {
            System.out.println("Group is at full capacity. Cannot add more students.");
        }
    }

    public void removeStudent(String etudiantId) {
        if (listEtuds.containsKey(etudiantId)) {
            Etudiant removedStudent = listEtuds.remove(etudiantId);
            System.out.println("Student removed from the group: " + removedStudent.nom);
        } else {
            System.out.println("Student with ID " + etudiantId + " not found in the group.");
        }
    }


  
}

class Institut {
    List<Groupe> listGroupes;

    public Institut() {
        this.listGroupes = new ArrayList<>();
    }

    public void addGroup(Groupe group) {
        if (!groupExists(group.nom)) {
            listGroupes.add(group);
            System.out.println("Group added to the institute: " + group.nom);
        } else {
            System.out.println("Tentative to add an existing group: " + group.nom);
        }
    }
    private boolean groupExists(String groupNom) 
    {
        return listGroupes.stream().anyMatch(group -> group.nom.equals(groupNom));
    }
    public void listAll() {
        System.out.println("List of all groups in the institute:");
        for (Groupe group : listGroupes) {
            System.out.println("Group Name: " + group.nom + ", Global Average: " + group.moyenneGlobale());
        }
    }


    public void removeGroup(String groupName) {
        Groupe groupToRemove = findGroupByName(groupName);
        if (groupToRemove != null) {
            listGroupes.remove(groupToRemove);
            System.out.println("Group removed from the institute: " + groupName);
        } else {
            System.out.println("Tentative to remove a non-existing group: " + groupName);
        }
    }
    private Groupe findGroupByName(String groupName) {
        return listGroupes.stream().filter(group -> group.nom.equals(groupName)).findFirst().orElse(null);
    }

    
    

    
    public void listAllEtuds() {
        System.out.println("List of all students in the institute:");
        for (Groupe group : listGroupes) {
            for (Etudiant student : group.listEtuds.values()) {
                System.out.println("Student ID: " + student.id + ", Name: " + student.nom);
            }
        }
    }
    public void afficherGroupe(String groupName) {
        Groupe group = findGroupByName(groupName);
        if (group != null) {
            System.out.println("Group Name: " + group.nom);
            group.listall();
        } else {
            System.out.println("Group not found: " + groupName);
        }
    }

    public void afficherFiliere(String filiereName) {
        System.out.println("Students from the field " + filiereName + ":");
        for (Groupe group : listGroupes) {
            for (Etudiant student : group.listEtuds.values()) {
                if (student instanceof eLmd) {
                    if ((student instanceof eTic && filiereName.equals("Tic")) ||
                            (student instanceof eElect && filiereName.equals("Elect"))) {
                        System.out.println("Student ID: " + student.id + ", Name: " + student.nom);
                    }
                }
            }
        }
    }

    public void meilleurGroupe() {
        if (!listGroupes.isEmpty()) {
            Groupe bestGroup = listGroupes.stream()
                    .max(Comparator.comparingDouble(Groupe::moyenneGlobale))
                    .orElse(null);

            if (bestGroup != null) {
                System.out.println("The best group in the institute is: " + bestGroup.nom +
                        " with a global average of " + bestGroup.moyenneGlobale());
            } else {
                System.out.println("No groups found in the institute.");
            }
        } else {
            System.out.println("No groups found in the institute.");
        }
    }


    public void saveToFile(String ISSAT) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(ISSAT))) {
            outputStream.writeObject(listGroupes);
            System.out.println("Students saved to file: " + ISSAT);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error saving students to file: " + e.getMessage());
        }
    }

    public void readFromFile(String ISSAT) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(ISSAT))) {
            listGroupes = (List<Groupe>) inputStream.readObject();
            System.out.println("Students loaded from file: " + ISSAT);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error loading students from file: " + e.getMessage());
        }
    }
       
    }


public class OurProject {
    public static void main(String[] args) {
        // Sample usage of the classes
      Etudiant E1 = new eLmd("1", "ahmed" ,"ahmed@gmail.com", "certificate1 ");
      Etudiant  E2 = new eTic("2", "seddik", "seddik@gmail.com", "certificate2 ");
      Etudiant E3   = new eElect("3", "mohamed", "mohamed@gmail.com","certificate 3 " , new Stage("2022-01-02", 15, 16)); 
      Etudiant E4 = new eIng("4", "amine", "amine@gmail.com", new Stage("2023-11-03", 17, 18.5), new Stage("2024-01-04", 15, 12));
        E1.notes.add(new Note("iot", 12, 4));
        E1.notes.add(new Note("cyber security", 15, 3));

        E2.notes.add(new Note("math", 17, 4));
        E2.notes.add(new Note("physic", 12, 3));

        E3.notes.add(new Note("math", 15, 4));
        E3.notes.add(new Note("physic", 13, 3));
        
        E4.notes.add(new Note("mecanique", 16, 3));
        E4.notes.add(new Note("conception", 15, 2));

        
        



        
        
      
      
      
      
        Groupe groupe1 = new Groupe("Groupe1", 8);
        Groupe groupe2 = new Groupe("Groupe2", 5);  
        groupe1.addEtudiant(E1);
        groupe1.addEtudiant(E2);
        groupe2.addEtudiant(E3);
        groupe2.addEtudiant(E4);

        Institut institut = new Institut();
        institut.addGroup(groupe1);
        institut.addGroup(groupe2);
        institut.listAll();
        institut.meilleurGroupe();
        institut.afficherGroupe("Groupe2");
        institut.afficherGroupe("Groupe1");
        institut.afficherFiliere("eTic");
        institut.saveToFile("students.txt");
        institut. readFromFile("students.txt");
    }
}


